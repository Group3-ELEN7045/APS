package test.za.ac.wits.group3.scrape;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.runners.MockitoJUnitRunner;

import com.thoughtworks.xstream.XStream;
  
@RunWith(MockitoJUnitRunner.class)

public class XMLDataTests {
	
	String filePath;
	XStream xstream;
	
	
	@Before
	public void init(){
		xstream = new XStream();
		filePath = "E:\\ELEN 7045\\Group Project\\New Folder\\return.xml";
		
	}
	@After
	public void tearDown(){
		
	}
	
	@Test
	public void testGenericRead(){
		
	}
	
	@Test
	public void testGenericWrite(){
		
	}
/*	
	@Test
	public void testMunicipalAccountRead(){
		
	}
	
	@Test
	public void testMunicipalAccountWrite(){
		
	}
	
	@Test
	public void testCreditCardAccountRead(){
		
	}
	
	@Test
	public void testCreditCardAccountWrite(){
		
	}
	
	@Test
	public void testTelcoAccountRead(){
	}
	
	@Test
	public void testTelcoAccountWrite(){
	}
	*/
	
	
	public static void main(String [] args)
	{
		
	}
}
