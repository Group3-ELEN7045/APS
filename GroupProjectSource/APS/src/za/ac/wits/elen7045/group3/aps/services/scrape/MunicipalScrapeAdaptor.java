package za.ac.wits.elen7045.group3.aps.services.scrape;

import za.ac.wits.elen7045.group3.aps.domain.entities.BillingAccount;
import za.ac.wits.elen7045.group3.aps.phantomscraper.WebsiteScraper;
public class MunicipalScrapeAdaptor implements ScrapeAdaptor{

	private StatementScrapedData scrapedXML;
	@Override
	public StatementScrapedData scrapeWebsite(String url, BillingAccount account) {
		String filePath = "..\\..\\XML Files\\municipal.xml";
		WebsiteScraper.scrapeWebsite(
				url, 
				account.getAccountNumber(), 
				account.getCredentials().getUserName(), 
				account.getCredentials().getPassword());
		APSXMLMarshaller marshaller = new APSXMLMarshaller(filePath);
		scrapedXML = (StatementScrapedData)marshaller.convertScrapedXMLToObject(StatementScrapedData.class);
		return scrapedXML;
	}

}
