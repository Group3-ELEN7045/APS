
package za.ac.wits.elen7045.group3.aps.services.managers;

import za.ac.wits.elen7045.group3.aps.domain.entities.BillingAccountStatement;

public interface BillingAccountStatementManager <T>{	
	public void saveBillingAccountStatement(BillingAccountStatement stractDataStatement);
	public T getBillingAccountStatements(String accountNumber, String period);
}

