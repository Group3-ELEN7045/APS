package za.ac.wits.elen7045.group3.aps.services.managers;

import java.util.ArrayList;
import java.util.List;

import za.ac.wits.elen7045.group3.aps.domain.accounts.repository.BillingAccountRepository;
import za.ac.wits.elen7045.group3.aps.domain.accounts.repository.BillingAccountStatementRepository;
import za.ac.wits.elen7045.group3.aps.domain.entities.BillingAccount;

/**
 * @author Livious
 * 
 */
public class BillingAccountStatementManagerBean implements BillingAccountStatementManager{
	private BillingAccountStatementRepository billingStatementRepository;
	
	BillingAccountStatementManagerBean(BillingAccountStatementRepository billingStatementRepository){
		this.billingStatementRepository = billingStatementRepository;
	}
	public List<BillingAccountStatement> getUserAggrigatedStatement(
			List<BillingAccount> billingAccountList, String billingPeriod) {
		List<BillingAccountStatement> accountList = new ArrayList<BillingAccountStatement>();
		if (billingAccountList.size() == 0) {
			// Specify the billing Accounts
		}

		for (BillingAccount account : billingAccountList) {
			BillingAccountStatement statement = billingStatementRepository.getCustomerStatement(account.getId(), billingPeriod);
			if(statement != null){
				accountList.add(statement);
			}
		}
		return accountList;
	}
}