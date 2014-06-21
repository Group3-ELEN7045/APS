package za.ac.wits.elen7045.group3.aps.services.specification.credentials;

import za.ac.wits.elen7045.group3.aps.domain.entities.BillingAccount;
import za.ac.wits.elen7045.group3.aps.domain.vo.CredentialsVO;
import za.ac.wits.elen7045.group3.aps.services.specification.ApplicationSpecification;

public class BillingAccountDetailsSpecification extends ApplicationSpecification<BillingAccount>{
	
	private BillingAccount billingAccount;
		
	public BillingAccountDetailsSpecification(BillingAccount billingAccount){
		this.billingAccount = billingAccount;	
	}

	public boolean isSatisfiedBy(BillingAccount billingAccount) {
		if(billingAccount.getCredentials() != null){
     return((billingAccount.getAccountNumber() != null) &&
    		 (billingAccount.getCustomerId() != null) &&
    		 (billingAccount.getBillingCompanyName() != null) &&
    		 (billingAccount.getCredentials().getUserName() != null) &&
    		 (billingAccount.getCredentials().getPassword() != null));
		}
		return false;
	}

}