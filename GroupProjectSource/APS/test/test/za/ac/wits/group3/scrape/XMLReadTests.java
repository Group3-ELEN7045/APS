package test.za.ac.wits.group3.scrape;

import com.thoughtworks.xstream.XStream;

import static org.junit.Assert.*;    

import org.junit.After;  
import org.junit.Before;  
import org.junit.Test;  
import org.junit.runner.RunWith;  
import org.mockito.runners.MockitoJUnitRunner;  

import za.ac.wits.elen7045.group3.aps.services.scrape.APSXMLMarshaller;
import za.ac.wits.elen7045.group3.aps.services.util.StatementScrapedData;
//import za.ac.wits.elen7045.group3.aps.services.util.ScrapedErrorData;

  
@RunWith(MockitoJUnitRunner.class)
public class XMLReadTests {
	
	String filePath;
	XStream xstream;	
	StatementScrapedData statementScrapedData;
	@Before
	public void init(){
		xstream = new XStream();
		statementScrapedData = new StatementScrapedData();	
	}
	@After
	public void tearDown(){
		xstream = null;
		statementScrapedData = null;
	}
	
	@Test
	public void testReadScrapeXMLForTelcoAccount(){
		
		filePath = ".\\telco.xml";
		statementScrapedData = (StatementScrapedData)new APSXMLMarshaller(filePath).convertScrapedXMLToObject(StatementScrapedData.class);
		assertTrue(statementScrapedData.getBaseURL().equals("www.elen7045.co.za"));
		assertTrue(statementScrapedData.getDate().equals("12/12/2014"));
		assertTrue(statementScrapedData.getTime().equals("13:50:00"));
		assertTrue("Incorrect number of datapairs for Telco account",statementScrapedData.getDataPairList().size() == 19);
	}
	
	@Test
	public void testReadScrapeXMLForMunicipalAccount(){
		
		filePath = ".\\municipal.xml";
		statementScrapedData = (StatementScrapedData)new APSXMLMarshaller(filePath).convertScrapedXMLToObject(StatementScrapedData.class);
		assertTrue(statementScrapedData.getBaseURL().equals("www.elen7045.co.za"));
		assertTrue(statementScrapedData.getDate().equals("12/12/2014"));
		assertTrue(statementScrapedData.getTime().equals("13:50:00"));	
		assertTrue("Incorrect number of datapairs for Municipal account",statementScrapedData.getDataPairList().size() == 23);
	}
	
	@Test
	public void testReadScrapeXMLForCreditCardAccount(){
		
		filePath = ".\\creditcard.xml";
		statementScrapedData = (StatementScrapedData)new APSXMLMarshaller(filePath).convertScrapedXMLToObject(StatementScrapedData.class);
		assertTrue(statementScrapedData.getBaseURL().equals("www.elen7045.co.za"));
		assertTrue(statementScrapedData.getDate().equals("12/12/2014"));
		assertTrue(statementScrapedData.getTime().equals("13:50:00"));
		assertTrue("Incorrect number of datapairs for Credit Card account",statementScrapedData.getDataPairList().size() == 19);
	}
	
	@Test
	public void testReadScrapeXMLForError(){
		
		filePath = ".\\errors.xml";
		statementScrapedData = (StatementScrapedData)new APSXMLMarshaller(filePath).convertScrapedXMLToObject(StatementScrapedData.class);
		assertTrue(statementScrapedData.getBaseURL().equals("www.elen7045.co.za"));
		assertTrue(statementScrapedData.getDate().equals("12/12/2014"));
		assertTrue(statementScrapedData.getTime().equals("13:50:00"));
		assertTrue(statementScrapedData.getDataPairList().get(0).getText().equals("Scraper Error"));
		assertTrue("Incorrect number of datapairs for Credit Card account",statementScrapedData.getDataPairList().size() == 1);
	}



}
