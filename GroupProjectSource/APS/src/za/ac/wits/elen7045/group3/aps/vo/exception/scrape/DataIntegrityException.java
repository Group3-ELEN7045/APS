package za.ac.wits.elen7045.group3.aps.vo.exception.scrape;


public class DataIntegrityException extends Exception {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String accountNumber;
	public DataIntegrityException(String accountNumber){
		this.accountNumber = accountNumber;
	}

}
