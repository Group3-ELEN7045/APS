package za.ac.wits.elen7045.group3.aps.domain.accounts.repository;

import java.util.List;

import za.ac.wits.elen7045.group3.aps.domain.BillingAccountDataAccess;
import za.ac.wits.elen7045.group3.aps.domain.entities.BillingAccount;
import za.ac.wits.elen7045.group3.aps.services.exception.DatabaseException;

public class RetriveBillingAccountRepositoryImpl implements RetriveBillingAccountRepository{
	private BillingAccountDataAccess dataAccess;
	
	public RetriveBillingAccountRepositoryImpl(BillingAccountDataAccess dataAccess){
		this.dataAccess = dataAccess;
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
	public List<BillingAccount> getBillingAccountForCustomer(Long customerId)
			throws DatabaseException { 
		return dataAccess.getBillingAccountForCustomer(customerId);
	}	
}
