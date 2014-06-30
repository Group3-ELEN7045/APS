package za.ac.wits.elen7045.group3.aps.domain;

import za.ac.wits.elen7045.group3.aps.domain.entities.BillingAccountStatement;

public interface RetriveBillingAccountStatementDataAccess {
	public BillingAccountStatement getMunicipalStatement(String accountNumber, String period);
	public BillingAccountStatement getTelcoStatement(String accountNumber, String period);
	public BillingAccountStatement getCreditCardStatement(String accountNumber, String period);
}
