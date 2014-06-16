/**
 * 
 */
package za.ac.wits.elen7045.group3.aps.services.enumtypes;

/**
 * @author BakwanyanaThobela
 *
 */
public enum AccountType {
	MUNICIPALITY("M"), CREDITCARD("C"), TELCO("T");
	 
	private String accountType;
 
	private AccountType(String accountType) {
		this.accountType = accountType;
	}
 
	public String getAccountType() {
		return accountType;
	}
 

}
