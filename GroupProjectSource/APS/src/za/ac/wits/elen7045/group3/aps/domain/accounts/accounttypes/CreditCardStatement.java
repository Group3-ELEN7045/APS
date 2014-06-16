package za.ac.wits.elen7045.group3.aps.domain.accounts.accounttypes;

<<<<<<< HEAD:GroupProjectSource/APS/src/za/ac/wits/elen7045/group3/aps/domain/accounts/accounttypes/CreditCardStatement.java
import za.ac.wits.elen7045.group3.aps.domain.accounts.abtracts.AbstractStatement;

public class CreditCardStatement extends AbstractStatement{
=======
import za.ac.wits.elen7045.group3.aps.domain.accounts.abtracts.AbstractBillingAccountStatement;

public class CreditCardAccount extends AbstractBillingAccountStatement{
>>>>>>> 334e171862bacecf51ba61bafe29223ce078425e:GroupProjectSource/APS/src/za/ac/wits/elen7045/group3/aps/domain/accounts/accounttypes/CreditCardAccount.java

	private String cardType;
	private String interestRate;
	private String creditLimit;
	private String creditAvailable;
	private String minimumAmountDue;

	public CreditCardStatement(String accountNumber) {
		setAccountNumber(accountNumber);
	}
	
	public String getCardType() {
		return cardType;
	}
	public void setCardType(String cardType) {
		this.cardType = cardType;
	}
	public String getInterestRate() {
		return interestRate;
	}
	public void setInterestRate(String interestRate) {
		this.interestRate = interestRate;
	}
	public String getCreditLimit() {
		return creditLimit;
	}
	public void setCreditLimit(String creditLimit) {
		this.creditLimit = creditLimit;
	}
	public String getCreditAvailable() {
		return creditAvailable;
	}
	public void setCreditAvailable(String creditAvailable) {
		this.creditAvailable = creditAvailable;
	}
	public String getMinimumAmountDue() {
		return minimumAmountDue;
	}
	public void setMinimumAmountDue(String minimumAmountDue) {
		this.minimumAmountDue = minimumAmountDue;
	}
	
	
	
	
}
