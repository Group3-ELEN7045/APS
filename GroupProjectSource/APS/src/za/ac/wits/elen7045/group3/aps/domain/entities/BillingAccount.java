package za.ac.wits.elen7045.group3.aps.domain.entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import za.ac.wits.elen7045.group3.aps.domain.accounts.abtracts.AbstractBillingAccountStatement;
import za.ac.wits.elen7045.group3.aps.domain.vo.CredentialsVO;
import za.ac.wits.elen7045.group3.aps.services.enumtypes.AccountStatusType;


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
	private AccountStatusType accountStatus;
	
	public BillingAccount(String accountNumber){
		if(accountNumber == null || accountNumber ==""){
			throw new RuntimeException("Billing Account number cannot be null or empty String");
		}
		this.accountNumber = accountNumber;
	}
				 
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
		if(accountNumber == null || accountNumber ==""){
			throw new RuntimeException("Billing Account number cannot be null or empty String");
		}
		this.accountNumber = accountNumber;
	}
	
	public CredentialsVO getCredentials() {
		return credentials;
	}
	public void setCredentials(CredentialsVO credentials) {
		if(credentials == null){
			throw new RuntimeException("Credentials cannot be null");
		}
		if(credentials.getUserName()== null){
			throw new RuntimeException("Username cannot be null");
		}
		if(credentials.getPassword() == null){
			throw new RuntimeException("Password cannot be null");
		}
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

	public Long getCustomerId() {
		return customerId;
	}
	public void setCustomerId(Long customerId) {
		this.customerId = customerId;
	}
	public AccountStatusType getAccountStatus() {
		return accountStatus;
	}
	public void setAccountStatus(AccountStatusType accountStatus) {
		this.accountStatus = accountStatus;
	}	
	public void addBillingAccountStatament(AbstractBillingAccountStatement statement){
		if(!(statement == null)){
			if(billingStatement == null){
				billingStatement = new ArrayList<AbstractBillingAccountStatement>();
			}
			billingStatement.add(statement);
		}
	}
}
