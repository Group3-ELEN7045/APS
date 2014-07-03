
package za.ac.wits.elen7045.group3.aps.services.managers;

import za.ac.wits.elen7045.group3.aps.services.dto.BillingAccountDTO;
/**
 * @author Livious
 *
 */
public interface AddBillingAccountManager{
	public boolean saveBillingAccount(BillingAccountDTO billingAccount);
	public boolean updateBillingAccountStatus(BillingAccountDTO billingAccount);
}
