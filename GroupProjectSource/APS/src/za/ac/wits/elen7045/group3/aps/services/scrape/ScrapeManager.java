package za.ac.wits.elen7045.group3.aps.services.scrape;
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
import za.ac.wits.elen7045.group3.aps.services.specification.scrape.SuitableForScrapeSpecification;

public class ScrapeManager {
	private ScrapeRequest scrapeRequest;
	private BillingCompany billingCompany;
	private String filePath; 
	private AbstractBillingAccountStatement scrapedStatement;
	private StatementScrapedData scrapedXML;
	// TODO depend on implementations here??
	private SuitableForScrapeSpecification scrapeCriteria;
	
	
	public ScrapeManager(ScrapeRequest scrapeRequest, String filePath){
		this.scrapeRequest = scrapeRequest;
		this.filePath = filePath;
		scrapeCriteria = new SuitableForScrapeSpecification();
		this.billingCompany = new BillingCompany(scrapeRequest.getBillingCompany());
	}
	
	public void scrapeWebsite(){
		List <BillingAccount> accounts = scrapeRequest.getBillingCompany().getBillingAccounts();
		String url = scrapeRequest.getBillingCompany().getUrl();
		for(int i = 0; i < accounts.size(); i++){
			if(scrapeCriteria.isSatisfiedBy(accounts.get(i))){
				WebsiteScraper.scrapeWebsite(url, 
					billingCompany.getBillingAccounts().get(i).getCredentials().getUserName(), 
					billingCompany.getBillingAccounts().get(i).getCredentials().getPassword(), 
					billingCompany.getBillingAccounts().get(i).getAccountNumber()
				);
			}
		}
		try{
		scrapedStatement = readScrapedResults(filePath);
		
		// successful scrape logic
		}
		catch(ScrapeErrorException e){
			// error logic
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
			throws DuplicateDataException, ScrapeErrorException, VatCalculationException{
		
		APSXMLMarshaller marshaller = new APSXMLMarshaller(filePath);
		CompanyStatementType companyType = billingCompany.getCompanyType();
		scrapedXML = (StatementScrapedData)marshaller.convertScrapedXMLToObject(StatementScrapedData.class);
		
		ScrapedStatementAdaptor statementAdaptor = new ScrapedStatementAdaptor(scrapedXML, companyType, new DefaultNumericDataConverterStrategy());
		
		return statementAdaptor.getStatement();
	}
	
}
