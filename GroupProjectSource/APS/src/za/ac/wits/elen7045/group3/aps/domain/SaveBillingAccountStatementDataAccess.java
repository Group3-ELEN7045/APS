package za.ac.wits.elen7045.group3.aps.domain;

import za.ac.wits.elen7045.group3.aps.domain.entities.BillingAccountStatement;

public interface SaveBillingAccountStatementDataAccess{
	public boolean saveBillingAccountStatement(BillingAccountStatement statement);
}

