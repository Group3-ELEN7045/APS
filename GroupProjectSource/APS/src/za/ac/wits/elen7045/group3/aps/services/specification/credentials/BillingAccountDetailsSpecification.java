package za.ac.wits.elen7045.group3.aps.services.specification.credentials;

import za.ac.wits.elen7045.group3.aps.services.dto.BillingAccountDTO;
import za.ac.wits.elen7045.group3.aps.services.enumtypes.AccountStatusType;
import za.ac.wits.elen7045.group3.aps.services.specification.ApplicationSpecification;
/**
 * @author Livious
 *
 */
public class BillingAccountDetailsSpecification extends ApplicationSpecification<BillingAccountDTO>{
	
	private BillingAccountDTO billingAccount;
		
	public BillingAccountDetailsSpecification(BillingAccountDTO billingAccount){
		this.billingAccount = billingAccount;	
	}

	@Override
	public boolean isSatisfiedBy(BillingAccountDTO billingAccount) {
		if(billingAccount.getCredentials() != null){
     return((billingAccount.getAccountNumber() != null) &&
    		 (billingAccount.getCustomerId() != null) &&
    		 (billingAccount.getCompanyUrl() != null) &&
    		 (billingAccount.getAccountStatus().equals(AccountStatusType.TRYING.getStatusType())) &&
    		 (billingAccount.getCredentials().getUserName() != null) &&
    		 (billingAccount.getCredentials().getPassword() != null));
		}
		return false;
	}

}