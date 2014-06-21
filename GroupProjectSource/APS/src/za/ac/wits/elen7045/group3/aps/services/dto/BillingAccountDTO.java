package za.ac.wits.elen7045.group3.aps.services.dto;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import za.ac.wits.elen7045.group3.aps.domain.accounts.abtracts.AbstractBillingAccountStatement;

/**
 * @author SilasMahlangu
 *
 */

public class BillingAccountDTO implements Serializable{
	
	private Long id;
	private Long customerId;
	private String accountNumber;
	private String billingCompanyName;
	private String billingCompanyType;
	private CredentialsDTO credentials;
	private List<AbstractBillingAccountStatement> billingStatement;
	private String accountStatus;
				
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
	
	public CredentialsDTO getCredentials() {
		return credentials;
	}
	public void setCredentials(CredentialsDTO credentials) {
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
	public String getAccountStatus() {
		return accountStatus;
	}
	public void setAccountStatus(String accountStatus) {
		this.accountStatus = accountStatus;
	}
	
	public String getBillingCompanyType() {
		return billingCompanyType;
	}
	public void setBillingCompanyType(String billingCompanyNameType) {
		this.billingCompanyType = billingCompanyType;
	}
	public void addBillingAccountStatament(AbstractBillingAccountStatement statement){
		if(billingStatement == null){
			billingStatement = new ArrayList<AbstractBillingAccountStatement>();
		}
		billingStatement.add(statement);
	}
}
