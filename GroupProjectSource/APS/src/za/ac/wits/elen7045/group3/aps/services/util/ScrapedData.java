package za.ac.wits.elen7045.group3.aps.services.util;

import java.util.ArrayList;
import java.util.List;
import za.ac.wits.elen7045.group3.aps.domain.vo.DataPair;

public class ScrapedData {
	private String baseURL;
	private String date;
	private String time;
	private List <DataPair> dataPairs;

	public ScrapedData (){
		dataPairs = new ArrayList<DataPair>();
	}
	public String getBaseURL() {
		return baseURL;
	}
	public void setBaseURL(String baseURL) {
		this.baseURL = baseURL;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public String getTime() {
		return time;
	}
	public void setTime(String time) {
		this.time = time;
	}
	public List<DataPair> getDataPairList() {
		return dataPairs;
	}
	public void setDataPairList(List<DataPair> dp) {
		this.dataPairs = dp;
	}
}
