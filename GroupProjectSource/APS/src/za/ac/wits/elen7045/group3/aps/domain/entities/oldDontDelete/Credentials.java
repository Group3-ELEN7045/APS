
package za.ac.wits.elen7045.group3.aps.domain.entities.oldDontDelete;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Credentials")
public class Credentials {
	
	private Long id;
	private String userName;
	private String password;
	private String accountStatus;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO) 
	@Column(name = "ID", unique = true, nullable = false)	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
    
	@Column(name = "USER_NAME", nullable = false) 
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

	@Column(name = "ACCOUNT_STATUS", nullable = false) 
	public String getAccountStatus() {
		return accountStatus;
	}

	public void setAccountStatus(String accountStatus) {
		this.accountStatus = accountStatus;
	}
}
