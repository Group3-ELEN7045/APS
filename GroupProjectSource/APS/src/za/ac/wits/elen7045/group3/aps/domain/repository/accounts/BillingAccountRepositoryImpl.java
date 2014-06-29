package za.ac.wits.elen7045.group3.aps.domain.repository.accounts;

import java.util.List;

import za.ac.wits.elen7045.group3.aps.domain.BillingAccountDataAccess;
import za.ac.wits.elen7045.group3.aps.domain.entities.BillingAccount;
import za.ac.wits.elen7045.group3.aps.domain.entities.BillingAccountStatement;
import za.ac.wits.elen7045.group3.aps.domain.entities.BillingCompany;
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
	public boolean saveBillingAccount(BillingAccount billingAccount)throws DatabaseException {

		return dataAccess.saveBillingAccount(billingAccount);
	}

	@Override
	public boolean updateBillingAccountStatus(BillingAccount billingAccount)throws DatabaseException {

		return dataAccess.updateBillingAccountStatus(billingAccount);
	}

	@Override
	public BillingAccount getBillingAccount(String accountNumberSearch)	throws DatabaseException {
		return dataAccess.getBillingAccount(accountNumberSearch);
	}

	@Override
	public List<BillingAccount> getBillingAccountsByCompanyName(String billingCompanyUrl) throws DatabaseException {
		return dataAccess.getBillingAccountsByCompanyName(billingCompanyUrl);
	}

	@Override
	public List<BillingAccount> getBillingAccountStatementByAccountNumberAndPeriod(
			Long customerId, String period) throws DatabaseException {
		return dataAccess.getBillingAccountStatementByAccountNumberAndPeriod(customerId, period);
		
	}

	@Override
	public List<BillingAccount> getBillingAccountsByUserId(Long id)	throws DatabaseException {
		List<BillingAccount> bilingAccs = dataAccess.getBillingAccountsByUserId(id);
		return bilingAccs;
	}

	@Override
	public boolean updateBillingAccountStatement(
			BillingAccountStatement billingAccountStatement)
			throws DatabaseException {
		// TODO Auto-generated method stub
		return false;
	}	
}
