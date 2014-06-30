package za.ac.wits.elen7045.group3.aps.domain.accounts.repository;

import za.ac.wits.elen7045.group3.aps.domain.entities.BillingAccount;
import za.ac.wits.elen7045.group3.aps.services.exception.DatabaseException;
/**
 * @author Livious
 *
 */
public interface AddBillingAccountRepository {	
	public boolean saveBillingAccount(BillingAccount billingAccount) throws DatabaseException;
	public boolean updateBillingAccountStatus(BillingAccount billingAccount) throws DatabaseException;
}
