package za.ac.wits.elen7045.group3.aps.domain.accounts.interfaces;

import za.ac.wits.elen7045.group3.aps.domain.entities.BillingAccount;
import za.ac.wits.elen7045.group3.aps.domain.entities.Customer;
import za.ac.wits.elen7045.group3.aps.services.exception.DatabaseException;

public interface BillingAccountStatementRepository {
	public void saveCustomerBillingAccount(Customer customer) throws DatabaseException;
	public BillingAccount getBillingAccount(String accountNumer) throws DatabaseException;
	public void upDateCustomerBillingAccount(Customer customer, BillingAccount billingAccount) throws DatabaseException;
}
