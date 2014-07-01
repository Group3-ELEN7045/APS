package za.ac.wits.elen7045.group3.aps.domain.statement.repository;

import za.ac.wits.elen7045.group3.aps.domain.entities.BillingAccountStatement;

public interface RetriveStatementRepository {
	public BillingAccountStatement getMunicipalStatement(String accountNumber, String period);
	public BillingAccountStatement getTelcoStatement(String accountNumber, String period);
	public BillingAccountStatement getCreditCardStatement(String accountNumber, String period);
}
