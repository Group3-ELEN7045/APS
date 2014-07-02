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
import za.ac.wits.elen7045.group3.aps.services.scrape.ScrapedResultInterpreter;
import za.ac.wits.elen7045.group3.aps.domain.scrape.vo.ScrapedResult;
import za.ac.wits.elen7045.group3.aps.domain.scrape.vo.specification.HasDuplicateScrapedResultErrorSpecification;
import za.ac.wits.elen7045.group3.aps.domain.scrape.vo.specification.HasGenericErrorInScrapedResultSpecification;
import za.ac.wits.elen7045.group3.aps.domain.scrape.vo.specification.MunicipalScrapedResultAdditionSpecification;
import za.ac.wits.elen7045.group3.aps.domain.scrape.vo.specification.ScrapedResultAccountNumberMatchesSpecification;
import za.ac.wits.elen7045.group3.aps.services.scrape.ScrapedResultToTelcoStatementConverter;
import za.ac.wits.elen7045.group3.aps.domain.statement.repository.SaveStatementRepository;
import za.ac.wits.elen7045.group3.aps.services.enumtypes.AccountStatusType;
import za.ac.wits.elen7045.group3.aps.services.enumtypes.NotificationStatus;
import za.ac.wits.elen7045.group3.aps.services.enumtypes.NotificationType;
import za.ac.wits.elen7045.group3.aps.services.exception.DatabaseException;
import za.ac.wits.elen7045.group3.aps.services.scrape.acl.XMLToScrapedResultAdaptor;
import za.ac.wits.elen7045.group3.aps.services.scrape.exceptions.AccountNumberIncorrectException;
import za.ac.wits.elen7045.group3.aps.services.scrape.exceptions.DataIntegrityCheckException;
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
				
			} catch (AccountNumberIncorrectException e) {
				e.printStackTrace();
				
				scrapeLog.setMessage(e.getMessage());
				scrapeLog.setNotificationType(NotificationType.EMAIL.getNotificationType());
				scrapeLog.setStatsus(NotificationStatus.WAITING.getNotificationStatus());
				
				account.setAccountStatus(AccountStatusType.INACTIVE.getStatusType());
			} catch (DataIntegrityCheckException e) {
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
		}
		
		try {
			billingRepository.updateBillingAccountStatus(account);
		} catch (DatabaseException e) {
			e.printStackTrace();
			
			scrapeLog.setMessage(e.getMessage());
			scrapeLog.setNotificationType(NotificationType.APS.getNotificationType());
			scrapeLog.setStatsus(NotificationStatus.WAITING.getNotificationStatus());			
		}
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

	private boolean isIntegrityCheckPassed(ScrapedResult scrapeResult) throws AccountNumberIncorrectException, DataIntegrityCheckException {
		boolean integrityPassed = true;

		//check account number integrity
		ScrapedResultAccountNumberMatchesSpecification accNoSpec = new ScrapedResultAccountNumberMatchesSpecification(account.getAccountNumber());
		if(!account.getAccountStatus().equalsIgnoreCase(AccountStatusType.ACTIVE.getStatusType())  
			&& !accNoSpec.isSatisfiedBy(scrapeResult)){
			integrityPassed = false;
			throw new AccountNumberIncorrectException("Account number " +account.getAccountNumber()+ " incorrect");
		}
		
		try{
			//check municipal statement data integrity
			HasGenericErrorInScrapedResultSpecification hasGenError = new HasGenericErrorInScrapedResultSpecification();
			HasDuplicateScrapedResultErrorSpecification hasDupError = new HasDuplicateScrapedResultErrorSpecification();
			MunicipalScrapedResultAdditionSpecification municipalStatementSpec = new MunicipalScrapedResultAdditionSpecification();
			
			hasDupError.or(hasGenError).or(municipalStatementSpec).isSatisfiedBy(scrapeResult);

		}catch (Exception e){
			throw new DataIntegrityCheckException("Invalid data scraped for account("+account.getAccountNumber()+")");
		}
				
		return integrityPassed;
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
		return (TelcoStatement) tsc.getStatement();
	}
}
