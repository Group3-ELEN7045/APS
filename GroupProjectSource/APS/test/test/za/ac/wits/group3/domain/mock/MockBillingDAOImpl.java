package test.za.ac.wits.group3.domain.mock;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import za.ac.wits.elen7045.group3.aps.domain.BillingAccountDataAccess;
import za.ac.wits.elen7045.group3.aps.domain.UserDataAccess;
import za.ac.wits.elen7045.group3.aps.domain.accounts.abtracts.AbstractBillingAccountStatement;
import za.ac.wits.elen7045.group3.aps.domain.entities.BillingAccount;
import za.ac.wits.elen7045.group3.aps.domain.entities.Customer;
import za.ac.wits.elen7045.group3.aps.domain.vo.CredentialsVO;
import za.ac.wits.elen7045.group3.aps.services.exception.DatabaseException;
import za.ac.wits.elen7045.group3.aps.services.specification.Specification;
import za.ac.wits.elen7045.group3.aps.services.specification.user.UserSpecificationByID;
import za.ac.wits.elen7045.group3.aps.services.util.ApplicationContants;

public class MockBillingDAOImpl implements BillingAccountDataAccess {
	private static Map<String, Long> customerBillingAccountsDatabase = new HashMap<String, Long>();
	private static Map<String, BillingAccount> billingAccountsDatabase = new HashMap<String, BillingAccount>();
	private static Map<String, BillingAccount> billingStatementsDatabase = new HashMap<String, BillingAccount>();

	public void saveBillingAccount(BillingAccount billingAccount) throws DatabaseException{
			List<AbstractBillingAccountStatement> statementList = new ArrayList<AbstractBillingAccountStatement>();	
						
			if(!billingAccountsDatabase.containsKey(billingAccount.getAccountNumber())){
				billingAccountsDatabase.put(billingAccount.getAccountNumber(), billingAccount);
				customerBillingAccountsDatabase.put(billingAccount.getAccountNumber(), billingAccount.getCustomerId());
				
				for (AbstractBillingAccountStatement statement : billingAccount.getBillingStatement()){
					billingStatementsDatabase.put(statement.getAccountStatementMonth(), billingAccount);
				}
			}
					
		}
	
public List<BillingAccount> getBillingAccounts(String accountNumber)
			throws DatabaseException {
		List<BillingAccount> billingAccountList = new ArrayList<BillingAccount>();
	//	billingAccountList = billingAccountsDatabase.get(accountNumber);

		if (billingAccountList != null) {
			return billingAccountList;
		}
		return null;
	}

public BillingAccount getBillingAccount(String accountNumber)
		throws DatabaseException {
	BillingAccount billingAccount = billingAccountsDatabase.get(accountNumber);
//	billingAccountList = billingAccountsDatabase.get(accountNumber);

	if (billingAccount != null) {
		return billingAccount;
	}
	return null;
}
	@Override
	public void updateBillingAccount(BillingAccount billingAccount)
			throws DatabaseException {
		if (billingAccountsDatabase.containsKey(billingAccount.getAccountNumber())) {
			billingAccountsDatabase.remove(billingAccount);
			billingAccountsDatabase.put(billingAccount.getAccountNumber(), billingAccount);
							
			for (AbstractBillingAccountStatement statement : billingAccount.getBillingStatement()){
				billingStatementsDatabase.put(statement.getAccountStatementDate(), billingAccount);
			}
		}
	}

	@Override
	public BillingAccount getBillingAccountStatement(String accountNumber,
			String period) throws DatabaseException {
		BillingAccount billingAccount = billingStatementsDatabase.get(period);
		return billingAccount;
	}
}
