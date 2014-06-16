package za.ac.wits.elen7045.group3.aps.domain.accounts.repository;



import za.ac.wits.elen7045.group3.aps.domain.BillingAccountStatementDataAccess;
import za.ac.wits.elen7045.group3.aps.domain.entities.BillingAccountStatement;

public class BillingAccountStatementRepositoryImpl implements BillingAccountStatementRepository{
	private BillingAccountStatementDataAccess dataAccess;
	
	@Override
	public BillingAccountStatement getCustomerStatement(long billingAccountId, String billingPeriod) {
		
		return dataAccess.getCustemerStatement(billingAccountId, billingPeriod);
	}

}
