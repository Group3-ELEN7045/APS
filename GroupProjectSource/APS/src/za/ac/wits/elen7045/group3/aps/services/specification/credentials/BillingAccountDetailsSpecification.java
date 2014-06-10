package za.ac.wits.elen7045.group3.aps.services.specification.credentials;

import za.ac.wits.elen7045.group3.aps.domain.entities.BillingAccount;
import za.ac.wits.elen7045.group3.aps.domain.vo.CredentialsVO;
import za.ac.wits.elen7045.group3.aps.services.specification.ApplicationSpecification;

public class BillingAccountDetailsSpecification extends ApplicationSpecification<BillingAccount>{
	
	private BillingAccount billingAccount;
		
	public BillingAccountDetailsSpecification(BillingAccount billingAccount){
		this.billingAccount = billingAccount;	
	}

	public boolean isSatisfiedBy(BillingAccount billingAccountParam) {
     return((billingAccount.getAccountNumber().equals(billingAccountParam.getAccountNumber())) &&
    		 (billingAccount.getBillingCompanyName().equals(billingAccountParam.getBillingCompanyName())) &&
    		 (billingAccount.getCredentials().getUserName().equals(billingAccountParam.getCredentials().getUserName())) &&
    		 (billingAccount.getCredentials().getPassword().equals(billingAccountParam.getCredentials().getPassword())));
	}

}