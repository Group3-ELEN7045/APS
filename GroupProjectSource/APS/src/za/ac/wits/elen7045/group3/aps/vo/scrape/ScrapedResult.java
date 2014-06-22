package za.ac.wits.elen7045.group3.aps.vo.scrape;
/**
 * @author bakwanyana
 */

import java.util.List;
import za.ac.wits.elen7045.group3.aps.domain.vo.DataPair;

public class StatementScrapedData {
	private String baseURL;
	private String date;
	private String time;
	private List <DataPair> dataPairs;

	public StatementScrapedData(String baseURL, String date, 
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
}
