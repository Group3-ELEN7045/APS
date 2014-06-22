package za.ac.wits.elen7045.group3.aps.scrape.scripts;

import za.ac.wits.elen7045.group3.aps.domain.vo.CredentialsVO;
import za.ac.wits.elen7045.group3.aps.services.scrape.acl.XMLFileMarshall;
import za.ac.wits.elen7045.group3.aps.services.scraper.ScrapeResult;
import za.ac.wits.elen7045.group3.aps.vo.scrape.ScrapedResult;

/**
 * @author bakwanyana
 * @author boitumelo(refactoring)
 */
public class WebsiteScraper {
	public static ScrapeResult scrapeWebsite(String url, CredentialsVO credentials){
		return (ScrapeResult)new XMLFileMarshall().convertScrapedDataToObject(ScrapeResult.class, url);
	}
}
