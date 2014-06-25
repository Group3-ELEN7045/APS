
package za.ac.wits.elen7045.group3.aps.domain.vo;

import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 * @author SilasMahlangu
 *
 */
@Embeddable
public class CredentialsVO{
	
	private String userName;
	private String password;
	
	@Column(name = "USER_NAME", nullable = false,unique = true) 
	public String getUserName() {
		return userName;
	}
	
	public void setUserName(String userName) {
		this.userName = userName;
	}
    
	@Column(name = "PASSWORD", nullable = false) 
	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

}
