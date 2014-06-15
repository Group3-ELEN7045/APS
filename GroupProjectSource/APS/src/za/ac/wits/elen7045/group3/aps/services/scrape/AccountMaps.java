package za.ac.wits.elen7045.group3.aps.services.scrape;

import java.util.HashMap;
import java.util.Map;

public class AccountMaps {
	
	private Map<String, String> fieldMap;
	
	public AccountMaps(){
		fieldMap = new HashMap<String, String>();
		fieldMap.put("001", "Account number");
		fieldMap.put("002", "Account holder name");
		fieldMap.put("003", "Statement date");
		fieldMap.put("004", "Statement number");
		fieldMap.put("005", "Statement month");
		fieldMap.put("006", "Total due");
		fieldMap.put("007", "Due date");
		fieldMap.put("008", "Opening balance");
		fieldMap.put("009", "Closing balance");
		fieldMap.put("010", "Payment received");
		fieldMap.put("011", "New charges");
		fieldMap.put("012", "Deductions");
		fieldMap.put("013", "Discount");
		fieldMap.put("014", "VAT amount");
	}
	
	public Map<String, String> getTelcoMap()
	{
		fieldMap.put("015", "Telephone number");
		fieldMap.put("016", "Service charges");
		fieldMap.put("017", "Call charges");
		fieldMap.put("018", "Total number of calls");
		fieldMap.put("019", "Total call duration");
		
		return fieldMap;
	}
	
	/*TELCO getFieldMap().put("015", "Telephone number");
	getFieldMap().put("016", "Service charges");
	getFieldMap().put("017", "Call charges");
	getFieldMap().put("018", "Total number of calls");
	getFieldMap().put("019", "Total call duration");*/
}
