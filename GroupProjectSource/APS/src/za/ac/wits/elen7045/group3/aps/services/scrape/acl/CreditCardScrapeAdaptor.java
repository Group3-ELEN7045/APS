package za.ac.wits.elen7045.group3.aps.services.scrape.acl;
/**
 * @author bakwanyana
 * @author boitumelo(refactoring)
 */
import za.ac.wits.elen7045.group3.aps.domain.scrape.vo.ScrapedResult;
import za.ac.wits.elen7045.group3.aps.domain.vo.CredentialsVO;
import za.ac.wits.elen7045.group3.aps.services.scrape.scripts.WebsiteScraper;
public class CreditCardScrapeAdaptor implements ScrapeAdaptor{
	@Override
	public ScrapedResult scrapeWebsite(String url, CredentialsVO credenttials) {
		return WebsiteScraper.scrapeWebsite(url,credenttials);
	}

}
