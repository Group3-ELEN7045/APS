package za.ac.wits.elen7045.group3.aps.domain.entities;

import java.util.ArrayList;
import java.util.List;

import za.ac.wits.elen7045.group3.aps.domain.accounts.interfaces.BillingAccountRepository;
import za.ac.wits.elen7045.group3.aps.services.enumtypes.StatusType;
import za.ac.wits.elen7045.group3.aps.services.exception.ApplicationException;
import za.ac.wits.elen7045.group3.aps.services.exception.DatabaseException;
import za.ac.wits.elen7045.group3.aps.services.specification.ApplicationSpecification;
import za.ac.wits.elen7045.group3.aps.services.specification.credentials.BillingAccountDetailsSpecification;
import za.ac.wits.elen7045.group3.aps.services.util.ApplicationContants;

public class BillingAccountManagerBean implements BillingAccountManager {
	private Customer customer;
	private BillingAccountRepository billingRepository;

	public BillingAccountManagerBean(Customer customer,
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
				if (billingRepository.getBillingAccount(item.getAccountNumber()) == null) {

					if (userBillingAccountDetails.isSatisfiedBy(item)) {
						item.setAccountStatus(StatusType.TRYING.getStatusType());
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
			billingRepository.saveCustomerBillingAccount(customer);  //Update the Customer with billing account details
		} catch (DatabaseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	
	//Method to update customer's billing account
	public void updateCustomerBillingAccounts(BillingAccount billingAccount) {

		if (billingAccount == null) {
			 try {
				throw new ApplicationException(ApplicationContants.BILLING_ACCOUNT_DETAILS);
			} catch (ApplicationException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		//Check if all the required fields are set
		ApplicationSpecification<BillingAccount> userBillingAccountDetails = new BillingAccountDetailsSpecification(
				billingAccount);
		if (userBillingAccountDetails.isSatisfiedBy(billingAccount)) {
			try {
				billingAccount.setAccountStatus(StatusType.TRYING.getStatusType());  // billing account status set to TRYING
				billingRepository.upDateCustomerBillingAccount(customer,
						billingAccount);
			} catch (DatabaseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	public BillingAccount getBillingAccount(String accountNumber){
		
		BillingAccount billingAccount = null;		
		if(accountNumber == null){
			 try {
				throw new Exception(ApplicationContants.ACCOUNT_NUMBER_REQ);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		try {
			billingAccount = billingRepository.getBillingAccount(accountNumber);
			if(billingAccount != null){
				return billingAccount;
			}
		} catch (DatabaseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
}