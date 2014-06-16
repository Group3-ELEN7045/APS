/**
 * 
 */
package za.ac.wits.elen7045.group3.aps.services.enumtypes;

/**
 * @author SilasMahlangu
 *
 */
public enum AccountType {
	CLOTHING("C"), ELECTRIC("E"), CELLPHONE("CL"), LOAN("L");
	 
	private String accountType;
 
	private AccountType(String accountType) {
		this.accountType = accountType;
	}
 
	public String getAccountType() {
		return accountType;
	}
 

}
