package za.ac.wits.elen7045.group3.aps.services.scrape.acl;
/**
 * @author bakwanyana
 */
import za.ac.wits.elen7045.group3.aps.domain.entities.BillingAccount;
import za.ac.wits.elen7045.group3.aps.domain.vo.CredentialsVO;
import za.ac.wits.elen7045.group3.aps.vo.scrape.ScrapedResult;
public class MunicipalScrapeAdaptor implements ScrapeAdaptor{
	@Override
	public ScrapedResult scrapeWebsite(String url, CredentialsVO credentialsVO) {
		String filePath = "..\\..\\XML Files\\municipal.xml";
		/*WebsiteScraper.scrapeWebsite(
				url, 
				account.getAccountNumber(), 
				account.getCredentials().getUserName(), 
				account.getCredentials().getPassword());*/
		return (ScrapedResult)new XMLFileMarshall().convertScrapedDataToObject(ScrapedResult.class, filePath);		
	}

}
