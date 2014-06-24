package za.ac.wits.elen7045.group3.aps.services.scrape.interfaces;

import za.ac.wits.elen7045.group3.aps.domain.entities.BillingAccount;

/**
 * 
 * @author boitumelo
 *
 */
public interface ScraperStrategyFactory {
	public ScraperStrategy getScraperStrategy(BillingAccount billlingAccount);
}
