package za.ac.wits.elen7045.group3.aps.domain.accounts.repository;

import java.util.List;

import za.ac.wits.elen7045.group3.aps.domain.AddBillingAccountDataAccess;
import za.ac.wits.elen7045.group3.aps.domain.entities.BillingAccount;
import za.ac.wits.elen7045.group3.aps.services.exception.DatabaseException;

/**
 * @author Livious
 *
 */

public class AddBillingAccountRepositoryImpl implements AddBillingAccountRepository {
	
	private AddBillingAccountDataAccess dataAccess;

		public AddBillingAccountRepositoryImpl(AddBillingAccountDataAccess dataAccess){
		this.dataAccess = dataAccess;
	}

	@Override
	public boolean saveBillingAccount(BillingAccount billingAccount) {

		try {
			return dataAccess.saveBillingAccount(billingAccount);
		} catch (DatabaseException e) {
				throw new RuntimeException("Problem Saving the billing account");
			
		}
	}

	@Override
	public boolean updateBillingAccountStatus(BillingAccount billingAccount){

		try {
			return dataAccess.updateBillingAccountStatus(billingAccount);
		} catch (DatabaseException e) {
			throw new RuntimeException("Problem Updating the billing account");
		}
	}
	
}
