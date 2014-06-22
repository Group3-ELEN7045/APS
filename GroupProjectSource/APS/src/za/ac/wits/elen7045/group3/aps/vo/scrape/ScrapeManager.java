package za.ac.wits.elen7045.group3.aps.vo.scrape;
/**
 * @author bakwanyana
 */
import java.util.List;

import za.ac.wits.elen7045.group3.aps.phantomscraper.*;
import za.ac.wits.elen7045.group3.aps.domain.accounts.abtracts.AbstractBillingAccountStatement;
import za.ac.wits.elen7045.group3.aps.domain.entities.BillingAccount;
import za.ac.wits.elen7045.group3.aps.domain.entities.BillingCompany;
import za.ac.wits.elen7045.group3.aps.domain.scrape.entities.ScrapeRequest;
import za.ac.wits.elen7045.group3.aps.services.enumtypes.CompanyStatementType;
import za.ac.wits.elen7045.group3.aps.services.scrape.acl.XMLFileMarshall;
import za.ac.wits.elen7045.group3.aps.vo.exception.scrape.DataIntegrityException;
import za.ac.wits.elen7045.group3.aps.vo.exception.scrape.DuplicateDataException;
import za.ac.wits.elen7045.group3.aps.vo.exception.scrape.ScrapeErrorException;
import za.ac.wits.elen7045.group3.aps.vo.exception.scrape.VatCalculationException;
import za.ac.wits.elen7045.group3.aps.vo.specification.scrape.BillingAccountSuitableForScrapeSpecification;

public class ScrapeManager {
	private ScrapeRequest scrapeRequest;
	private BillingCompany billingCompany;
	private String filePath; 
	private AbstractBillingAccountStatement scrapedStatement;
	private ScrapedResult scrapedXML;
	// TODO depend on implementations here??
	private BillingAccountSuitableForScrapeSpecification scrapeCriteria;
	
	
	public ScrapeManager(ScrapeRequest scrapeRequest, String filePath){
		this.scrapeRequest = scrapeRequest;
		this.filePath = filePath;
		scrapeCriteria = new BillingAccountSuitableForScrapeSpecification();
		this.billingCompany = new BillingCompany(scrapeRequest.getBillingCompany().getCompanyName());
	}
	
	public void scrapeWebsite(){
		List <BillingAccount> accounts = scrapeRequest.getBillingCompany().getBillingAccounts();
		String url = scrapeRequest.getBillingCompany().getUrl();
		for(BillingAccount billingAccount: accounts){
			if(scrapeCriteria.isSatisfiedBy(billingAccount)){
				WebsiteScraper.scrapeWebsite(url, 
						billingAccount.getCredentials().getUserName(), 
						billingAccount.getCredentials().getPassword(), 
						billingAccount.getAccountNumber()
					);
			}
		}
		try{ // what happens when in a loop and exception is thrown??
		scrapedStatement = readScrapedResults(filePath);
		
		// successful scrape logic
		}
		catch(ScrapeErrorException e){
			// error logic
		}
		catch(DataIntegrityException e){
			// statement data error logic
		}
		catch(DuplicateDataException e){
			// statement data error logic
		}
		catch(VatCalculationException e){
			// statement data error logic
		}
		catch(Exception e){
			
		}
	}
	
	private AbstractBillingAccountStatement readScrapedResults(String filePath) 
			throws DataIntegrityException, DuplicateDataException, ScrapeErrorException, VatCalculationException{
		
		CompanyStatementType companyType = billingCompany.getCompanyType();
		scrapedXML = (ScrapedResult)new XMLFileMarshall().convertScrapedDataToObject(ScrapedResult.class, filePath);
		
		ScrapedStatementConverter statementAdaptor = new ScrapedStatementConverter(scrapedXML, companyType, new DefaultNumericDataFormatStrategy());
		
		return statementAdaptor.getStatement();
	}
	
}
