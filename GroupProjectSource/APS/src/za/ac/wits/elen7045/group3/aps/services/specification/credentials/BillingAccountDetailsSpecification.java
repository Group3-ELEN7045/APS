package za.ac.wits.elen7045.group3.aps.services.specification.credentials;

import za.ac.wits.elen7045.group3.aps.services.dto.BillingAccountDTO;
import za.ac.wits.elen7045.group3.aps.services.specification.ApplicationSpecification;

public class BillingAccountDetailsSpecification extends ApplicationSpecification<BillingAccountDTO>{
	
	private BillingAccountDTO billingAccount;
		
	public BillingAccountDetailsSpecification(BillingAccountDTO billingAccount){
		this.billingAccount = billingAccount;	
	}

	public boolean isSatisfiedBy(BillingAccountDTO billingAccount) {
		if(billingAccount.getCredentials() != null){
     return((billingAccount.getAccountNumber() != null) &&
    		 (billingAccount.getCustomerId() != null) &&
    		 (billingAccount.getCompanyUrl() != null) &&
    		 (billingAccount.getCredentials().getUserName() != null) &&
    		 (billingAccount.getCredentials().getPassword() != null));
		}
		return false;
	}

}