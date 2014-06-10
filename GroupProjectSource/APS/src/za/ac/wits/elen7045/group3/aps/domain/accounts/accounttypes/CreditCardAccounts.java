package za.ac.wits.elen7045.group3.aps.domain.accounts.accounttypes;

import za.ac.wits.elen7045.group3.aps.domain.accounts.abtracts.AbstractAccounts;
import za.ac.wits.elen7045.group3.aps.domain.vo.DataPair;

public class CreditCardAccounts extends AbstractAccounts{

	private DataPair cardType;
	private DataPair interestRate;
	private DataPair creditLimit;
	private DataPair creditAvailable;
	private DataPair minimumAmountDue;

	public CreditCardAccounts(DataPair accountNumber) {
		setAccountNumber(new DataPair(accountNumber));
	}
	
	public DataPair getCardType() {
		return new DataPair(cardType);
	}

	public void setCardType(DataPair cardType) {
		this.cardType = new DataPair(cardType);
	}

	public DataPair getInterestRate() {
		return new DataPair(interestRate);
	}

	public void setInterestRate(DataPair interestRate) {
		this.interestRate = new DataPair(interestRate);
	}

	public DataPair getCreditLimit() {
		return new DataPair(creditLimit);
	}

	public void setCreditLimit(DataPair creditLimit) {
		this.creditLimit = new DataPair(creditLimit);
	}

	public DataPair getCreditAvailable() {
		return new DataPair(creditAvailable);
	}

	public void setCreditAvailable(DataPair creditAvailable) {
		this.creditAvailable = new DataPair(creditAvailable);
	}

	public DataPair getMinimumAmountDue() {
		return new DataPair(minimumAmountDue);
	}

	public void setMinimumAmountDue(DataPair minimumAmountDue) {
		this.minimumAmountDue = new DataPair(minimumAmountDue);
	}
	
}
