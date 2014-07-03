package za.ac.wits.elen7045.group3.aps.services.scrape;

/**
 *@author boitumelo
 * 
 */


import java.sql.Timestamp;

import org.apache.derby.iapi.util.StringUtil;

import za.ac.wits.elen7045.group3.aps.domain.accounts.repository.AddBillingAccountRepository;
import za.ac.wits.elen7045.group3.aps.domain.accounts.statement.TelcoStatement;
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
import za.ac.wits.elen7045.group3.aps.services.exception.DatabaseException;
import za.ac.wits.elen7045.group3.aps.services.scrape.acl.XMLToScrapedResultAdaptor;
import za.ac.wits.elen7045.group3.aps.services.scrape.exceptions.NotifyAPSException;
import za.ac.wits.elen7045.group3.aps.services.scrape.exceptions.NotifyUserException;
import za.ac.wits.elen7045.group3.aps.services.scrape.exceptions.ScrapeRetryException;
import za.ac.wits.elen7045.group3.aps.services.scrape.interfaces.ScraperStrategy;

public class TelcoScrapeStrategy implements ScraperStrategy {
	
	private static final String SUCCESS = "000";
	private ScrapeLogResultRepository 	scrapeLogRepository;
	private AddBillingAccountRepository 	billingRepository;
	private SaveStatementRepository			statementRepository;
	private BillingAccount account;
	
	public TelcoScrapeStrategy(BillingAccount acc, ScrapeLogResultRepository scrapeLogRepository, AddBillingAccountRepository billingAccountRepository, SaveStatementRepository statementRepository) {
		super();
		this.account = acc;
		this.scrapeLogRepository = scrapeLogRepository;
		this.billingRepository = billingAccountRepository;
		this.statementRepository = statementRepository;
	}
	
	
	@Override
	public void scrapeAccount() {
		//scrape account
		XMLToScrapedResultAdaptor msa = new XMLToScrapedResultAdaptor();
		ScrapedResult scrapeResult;
		ScrapeLogResult scrapeLog;
		try{
			scrapeResult = msa.scrapeWebsite(account.getCompanyUrl(), account.getCredentials());
		
			scrapeLog = new ScrapeLogResult();
			scrapeLog.setAccountNumber(account.getAccountNumber());
		
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
				} catch (Exception e){
					e.printStackTrace();
					
					scrapeLog.setMessage(e.getMessage());
					scrapeLog.setNotificationType(NotificationType.APS.getNotificationType());
					scrapeLog.setStatsus(NotificationStatus.WAITING.getNotificationStatus());
					
					account.setAccountStatus(AccountStatusType.INACTIVE.getStatusType());
				}
			}else{
				handleScrapeFailure(returnCode);
			}
	
			billingRepository.updateBillingAccountStatus(account);
		}catch(Exception e){
			e.printStackTrace();
	
			scrapeLog = new ScrapeLogResult();
			scrapeLog.setAccountNumber(account.getAccountNumber());
			scrapeLog.setResponse(e.getMessage());
			scrapeLog.setNotificationDate(new Timestamp(System.currentTimeMillis()));
		}
		//log the scrape call with its result
		logScrapeResult(scrapeLog);
	}

	private boolean isIntegrityCheckPassed(ScrapedResult scrapeResult) throws NotifyUserException, NotifyAPSException {
		boolean integrityPassed = true;

		//check account number integrity
		ScrapedResultAccountNumberMatchesSpecification accNoSpec = new ScrapedResultAccountNumberMatchesSpecification(account.getAccountNumber());
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
			
			hasDupError.or(hasGenError).or(municipalStatementSpec).isSatisfiedBy(scrapeResult);

		}catch (Exception e){
			throw new NotifyAPSException("Invalid data scraped for account("+account.getAccountNumber()+")");
		}
				
		return integrityPassed;
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
	
	private void logScrapeResult(ScrapeLogResult scrapeLog) {		
		try {
			scrapeLogRepository.insertScrapeLogResult(scrapeLog);
		} catch (DatabaseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
		
	private TelcoStatement getMunicipalStatement(ScrapedResult scrapeResult) {
		ScrapedResultToTelcoStatementConverter tsc = new ScrapedResultToTelcoStatementConverter(scrapeResult);
		return (TelcoStatement) tsc.getBillingStatement();
	}
}
