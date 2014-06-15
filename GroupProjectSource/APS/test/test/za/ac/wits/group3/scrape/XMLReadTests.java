package test.za.ac.wits.group3.scrape;

import com.thoughtworks.xstream.XStream;

import static org.junit.Assert.*;    

import org.junit.After;  
import org.junit.Before;  
import org.junit.Test;  
import org.junit.runner.RunWith;  
import org.mockito.runners.MockitoJUnitRunner;  

import za.ac.wits.elen7045.group3.aps.domain.accounts.accounttypes.Accounts;
import za.ac.wits.elen7045.group3.aps.services.scrape.APSXMLMarshaller;
  
@RunWith(MockitoJUnitRunner.class)
public class XMLReadTests {
	
	String filePath;
	XStream xstream;	
	Accounts scrapedAccount;
	
	@Before
	public void init(){
		xstream = new XStream();
		scrapedAccount = new Accounts();	
	}
	@After
	public void tearDown(){
		xstream = null;
		scrapedAccount = null;
	}
	
	@Test
	public void testReadScrapeXMLForTelcoAccount()
	{
		
		filePath = ".\\telco.xml";
		scrapedAccount = (Accounts)new APSXMLMarshaller(filePath).convertXMLFileToObject(Accounts.class);
		assertTrue("There are incorrect number of datapairs for this Account type",scrapedAccount.getDataPairList().size() == 19);
		assertTrue(scrapedAccount.getBaseURL().equals("www.elen7045.co.za"));
		assertTrue(scrapedAccount.getDate().equals("12/12/2014"));
		assertTrue(scrapedAccount.getTime().equals("13:50:00"));
	}
	
	@Test
	public void testReadScrapeXMLForMunicipalAccount()
	{
		
		filePath = ".\\municipal.xml";
		scrapedAccount = (Accounts)new APSXMLMarshaller(filePath).convertXMLFileToObject(Accounts.class);
		assertTrue("There are incorrect number of datapairs for this Account type",scrapedAccount.getDataPairList().size() == 22);
		assertTrue(scrapedAccount.getBaseURL().equals("www.elen7045.co.za"));
		assertTrue(scrapedAccount.getDate().equals("12/12/2014"));
		assertTrue(scrapedAccount.getTime().equals("13:50:00"));	
	}
	
	@Test
	public void testReadScrapeXMLForCreditCardAccount()
	{
		
		filePath = ".\\creditcard.xml";
		scrapedAccount = (Accounts)new APSXMLMarshaller(filePath).convertXMLFileToObject(Accounts.class);
		assertTrue("There are incorrect number of datapairs for this Account type",scrapedAccount.getDataPairList().size() == 19);
		assertTrue(scrapedAccount.getBaseURL().equals("www.elen7045.co.za"));
		assertTrue(scrapedAccount.getBaseURL().equals("www.elen7045.co.za"));
		assertTrue(scrapedAccount.getDate().equals("12/12/2014"));
		assertTrue(scrapedAccount.getTime().equals("13:50:00"));
	}
	


}
