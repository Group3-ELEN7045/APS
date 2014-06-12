package test.za.ac.wits.group3.scrape;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.xml.crypto.Data;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.StaxDriver;

import static org.junit.Assert.*;  
import static org.mockito.Mockito.*;  

import org.junit.After;  
import org.junit.Before;  
import org.junit.Test;  
import org.junit.runner.RunWith;  
import org.mockito.Mock;  
import org.mockito.MockitoAnnotations;
import org.mockito.runners.MockitoJUnitRunner;  

import test.XSTreamTest.DummyClass;
import za.ac.wits.elen7045.group3.aps.domain.accounts.accounttypes.Accounts;
import za.ac.wits.elen7045.group3.aps.domain.accounts.accounttypes.CreditCardAccount;
import za.ac.wits.elen7045.group3.aps.domain.accounts.accounttypes.TelcoAccounts;
import za.ac.wits.elen7045.group3.aps.domain.vo.DataPair;
import za.ac.wits.elen7045.group3.aps.services.util.APSXMLMarshaller;
  
@RunWith(MockitoJUnitRunner.class)

public class XMLReadTests {
	
	String filePath;
	XStream xstream;
	File file;
	PrintWriter writer;
	static Accounts dummyScrapeObjectOut, dummyScrapeObjectIn;
	List<DataPair> dp;
	
	String xml = "<scrape-session>"
			+ "<baseURL>www.facebook.com</baseURL>"
			+ "<date>12/12/2014</date>"
			+ "<time>00:28:56</time>"
			+ "<datapair id=\"001\">"
					+ "<text>Account Number</text>"
					+ "<value>123456789</value>"
					+ "</datapair>"
			+ "</scrape-session>";

	
	
	@Before
	public void init() throws FileNotFoundException{
		dummyScrapeObjectOut = new Accounts();
		dummyScrapeObjectIn = new Accounts();
		xstream = new XStream();
		
		xstream.alias("scrape-session",Accounts.class);
		xstream.alias("datapair",DataPair.class);
		xstream.useAttributeFor(DataPair.class, "id");
		xstream.addImplicitCollection(Accounts.class, "dataPairs"); // no List class tag, only entries
		
		dummyScrapeObjectOut.setBaseURL("www.facebook.com");
		dummyScrapeObjectOut.setDate("12/12/2014");
		dummyScrapeObjectOut.setTime("00:28:56");
		
		filePath = ".\\test.xml";
		file = new File(filePath);
		writer = new PrintWriter(file);
		
		
		dp = dummyScrapeObjectOut.getDataPairList();
		dp.add(new DataPair("001","Account Number","123456789"));	
		
	}
	@After
	public void tearDown(){
		writer.close();
		xstream = null;
		file = null;
		dummyScrapeObjectOut = null;
		dummyScrapeObjectIn = null;
	}
	
	@Test
	public void testReadScrapeXMLForTelcoAccount()
	{
		
		writer.println(xstream.toXML(dummyScrapeObjectOut));	
		writer.close();
		
		dummyScrapeObjectIn = (Accounts)new APSXMLMarshaller(filePath).convertXMLFileToObject(Accounts.class);
		assert(xstream.toXML(dummyScrapeObjectIn.getDataPairList().get(0)).equals(xml));
		
		
	}
	
	
	/*
	@Test
	public void testReadScrapeXMLForMunicipalAccount(){
		dummyScrapeObjectOut.loadMunicipalAccountData();
		writer.println(xstream.toXML(dummyScrapeObjectOut));
	}
	@Test
	public void testReadScrapeXMLForCreditCardAccount(){
		dummyScrapeObjectOut.loadCreditCardAccountData();
		writer.println(xstream.toXML(dummyScrapeObjectOut));
	}
	
	

	*/
	
	/*@Test
	public void testReadScrapeXMLForError(){
		
	}*/
	


}
