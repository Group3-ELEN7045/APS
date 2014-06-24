package za.ac.wits.elen7045.group3.aps.services.scrape;
import za.ac.wits.elen7045.group3.aps.domain.entities.BillingAccount;
import za.ac.wits.elen7045.group3.aps.services.scrape.exceptions.ScrapeRetryException;
import za.ac.wits.elen7045.group3.aps.services.scrape.factory.ScraperStrategyFactory;
import za.ac.wits.elen7045.group3.aps.services.scrape.interfaces.ScrapeManager;
import za.ac.wits.elen7045.group3.aps.services.scrape.interfaces.ScraperStrategy;

/**
 * 
 * @author boitumelo
 *
 */
public class ScrapeManagerImpl implements ScrapeManager {
		
	@Override
	public void scrapeAccount(BillingAccount account) throws ScrapeRetryException {
		getScraper(account.getCompanyUrl()).scrapeAccount();
	}
	
	private ScraperStrategy getScraper(String companyUrl){
		return ScraperStrategyFactory.getScraperStrategy(companyUrl);
	}
}
