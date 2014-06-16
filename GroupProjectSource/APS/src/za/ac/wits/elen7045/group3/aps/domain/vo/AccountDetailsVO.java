
package za.ac.wits.elen7045.group3.aps.domain.vo;

import java.io.Serializable;

/**
 * @author SilasMahlangu
 *
 */

public class AccountDetailsVO implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public String accountName;
	public String accountType;
	public String accountNumber;
    public String accountStatus;
    
	public String getAccountName() {
		return accountName;
	}

	public void setAccountName(String accountName) {
		this.accountName = accountName;
	}
    
	public String getAccountType() {
		return accountType;
	}

	public void setAccountType(String accountType) {
		this.accountType = accountType;
	}
    
	public String getAccountNumber() {
		return accountNumber;
	}

	public void setAccountNumber(String accountNumber) {
		this.accountNumber = accountNumber;
	}

	public String getAccountStatus() {
		return accountStatus;
	}

	public void setAccountStatus(String accountStatus) {
		this.accountStatus = accountStatus;
	}
}
