package za.ac.wits.elen7045.group3.aps.services.dto;

import java.io.Serializable;


public class BillingAccountDTO implements Serializable{
	
	private static final long serialVersionUID = 1L;
	private Long id;
	private Long customerId;
	private String accountNumber;
	private String companyUrl;	
	private CredentialsDTO credentials;	
	private String accountStatus;
	private String accountType;
	
	public BillingAccountDTO(String accountNumber){
		if(accountNumber == null || accountNumber == ""){
			throw new RuntimeException("Account numnber cannot be null or empty string");
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
		this.accountNumber = accountNumber;
	}
	
	public CredentialsDTO getCredentials() {
		return credentials;
	}
	public void setCredentials(CredentialsDTO credentials) {
		if(credentials == null){
			new RuntimeException("Billing account should have credentials");
		}
		if(credentials.getUserName() == null){
			new RuntimeException("Username cannot be null");
		}
		if(credentials.getPassword() ==null){
			new RuntimeException("Password cannot be null");
		}
		this.credentials = credentials;
	}	
	
	
public String getCompanyUrl() {
		return companyUrl;
	}

	public void setCompanyUrl(String companyUrl) {
		this.companyUrl = companyUrl;
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

	public String getAccountType() {
		return accountType;
	}

	public void setAccountType(String accountType) {
		this.accountType = accountType;
	}	
}
