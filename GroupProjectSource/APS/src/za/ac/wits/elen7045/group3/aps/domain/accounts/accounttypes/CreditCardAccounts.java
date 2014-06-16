package za.ac.wits.elen7045.group3.aps.domain.accounts.accounttypes;

<<<<<<< HEAD
import za.ac.wits.elen7045.group3.aps.domain.accounts.abtracts.AbstractAccounts;
import za.ac.wits.elen7045.group3.aps.domain.vo.DataPair;

public class CreditCardAccounts extends AbstractAccounts{

	private DataPair cardType;
	private DataPair interestRate;
	private DataPair creditLimit;
	private DataPair creditAvailable;
	private DataPair minimumAmountDue;

	protected CreditCardAccounts(DataPair accountNumber) {
		setAccountNumber(new DataPair(accountNumber));
	}
	
	protected DataPair getCardType() {
		return new DataPair(cardType);
	}

	protected void setCardType(DataPair cardType) {
		this.cardType = new DataPair(cardType);
	}

	protected DataPair getInterestRate() {
		return new DataPair(interestRate);
	}

	protected void setInterestRate(DataPair interestRate) {
		this.interestRate = new DataPair(interestRate);
	}

	protected DataPair getCreditLimit() {
		return new DataPair(creditLimit);
	}

	protected void setCreditLimit(DataPair creditLimit) {
		this.creditLimit = new DataPair(creditLimit);
	}

	protected DataPair getCreditAvailable() {
		return new DataPair(creditAvailable);
	}

	protected void setCreditAvailable(DataPair creditAvailable) {
		this.creditAvailable = new DataPair(creditAvailable);
	}

	protected DataPair getMinimumAmountDue() {
		return new DataPair(minimumAmountDue);
	}

	protected void setMinimumAmountDue(DataPair minimumAmountDue) {
		this.minimumAmountDue = new DataPair(minimumAmountDue);
=======
import za.ac.wits.elen7045.group3.aps.domain.vo.DataPair;
import za.ac.wits.elen7045.group3.aps.services.util.AccountScrapedData;

public class CreditCardAccounts extends AccountScrapedData{

	public CreditCardAccounts(){

>>>>>>> 334e171862bacecf51ba61bafe29223ce078425e
	}
	
}
