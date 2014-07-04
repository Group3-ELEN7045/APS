
package za.ac.wits.elen7045.group3.aps.domain.scrape.vo;
/**
 * @author bakwanyana
 */

import java.util.List;

public class ScrapedResult {
	private String baseURL;
	private String date;
	private String time;
	private List <DataPair> dataPairs;

	public ScrapedResult(String baseURL, String date, 
			String time, List<DataPair> datapairs){
		this.baseURL = baseURL;
		this.dataPairs = datapairs;
		this.date = date;
		this.time = time;
	}
	
	public String getBaseURL() {
		return baseURL;
	}
	
	public String getDate() {
		return date;
	}
	
	public String getTime() {
		return time;
	}
	
	public int getDataPairSize(){
		return dataPairs.size();
	}
	
	public String getDataPairListItemId(int index){
		return dataPairs.get(index).getId();
	}
	
	public String getDataPairListItemText(int index){
		return dataPairs.get(index).getText();
	}
	
	public String getDataPairListItemValue(int index){
		return dataPairs.get(index).getValue();
	}
	
}
