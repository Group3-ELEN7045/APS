package za.ac.wits.elen7045.group3.aps.domain;

import za.ac.wits.elen7045.group3.aps.domain.entities.BillingAccountStatement;
import za.ac.wits.elen7045.group3.aps.services.exception.DatabaseException;

public interface SaveBillingAccountStatementDataAccess{
	public boolean saveBillingAccountStatement(BillingAccountStatement statement)throws DatabaseException;
}

