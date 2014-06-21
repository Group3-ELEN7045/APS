package za.ac.wits.elen7045.group3.aps.services.managers;

import za.ac.wits.elen7045.group3.aps.domain.accounts.repository.BillingAccountRepository;
import za.ac.wits.elen7045.group3.aps.domain.entities.BillingAccount;
import za.ac.wits.elen7045.group3.aps.services.enumtypes.StatusType;
import za.ac.wits.elen7045.group3.aps.services.exception.ApplicationException;
import za.ac.wits.elen7045.group3.aps.services.exception.DatabaseException;
import za.ac.wits.elen7045.group3.aps.services.specification.ApplicationSpecification;
import za.ac.wits.elen7045.group3.aps.services.specification.credentials.BillingAccountDetailsSpecification;
import za.ac.wits.elen7045.group3.aps.services.util.ApplicationContants;

public class BillingAccountManagerImpl implements BillingAccountManager {
	private BillingAccountRepository billingRepository;

	public BillingAccountManagerImpl(BillingAccountRepository billingRepository) {
		this.billingRepository = billingRepository;
	}

	public void addCustomerBillingAccounts(BillingAccount billingAccount) {
		if (billingAccount == null) {
			// throw new LogonException(ApplicationContants.USER_NOT_FOUND);
		}
		
		try {
			if (billingRepository.getBillingAccount(billingAccount.getAccountNumber()) == null) {
			ApplicationSpecification<BillingAccount> userBillingAccountDetails = new BillingAccountDetailsSpecification(
					billingAccount);
			if (userBillingAccountDetails.isSatisfiedBy(billingAccount)) {  //checks is all fields on the billing account have been set
				billingAccount.setAccountStatus(StatusType.TRYING);		//set the billing account status to trying
			} else {
				// new Exception() billing account details incorrect.
			}			
			billingRepository.saveBillingAccount(billingAccount);
			}
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
			//	billingAccount.setAccountStatus(StatusType.TRYING);  // billing account status set to TRYING
				billingRepository.updateBillingAccount(billingAccount);
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

	@Override
	public BillingAccount getBillingStatement(String accountNumber, String period) {
		BillingAccount billAccount = null;
		if(accountNumber == null){
			//throws new Exception()
		}
		if(period == null){
			//throws new Exception()
		}		
		try {
			billAccount =  billingRepository.getBillingStatement(accountNumber, period);
		} catch (DatabaseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return billAccount;
	}
}
