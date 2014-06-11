
/**
 * 
 */
package test;


import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

import sun.swing.FilePane;
import za.ac.wits.elen7045.group3.aps.domain.accounts.accounttypes.TelcoAccount;
import za.ac.wits.elen7045.group3.aps.domain.accounts.accounttypes.TelcoAccounts;
import za.ac.wits.elen7045.group3.aps.domain.entities.Customer;
import za.ac.wits.elen7045.group3.aps.domain.vo.DataPair;
import za.ac.wits.elen7045.group3.aps.services.util.APSXMLMarshaller;

import com.thoughtworks.xstream.XStream;
/**
 * @author SilasMahlangu
 *
 */
public class XSTreamTest {
	
	static String filePath = "E:\\ELEN 7045\\Group Project\\New Folder\\return.xml";
	public static class DummyClass{
		DataPair dataPair;
		
		public DummyClass(){

			dataPair = new DataPair("001","account no","1234567");
		}

		@Override
		public String toString() {
			return "DummyClass [dataPair=" + dataPair + "]";
		}

	
		
	}
	/**
	 * @param args
	 */
	public static void main(String[] args) throws FileNotFoundException{
		
		
		/*DummyClass dumz = new DummyClass();
		PrintWriter writer = new PrintWriter(filePath);
	
		XStream xml = new XStream();
		xml.alias("scrape-session",DummyClass.class);
		xml.aliasField("datapair", DummyClass.class, "dataPair");
		
		xml.useAttributeFor(DataPair.class, "id");
		writer.println(xml.toXML(dumz));
		writer.close();
		dumz = (DummyClass)xml.fromXML(new File(filePath));
		System.out.println(xml.toXML(dumz));*/
		
		TelcoAccounts dumz = new TelcoAccounts(new DataPair("001","Account no","2434434") );
		//PrintWriter writer = new PrintWriter(filePath);
		
		XStream xml = new XStream();
		
		
				
		System.out.println(new APSXMLMarshaller(xml).objectToXML("scrape-session", dumz));
		//xml.processAnnotations(GetConfigurationParametersResponse.class);

		//writer.println(xml.toXML(dumz));
		//writer.close();
		//dumz = (TelcoAccounts)xml.fromXML(new File(filePath));
		//System.out.println(xml.toXML(dumz));
	}

}
