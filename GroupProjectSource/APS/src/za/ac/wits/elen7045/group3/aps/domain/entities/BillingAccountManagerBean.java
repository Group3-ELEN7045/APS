package za.ac.wits.elen7045.group3.aps.domain.entities;

import java.util.ArrayList;
import java.util.List;

import za.ac.wits.elen7045.group3.aps.domain.accounts.interfaces.BillingAccountRepository;
import za.ac.wits.elen7045.group3.aps.services.exception.DatabaseException;
import za.ac.wits.elen7045.group3.aps.services.specification.ApplicationSpecification;
import za.ac.wits.elen7045.group3.aps.services.specification.credentials.BillingAccountDetailsSpecification;
import za.ac.wits.elen7045.group3.aps.services.util.ApplicationContants;

public class BillingAccountManagerBean implements BillingAccountManager {
	private Customer customer;
	private BillingAccountRepository billingRepository;

	BillingAccountManagerBean(Customer customer,
			BillingAccountRepository billingRepository) {
		this.customer = customer;
		this.billingRepository = billingRepository;
	}

	public void addCustomerBillingAccounts(List<BillingAccount> billingAccount) {
		List<BillingAccount> account = new ArrayList<BillingAccount>();

		if (billingAccount.size() == 0) {
			// throw new LogonException(ApplicationContants.USER_NOT_FOUND);
		}

		for (BillingAccount item : billingAccount) {
			try {

				ApplicationSpecification<BillingAccount> userBillingAccountDetails = new BillingAccountDetailsSpecification(
						item);
				if (billingRepository.getCustomerBillingAccount(customer,
						item.getAccountNumber()) == null) {

					if (userBillingAccountDetails.isSatisfiedBy(item)) {
						account.add(item);
					} else {
						throw new Exception(
								ApplicationContants.BILLING_ACCOUNT_DETAILS);
					}
				}

			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		customer.setBillingAccounts(account);
		try {
			billingRepository.saveCustomerBillingAccount(customer);
		} catch (DatabaseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void updateCustomerBillingAccounts(BillingAccount billingAccount) {

		if (billingAccount == null) {
			// throw new LogonException(ApplicationContants.USER_NOT_FOUND);
		}

		ApplicationSpecification<BillingAccount> userBillingAccountDetails = new BillingAccountDetailsSpecification(
				billingAccount);
		if (userBillingAccountDetails.isSatisfiedBy(billingAccount)) {
			try {
				billingRepository.upDateCustomerBillingAccount(customer,
						billingAccount);
			} catch (DatabaseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
