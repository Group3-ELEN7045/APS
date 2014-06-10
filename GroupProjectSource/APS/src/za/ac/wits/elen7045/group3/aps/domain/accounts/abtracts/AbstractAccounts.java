package za.ac.wits.elen7045.group3.aps.domain.accounts.abtracts;
import com.thoughtworks.xstream.annotations.XStreamAlias;

import za.ac.wits.elen7045.group3.aps.domain.vo.DataPair;
@XStreamAlias("scrape-session")
public abstract class  AbstractAccounts {

	DataPair accountNumber;
	DataPair accountHolderName;
	DataPair accountStatementDate;
	DataPair accountStatementNumber;
	DataPair accountStatementMonth;
	DataPair accountTotalDue;
	DataPair accountDueDate;
	DataPair accountOpeningBalance;
	DataPair accountClosingBalance;
	DataPair accountPaymentReceived;
	DataPair accountNewCharges;
	DataPair accountDeductions;
	DataPair accountDiscount;
	DataPair accountVATAmount;
	public DataPair getAccountNumber() {
		return new DataPair(accountNumber);
	}
	public void setAccountNumber(DataPair accountNumber) {
		this.accountNumber = new DataPair(accountNumber) ;
	}
	public DataPair getAccountHolderName() {
		return new DataPair(accountHolderName);
	}
	public void setAccountHolderName(DataPair accountHolderName) {
		this.accountHolderName = new DataPair(accountHolderName);
	}
	public DataPair getAccountStatementDate() {
		return new DataPair(accountStatementDate);
	}
	public void setAccountStatementDate(DataPair accountStatementDate) {
		this.accountStatementDate = new DataPair(accountStatementDate);
	}
	public DataPair getAccountStatementNumber() {
		return new DataPair(accountStatementNumber);
	}
	public void setAccountStatementNumber(DataPair accountStatementNumber) {
		this.accountStatementNumber = new DataPair(accountStatementNumber);
	}
	public DataPair getAccountStatementMonth() {
		return new DataPair(accountStatementMonth);
	}
	public void setAccountStatementMonth(DataPair accountStatementMonth) {
		this.accountStatementMonth = new DataPair(accountStatementMonth);
	}
	public DataPair getAccountTotalDue() {
		return new DataPair(accountTotalDue);
	}
	public void setAccountTotalDue(DataPair accountTotalDue) {
		this.accountTotalDue = new DataPair(accountTotalDue);
	}
	public DataPair getAccountDueDate() {
		return new DataPair(accountDueDate);
	}
	public void setAccountDueDate(DataPair accountDueDate) {
		this.accountDueDate = new DataPair(accountDueDate);
	}
	public DataPair getAccountOpeningBalance() {
		return new DataPair(accountOpeningBalance);
	}
	public void setAccountOpeningBalance(DataPair accountOpeningBalance) {
		this.accountOpeningBalance = new DataPair(accountOpeningBalance);
	}
	public DataPair getAccountClosingBalance() {
		return new DataPair(accountClosingBalance);
	}
	public void setAccountClosingBalance(DataPair accountClosingBalance) {
		this.accountClosingBalance = new DataPair(accountClosingBalance);
	}
	public DataPair getAccountPaymentReceived() {
		return new DataPair(accountPaymentReceived);
	}
	public void setAccountPaymentReceived(DataPair accountPaymentReceived) {
		this.accountPaymentReceived = new DataPair(accountPaymentReceived);
	}
	public DataPair getAccountNewCharges() {
		return new DataPair(accountNewCharges);
	}
	public void setAccountNewCharges(DataPair accountNewCharges) {
		this.accountNewCharges = new DataPair(accountNewCharges);
	}
	public DataPair getAccountDeductions() {
		return new DataPair(accountDeductions);
	}
	public void setAccountDeductions(DataPair accountDeductions) {
		this.accountDeductions = new DataPair(accountDeductions);
	}
	public DataPair getAccountDiscount() {
		return new DataPair(accountDiscount);
	}
	public void setAccountDiscount(DataPair accountDiscount) {
		this.accountDiscount = new DataPair(accountDiscount);;
	}
	public DataPair getAccountVATAmount() {
		return new DataPair(accountVATAmount);
	}
	public void setAccountVATAmount(DataPair accountVATAmount) {
		this.accountVATAmount = new DataPair(accountVATAmount);
	}
}
