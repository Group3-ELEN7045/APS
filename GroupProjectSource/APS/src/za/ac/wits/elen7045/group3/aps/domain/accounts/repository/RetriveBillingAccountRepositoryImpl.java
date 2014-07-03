package za.ac.wits.elen7045.group3.aps.domain.accounts.repository;

import java.util.List;
import za.ac.wits.elen7045.group3.aps.domain.RetriveBillingAccountDataAccess;
import za.ac.wits.elen7045.group3.aps.domain.entities.BillingAccount;
import za.ac.wits.elen7045.group3.aps.services.exception.DatabaseException;
/**
 * @author Livious
 *
 */
public class RetriveBillingAccountRepositoryImpl implements RetriveBillingAccountRepository{
	private RetriveBillingAccountDataAccess dataAccess;
	
	public RetriveBillingAccountRepositoryImpl(RetriveBillingAccountDataAccess dataAccess){
		this.dataAccess = dataAccess;
	}
	
	@Override
	public BillingAccount getBillingAccount(String accountNumberSearch) {
		try {
			return dataAccess.getBillingAccount(accountNumberSearch);
		} catch (DatabaseException e) {
			throw new RuntimeException("Problem getting the billing account");
		}
	}

	@Override
	public List<BillingAccount> getBillingAccountsByCompanyUrl(String billingCompanyUrl) {
		try {
			return dataAccess.getBillingAccountsByCompanyUrl(billingCompanyUrl);
		} catch (DatabaseException e) {
			throw new RuntimeException("Problem getting the billing account for url");
		}
	}

	
	@Override
	public List<BillingAccount> getBillingAccountForCustomer(Long customerId){ 
		try {
			return dataAccess.getBillingAccountForCustomer(customerId);
		} catch (DatabaseException e) {
			throw new RuntimeException("Problem getting the billing account for customer");
			
		}
	}	
}
