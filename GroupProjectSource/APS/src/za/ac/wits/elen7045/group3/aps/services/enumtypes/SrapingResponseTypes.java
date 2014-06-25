package za.ac.wits.elen7045.group3.aps.services.enumtypes;
/**
 * @author SilasMahlangu
 *
 */

public enum SrapingResponseTypes {
	ACCOUNT_INACTIVE("ACC_I");
	 
	private String scrapingResponse;
 
	private SrapingResponseTypes(String scrapingResponse) {
		this.scrapingResponse = scrapingResponse;
	}
 
	public String getScrapingResponse() {
		return scrapingResponse;
	}
 

}
