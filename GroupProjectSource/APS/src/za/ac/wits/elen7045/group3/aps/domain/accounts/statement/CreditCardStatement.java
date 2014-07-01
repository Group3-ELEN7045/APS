package za.ac.wits.elen7045.group3.aps.domain.accounts.statement;
/**
 * @author boitumelo
 */

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;

import za.ac.wits.elen7045.group3.aps.domain.entities.BillingAccountStatement;

@Entity
@Table(name="CREDIT_CARD_STATEMENT")
@Inheritance(strategy=InheritanceType.SINGLE_TABLE)
public class CreditCardStatement extends BillingAccountStatement implements Serializable{
			
	private String cardType;
	private String interestRate;
	private String creditLimit;
	private String creditAvailable;
	private String minimumAmountDue;
	
	public CreditCardStatement(){
		
	}
	
	public CreditCardStatement(String accountNumber){
		this.setAccountNumber(accountNumber);
	}
	
	@Column(name = "CARD_TYPE",nullable = true)	
	public String getCardType() {
		return cardType;
	}
	public void setCardType(String cardType) {
		this.cardType = cardType;
	}
	
	@Column(name = "INTEREST_RATE",nullable = true)
	public String getInterestRate() {
		return interestRate;
	}
	public void setInterestRate(String interestRate) {
		this.interestRate = interestRate;
	}
	
	@Column(name = "CREDIT_LIMIT",nullable = true)
	public String getCreditLimit() {
		return creditLimit;
	}
	public void setCreditLimit(String creditLimit) {
		this.creditLimit = creditLimit;
	}
	
	@Column(name = "CREDIT_AVAILABLE",nullable = true)
	public String getCreditAvailable() {
		return creditAvailable;
	}
	public void setCreditAvailable(String creditAvailable) {
		this.creditAvailable = creditAvailable;
	}
	
	@Column(name = "MINIMUM_AMOUNT_DUE",nullable = true)
	public String getMinimumAmountDue() {
		return minimumAmountDue;
	}
	public void setMinimumAmountDue(String minimumAmountDue) {
		this.minimumAmountDue = minimumAmountDue;
	}	
}
