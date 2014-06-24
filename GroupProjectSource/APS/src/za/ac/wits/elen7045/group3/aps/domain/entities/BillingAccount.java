package za.ac.wits.elen7045.group3.aps.domain.entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.CascadeType;
import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

import za.ac.wits.elen7045.group3.aps.domain.accounts.abtracts.AbstractBillingAccountStatement;
import za.ac.wits.elen7045.group3.aps.domain.accounts.statement.TelcoStatement;
import za.ac.wits.elen7045.group3.aps.domain.vo.CredentialsVO;
import za.ac.wits.elen7045.group3.aps.services.enumtypes.AccountStatusType;

/**
 * @author Livious
 *
 */
@Entity
@Table(name="BILLING_ACCOUNT")
public class BillingAccount implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "ID", unique = true, nullable = false)	
	private Long id;
	private Long customerId;
	private String accountNumber;
	private String companyUrl;	
	private CredentialsVO credentials;

	@ Embedded
	private List<AbstractBillingAccountStatement> billingStatement = new ArrayList<AbstractBillingAccountStatement>();

	@ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="CUSTOMER_ID",referencedColumnName="ID")
	private Customer customer;	 
	private String accountStatus=AccountStatusType.TRYING.getStatusType();
	
	public BillingAccount() {
		super();
	}
	
	public BillingAccount(long id, long cuid, String accNo) {
		this.id=id;
		this.customerId=cuid;
		this.accountNumber=accNo;
	}
	
	public Customer getCustomer() {
		return customer;
	}
	public void setCustomer(Customer customer) {
		this.customer = customer;
	}
	public long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	
	@Column(name = "ACCOUNT_NUMBER") 
	public String getAccountNumber() {
		return accountNumber;
	}
	public void setAccountNumber(String accountNumber) {
		this.accountNumber = accountNumber;
	}
	
	@Embedded 
	public CredentialsVO getCredentials() {
		return credentials;
	}
	public void setCredentials(CredentialsVO credentials) {
		this.credentials = credentials;
	}	

		
	@LazyCollection(LazyCollectionOption.FALSE)
	public List<AbstractBillingAccountStatement> getBillingStatement() {
		return billingStatement;
	}

	public Long getCustomerId() {
		return customerId;
	}
	public void setCustomerId(Long customerId) {
		this.customerId = customerId;
	}
	
	@Column(name = "ACCOUNT_STATUS")
	public String getAccountStatus() {
		return accountStatus;
	}
	public void setAccountStatus(String accountStatus) {
		this.accountStatus = accountStatus;
	}
	public void addBillingAccountStatament(AbstractBillingAccountStatement statement){
		if(!(statement == null)){
			if(billingStatement == null){
				billingStatement = new ArrayList<AbstractBillingAccountStatement>();
			}
			if(!billingStatement.contains(statement)){
				billingStatement.add(statement);	
			}		
		}
	}
	
	public String getCompanyUrl() {
		return companyUrl;
	}
	public void setCompanyUrl(String companyUrl) {
		this.companyUrl = companyUrl;
	}
}
