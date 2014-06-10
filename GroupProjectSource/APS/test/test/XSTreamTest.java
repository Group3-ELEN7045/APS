
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
import za.ac.wits.elen7045.group3.aps.domain.entities.Customer;
import za.ac.wits.elen7045.group3.aps.domain.vo.DataPair;

import com.thoughtworks.xstream.XStream;
/**
 * @author SilasMahlangu
 *
 */
public class XSTreamTest {
	
	static String filePath = "E:\\ELEN 7045\\Group Project\\New Folder\\return.xml";
	public static class DummyClass{
		String name;
		DataPair dataPair;
		
		public DummyClass(){
			name = "MyName";
			dataPair = new DataPair();
			dataPair.setId("001");
			dataPair.setText("Account no");
			dataPair.setValue("1122334");
		}

		@Override
		public String toString() {
			return "DummyClass [name=" + name + ", dataPair=" + dataPair + "]";
		}
		
	}
	/**
	 * @param args
	 */
	public static void main(String[] args) throws FileNotFoundException{
		DummyClass dumz = new DummyClass();
		DummyClass dum1 = new DummyClass();
		PrintWriter writer = new PrintWriter(filePath);
		
		/*Customer cust = new Customer();
		cust.setFirstName("Silas");
		cust.setLastname("dork");
		cust.setId((long)13);*/
		//CreditCardAccountXML crXML = new CreditCardAccountXML();
		XStream xml = new XStream();
		xml.alias("scrape-session",DummyClass.class);
		xml.useAttributeFor(DataPair.class, "id");
		writer.println(xml.toXML(dumz));
		writer.close();
		dumz = (DummyClass)xml.fromXML(new File(filePath));
		System.out.println(xml.toXML(dumz));
	}

}
