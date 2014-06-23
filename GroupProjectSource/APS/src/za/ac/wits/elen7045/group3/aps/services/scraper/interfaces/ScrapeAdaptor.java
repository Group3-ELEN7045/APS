package za.ac.wits.elen7045.group3.aps.services.scraper.interfaces;

import za.ac.wits.elen7045.group3.aps.domain.vo.CredentialsVO;
import za.ac.wits.elen7045.group3.aps.vo.scrape.*;

public interface ScrapeAdaptor {
	ScrapedResult scrapeWebsite(String url, CredentialsVO credenttials);
}
