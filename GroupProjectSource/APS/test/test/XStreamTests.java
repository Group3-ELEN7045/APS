
/**
 * 
 */
package test;


import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

import sun.swing.FilePane;
import za.ac.wits.elen7045.group3.aps.domain.accounts.accounttypes.Accounts;
import za.ac.wits.elen7045.group3.aps.domain.accounts.accounttypes.CreditCardAccounts;
import za.ac.wits.elen7045.group3.aps.domain.accounts.accounttypes.TelcoAccount;
import za.ac.wits.elen7045.group3.aps.domain.accounts.accounttypes.TelcoAccounts;
import za.ac.wits.elen7045.group3.aps.domain.entities.Customer;
import za.ac.wits.elen7045.group3.aps.domain.vo.DataPair;
import za.ac.wits.elen7045.group3.aps.services.scrape.APSXMLMarshaller;

import com.thoughtworks.xstream.XStream;
/**
 * @author SilasMahlangu
 *
 */
public class XStreamTests {
	
	static String filePath = ".\\creditcard.xml";

	/**
	 * @param args
	 */
	public static void main(String[] args) throws FileNotFoundException{
		
		PrintWriter write = new PrintWriter(new File(filePath));
		
		Accounts dumz1 = new Accounts();
		dumz1.setBaseURL("www.elen7045.co.za");
		dumz1.setDate("12/12/2014");
		dumz1.setTime("13:50:00");
		List <DataPair>dataPairs = dumz1.getDataPairList();
		dataPairs.add(new DataPair("001","Account Number","123456789"));
		dataPairs.add(new DataPair("002","Account holder name","Jack Parcell"));
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
		dataPairs.add(new DataPair("014","VAT Amount","R123"));
		dataPairs.add(new DataPair("015","Card type","Visa"));
		dataPairs.add(new DataPair("016","Interest rate","12%"));
		dataPairs.add(new DataPair("017","Credit limit","R20000"));
		dataPairs.add(new DataPair("018","Credit available","R4500"));
		dataPairs.add(new DataPair("019","Minimum amount due","R90"));
		
		XStream xstream = new XStream();
		xstream.alias("scrape-session",Accounts.class);
		xstream.alias("datapair",DataPair.class);
		xstream.useAttributeFor(DataPair.class, "id");
		xstream.addImplicitCollection(Accounts.class, "dataPairs"); // no List class tag, only entries
		write.println(xstream.toXML(dumz1));
		write.close();
		
		dumz1 = (Accounts)new APSXMLMarshaller(".\\creditcard.xml").convertXMLFileToObject(Accounts.class);
		System.out.println(dumz1.getDataPairList().get(0).getId().equals("001"));
		
		System.out.println(readFile(".\\creditcard.xml"));
		//System.out.println(xstream.toXML(dumz1));
	}
	
	public static String readFile(String filepath) throws FileNotFoundException{
		String tempString="";
		File file = new File(filepath);
		Scanner scanner = new Scanner(file);
		while (scanner.hasNextLine()){
			tempString += scanner.nextLine();
		}
		scanner.close();
		return tempString;
	}

}
