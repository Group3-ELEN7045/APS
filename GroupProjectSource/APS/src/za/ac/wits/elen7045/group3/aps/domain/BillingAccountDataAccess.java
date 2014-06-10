package za.ac.wits.elen7045.group3.aps.domain;

import za.ac.wits.elen7045.group3.aps.domain.entities.BillingAccount;
import za.ac.wits.elen7045.group3.aps.domain.entities.Customer;
import za.ac.wits.elen7045.group3.aps.services.exception.DatabaseException;



public interface BillingAccountDataAccess {	
	 void saveCustomerBillingAccount(Customer customer) throws DatabaseException;
	 BillingAccount getBillingAccount(Customer customer, String accountNumber) throws DatabaseException;
	 void upCustomerBillingAccount(Customer customer,  BillingAccount billingAccount) throws DatabaseException;
}
