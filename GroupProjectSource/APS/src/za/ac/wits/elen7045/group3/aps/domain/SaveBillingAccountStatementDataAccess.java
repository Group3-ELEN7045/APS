package za.ac.wits.elen7045.group3.aps.domain;

import za.ac.wits.elen7045.group3.aps.domain.entities.BillingAccountStatement;
import za.ac.wits.elen7045.group3.aps.services.exception.DatabaseException;
/**
 * @author Livious
 *
 */
public interface SaveBillingAccountStatementDataAccess{
	public boolean saveBillingAccountStatement(BillingAccountStatement statement)throws DatabaseException;
}

