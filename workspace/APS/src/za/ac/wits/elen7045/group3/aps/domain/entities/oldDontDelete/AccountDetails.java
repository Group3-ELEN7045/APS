package za.ac.wits.elen7045.group3.aps.domain.entities.oldDontDelete;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @author SilasMahlangu
 *
 */
@Entity
@Table(name="ACCOUNTDETAIS")
public class AccountDetails implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public Long   id;
	public String accountName;
	public String accountType;
	public String accountNumber;
    
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "ID", unique = true, nullable = false)		
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	@Column(name = "ACCOUNT_NAME", nullable = false) 
	public String getAccountName() {
		return accountName;
	}

	public void setAccountName(String accountName) {
		this.accountName = accountName;
	}
    
	@Column(name = "ACCOUNT_TYPE", nullable = false) 
	public String getAccountType() {
		return accountType;
	}

	public void setAccountType(String accountType) {
		this.accountType = accountType;
	}
    
	@Column(name = "ACCOUNT_NUMBER", nullable = false) 
	public String getAccountNumber() {
		return accountNumber;
	}

	public void setAccountNumber(String accountNumber) {
		this.accountNumber = accountNumber;
	}

}
