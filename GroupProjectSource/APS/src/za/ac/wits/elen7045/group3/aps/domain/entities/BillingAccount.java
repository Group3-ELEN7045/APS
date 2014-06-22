package za.ac.wits.elen7045.group3.aps.domain.entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import za.ac.wits.elen7045.group3.aps.domain.vo.CredentialsVO;

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
	private String billingCompanyName;
	private String billingCompanyType;
	private CredentialsVO credentials;
	//private List<AbstractBillingAccountStatement> billingStatement = new ArrayList<AbstractBillingAccountStatement>();
	
	@ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="CUSTOMER_ID",referencedColumnName="ID")
	private Customer customer;	 
	private String accountStatus;
		
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
	
	@Column(name = "BILLING_COMPANY_NAME")
	public String getBillingCompanyName() {
		return billingCompanyName;
	}
	public void setBillingCompanyName(String billingCompanyName) {
		this.billingCompanyName = billingCompanyName;
	}
	
	//@LazyCollection(LazyCollectionOption.FALSE)
	//@OneToMany(cascade=CascadeType.ALL)
	//public List<AbstractBillingAccountStatement> getBillingStatement() {
	//	return billingStatement;
	//}
		
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
	
	//public void addBillingAccountStatament(AbstractBillingAccountStatement statement){
		//if(!(statement ==null)){
			//if(!billingStatement.contains(statement)){
				//billingStatement.add(statement);	
		//	}		
		//}
	//}
	
	@Column(name = "BILLING_COMPANY_TYPE")
	public String getBillingCompanyType() {
		return billingCompanyType;
	}
	public void setBillingCompanyType(String billingCompanyType) {
		this.billingCompanyType = billingCompanyType;
	}
}
