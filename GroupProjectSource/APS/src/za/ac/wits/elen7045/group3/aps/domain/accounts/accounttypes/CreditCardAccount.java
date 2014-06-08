package za.ac.wits.elen7045.group3.aps.domain.accounts.accounttypes;

import za.ac.wits.elen7045.group3.aps.domain.accounts.abtracts.AbstractAccount;

public class CreditCardAccount extends AbstractAccount{

	private String cardType;
	private String interestRate;
	private String creditLimit;
	private String creditAvailable;
	private String minimumAmountDue;

	public CreditCardAccount(String accountNumber) {
		setAccountNumber(accountNumber);
	}
	
	protected String getCardType() {
		return cardType;
	}
	protected void setCardType(String cardType) {
		this.cardType = cardType;
	}
	protected String getInterestRate() {
		return interestRate;
	}
	protected void setInterestRate(String interestRate) {
		this.interestRate = interestRate;
	}
	protected String getCreditLimit() {
		return creditLimit;
	}
	protected void setCreditLimit(String creditLimit) {
		this.creditLimit = creditLimit;
	}
	protected String getCreditAvailable() {
		return creditAvailable;
	}
	protected void setCreditAvailable(String creditAvailable) {
		this.creditAvailable = creditAvailable;
	}
	protected String getMinimumAmountDue() {
		return minimumAmountDue;
	}
	protected void setMinimumAmountDue(String minimumAmountDue) {
		this.minimumAmountDue = minimumAmountDue;
	}
	
	
	
	
}
