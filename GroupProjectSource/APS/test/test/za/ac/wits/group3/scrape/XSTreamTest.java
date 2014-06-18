
/**
 * 
 */
package test.za.ac.wits.group3.scrape;


import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import sun.swing.FilePane;
import za.ac.wits.elen7045.group3.aps.domain.entities.Customer;
import za.ac.wits.elen7045.group3.aps.domain.vo.DataPair;
import za.ac.wits.elen7045.group3.aps.services.scrape.APSXMLMarshaller;
import za.ac.wits.elen7045.group3.aps.services.util.StatementScrapedData;

import com.thoughtworks.xstream.XStream;
/**
 * @author SilasMahlangu
 *
 */
public class XSTreamTest {
	
	static String filePath = "E:\\ELEN 7045\\Group Project\\New Folder\\return1.xml";
	
	static String myxml = "<scrape-session>"
			+ "<baseURL>www.xbox.com</baseURL>"
			+ "<date>12/12/2014</date>"
			+ "<time>00:28:56</time>"
			+ "<datapair id=\"001\">"
					+ "<text>Account Number</text>"
					+ "<value>123456789</value>"
					+ "</datapair>"
			+ "</scrape-session>";
	public static class DummyClass{
		
		String baseURL;
		String date;
		String time;
		List <DataPair> dataPairs;
		

		
		public DummyClass(){
			baseURL="www.xbox.com";
			date="12/12/2014";
			time="00:28:56";
			dataPairs = new ArrayList<DataPair>();
			dataPairs.add(new DataPair("001","Account Number","123456789"));
			/*dataPairs.add(new DataPair("002","Account holder name","Jack Parcell"));
			dataPairs.add(new DataPair("003","Statement date","12/12/2014"));
			dataPairs.add(new DataPair("004","Statement number","1122"));
			dataPairs.add(new DataPair("005","Statement month","2"));
			dataPairs.add(new DataPair("006","Total due","R340"));
			dataPairs.add(new DataPair("007","Due date","01/01/2015"));
			dataPairs.add(new DataPair("008","Opening balance","R120"));
			dataPairs.add(new DataPair("009","Closing balance","R123"));
			dataPairs.add(new DataPair("010","Payment received","R40"));
			dataPairs.add(new DataPair("011","New charges","R45"));
			dataPairs.add(new DataPair("012","Deductions","R123"));
			dataPairs.add(new DataPair("013","Discount","R456"));
			dataPairs.add(new DataPair("014","VAT Amount","R123"));*/
			
		}
		public void loadMunicipalAccountData()
		{
			dataPairs.add(new DataPair("015","Instalment notice","10"));
			dataPairs.add(new DataPair("016","Electricity used","200kW"));
			dataPairs.add(new DataPair("017","Electricity charges","R100"));
			dataPairs.add(new DataPair("018","Gas used","400Btu"));
			dataPairs.add(new DataPair("019","Water used","300Kl"));
			dataPairs.add(new DataPair("020","Water charges","R456"));
			dataPairs.add(new DataPair("021","Sewerage charges","R345"));
			dataPairs.add(new DataPair("022","Refuse charges","R123"));
		}
		
		public void loadTelcoAccountData()
		{
			dataPairs.add(new DataPair("015","Telephone number","0721231232"));
			dataPairs.add(new DataPair("016","Service charges","R90"));
			dataPairs.add(new DataPair("017","Call charges","R100"));
			dataPairs.add(new DataPair("018","Total number of calls","23"));
			dataPairs.add(new DataPair("019","Total call duration","120mins"));

		}
		
		public void loadCreditCardAccountData()
		{
			dataPairs.add(new DataPair("015","Card type","0721231232"));
			dataPairs.add(new DataPair("016","Interest rate","R90"));
			dataPairs.add(new DataPair("017","Credit limit","R100"));
			dataPairs.add(new DataPair("018","Credit available","R23"));
			dataPairs.add(new DataPair("019","Minimum amount due","R90"));
		}

	}
	/**
	 * @param args
	 */
	public static void main(String[] args) throws FileNotFoundException{
		
		PrintWriter write = new PrintWriter(new File(filePath));
		
		//AbstractAccounts dumz = new AbstractAccounts();
		
		DummyClass dumz = new DummyClass();
		//dumz.loadTelcoAccountData();
		
		XStream xstream = new XStream();
		xstream.alias("scrape-session",DummyClass.class);
		xstream.alias("datapair",DataPair.class);
		xstream.useAttributeFor(DataPair.class, "id");
		xstream.addImplicitCollection(DummyClass.class, "dataPairs"); // no List class tag, only entries
		//System.out.println(xml.toXML(dumz));
		write.println(xstream.toXML(dumz));
		write.close();
		dumz = null;
		//dumz = (AbstractAccounts)xml.fromXML(new File(filePath));
		
		dumz = (DummyClass)new APSXMLMarshaller(filePath).convertScrapedXMLToObject(DummyClass.class);
		System.out.println(xstream.toXML(dumz));
		//System.out.println(xstream.toXML(myxml).equals(xstream.toXML(dumz)));
		//System.out.println(xstream.toXML(myxml));
		
	}

}
