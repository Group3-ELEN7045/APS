package za.ac.wits.elen7045.group3.aps.services.scraper;

/**
 *@author boitumelo
 * 
 */


import za.ac.wits.elen7045.group3.aps.domain.accounts.statement.CreditCardStatement;
import za.ac.wits.elen7045.group3.aps.domain.entities.BillingAccount;
import za.ac.wits.elen7045.group3.aps.services.scrape.acl.CreditCardScrapeAdaptor;
import za.ac.wits.elen7045.group3.aps.services.scraper.entities.ScrapeLog;
import za.ac.wits.elen7045.group3.aps.services.scraper.interfaces.ScraperStrategy;
import za.ac.wits.elen7045.group3.aps.services.scraper.repository.ScrapeLogRepository;
import za.ac.wits.elen7045.group3.aps.vo.scrape.CreditCardStatementConverter;

public class CreditCardScrapeStrategy implements ScraperStrategy {
	
	private ScrapeLogRepository resultLog;
	private BillingAccount account;
	
	public CreditCardScrapeStrategy(BillingAccount acc) {
		super();
		this.account = acc;
		resultLog = new ScrapeLogRepository();
	}
	
	
	@Override
	public void scrapeAccount() {
		//scrape account
		CreditCardScrapeAdaptor msa = new CreditCardScrapeAdaptor();
		ScrapeResult scrapeResult = msa.scrapeWebsite(account.getCompanyUrl(), account.getCredentials());
		
		//check if error or good reply
		
		//log the scrape call with its result
		ScrapeLog scrapeLog = new ScrapeLog();
		scrapeLog.setScrapeResult(scrapeResult.toString());
		resultLog.logScrapeResult(scrapeLog);
		
		//add statement to billing account
		if(!isScrapeError(scrapeResult)){
			account.addBillingAccountStatament(getCreditCardStatement(scrapeResult));
		}
	}

	private CreditCardStatement getCreditCardStatement(ScrapeResult scrapeResult) {
		CreditCardStatementConverter csc = new CreditCardStatementConverter(scrapeResult);
		return csc.getCreditCardStatement();
	}


	private boolean isScrapeError(ScrapeResult scrapeResult) {
		if(scrapeResult.getDataPairList().size() == 1){
			return true;
		}
		return false;
	}
}
