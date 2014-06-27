/**
 * 
 */
package za.ac.wits.elen7045.group3.aps.services.enumtypes;

public enum CompanyStatementType {
	MUNICIPALITY("M"), CREDITCARD("C"), TELCO("T");
	 
	private String accountType;
 
	private CompanyStatementType(String accountType) {
		this.accountType = accountType;
	}
 
	public String getAccountType() {
		return accountType;
	}
}
