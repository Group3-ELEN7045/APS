package test.za.ac.wits.elen7045.group3.scrape;
/**
 * @author bakwanyana
 */

import com.thoughtworks.xstream.XStream;

import static org.junit.Assert.*;    

import org.junit.After;  
import org.junit.Before;  
import org.junit.Test;  

import za.ac.wits.elen7045.group3.aps.domain.scrape.vo.ScrapedResult;
import za.ac.wits.elen7045.group3.aps.services.scrape.acl.XMLFileToScrapedResultTranslator;

public class ScrapedXMLFileReadTests {
	
	String filePath;
	XStream xstream;	
	ScrapedResult statementScrapedData;
	@Before
	public void init(){
		xstream = new XStream();
		statementScrapedData = new ScrapedResult(null,null,null,null);	
	}
	@After
	public void tearDown(){
		xstream = null;
		statementScrapedData = null;
	}
	
	@Test
	public void testReadScrapeXMLForTelcoAccount(){
		filePath = "..\\..\\XML Files\\telco.xml";
		statementScrapedData = (ScrapedResult)new XMLFileToScrapedResultTranslator().convertScrapedDataToObject(ScrapedResult.class, filePath);
		assertTrue(statementScrapedData.getBaseURL().equals("www.elen7045.co.za"));
		assertTrue(statementScrapedData.getDate().equals("12/12/2014"));
		assertTrue(statementScrapedData.getTime().equals("13:50:00"));
		assertTrue("Incorrect number of datapairs for Telco account",statementScrapedData.getDataPairSize() == 19);
	}
	
	@Test
	public void testReadScrapeXMLForMunicipalAccount(){
		
		filePath = "..\\..\\XML Files\\municipal.xml";
		statementScrapedData = (ScrapedResult)new XMLFileToScrapedResultTranslator().convertScrapedDataToObject(ScrapedResult.class, filePath);
		assertTrue(statementScrapedData.getBaseURL().equals("www.elen7045.co.za"));
		assertTrue(statementScrapedData.getDate().equals("12/12/2014"));
		assertTrue(statementScrapedData.getTime().equals("13:50:00"));	
		assertTrue("Incorrect number of datapairs for Municipal account",statementScrapedData.getDataPairSize() == 23);
	}
	
	@Test
	public void testReadScrapeXMLForCreditCardAccount(){
		
		filePath = "..\\..\\XML Files\\creditcard.xml";
		statementScrapedData = (ScrapedResult)new XMLFileToScrapedResultTranslator().convertScrapedDataToObject(ScrapedResult.class, filePath);
		assertTrue(statementScrapedData.getBaseURL().equals("www.elen7045.co.za"));
		assertTrue(statementScrapedData.getDate().equals("12/12/2014"));
		assertTrue(statementScrapedData.getTime().equals("13:50:00"));
		assertTrue("Incorrect number of datapairs for Credit Card account",statementScrapedData.getDataPairSize() == 19);
	}
	
	@Test
	public void testReadScrapeXMLForError(){
		
		filePath = "..\\..\\XML Files\\errors.xml";
		statementScrapedData = (ScrapedResult)new XMLFileToScrapedResultTranslator().convertScrapedDataToObject(ScrapedResult.class, filePath);
		assertTrue(statementScrapedData.getBaseURL().equals("www.elen7045.co.za"));
		assertTrue(statementScrapedData.getDate().equals("12/12/2014"));
		assertTrue(statementScrapedData.getTime().equals("13:50:00"));
		assertTrue(statementScrapedData.getDataPairListItemText(0).equals("Scraper Error"));
		assertTrue("Incorrect number of datapairs for Credit Card account",statementScrapedData.getDataPairSize() == 1);
	}



}
