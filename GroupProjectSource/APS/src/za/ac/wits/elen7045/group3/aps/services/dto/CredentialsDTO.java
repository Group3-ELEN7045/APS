package za.ac.wits.elen7045.group3.aps.services.dto;

import java.io.IOException;
import java.io.Serializable;

import za.ac.wits.elen7045.group3.aps.services.security.EncryptionModule;

/**
 * @author SilasMahlangu
 *
 */

public class CredentialsDTO implements Serializable{
	private static final long serialVersionUID = 1L;
	private String userName;
	private String password;
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

	public CredentialsDTO encryptCredentials() {
		String encUserName        = encryptionModule.encrypt(this.userName);
		String encPassWordString  = encryptionModule.encrypt(this.password);
		setPassword(encPassWordString);
		setUserName(encUserName);
		return this;
	}
	
	public CredentialsDTO decryptCredentals() throws IOException {
		String encUserName        = encryptionModule.decrypt(this.userName);
		String encPassWordString  = encryptionModule.decrypt(this.password);
		setPassword(encPassWordString);
		setUserName(encUserName);
		return this;
	}
}
