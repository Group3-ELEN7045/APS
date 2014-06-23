package za.ac.wits.elen7045.group3.aps.services.scrape.acl;
/**
 * @author bakwanyana
 * @author boitumelo(refactoring)
 */
import za.ac.wits.elen7045.group3.aps.domain.vo.CredentialsVO;
import za.ac.wits.elen7045.group3.aps.scrape.scripts.WebsiteScraper;
import za.ac.wits.elen7045.group3.aps.vo.scrape.ScrapedResult;
import za.ac.wits.elen7045.group3.aps.services.scraper.interfaces.ScrapeAdaptor;

public class TelcoScrapeAdaptor implements ScrapeAdaptor{
	@Override
	public ScrapedResult scrapeWebsite(String url, CredentialsVO credenttials) {
		return WebsiteScraper.scrapeWebsite(url,credenttials);
	}

}
