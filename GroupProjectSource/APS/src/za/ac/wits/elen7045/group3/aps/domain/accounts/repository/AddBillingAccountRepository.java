package za.ac.wits.elen7045.group3.aps.domain.accounts.repository;

import za.ac.wits.elen7045.group3.aps.domain.entities.BillingAccount;
/**
 * @author Livious
 *
 */
public interface AddBillingAccountRepository {	
	public boolean saveBillingAccount(BillingAccount billingAccount);
	public boolean updateBillingAccountStatus(BillingAccount billingAccount);
}
