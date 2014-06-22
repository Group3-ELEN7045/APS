package za.ac.wits.elen7045.group3.aps.services.scrape.acl;
/**
 * @author bakwanyana
 */
import za.ac.wits.elen7045.group3.aps.domain.entities.BillingAccount;
import za.ac.wits.elen7045.group3.aps.vo.scrape.ScrapedResult;

// Adapter pattern
public interface ScrapeAdaptor {
	ScrapedResult scrapeWebsite(String url, BillingAccount account);
}
