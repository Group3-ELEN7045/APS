package za.ac.wits.elen7045.group3.aps.services.scrape.acl;
/**
 * @author bakwanyana
 */
import za.ac.wits.elen7045.group3.aps.domain.entities.BillingAccount;
import za.ac.wits.elen7045.group3.aps.phantomscraper.WebsiteScraper;
import za.ac.wits.elen7045.group3.aps.vo.scrape.StatementScrapedData;
public class CreditCardScrapeAdaptor implements ScrapeAdaptor{
	
	@Override
	public StatementScrapedData scrapeWebsite(String url, BillingAccount account) {
		String filePath = "..\\..\\XML Files\\municipal.xml";
		WebsiteScraper.scrapeWebsite(
				url, 
				account.getAccountNumber(), 
				account.getCredentials().getUserName(), 
				account.getCredentials().getPassword());
		return (StatementScrapedData)new XMLFileMarshall().convertScrapedDataToObject(StatementScrapedData.class, filePath);
	}

}
