package test.za.ac.wits.group3.scrape;

import java.io.File;

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
  
@RunWith(MockitoJUnitRunner.class)


public class XMLDataTests {
	static String filePath = "E:\\ELEN 7045\\Group Project\\New Folder\\return.xml";
	static XStream xstream;
	
	@Before
	public void init(){
		xstream = new XStream();
	}
	@After
	public void tearDown(){
		
		
	}
	
	@Test
	public void testXMLRead(){
		Object newObj = (Object)xstream.fromXML(new File(filePath));
		System.out.println(newObj);
	}
	
	public static void main(String [] args)
	{
		Object newObj = (Object)xstream.fromXML(new File(filePath));
		System.out.println(newObj);
	}
}
