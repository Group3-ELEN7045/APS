package za.ac.wits.elen7045.group3.aps.domain.entities;

import za.ac.wits.elen7045.group3.aps.domain.vo.CredentialsVO;
import za.ac.wits.elen7045.group3.aps.services.enumtypes.StatusType;


/**
 * @author Livious
 *
 */
public class BillingAccount {
	private StatusType accountStatus;
	private String accountNumber;
	private String billingCompanyName;
	private CredentialsVO credentials;
	
	public String getAccountNumber() {
		return accountNumber;
	}
	public void setAccountNumber(String accountNumber) {
		this.accountNumber = accountNumber;
	}
	
	public CredentialsVO getCredentials() {
		return credentials;
	}
	public void setCredentials(CredentialsVO credentials) {
		this.credentials = credentials;
	}	
	public String getBillingCompanyName() {
		return billingCompanyName;
	}
	public void setBillingCompanyName(String billingCompanyName) {
		this.billingCompanyName = billingCompanyName;
	}
	public StatusType getAccountStatus() {
		return accountStatus;
	}
	public void setAccountStatus(StatusType accountStatus) {
		this.accountStatus = accountStatus;
	}	
}
