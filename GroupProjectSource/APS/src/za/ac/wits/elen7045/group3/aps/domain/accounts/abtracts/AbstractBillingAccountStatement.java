package za.ac.wits.elen7045.group3.aps.domain.accounts.abtracts;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MappedSuperclass;
import javax.persistence.Table;

import za.ac.wits.elen7045.group3.aps.domain.entities.BillingAccount;
import za.ac.wits.elen7045.group3.aps.domain.entities.Customer;

//@MappedSuperclass
@Entity
@Table(name="Statements")
public class  AbstractBillingAccountStatement implements Serializable {
	
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "ID", unique = true, nullable = false)
	private long id;
	private Long billingAccountId;
	private String AccountNumber="";
	private String AccountHolderName="";
	private String AccountStatementDate="";
	private String AccountStatementNumber="";
	private String AccountStatementMonth="";
	private String AccountTotalDue="";
	
	private String AccountDueDate="";
	private String AccountOpeningBalance="";
	private String AccountClosingBalance="";
	private String AccountPaymentReceived="";
	private String AccountNewCharges="";
	private String AccountDeductions="";
	private String AccountDiscount="";
	private String AccountVATAmount="";
	
	@ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="CUSTOMER_ID",referencedColumnName="ID")
	private BillingAccount billingAccount;	 
	
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}	
	
	public BillingAccount getBillingAccount() {
		return billingAccount;
	}
	public void setBillingAccount(BillingAccount billingAccount) {
		this.billingAccount = billingAccount;
	}
	public Long getBillingAccountId() {
		return billingAccountId;
	}
	public void setBillingAccountId(Long billingAccountId) {
		this.billingAccountId = billingAccountId;
	}
	public String getAccountNumber() {
		return AccountNumber;
	}
	public void setAccountNumber(String accountNumber) {
		AccountNumber = accountNumber;
	}
	public String getAccountHolderName() {
		return AccountHolderName;
	}
	public void setAccountHolderName(String accountHolderName) {
		AccountHolderName = accountHolderName;
	}
	public String getAccountStatementDate() {
		return AccountStatementDate;
	}
	public void setAccountStatementDate(String accountStatementDate) {
		AccountStatementDate = accountStatementDate;
	}
	public String getAccountStatementNumber() {
		return AccountStatementNumber;
	}
	public void setAccountStatementNumber(String accountStatementNumber) {
		AccountStatementNumber = accountStatementNumber;
	}
	public String getAccountStatementMonth() {
		return AccountStatementMonth;
	}
	public void setAccountStatementMonth(String accountStatementMonth) {
		AccountStatementMonth = accountStatementMonth;
	}
	public String getAccountTotalDue() {
		return AccountTotalDue;
	}
	public void setAccountTotalDue(String accountTotalDue) {
		AccountTotalDue = accountTotalDue;
	}
	public String getAccountDueDate() {
		return AccountDueDate;
	}
	public void setAccountDueDate(String accountDueDate) {
		AccountDueDate = accountDueDate;
	}
	public String getAccountOpeningBalance() {
		return AccountOpeningBalance;
	}
	public void setAccountOpeningBalance(String accountOpeningBalance) {
		AccountOpeningBalance = accountOpeningBalance;
	}
	public String getAccountClosingBalance() {
		return AccountClosingBalance;
	}
	public void setAccountClosingBalance(String accountClosingBalance) {
		AccountClosingBalance = accountClosingBalance;
	}
	public String getAccountPaymentReceived() {
		return AccountPaymentReceived;
	}
	public void setAccountPaymentReceived(String accountPaymentReceived) {
		AccountPaymentReceived = accountPaymentReceived;
	}
	public String getAccountNewCharges() {
		return AccountNewCharges;
	}
	public void setAccountNewCharges(String accountNewCharges) {
		AccountNewCharges = accountNewCharges;
	}
	public String getAccountDeductions() {
		return AccountDeductions;
	}
	public void setAccountDeductions(String accountDeductions) {
		AccountDeductions = accountDeductions;
	}
	public String getAccountDiscount() {
		return AccountDiscount;
	}
	public void setAccountDiscount(String accountDiscount) {
		AccountDiscount = accountDiscount;
	}
	public String getAccountVATAmount() {
		return AccountVATAmount;
	}
	public void setAccountVATAmount(String accountVATAmount) {
		AccountVATAmount = accountVATAmount;
	}
}
