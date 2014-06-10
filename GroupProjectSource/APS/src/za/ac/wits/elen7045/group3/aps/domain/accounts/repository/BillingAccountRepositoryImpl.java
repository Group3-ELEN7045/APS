package za.ac.wits.elen7045.group3.aps.domain.accounts.repository;

import za.ac.wits.elen7045.group3.aps.domain.BillingAccountDataAccess;
import za.ac.wits.elen7045.group3.aps.domain.accounts.interfaces.BillingAccountRepository;
import za.ac.wits.elen7045.group3.aps.domain.entities.BillingAccount;
import za.ac.wits.elen7045.group3.aps.domain.entities.Customer;
import za.ac.wits.elen7045.group3.aps.services.exception.DatabaseException;



/**
 * @author Livious
 *
 */

public class BillingAccountRepositoryImpl implements BillingAccountRepository {
	private BillingAccountDataAccess dataAccess;
	
	BillingAccountRepositoryImpl(BillingAccountDataAccess dataAccess){
		this.dataAccess = dataAccess;
	}
	
	public void saveCustomerBillingAccount(Customer customer) throws DatabaseException{
		dataAccess.saveCustomerBillingAccount(customer);
	}
	
	public BillingAccount getCustomerBillingAccount(Customer customer, String accountNumber)throws DatabaseException{
		return dataAccess.getBillingAccount(customer, accountNumber);
	}
	
	public void upDateCustomerBillingAccount(Customer customer, BillingAccount billingAccount)throws DatabaseException{
		dataAccess.upCustomerBillingAccount(customer, billingAccount);
	}
}
