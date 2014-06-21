
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
import za.ac.wits.elen7045.group3.aps.domain.entities.Customer;
import za.ac.wits.elen7045.group3.aps.domain.vo.DataPair;
import za.ac.wits.elen7045.group3.aps.services.scrape.APSXMLMarshaller;
import za.ac.wits.elen7045.group3.aps.services.util.AccountScrapedData;
import za.ac.wits.elen7045.group3.aps.services.util.ErrorScrapedData;

import com.thoughtworks.xstream.XStream;
/**
 * @author SilasMahlangu
 *
 */
public class XStreamTests {
	
	static String filePath = ".\\errors.xml";

	/**
	 * @param args
	 */
	public static void main(String[] args) throws FileNotFoundException{
		
		PrintWriter write = new PrintWriter(new File(filePath));
		
		ErrorScrapedData dumz1 = new ErrorScrapedData();
		dumz1.setBaseURL("www.elen7045.co.za");
		dumz1.setDate("12/12/2014");
		dumz1.setTime("13:50:00");
		dumz1.setError("InvalidCredentials");
		/*List <DataPair>dataPairs = dumz1.getDataPairList();
		dataPairs.add(new DataPair("001","error",""));
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
		dataPairs.add(new DataPair("015","Instalment notice","10"));
		dataPairs.add(new DataPair("016","Electricity used","200kW"));
		dataPairs.add(new DataPair("017","Electricity charges","R100"));
		dataPairs.add(new DataPair("018","Gas used","400Btu"));
		dataPairs.add(new DataPair("019", "Gas Charges", "R100"));
		dataPairs.add(new DataPair("020","Water used","300Kl"));
		dataPairs.add(new DataPair("021","Water charges","R456"));
		dataPairs.add(new DataPair("022","Sewerage charges","R345"));
		dataPairs.add(new DataPair("023","Refuse charges","R123"));*/
		
		XStream xstream = new XStream();
		xstream.alias("scrape-session",ErrorScrapedData.class);
		//xstream.alias("datapair",DataPair.class);
		//xstream.useAttributeFor(DataPair.class, "id");
		//xstream.addImplicitCollection(AccountScrapedData.class, "dataPairs"); // no List class tag, only entries
		write.println(xstream.toXML(dumz1));
		write.close();
		
		dumz1 = (ErrorScrapedData)new APSXMLMarshaller(".\\errors.xml").convertErrorXMLToObject(ErrorScrapedData.class);
		System.out.println(xstream.toXML(dumz1));
		
	//	System.out.println(readFile(".\\creditcard.xml"));
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
