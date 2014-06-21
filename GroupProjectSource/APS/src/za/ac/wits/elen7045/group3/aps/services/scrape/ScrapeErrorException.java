package za.ac.wits.elen7045.group3.aps.services.scrape;
/**
 * @author bakwanyana
 */
public class ScrapeErrorException extends Exception {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private String errorCode;

	public ScrapeErrorException(String errorCode){
		this.errorCode = errorCode;
	}
	
	public String getErrorCode(){
		return errorCode;
	}
}
