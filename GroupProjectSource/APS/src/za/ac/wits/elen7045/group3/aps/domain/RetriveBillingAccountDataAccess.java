package za.ac.wits.elen7045.group3.aps.domain;

import java.util.List;

import za.ac.wits.elen7045.group3.aps.domain.entities.BillingAccount;
import za.ac.wits.elen7045.group3.aps.services.exception.DatabaseException;

public interface RetriveBillingAccountDataAccess {
	public BillingAccount getBillingAccount(String accountNumber) throws DatabaseException;
	public List<BillingAccount> getBillingAccountsByCompanyUrl(String billingCompanyUrl) throws DatabaseException;
	public List<BillingAccount> getBillingAccountForCustomer(Long id) throws DatabaseException;
}
