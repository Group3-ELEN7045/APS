package za.ac.wits.elen7045.group3.aps.services.scrape.acl;

import za.ac.wits.elen7045.group3.aps.domain.scrape.vo.ScrapedResult;
import za.ac.wits.elen7045.group3.aps.domain.vo.CredentialsVO;
import za.ac.wits.elen7045.group3.aps.services.scrape.scripts.WebsiteScraper;

/**
 * @author bakwanyana
 */
public class XMLToScrapedResultAdaptor implements ScrapedResultAdaptor{

	@Override
	public ScrapedResult scrapeWebsite(String url, CredentialsVO credentialsVO) {
		return WebsiteScraper.scrapeWebsite(url,credentialsVO);
	}

}
