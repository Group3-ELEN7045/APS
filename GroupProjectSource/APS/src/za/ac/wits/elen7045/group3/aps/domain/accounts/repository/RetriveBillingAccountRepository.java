package za.ac.wits.elen7045.group3.aps.domain.accounts.repository;

import java.util.List;

import za.ac.wits.elen7045.group3.aps.domain.entities.BillingAccount;
/**
 * @author Livious
 *
 */
public interface RetriveBillingAccountRepository {
	public BillingAccount getBillingAccount(String accountNumber);
	public List<BillingAccount> getBillingAccountForCustomer(Long customerId);
	public List<BillingAccount> getBillingAccountsByCompanyUrl(String billingCompanyUrl);
	
}
