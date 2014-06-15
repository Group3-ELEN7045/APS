package test.za.ac.wits.group3.scrape;

import com.thoughtworks.xstream.XStream;

import static org.junit.Assert.*;    

import org.junit.After;  
import org.junit.Before;  
import org.junit.Test;  
import org.junit.runner.RunWith;  
import org.mockito.runners.MockitoJUnitRunner;  

import za.ac.wits.elen7045.group3.aps.services.scrape.APSXMLMarshaller;
import za.ac.wits.elen7045.group3.aps.services.util.ScrapedData;
  
@RunWith(MockitoJUnitRunner.class)
public class XMLReadTests {
	
	String filePath;
	XStream xstream;	
	ScrapedData scrapedData;
	
	@Before
	public void init(){
		xstream = new XStream();
		scrapedData = new ScrapedData();	
	}
	@After
	public void tearDown(){
		xstream = null;
		scrapedData = null;
	}
	
	@Test
	public void testReadScrapeXMLForTelcoAccount()
	{
		
		filePath = ".\\telco.xml";
		scrapedData = (ScrapedData)new APSXMLMarshaller(filePath).convertXMLFileToObject(ScrapedData.class);
		assertTrue(scrapedData.getBaseURL().equals("www.elen7045.co.za"));
		assertTrue(scrapedData.getDate().equals("12/12/2014"));
		assertTrue(scrapedData.getTime().equals("13:50:00"));
		assertTrue("Incorrect number of datapairs for Telco account",scrapedData.getDataPairList().size() == 19);
	}
	
	@Test
	public void testReadScrapeXMLForMunicipalAccount()
	{
		
		filePath = ".\\municipal.xml";
		scrapedData = (ScrapedData)new APSXMLMarshaller(filePath).convertXMLFileToObject(ScrapedData.class);
		assertTrue(scrapedData.getBaseURL().equals("www.elen7045.co.za"));
		assertTrue(scrapedData.getDate().equals("12/12/2014"));
		assertTrue(scrapedData.getTime().equals("13:50:00"));	
		assertTrue("Incorrect number of datapairs for Municipal account",scrapedData.getDataPairList().size() == 23);
	}
	
	@Test
	public void testReadScrapeXMLForCreditCardAccount()
	{
		
		filePath = ".\\creditcard.xml";
		scrapedData = (ScrapedData)new APSXMLMarshaller(filePath).convertXMLFileToObject(ScrapedData.class);
		assertTrue(scrapedData.getBaseURL().equals("www.elen7045.co.za"));
		assertTrue(scrapedData.getDate().equals("12/12/2014"));
		assertTrue(scrapedData.getTime().equals("13:50:00"));
		assertTrue("Incorrect number of datapairs for Credit Card account",scrapedData.getDataPairList().size() == 19);
	}
	
	@Test
	public void testReadScrapeXMLForError(){
		filePath = ".\\error.xml";
		scrapedData = (ScrapedData)new APSXMLMarshaller(filePath).convertXMLFileToObject(ScrapedData.class);
		assertTrue(scrapedData.getBaseURL().equals("www.elen7045.co.za"));
		assertTrue(scrapedData.getDate().equals("12/12/2014"));
		assertTrue(scrapedData.getTime().equals("13:50:00"));
		assertTrue("Incorrect number of datapairs for error",scrapedData.getDataPairList().size() == 1);
	}


}
