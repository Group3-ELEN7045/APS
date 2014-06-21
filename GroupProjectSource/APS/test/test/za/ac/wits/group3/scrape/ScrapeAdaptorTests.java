package test.za.ac.wits.group3.scrape;
/**
 * @author bakwanyana
 */
import com.thoughtworks.xstream.XStream;

import static org.junit.Assert.*;    

import org.junit.After;  
import org.junit.Before;  
import org.junit.Test;  

import za.ac.wits.elen7045.group3.aps.services.scrape.acl.*;
import za.ac.wits.elen7045.group3.aps.vo.scrape.StatementScrapedData;

public class ScrapeAdaptorTests {
	
	String filePath;
	XStream xstream;	
	StatementScrapedData statementScrapedData;
	TelcoScrapeAdaptor telcoScrapeAdaptor;
	MunicipalScrapeAdaptor munipalScrapeAdaptor;
	CreditCardScrapeAdaptor crediCardScrapeAdapter;
	@Before
	public void init(){
		xstream = new XStream();
		statementScrapedData = new StatementScrapedData(null,null,null,null);	
		telcoScrapeAdaptor = new TelcoScrapeAdaptor();
		munipalScrapeAdaptor = new MunicipalScrapeAdaptor();
		crediCardScrapeAdapter = new CreditCardScrapeAdaptor();
		
	}
	@After
	public void tearDown(){
		xstream = null;
		statementScrapedData = null;
	}
	
	@Test
	public void testReadScrapeAdaptorForTelcoAccount(){
		statementScrapedData = telcoScrapeAdaptor.scrapeWebsite(null, null);
		assertTrue(statementScrapedData.getBaseURL().equals("www.elen7045.co.za"));
		assertTrue(statementScrapedData.getDate().equals("12/12/2014"));
		assertTrue(statementScrapedData.getTime().equals("13:50:00"));
		assertTrue("Incorrect number of datapairs for Telco account",statementScrapedData.getDataPairList().size() == 19);
	}
	

	@Test
	public void testReadScrapeAdaptorForMunicipalAccount(){
		statementScrapedData = munipalScrapeAdaptor.scrapeWebsite(null, null);
		assertTrue(statementScrapedData.getBaseURL().equals("www.elen7045.co.za"));
		assertTrue(statementScrapedData.getDate().equals("12/12/2014"));
		assertTrue(statementScrapedData.getTime().equals("13:50:00"));	
		assertTrue("Incorrect number of datapairs for Municipal account",statementScrapedData.getDataPairList().size() == 23);
	}
	
	@Test
	public void testReadScrapeAdaptorForCreditCardAccount(){
		statementScrapedData = crediCardScrapeAdapter.scrapeWebsite(null, null);
		assertTrue(statementScrapedData.getBaseURL().equals("www.elen7045.co.za"));
		assertTrue(statementScrapedData.getDate().equals("12/12/2014"));
		assertTrue(statementScrapedData.getTime().equals("13:50:00"));
		assertTrue("Incorrect number of datapairs for Credit Card account",statementScrapedData.getDataPairList().size() == 19);
	}
}