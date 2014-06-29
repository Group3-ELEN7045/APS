package za.ac.wits.elen7045.group3.aps.services.managers;

import java.util.List;

import za.ac.wits.elen7045.group3.aps.domain.entities.BillingAccountStatement;

public interface BillingAccountStatementManager{	
	public boolean addStatement(BillingAccountStatement statement);
    public List<BillingAccountStatement> getAccountStatement(String accountNumber);
}

