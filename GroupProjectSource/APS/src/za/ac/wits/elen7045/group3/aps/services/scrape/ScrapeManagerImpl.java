package za.ac.wits.elen7045.group3.aps.services.scrape;
import org.springframework.context.ApplicationContext;

import za.ac.wits.elen7045.group3.aps.domain.APSFactory;
import za.ac.wits.elen7045.group3.aps.domain.entities.BillingAccount;
import za.ac.wits.elen7045.group3.aps.services.scrape.exceptions.ScrapeRetryException;
import za.ac.wits.elen7045.group3.aps.services.scrape.interfaces.ScrapeManager;
import za.ac.wits.elen7045.group3.aps.services.scrape.interfaces.ScraperStrategy;
import za.ac.wits.elen7045.group3.aps.services.scrape.interfaces.ScraperStrategyFactory;

/**
 * 
 * @author boitumelo
 *
 */
public class ScrapeManagerImpl implements ScrapeManager {
	
	private ScraperStrategyFactory strategyFactory;
	private ApplicationContext _apscontext;
	
	public ScrapeManagerImpl() {
		super();
		_apscontext = APSFactory.getAPSContext();
		this.strategyFactory = (ScraperStrategyFactory) _apscontext.getBean("scrapeStrategyFactory");
	}

	@Override
	public void scrapeAccount(BillingAccount billingAccount) throws ScrapeRetryException {
		getScraper(billingAccount).scrapeAccount();
	}
	
	private ScraperStrategy getScraper(BillingAccount billingAccount){
		return strategyFactory.getScraperStrategy(billingAccount);
	}
}
