package za.ac.wits.elen7045.group3.aps.services.managers;

import java.util.List;

import za.ac.wits.elen7045.group3.aps.services.dto.BillingAccountDTO;
/**
 * @author Livious
 *
 */
public interface RetriveBillingAccountManager {
	public BillingAccountDTO getBillingAccount(String accountNumber);
	public List<BillingAccountDTO> getBillingAccountForCustomer(Long customerId);
	public List<BillingAccountDTO> getBillingAccountsByCompanyUrl(String billingCompanyUrl);
}
