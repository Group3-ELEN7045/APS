package za.ac.wits.elen7045.group3.aps.domain.accounts.abtracts;

public abstract class  AbstractBillingAccountStatement {

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
