package za.ac.wits.elen7045.group3.aps.domain.accounts.abtracts;

public abstract class  AbstractAccount {

	String AccountNumber="";
	String AccountHolderName="";
	String AccountStatementDate="";
	String AccountStatementNumber="";
	String AccountStatementMonth="";
	String AccountTotalDue="";
	String AccountDueDate="";
	String AccountOpeningBalance="";
	String AccountClosingBalance="";
	String AccountPaymentReceived="";
	String AccountNewCharges="";
	String AccountDeductions="";
	String AccountDiscount="";
	String AccountVATAmount="";
	protected String getAccountNumber() {
		return AccountNumber;
	}
	protected void setAccountNumber(String accountNumber) {
		AccountNumber = accountNumber;
	}
	protected String getAccountHolderName() {
		return AccountHolderName;
	}
	protected void setAccountHolderName(String accountHolderName) {
		AccountHolderName = accountHolderName;
	}
	protected String getAccountStatementDate() {
		return AccountStatementDate;
	}
	protected void setAccountStatementDate(String accountStatementDate) {
		AccountStatementDate = accountStatementDate;
	}
	protected String getAccountStatementNumber() {
		return AccountStatementNumber;
	}
	protected void setAccountStatementNumber(String accountStatementNumber) {
		AccountStatementNumber = accountStatementNumber;
	}
	protected String getAccountStatementMonth() {
		return AccountStatementMonth;
	}
	protected void setAccountStatementMonth(String accountStatementMonth) {
		AccountStatementMonth = accountStatementMonth;
	}
	protected String getAccountTotalDue() {
		return AccountTotalDue;
	}
	protected void setAccountTotalDue(String accountTotalDue) {
		AccountTotalDue = accountTotalDue;
	}
	protected String getAccountDueDate() {
		return AccountDueDate;
	}
	protected void setAccountDueDate(String accountDueDate) {
		AccountDueDate = accountDueDate;
	}
	protected String getAccountOpeningBalance() {
		return AccountOpeningBalance;
	}
	protected void setAccountOpeningBalance(String accountOpeningBalance) {
		AccountOpeningBalance = accountOpeningBalance;
	}
	protected String getAccountClosingBalance() {
		return AccountClosingBalance;
	}
	protected void setAccountClosingBalance(String accountClosingBalance) {
		AccountClosingBalance = accountClosingBalance;
	}
	protected String getAccountPaymentReceived() {
		return AccountPaymentReceived;
	}
	protected void setAccountPaymentReceived(String accountPaymentReceived) {
		AccountPaymentReceived = accountPaymentReceived;
	}
	protected String getAccountNewCharges() {
		return AccountNewCharges;
	}
	protected void setAccountNewCharges(String accountNewCharges) {
		AccountNewCharges = accountNewCharges;
	}
	protected String getAccountDeductions() {
		return AccountDeductions;
	}
	protected void setAccountDeductions(String accountDeductions) {
		AccountDeductions = accountDeductions;
	}
	protected String getAccountDiscount() {
		return AccountDiscount;
	}
	protected void setAccountDiscount(String accountDiscount) {
		AccountDiscount = accountDiscount;
	}
	protected String getAccountVATAmount() {
		return AccountVATAmount;
	}
	protected void setAccountVATAmount(String accountVATAmount) {
		AccountVATAmount = accountVATAmount;
	}
}
