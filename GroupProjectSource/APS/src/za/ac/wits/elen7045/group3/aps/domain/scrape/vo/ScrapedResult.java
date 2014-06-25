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
	
	public List<DataPair> getDataPairList() {
		return dataPairs;
	}
	
	@Override
	public String toString() {
		String scrapeData = "";
		if(dataPairs!=null){
			for(DataPair data:dataPairs){
				scrapeData = scrapeData.concat(data.getText().concat(":".concat(data.getValue())).concat("\n"));
			}
		}
		return scrapeData.toString();// baseURL.concat(date).concat(time).concat(scrapeData);
	}
}
