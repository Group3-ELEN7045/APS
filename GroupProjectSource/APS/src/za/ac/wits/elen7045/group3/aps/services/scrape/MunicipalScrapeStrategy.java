package za.ac.wits.elen7045.group3.aps.services.scrape;

/**
 *@author boitumelo
 * 
 */


import za.ac.wits.elen7045.group3.aps.domain.accounts.repository.BillingAccountRepository;
import za.ac.wits.elen7045.group3.aps.domain.accounts.statement.MunicipalStatement;
import za.ac.wits.elen7045.group3.aps.domain.entities.BillingAccount;
import za.ac.wits.elen7045.group3.aps.domain.entities.ScrapeLogResult;
import za.ac.wits.elen7045.group3.aps.domain.repository.notification.ScrapeLogResultRepository;
import za.ac.wits.elen7045.group3.aps.services.exception.DatabaseException;
import za.ac.wits.elen7045.group3.aps.services.scrape.acl.MunicipalScrapeAdaptor;
import za.ac.wits.elen7045.group3.aps.services.scrape.interfaces.ScraperStrategy;
import za.ac.wits.elen7045.group3.aps.vo.scrape.MunicipalStatementConverter;
import za.ac.wits.elen7045.group3.aps.vo.scrape.ScrapedResult;

public class MunicipalScrapeStrategy implements ScraperStrategy {
	
	private ScrapeLogResultRepository scrapeLogRepository;
	private BillingAccountRepository billingRepository;
	private BillingAccount account;
	
	public MunicipalScrapeStrategy(BillingAccount acc, ScrapeLogResultRepository slr, BillingAccountRepository bar) {
		super();
		this.account = acc;
		scrapeLogRepository = slr;
		billingRepository = bar;
	}
	
	@Override
	public void scrapeAccount() {
		//scrape account
		MunicipalScrapeAdaptor msa = new MunicipalScrapeAdaptor();
		ScrapedResult scrapeResult = msa.scrapeWebsite(account.getCompanyUrl(), account.getCredentials());
		
		//log the scrape call with its result
		logScrapeResult(scrapeResult);
		
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

	private void logScrapeResult(ScrapedResult scrapeResult) {	
		
		ScrapeLogResult scrapeLog = new ScrapeLogResult();
		scrapeLog.setAccountNumber(account.getAccountNumber());
		scrapeLog.setResponse(scrapeResult.toString());
		
		try {
			scrapeLogRepository.insertScrapeLogResult(scrapeLog);
		} catch (DatabaseException e) {
			e.printStackTrace();
		}
	}
	
	
	private MunicipalStatement getMunicipalStatement(ScrapedResult scrapeResult) {
		MunicipalStatementConverter msc = new MunicipalStatementConverter(scrapeResult);
		return msc.getMunicipalStatement();
	}


	private boolean isScrapeError(ScrapedResult scrapeResult) {
		if(scrapeResult.getDataPairList().size() == 1){
			return true;
		}
		return false;
	}
}
