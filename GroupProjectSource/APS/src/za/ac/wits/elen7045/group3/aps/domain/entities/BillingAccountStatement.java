
package za.ac.wits.elen7045.group3.aps.domain.entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MappedSuperclass;
import javax.persistence.Table;

@MappedSuperclass
public class  BillingAccountStatement implements Serializable {
		
	/**
	 * 
	 */
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "ID", unique = true, nullable = false)	
	private Long id;
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
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	@Column(name = "ACCOUNT_NUMBER",nullable = false)
	public String getAccountNumber() {
		return AccountNumber;
	}
	public void setAccountNumber(String accountNumber) {
		AccountNumber = accountNumber;
	}
	
	@Column(name = "ACCOUNT_HOLDER_NAME",nullable = true)
	public String getAccountHolderName() {
		return AccountHolderName;
	}
	public void setAccountHolderName(String accountHolderName) {
		AccountHolderName = accountHolderName;
	}
	
	@Column(name = "STATEMENT_DATE",nullable = true)
	public String getAccountStatementDate() {
		return AccountStatementDate;
	}
	public void setAccountStatementDate(String accountStatementDate) {
		AccountStatementDate = accountStatementDate;
	}
	@Column(name = "STATEMENT_NUMBER",nullable = true)
	public String getAccountStatementNumber() {
		return AccountStatementNumber;
	}
	
	public void setAccountStatementNumber(String accountStatementNumber) {
		AccountStatementNumber = accountStatementNumber;
	}
	@Column(name = "PERIOD",nullable = true)
	public String getAccountStatementMonth() {
		return AccountStatementMonth;
	}
	public void setAccountStatementMonth(String accountStatementMonth) {
		AccountStatementMonth = accountStatementMonth;
	}
	
	@Column(name = "TOTAL_DUE",nullable = true)
	public String getAccountTotalDue() {
		return AccountTotalDue;
	}
	
	
	public void setAccountTotalDue(String accountTotalDue) {
		AccountTotalDue = accountTotalDue;
	}
	
	@Column(name = "ACCOUNT_TOTAL_DUE",nullable = true)
	public String getAccountDueDate() {
		return AccountDueDate;
	}
	public void setAccountDueDate(String accountDueDate) {
		AccountDueDate = accountDueDate;
	}
	
	@Column(name = "ACCOUNT_OPENING_BALANCE",nullable = true)
	public String getAccountOpeningBalance() {
		return AccountOpeningBalance;
	}
	public void setAccountOpeningBalance(String accountOpeningBalance) {
		AccountOpeningBalance = accountOpeningBalance;
	}
	
	@Column(name = "ACCOUNT_CLOSING_BALANCE",nullable = true)
	public String getAccountClosingBalance() {
		return AccountClosingBalance;
	}
	public void setAccountClosingBalance(String accountClosingBalance) {
		AccountClosingBalance = accountClosingBalance;
	}
	
	@Column(name = "ACCOUNT_ACCOUNT_PAYMENT_RECEIVED",nullable = true)
	public String getAccountPaymentReceived() {
		return AccountPaymentReceived;
	}
	public void setAccountPaymentReceived(String accountPaymentReceived) {
		AccountPaymentReceived = accountPaymentReceived;
	}
	
	@Column(name = "ACCOUNT_NEW_CHARGES",nullable = true)
	public String getAccountNewCharges() {
		return AccountNewCharges;
	}
	public void setAccountNewCharges(String accountNewCharges) {
		AccountNewCharges = accountNewCharges;
	}
	
	@Column(name = "ACCOUNT_DEDUCTIONS",nullable = true)
	public String getAccountDeductions() {
		return AccountDeductions;
	}
	public void setAccountDeductions(String accountDeductions) {
		AccountDeductions = accountDeductions;
	}
	
	@Column(name = "ACCOUNT_DISCOUNT",nullable = true)
	public String getAccountDiscount() {
		return AccountDiscount;
	}
	public void setAccountDiscount(String accountDiscount) {
		AccountDiscount = accountDiscount;
	}
	
	@Column(name = "ACCOUNT_VAT_AMOUNT",nullable = true)
	public String getAccountVATAmount() {
		return AccountVATAmount;
	}
	public void setAccountVATAmount(String accountVATAmount) {
		AccountVATAmount = accountVATAmount;
	}
}

