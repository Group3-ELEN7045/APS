package za.ac.wits.elen7045.group3.aps.services.managers;

import java.util.List;

import za.ac.wits.elen7045.group3.aps.domain.BillingAccountDataAccess;
import za.ac.wits.elen7045.group3.aps.domain.entities.BillingAccount;
import za.ac.wits.elen7045.group3.aps.domain.entities.BillingAccountStatement;

public interface BillingAccountStatementManager{	
	public void saveBillingAccountStatement(BillingAccountStatement stractDataStatement);
	public List<BillingAccountStatement> getBillingAccountStatements(String accountNumber, String period);
}
