package za.ac.wits.elen7045.group3.aps.domain.entities;

import java.util.List;

public interface BillingAccountManager {

	public void addCustomerBillingAccounts(List<BillingAccount> billingAccount);
	public void updateCustomerBillingAccounts(BillingAccount billingAccount);
}
