
package za.ac.wits.elen7045.group3.aps.services.managers;

import za.ac.wits.elen7045.group3.aps.services.dto.BillingAccountDTO;
import za.ac.wits.elen7045.group3.aps.services.exception.DatabaseException;

public interface AddBillingAccountManager{
	public boolean saveBillingAccount(BillingAccountDTO billingAccount) throws DatabaseException;
	public boolean updateBillingAccountStatus(BillingAccountDTO billingAccount) throws DatabaseException;
}
