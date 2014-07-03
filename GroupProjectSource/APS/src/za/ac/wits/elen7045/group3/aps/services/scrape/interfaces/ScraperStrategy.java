package za.ac.wits.elen7045.group3.aps.services.scrape.interfaces;

import za.ac.wits.elen7045.group3.aps.services.scrape.exceptions.ScrapeRetryException;

/**
 * 
 * @author boitumelo
 *
 */
public interface ScraperStrategy {
	public void scrapeAccount() throws ScrapeRetryException;
}
