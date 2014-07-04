package test.za.ac.wits.elen7045.group3.scrape;
/**
 * @author bakwanyana
 */
import com.thoughtworks.xstream.XStream;

import static org.junit.Assert.*;    

import org.junit.After;  
import org.junit.Before;  
import org.junit.Test;  

import za.ac.wits.elen7045.group3.aps.domain.entities.BillingAccount;
import za.ac.wits.elen7045.group3.aps.domain.entities.BillingCompany;
import za.ac.wits.elen7045.group3.aps.domain.scrape.vo.ScrapedResult;
import za.ac.wits.elen7045.group3.aps.domain.vo.CredentialsVO;
import za.ac.wits.elen7045.group3.aps.services.scrape.acl.*;

public class ScrapeAdaptorTests {
	
	String filePath;
	XStream xstream;	
	ScrapedResult statementScrapedData;
	XMLToScrapedResultAdaptor telcoScrapeAdaptor;
	XMLToScrapedResultAdaptor munipalScrapeAdaptor;
	XMLToScrapedResultAdaptor crediCardScrapeAdapter;
	
	BillingAccount billingAccount;
	BillingCompany billingCo;
	
	@Before
	public void init(){
		xstream = new XStream();
		telcoScrapeAdaptor = new XMLToScrapedResultAdaptor();
		munipalScrapeAdaptor = new XMLToScrapedResultAdaptor();
		crediCardScrapeAdapter = new XMLToScrapedResultAdaptor();
		
		billingCo = new BillingCompany("JoburgMunicipality");
		billingCo.setURL("http:////localhost/APS/municipal.xml");
		billingAccount = new BillingAccount(1L,98986L,"9098777546");
		billingAccount.setCredentials(new CredentialsVO());
		
	}
	@After
	public void tearDown(){
		xstream = null;
		statementScrapedData = null;
	}
	
	@Test
	public void testReadScrapeAdaptorForTelcoAccount(){
		billingAccount.setCompanyUrl("..\\..\\XML Files\\telco.xml");
		statementScrapedData = telcoScrapeAdaptor.scrapeWebsite(billingAccount.getCompanyUrl(), billingAccount.getCredentials());
		
		assertTrue(statementScrapedData.getBaseURL().equals("www.elen7045.co.za"));
		assertTrue(statementScrapedData.getDate().equals("12/12/2014"));
		assertTrue(statementScrapedData.getTime().equals("13:50:00"));
		assertTrue("Incorrect number of datapairs for Telco account",statementScrapedData.getDataPairSize() == 19);
	}
	

	@Test
	public void testReadScrapeAdaptorForMunicipalAccount(){

		billingAccount.setCompanyUrl("..\\..\\XML Files\\municipal.xml");
		statementScrapedData = munipalScrapeAdaptor.scrapeWebsite(billingAccount.getCompanyUrl(), billingAccount.getCredentials());
		
		assertTrue(statementScrapedData.getBaseURL().equals("www.elen7045.co.za"));
		assertTrue(statementScrapedData.getDate().equals("12/12/2014"));
		assertTrue(statementScrapedData.getTime().equals("13:50:00"));	
		assertTrue("Incorrect number of datapairs for Municipal account",statementScrapedData.getDataPairSize() == 23);
	}
	
	@Test
	public void testReadScrapeAdaptorForCreditCardAccount(){

		billingAccount.setCompanyUrl("..\\..\\XML Files\\creditcard.xml");
		statementScrapedData = crediCardScrapeAdapter.scrapeWebsite(billingAccount.getCompanyUrl(), billingAccount.getCredentials());
		
		assertTrue(statementScrapedData.getBaseURL().equals("www.elen7045.co.za"));
		assertTrue(statementScrapedData.getDate().equals("12/12/2014"));
		assertTrue(statementScrapedData.getTime().equals("13:50:00"));
		assertTrue("Incorrect number of datapairs for Credit Card account",statementScrapedData.getDataPairSize() ==  19);
	}
}