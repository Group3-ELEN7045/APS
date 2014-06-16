package za.ac.wits.elen7045.group3.aps.domain.accounts.abtracts;
import za.ac.wits.elen7045.group3.aps.domain.vo.DataPair;

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
	protected DataPair getAccountNumber() {
		return new DataPair(accountNumber);
	}
	protected void setAccountNumber(DataPair accountNumber) {
		this.accountNumber = new DataPair(accountNumber) ;
	}
	protected DataPair getAccountHolderName() {
		return new DataPair(accountHolderName);
	}
	protected void setAccountHolderName(DataPair accountHolderName) {
		this.accountHolderName = new DataPair(accountHolderName);
	}
	protected DataPair getAccountStatementDate() {
		return new DataPair(accountStatementDate);
	}
	protected void setAccountStatementDate(DataPair accountStatementDate) {
		this.accountStatementDate = new DataPair(accountStatementDate);
	}
	protected DataPair getAccountStatementNumber() {
		return new DataPair(accountStatementNumber);
	}
	protected void setAccountStatementNumber(DataPair accountStatementNumber) {
		this.accountStatementNumber = new DataPair(accountStatementNumber);
	}
	protected DataPair getAccountStatementMonth() {
		return new DataPair(accountStatementMonth);
	}
	protected void setAccountStatementMonth(DataPair accountStatementMonth) {
		this.accountStatementMonth = new DataPair(accountStatementMonth);
	}
	protected DataPair getAccountTotalDue() {
		return new DataPair(accountTotalDue);
	}
	protected void setAccountTotalDue(DataPair accountTotalDue) {
		this.accountTotalDue = new DataPair(accountTotalDue);
	}
	protected DataPair getAccountDueDate() {
		return new DataPair(accountDueDate);
	}
	protected void setAccountDueDate(DataPair accountDueDate) {
		this.accountDueDate = new DataPair(accountDueDate);
	}
	protected DataPair getAccountOpeningBalance() {
		return new DataPair(accountOpeningBalance);
	}
	protected void setAccountOpeningBalance(DataPair accountOpeningBalance) {
		this.accountOpeningBalance = new DataPair(accountOpeningBalance);
	}
	protected DataPair getAccountClosingBalance() {
		return new DataPair(accountClosingBalance);
	}
	protected void setAccountClosingBalance(DataPair accountClosingBalance) {
		this.accountClosingBalance = new DataPair(accountClosingBalance);
	}
	protected DataPair getAccountPaymentReceived() {
		return new DataPair(accountPaymentReceived);
	}
	protected void setAccountPaymentReceived(DataPair accountPaymentReceived) {
		this.accountPaymentReceived = new DataPair(accountPaymentReceived);
	}
	protected DataPair getAccountNewCharges() {
		return new DataPair(accountNewCharges);
	}
	protected void setAccountNewCharges(DataPair accountNewCharges) {
		this.accountNewCharges = new DataPair(accountNewCharges);
	}
	protected DataPair getAccountDeductions() {
		return new DataPair(accountDeductions);
	}
	protected void setAccountDeductions(DataPair accountDeductions) {
		this.accountDeductions = new DataPair(accountDeductions);
	}
	protected DataPair getAccountDiscount() {
		return new DataPair(accountDiscount);
	}
	protected void setAccountDiscount(DataPair accountDiscount) {
		this.accountDiscount = new DataPair(accountDiscount);;
	}
	protected DataPair getAccountVATAmount() {
		return new DataPair(accountVATAmount);
	}
	protected void setAccountVATAmount(DataPair accountVATAmount) {
		this.accountVATAmount = new DataPair(accountVATAmount);
	}
}
