package za.ac.wits.elen7045.group3.aps.domain.accounts.repository;

import java.util.List;

import za.ac.wits.elen7045.group3.aps.domain.entities.BillingAccount;
import za.ac.wits.elen7045.group3.aps.services.exception.DatabaseException;

public interface RetriveBillingAccountRepository {
	public BillingAccount getBillingAccount(String accountNumber) throws DatabaseException;
	public List<BillingAccount> getBillingAccountForCustomer(Long customerId)throws DatabaseException;
	public List<BillingAccount> getBillingAccountsByCompanyUrl(String billingCompanyUrl) throws DatabaseException;
	
}