package za.ac.wits.elen7045.group3.aps.services.managers;

import java.util.List;

import za.ac.wits.elen7045.group3.aps.domain.entities.BillingAccount;

public interface BillingAccountManager {

	public void addCustomerBillingAccounts(List<BillingAccount> billingAccount);
	public void updateCustomerBillingAccounts(BillingAccount billingAccount);
	public BillingAccount getBillingAccount(String accountNumber);
}