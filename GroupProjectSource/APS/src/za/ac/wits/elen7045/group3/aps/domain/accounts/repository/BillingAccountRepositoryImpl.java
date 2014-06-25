package za.ac.wits.elen7045.group3.aps.domain.accounts.repository;

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
	public List<BillingAccount> getBillingAccountsByCompanyUrl(String billingCompanyUrl) throws DatabaseException {
		return dataAccess.getBillingAccountsByCompanyUrl(billingCompanyUrl);
	}

	
	@Override
	public List<BillingAccount> getBillingAcountsForCustomer(Long customerId)
			throws DatabaseException {
		return dataAccess.getBillingAcountsForCustomer(customerId);
	}	
}
