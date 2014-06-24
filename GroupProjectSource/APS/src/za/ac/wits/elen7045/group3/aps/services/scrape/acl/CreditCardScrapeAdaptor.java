package za.ac.wits.elen7045.group3.aps.services.scrape.acl;
/**
 * @author bakwanyana
 * @author boitumelo(refactoring)
 */
import za.ac.wits.elen7045.group3.aps.domain.vo.CredentialsVO;
import za.ac.wits.elen7045.group3.aps.scrape.scripts.WebsiteScraper;
import za.ac.wits.elen7045.group3.aps.services.scraper.ScrapeResult;
import za.ac.wits.elen7045.group3.aps.services.scraper.interfaces.ScrapeAdaptor;
public class CreditCardScrapeAdaptor implements ScrapeAdaptor{
	@Override
	public ScrapeResult scrapeWebsite(String url, CredentialsVO credenttials) {
		return WebsiteScraper.scrapeWebsite(url,credenttials);
	}

}
