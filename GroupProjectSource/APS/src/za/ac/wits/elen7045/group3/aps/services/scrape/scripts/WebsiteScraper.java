package za.ac.wits.elen7045.group3.aps.services.scrape.scripts;

import za.ac.wits.elen7045.group3.aps.domain.scrape.vo.ScrapedResult;
import za.ac.wits.elen7045.group3.aps.domain.vo.CredentialsVO;
import za.ac.wits.elen7045.group3.aps.services.scrape.acl.XMLFileToScrapedResultTranslator;

/**
 * @author bakwanyana
 * @author boitumelo(refactoring)
 */
public class WebsiteScraper {
	public static ScrapedResult scrapeWebsite(String url, CredentialsVO credentials){
		return (ScrapedResult)new XMLFileToScrapedResultTranslator().convertScrapedDataToObject(ScrapedResult.class, url);
	}
}
