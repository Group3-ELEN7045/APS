package za.ac.wits.elen7045.group3.aps.services.scrape;

import za.ac.wits.elen7045.group3.aps.domain.entities.BillingAccount;

public interface ScrapeAdaptor {
	StatementScrapedData scrapeWebsite(String url, BillingAccount account);
}
