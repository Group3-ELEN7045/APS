package za.ac.wits.elen7045.group3.aps.services.scrape.acl;
/**
 * @author bakwanyana
 */
import za.ac.wits.elen7045.group3.aps.domain.vo.CredentialsVO;
import za.ac.wits.elen7045.group3.aps.vo.scrape.ScrapedResult;

// Adapter pattern
public interface ScrapeAdaptor {
	ScrapedResult scrapeWebsite(String url, CredentialsVO credentialsVO);
}
