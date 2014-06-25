package za.ac.wits.elen7045.group3.aps.services.scrape;

/**
 *@author boitumelo
 * 
 */


import za.ac.wits.elen7045.group3.aps.domain.accounts.statement.TelcoStatement;
import za.ac.wits.elen7045.group3.aps.domain.entities.BillingAccount;
import za.ac.wits.elen7045.group3.aps.domain.entities.ScrapeLogResult;
import za.ac.wits.elen7045.group3.aps.domain.repository.accounts.BillingAccountRepository;
import za.ac.wits.elen7045.group3.aps.domain.repository.notification.ScrapeLogResultRepository;
import za.ac.wits.elen7045.group3.aps.domain.scrape.vo.ScrapedResult;
import za.ac.wits.elen7045.group3.aps.domain.scrape.vo.TelcoStatementConverter;
import za.ac.wits.elen7045.group3.aps.services.exception.DatabaseException;
import za.ac.wits.elen7045.group3.aps.services.scrape.acl.MunicipalScrapeAdaptor;
import za.ac.wits.elen7045.group3.aps.services.scrape.interfaces.ScraperStrategy;

public class TelcoScrapeStrategy implements ScraperStrategy {
	
	private ScrapeLogResultRepository scrapeLogRepository;
	private BillingAccountRepository billingRepository;
	private BillingAccount account;
	
	public TelcoScrapeStrategy(BillingAccount acc, ScrapeLogResultRepository scrapeLogRepository, BillingAccountRepository billingAccountRepository) {
		super();
		this.account = acc;
		this.scrapeLogRepository = scrapeLogRepository;
		this.billingRepository = billingAccountRepository;
	}
	
	
	@Override
	public void scrapeAccount() {
		//scrape account
		MunicipalScrapeAdaptor msa = new MunicipalScrapeAdaptor();
		ScrapedResult scrapeResult = msa.scrapeWebsite(account.getCompanyUrl(), account.getCredentials());
		
		//log the scrape call with its result
		logScrapeRsult(scrapeResult);
		
		//add statement to billing account
		if(!isScrapeError(scrapeResult)){
			account.addBillingAccountStatament(getMunicipalStatement(scrapeResult));
			try {
				billingRepository.updateBillingAccountStatus(account);
			} catch (DatabaseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}			
		}
	}

	private void logScrapeRsult(ScrapedResult scrapeResult) {		
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
		
	
	private TelcoStatement getMunicipalStatement(ScrapedResult scrapeResult) {
		TelcoStatementConverter tsc = new TelcoStatementConverter(scrapeResult);
		return tsc.getTelcoStatement();
	}


	private boolean isScrapeError(ScrapedResult scrapeResult) {
		if(scrapeResult.getDataPairList().size() == 1){
			return true;
		}
		return false;
	}
}
