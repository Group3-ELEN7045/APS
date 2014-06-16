package za.ac.wits.elen7045.group3.aps.domain;

import java.util.List;

import za.ac.wits.elen7045.group3.aps.domain.entities.BillingAccount;
import za.ac.wits.elen7045.group3.aps.services.exception.DatabaseException;

public interface BillingAccountDataAccess {
	public void saveBillingAccount(BillingAccount billingAccount) throws DatabaseException;
	public void updateBillingAccount(BillingAccount billingAccount) throws DatabaseException;
	public BillingAccount getBillingAccount(String accountNumber) throws DatabaseException;
	public List<BillingAccount> getBillingAccounts(String billingCompanyName) throws DatabaseException;
}
