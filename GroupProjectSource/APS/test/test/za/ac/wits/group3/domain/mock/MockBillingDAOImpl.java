package test.za.ac.wits.group3.domain.mock;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import za.ac.wits.elen7045.group3.aps.domain.BillingAccountDataAccess;
import za.ac.wits.elen7045.group3.aps.domain.UserDataAccess;
import za.ac.wits.elen7045.group3.aps.domain.entities.BillingAccount;
import za.ac.wits.elen7045.group3.aps.domain.entities.Customer;
import za.ac.wits.elen7045.group3.aps.domain.vo.CredentialsVO;
import za.ac.wits.elen7045.group3.aps.services.exception.DatabaseException;
import za.ac.wits.elen7045.group3.aps.services.specification.Specification;
import za.ac.wits.elen7045.group3.aps.services.specification.user.UserSpecificationByID;
import za.ac.wits.elen7045.group3.aps.services.util.ApplicationContants;

public class MockBillingDAOImpl implements BillingAccountDataAccess {
	private static Map<Long, String> customerBillingAccountsDatabase = new HashMap<Long, String>();
	private static Map<String, BillingAccount> billingAccountsDatabase = new HashMap<String, BillingAccount>();

	public void saveCustomerBillingAccount(Customer customer) throws DatabaseException{
				
		for(BillingAccount account : customer.getBillingAccounts()){			
			if(!billingAccountsDatabase.containsKey(account.getAccountNumber())){
				billingAccountsDatabase.put(account.getAccountNumber(), account);
				customerBillingAccountsDatabase.put(customer.getId(), account.getAccountNumber());
			}else
			{		
				throw new DatabaseException(ApplicationContants.ACCOUNT_DUPLICATE);
			}
		}
	}	public BillingAccount getBillingAccount(String accountNumber)
			throws DatabaseException {
		BillingAccount billingAccount = null;
		billingAccount = billingAccountsDatabase.get(accountNumber);

		if (billingAccount != null) {
			return billingAccount;
		}
		return null;
	}

	public void upDateCustomerBillingAccount(Customer customer,
			BillingAccount billingAccount) throws DatabaseException {

		if (billingAccountsDatabase.containsKey(billingAccount)) {
			billingAccountsDatabase.remove(billingAccount);
			billingAccountsDatabase.put(billingAccount.getAccountNumber(),
					billingAccount);
		}
	}

}
