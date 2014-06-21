package za.ac.wits.elen7045.group3.aps.domain.entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import za.ac.wits.elen7045.group3.aps.domain.accounts.abtracts.AbstractBillingAccountStatement;
import za.ac.wits.elen7045.group3.aps.domain.vo.CredentialsVO;
import za.ac.wits.elen7045.group3.aps.services.enumtypes.StatusType;


/**
 * @author Livious
 *
 */
public class BillingAccount implements Serializable{
	private Long id;
	private Long customerId;
	private String accountNumber;
	private String billingCompanyName;
	private CredentialsVO credentials;
	private List<AbstractBillingAccountStatement> billingStatement;
	private StatusType accountStatus;
				
	public long getId() {
		return id;
	}
	public void setId(Long id) {
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
	
	public List<AbstractBillingAccountStatement> getBillingStatement() {
		return billingStatement;
	}
	public void setBillingStatement(List<AbstractBillingAccountStatement> billingStatement) {
		this.billingStatement = billingStatement;
	}
	public Long getCustomerId() {
		return customerId;
	}
	public void setCustomerId(Long customerId) {
		this.customerId = customerId;
	}
	public StatusType getAccountStatus() {
		return accountStatus;
	}
	public void setAccountStatus(StatusType accountStatus) {
		this.accountStatus = accountStatus;
	}
	
	public void addBillingAccountStatament(AbstractBillingAccountStatement statement){
		if(billingStatement == null){
			billingStatement = new ArrayList<AbstractBillingAccountStatement>();
		}
		billingStatement.add(statement);
	}
}
