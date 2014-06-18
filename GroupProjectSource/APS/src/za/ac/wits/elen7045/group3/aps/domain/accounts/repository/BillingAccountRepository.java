package za.ac.wits.elen7045.group3.aps.domain.accounts.repository;

import java.util.List;

import za.ac.wits.elen7045.group3.aps.domain.entities.BillingAccount;
import za.ac.wits.elen7045.group3.aps.services.exception.DatabaseException;

public interface BillingAccountRepository {
	public void saveBillingAccount(BillingAccount billingAccount) throws DatabaseException;
	public void updateBillingAccount(BillingAccount billingAccount) throws DatabaseException;
	public BillingAccount getBillingAccount(String accountNumber) throws DatabaseException;
	public List<BillingAccount> getBillingAccounts(String billingCompanyName) throws DatabaseException;
	public BillingAccount getBillingStatement(String accountnumber, String period) throws DatabaseException;
}
