package za.ac.wits.elen7045.group3.aps.domain.vo;

import java.io.IOException;

import za.ac.wits.elen7045.group3.aps.services.security.EncryptionModule;

public class CredentialsVO{
	
	private String userName;
	private String password;
	private String accountStatus;
	private EncryptionModule encryptionModule;
		

	public void setEncryptionModule(EncryptionModule encryptionModule) {
		this.encryptionModule = encryptionModule;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}
    
	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getAccountStatus() {
		return accountStatus;
	}

	public void setAccountStatus(String accountStatus) {
		this.accountStatus = accountStatus;
	}
	
	public CredentialsVO encryptCredentials() {
		String encUserName        = encryptionModule.encrypt(this.userName);
		String encPassWordString  = encryptionModule.encrypt(this.password);
		setPassword(encPassWordString);
		setUserName(encUserName);
		return this;
	}
	
	public CredentialsVO decryptCredentals() throws IOException {
		String encUserName        = encryptionModule.decrypt(this.userName);
		String encPassWordString  = encryptionModule.decrypt(this.password);
		setPassword(encPassWordString);
		setUserName(encUserName);
		return this;
	}
	
	public void changeAccountStatus(String statusType){
		this.setAccountStatus(statusType);
	}
}
