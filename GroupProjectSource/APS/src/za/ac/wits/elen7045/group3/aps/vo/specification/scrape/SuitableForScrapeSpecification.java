package za.ac.wits.elen7045.group3.aps.services.specification.scrape;

import za.ac.wits.elen7045.group3.aps.domain.entities.BillingAccount;
import za.ac.wits.elen7045.group3.aps.services.specification.ApplicationSpecification;
import za.ac.wits.elen7045.group3.aps.services.enumtypes.AccountStatusType;

public class SuitableForScrapeSpecification extends
		ApplicationSpecification<BillingAccount>{

	public SuitableForScrapeSpecification(){
		
	}
	@Override
	public boolean isSatisfiedBy(BillingAccount billingAccount) {
		
		return billingAccount.getAccountStatus().equals(AccountStatusType.TRYING) ||
				billingAccount.getAccountStatus().equals(AccountStatusType.ACTIVE);
		
	}

}
