package za.ac.wits.elen7045.group3.aps.domain.statement.repository;

import za.ac.wits.elen7045.group3.aps.domain.entities.BillingAccountStatement;

/**
 * @author Livious
 *
 */
public interface SaveStatementRepository {
	public boolean addStatement(BillingAccountStatement statement);   
}
