package za.ac.wits.elen7045.group3.aps.services.scrape.acl;
/**
 * @author bakwanyana
 */
import za.ac.wits.elen7045.group3.aps.domain.scrape.vo.ScrapedResult;
import za.ac.wits.elen7045.group3.aps.domain.vo.CredentialsVO;

public interface ScrapedResultAdaptor {
	ScrapedResult scrapeWebsite(String url, CredentialsVO credentialsVO);
}
