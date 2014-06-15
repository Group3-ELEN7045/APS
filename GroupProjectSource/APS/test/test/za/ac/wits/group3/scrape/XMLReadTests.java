package test.za.ac.wits.group3.scrape;

import com.thoughtworks.xstream.XStream;

import static org.junit.Assert.*;    

import org.junit.After;  
import org.junit.Before;  
import org.junit.Test;  
import org.junit.runner.RunWith;  
import org.mockito.runners.MockitoJUnitRunner;  

import za.ac.wits.elen7045.group3.aps.services.scrape.APSXMLMarshaller;
import za.ac.wits.elen7045.group3.aps.services.util.AccountScrapedData;
import za.ac.wits.elen7045.group3.aps.services.util.ErrorScrapedData;
  
@RunWith(MockitoJUnitRunner.class)
public class XMLReadTests {
	
	String filePath;
	XStream xstream;	
	AccountScrapedData accountScrapedData;
	ErrorScrapedData errorScrapedData;
	@Before
	public void init(){
		xstream = new XStream();
		accountScrapedData = new AccountScrapedData();	
		errorScrapedData = new ErrorScrapedData();
	}
	@After
	public void tearDown(){
		xstream = null;
		accountScrapedData = null;
	}
	
	@Test
	public void testReadScrapeXMLForTelcoAccount(){
		
		filePath = ".\\telco.xml";
		accountScrapedData = (AccountScrapedData)new APSXMLMarshaller(filePath).convertAccountXMLToObject(AccountScrapedData.class);
		assertTrue(accountScrapedData.getBaseURL().equals("www.elen7045.co.za"));
		assertTrue(accountScrapedData.getDate().equals("12/12/2014"));
		assertTrue(accountScrapedData.getTime().equals("13:50:00"));
		assertTrue("Incorrect number of datapairs for Telco account",accountScrapedData.getDataPairList().size() == 19);
	}
	
	@Test
	public void testReadScrapeXMLForMunicipalAccount(){
		
		filePath = ".\\municipal.xml";
		accountScrapedData = (AccountScrapedData)new APSXMLMarshaller(filePath).convertAccountXMLToObject(AccountScrapedData.class);
		assertTrue(accountScrapedData.getBaseURL().equals("www.elen7045.co.za"));
		assertTrue(accountScrapedData.getDate().equals("12/12/2014"));
		assertTrue(accountScrapedData.getTime().equals("13:50:00"));	
		assertTrue("Incorrect number of datapairs for Municipal account",accountScrapedData.getDataPairList().size() == 23);
	}
	
	@Test
	public void testReadScrapeXMLForCreditCardAccount(){
		
		filePath = ".\\creditcard.xml";
		accountScrapedData = (AccountScrapedData)new APSXMLMarshaller(filePath).convertAccountXMLToObject(AccountScrapedData.class);
		assertTrue(accountScrapedData.getBaseURL().equals("www.elen7045.co.za"));
		assertTrue(accountScrapedData.getDate().equals("12/12/2014"));
		assertTrue(accountScrapedData.getTime().equals("13:50:00"));
		assertTrue("Incorrect number of datapairs for Credit Card account",accountScrapedData.getDataPairList().size() == 19);
	}
	
	@Test
	public void testReadScrapeXMLForError(){
		filePath = ".\\errors.xml";
		errorScrapedData = (ErrorScrapedData)new APSXMLMarshaller(filePath).convertErrorXMLToObject(ErrorScrapedData.class);
		assertTrue(errorScrapedData.getBaseURL().equals("www.elen7045.co.za"));
		assertTrue(errorScrapedData.getDate().equals("12/12/2014"));
		assertTrue(errorScrapedData.getTime().equals("13:50:00"));
		assertTrue(errorScrapedData.getError().equals("InvalidCredentials"));
	
	}


}
