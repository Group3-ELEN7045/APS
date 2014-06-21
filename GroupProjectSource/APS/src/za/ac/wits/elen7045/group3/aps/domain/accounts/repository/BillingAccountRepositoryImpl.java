package za.ac.wits.elen7045.group3.aps.domain.accounts.repository;

import java.util.List;

import za.ac.wits.elen7045.group3.aps.domain.BillingAccountDataAccess;
import za.ac.wits.elen7045.group3.aps.domain.entities.BillingAccount;
import za.ac.wits.elen7045.group3.aps.services.exception.DatabaseException;



/**
 * @author Livious
 *
 */

public class BillingAccountRepositoryImpl implements BillingAccountRepository {
	private BillingAccountDataAccess dataAccess;
		
	public BillingAccountRepositoryImpl(BillingAccountDataAccess dataAccess){
		this.dataAccess = dataAccess;
	}

	@Override
	public void saveBillingAccount(BillingAccount billingAccount)
			throws DatabaseException {
		dataAccess.saveBillingAccount(billingAccount);
	}

	@Override
	public void updateBillingAccount(BillingAccount billingAccount)
			throws DatabaseException {
		dataAccess.updateBillingAccount(billingAccount);
		
	}

	@Override
	public BillingAccount getBillingAccount(String accountNumber)
			throws DatabaseException {
		return dataAccess.getBillingAccount(accountNumber);
	}

	@Override
	public List<BillingAccount> getBillingAccounts(String billingCompanyName)
			throws DatabaseException {
		dataAccess.getBillingAccounts(billingCompanyName);
		return null;
	}

	@Override
	public BillingAccount getBillingStatement(String accountNumber,
			String period) throws DatabaseException {		
		return dataAccess.getBillingAccountStatement(accountNumber, period);
	}
	
		
}
