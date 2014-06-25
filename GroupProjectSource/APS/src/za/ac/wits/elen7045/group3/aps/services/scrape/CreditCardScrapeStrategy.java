package za.ac.wits.elen7045.group3.aps.services.scrape;

/**
 *@author boitumelo
 * 
 */


import za.ac.wits.elen7045.group3.aps.domain.accounts.statement.CreditCardStatement;
import za.ac.wits.elen7045.group3.aps.domain.entities.BillingAccount;
import za.ac.wits.elen7045.group3.aps.domain.entities.ScrapeLogResult;
import za.ac.wits.elen7045.group3.aps.domain.repository.accounts.BillingAccountRepository;
import za.ac.wits.elen7045.group3.aps.domain.repository.notification.ScrapeLogResultRepository;
import za.ac.wits.elen7045.group3.aps.domain.repository.statement.StatementRepository;
import za.ac.wits.elen7045.group3.aps.domain.scrape.vo.CreditCardStatementConverter;
import za.ac.wits.elen7045.group3.aps.domain.scrape.vo.ScrapedResult;
import za.ac.wits.elen7045.group3.aps.services.exception.DatabaseException;
import za.ac.wits.elen7045.group3.aps.services.scrape.acl.CreditCardScrapeAdaptor;
import za.ac.wits.elen7045.group3.aps.services.scrape.interfaces.ScraperStrategy;

public class CreditCardScrapeStrategy implements ScraperStrategy {
	
	private ScrapeLogResultRepository scrapeLogRepository;
	private BillingAccountRepository billingRepository;
	private BillingAccount account;
	
	public CreditCardScrapeStrategy(BillingAccount acc, ScrapeLogResultRepository scrapeLogRepository, BillingAccountRepository billingAccountRepositoryImpl) {
		super();
		this.account = acc;
		this.scrapeLogRepository = scrapeLogRepository;
		this.billingRepository = billingAccountRepositoryImpl;
	}
	
	
	@Override
	public void scrapeAccount() {
		//scrape account
		CreditCardScrapeAdaptor msa = new CreditCardScrapeAdaptor();
		ScrapedResult scrapeResult = msa.scrapeWebsite(account.getCompanyUrl(), account.getCredentials());
		
	
		//log the scrape call with its result
		logScrapeResult(scrapeResult);
		
		//add statement to billing account
		if(!isScrapeError(scrapeResult)){
			account.addBillingAccountStatament(getCreditCardStatement(scrapeResult));
			try {
				billingRepository.updateBillingAccountStatus(account);
			} catch (DatabaseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}			
		}
	}

	private void logScrapeResult(ScrapedResult scrapeResult) {
		
		ScrapeLogResult scrapeLog = new ScrapeLogResult();
		scrapeLog.setAccountNumber(account.getAccountNumber());

		scrapeLog.setResponse(scrapeResult.toString());
		try {
			scrapeLogRepository.insertScrapeLogResult(scrapeLog);
		} catch (DatabaseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}


	private CreditCardStatement getCreditCardStatement(ScrapedResult scrapeResult) {
		CreditCardStatementConverter csc = new CreditCardStatementConverter(scrapeResult);
		return csc.getCreditCardStatement();
	}


	private boolean isScrapeError(ScrapedResult scrapeResult) {
		if(scrapeResult.getDataPairList().size() == 1){
			return true;
		}
		return false;
	}
}
