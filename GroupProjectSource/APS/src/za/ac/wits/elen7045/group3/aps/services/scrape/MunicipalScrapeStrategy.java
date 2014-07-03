package za.ac.wits.elen7045.group3.aps.services.scrape;

/**
 *@author boitumelo
 * 
 */


import java.sql.Timestamp;

import org.apache.derby.iapi.util.StringUtil;

import za.ac.wits.elen7045.group3.aps.domain.accounts.repository.AddBillingAccountRepository;
import za.ac.wits.elen7045.group3.aps.domain.accounts.statement.MunicipalStatement;
import za.ac.wits.elen7045.group3.aps.domain.entities.BillingAccount;
import za.ac.wits.elen7045.group3.aps.domain.entities.ScrapeLogResult;
import za.ac.wits.elen7045.group3.aps.domain.repository.notification.ScrapeLogResultRepository;
import za.ac.wits.elen7045.group3.aps.domain.scrape.vo.ScrapedResult;
import za.ac.wits.elen7045.group3.aps.domain.scrape.vo.specification.HasDuplicateScrapedResultErrorSpecification;
import za.ac.wits.elen7045.group3.aps.domain.scrape.vo.specification.HasGenericErrorInScrapedResultSpecification;
import za.ac.wits.elen7045.group3.aps.domain.scrape.vo.specification.MunicipalScrapedResultAdditionSpecification;
import za.ac.wits.elen7045.group3.aps.domain.scrape.vo.specification.ScrapedResultAccountNumberMatchesSpecification;
import za.ac.wits.elen7045.group3.aps.domain.statement.repository.SaveStatementRepository;
import za.ac.wits.elen7045.group3.aps.services.enumtypes.AccountStatusType;
import za.ac.wits.elen7045.group3.aps.services.enumtypes.NotificationStatus;
import za.ac.wits.elen7045.group3.aps.services.enumtypes.NotificationType;
import za.ac.wits.elen7045.group3.aps.services.enumtypes.ScrapeServiceError;
import za.ac.wits.elen7045.group3.aps.services.exception.ApplicationException;
import za.ac.wits.elen7045.group3.aps.services.exception.DatabaseException;
import za.ac.wits.elen7045.group3.aps.services.scrape.acl.XMLToScrapedResultAdaptor;
import za.ac.wits.elen7045.group3.aps.services.scrape.exceptions.NotifyAPSException;
import za.ac.wits.elen7045.group3.aps.services.scrape.exceptions.NotifyUserException;
import za.ac.wits.elen7045.group3.aps.services.scrape.exceptions.ScrapeRetryException;
import za.ac.wits.elen7045.group3.aps.services.scrape.interfaces.ScraperStrategy;

public class MunicipalScrapeStrategy implements ScraperStrategy {
	
	private static final String SUCCESS = "000";
	private ScrapeLogResultRepository scrapeLogRepository;
	private AddBillingAccountRepository accountRepository;
	private SaveStatementRepository statementRepository;
	private BillingAccount account;
	
	public MunicipalScrapeStrategy(BillingAccount acc, ScrapeLogResultRepository slr, AddBillingAccountRepository bar, SaveStatementRepository sr) {
		super();
		this.account = acc;
		this.scrapeLogRepository = slr;
		this.accountRepository = bar;
		this.statementRepository = sr;
	}
	
	@Override
	public void scrapeAccount() throws ScrapeRetryException {
		//scrape account
		XMLToScrapedResultAdaptor msa = new XMLToScrapedResultAdaptor();
		ScrapedResult scrapeResult;
		ScrapeLogResult scrapeLog;
		String exceptionMessage = "";
		try{
			scrapeResult = msa.scrapeWebsite(account.getCompanyUrl(), account.getCredentials());
		
			scrapeLog = new ScrapeLogResult();
			//scrapeLog.setAccountNumber(account.getAccountNumber());
			//removeAcc
			scrapeLog.setAccountNumber("123456789");
			
			scrapeLog.setResponse(StringUtil.truncate(scrapeResult.toString(), 255));
			scrapeLog.setNotificationDate(new Timestamp(System.currentTimeMillis()));
			
			//was the scrape successful
			ScrapedResultInterpreter scrapeResultCheck = new ScrapedResultInterpreter(scrapeResult);
			String returnCode = scrapeResultCheck.evaluate();
			if(SUCCESS.equalsIgnoreCase(returnCode)){
				try {
					isIntegrityCheckPassed(scrapeResult);
					
					statementRepository.addStatement(getMunicipalStatement(scrapeResult));
					scrapeLog.setNotificationType(NotificationType.SCRAPESUCCESS.getNotificationType());
					scrapeLog.setStatsus(NotificationStatus.SUCCESS.getNotificationStatus());
					
				} catch (NotifyUserException e) {
					e.printStackTrace();
					
					scrapeLog.setMessage(e.getMessage());
					scrapeLog.setNotificationType(NotificationType.EMAIL.getNotificationType());
					scrapeLog.setStatsus(NotificationStatus.WAITING.getNotificationStatus());
					
					account.setAccountStatus(AccountStatusType.INACTIVE.getStatusType());
				} catch (NotifyAPSException e) {
					e.printStackTrace();
					
					scrapeLog.setMessage(e.getMessage());
					scrapeLog.setNotificationType(NotificationType.APS.getNotificationType());
					scrapeLog.setStatsus(NotificationStatus.WAITING.getNotificationStatus());
					
					account.setAccountStatus(AccountStatusType.INACTIVE.getStatusType());
				}
			}else{
				handleScrapeFailure(returnCode);
			}
			
			accountRepository.updateBillingAccountStatus(account);

			//log the scrape call with its result
			logScrapeResult(scrapeLog);
		}catch(ApplicationException e){
			e.printStackTrace();
			exceptionMessage = e.getMessage();
		}finally{
			
			scrapeLog = new ScrapeLogResult();
			scrapeLog.setAccountNumber(account.getAccountNumber());
			scrapeLog.setResponse(exceptionMessage);
			scrapeLog.setNotificationDate(new Timestamp(System.currentTimeMillis()));
			
			//log the scrape call with its result
			logScrapeResult(scrapeLog);		
		}
	}

	private void handleScrapeFailure(String returnCode) throws NotifyUserException, NotifyAPSException, ScrapeRetryException {
		int errorCode = Integer.parseInt(returnCode);
		
		if(errorCode == ScrapeServiceError.INVALIDACCOUNT.getScrapeServiceError()){
			throw new NotifyUserException(ScrapeServiceError.INVALIDACCOUNT.getScrapeServiceErrorDesc());
		}if(errorCode == ScrapeServiceError.INVALIDUSERCREDENTIAL.getScrapeServiceError()){
			throw new NotifyUserException(ScrapeServiceError.INVALIDUSERCREDENTIAL.getScrapeServiceErrorDesc());
		}if(errorCode == ScrapeServiceError.NOTSIGNEFOREBILLING.getScrapeServiceError()){
			throw new NotifyUserException(ScrapeServiceError.NOTSIGNEFOREBILLING.getScrapeServiceErrorDesc());
		}if(errorCode == ScrapeServiceError.ACTIONREQUIRED.getScrapeServiceError()){
			throw new NotifyUserException(ScrapeServiceError.ACTIONREQUIRED.getScrapeServiceErrorDesc());
		}if(errorCode == ScrapeServiceError.BROKENSCRIPT.getScrapeServiceError()){
			throw new NotifyAPSException(ScrapeServiceError.BROKENSCRIPT.getScrapeServiceErrorDesc());
		}if(errorCode == ScrapeServiceError.DATAINTEGRITYFAILURE.getScrapeServiceError()){
			throw new NotifyAPSException(ScrapeServiceError.DATAINTEGRITYFAILURE.getScrapeServiceErrorDesc());
		}if(errorCode == ScrapeServiceError.BILLINGSITEDOWN.getScrapeServiceError()){
			throw new ScrapeRetryException(ScrapeServiceError.BILLINGSITEDOWN.getScrapeServiceErrorDesc());
		}if(errorCode == ScrapeServiceError.ERRORPAGEENCOUNTERED.getScrapeServiceError()){
			throw new ScrapeRetryException(ScrapeServiceError.ERRORPAGEENCOUNTERED.getScrapeServiceErrorDesc());
		}
	}

	private boolean isIntegrityCheckPassed(ScrapedResult scrapeResult) throws NotifyUserException, NotifyAPSException {
		boolean integrityPassed = true;

		//check account number integrity
		//removeAcc
		//ScrapedResultAccountNumberMatchesSpecification accNoSpec = new ScrapedResultAccountNumberMatchesSpecification(account.getAccountNumber());
		ScrapedResultAccountNumberMatchesSpecification accNoSpec = new ScrapedResultAccountNumberMatchesSpecification("123456789");
		if(!account.getAccountStatus().equalsIgnoreCase(AccountStatusType.ACTIVE.getStatusType())  
			&& !accNoSpec.isSatisfiedBy(scrapeResult)){
			integrityPassed = false;
			throw new NotifyUserException("Account number " +account.getAccountNumber()+ " incorrect");
		}
		
		try{
			//check municipal statement data integrity
			HasGenericErrorInScrapedResultSpecification hasGenError = new HasGenericErrorInScrapedResultSpecification();
			HasDuplicateScrapedResultErrorSpecification hasDupError = new HasDuplicateScrapedResultErrorSpecification();
			MunicipalScrapedResultAdditionSpecification municipalStatementSpec = new MunicipalScrapedResultAdditionSpecification();
			integrityPassed = hasDupError.or(hasGenError).or(municipalStatementSpec).isSatisfiedBy(scrapeResult);
			
			if(!integrityPassed){
				throw new NotifyAPSException("Invalid data scraped for account("+account.getAccountNumber()+")");
			}

		}catch (Exception e){
			throw new NotifyAPSException("Invalid data scraped for account("+account.getAccountNumber()+")");
		}
	
		return integrityPassed;
	}

	private void logScrapeResult(ScrapeLogResult scrapeLog) {	
		try {
			scrapeLogRepository.insertScrapeLogResult(scrapeLog);
		} catch (DatabaseException e) {
			e.printStackTrace();
		}
	}
	
	private MunicipalStatement getMunicipalStatement(ScrapedResult scrapeResult) {
		ScrapedResultToMunicipalStatementConverter msc = new ScrapedResultToMunicipalStatementConverter(scrapeResult);
		return (MunicipalStatement) msc.getStatement();
	}
}
