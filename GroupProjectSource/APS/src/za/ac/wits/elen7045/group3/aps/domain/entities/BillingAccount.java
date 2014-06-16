package za.ac.wits.elen7045.group3.aps.domain.entities;

import java.util.List;

import za.ac.wits.elen7045.group3.aps.domain.vo.CredentialsVO;
import za.ac.wits.elen7045.group3.aps.services.enumtypes.StatusType;


/**
 * @author Livious
 *
 */
public class BillingAccount {
	private long id;
	private StatusType accountStatus;
	private String accountNumber;
	private String billingCompanyName;
	private CredentialsVO credentials;
	private StatementType billingType;
	private List<BillingAccountStatement> billingStatement;
		
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
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
	public List<BillingAccountStatement> getBillingStatement() {
		return billingStatement;
	}
	public void setBillingStatement(List<BillingAccountStatement> billingStatement) {
		this.billingStatement = billingStatement;
	}
	public StatementType getBillingType() {
		return billingType;
	}
	public void setBillingType(StatementType billingType) {
		this.billingType = billingType;
	}	
}