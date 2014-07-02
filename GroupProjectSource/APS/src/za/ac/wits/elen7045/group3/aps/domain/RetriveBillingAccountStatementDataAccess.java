package za.ac.wits.elen7045.group3.aps.domain;

import za.ac.wits.elen7045.group3.aps.domain.entities.BillingAccountStatement;
import za.ac.wits.elen7045.group3.aps.services.exception.DatabaseException;
/**
 * @author Livious
 *
 */
public interface RetriveBillingAccountStatementDataAccess {
	public BillingAccountStatement getMunicipalStatement(String accountNumber, String period) throws DatabaseException;
	public BillingAccountStatement getTelcoStatement(String accountNumber, String period)throws DatabaseException;
	public BillingAccountStatement getCreditCardStatement(String accountNumber, String period) throws DatabaseException;
}
