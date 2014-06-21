package za.ac.wits.elen7045.group3.aps.vo.specification.scrape;
/**
 * @author bakwanyana
 */
import za.ac.wits.elen7045.group3.aps.domain.entities.BillingAccount;
import za.ac.wits.elen7045.group3.aps.services.specification.ApplicationSpecification;
import za.ac.wits.elen7045.group3.aps.services.enumtypes.AccountStatusType;

public class BillingAccountSuitableForScrapeSpecification extends
		ApplicationSpecification<BillingAccount>{

	@Override
	public boolean isSatisfiedBy(BillingAccount billingAccount) {
	// only billing accounts in trying and active statuses are scraped	
		return billingAccount.getAccountStatus().equals(AccountStatusType.TRYING) ||
				billingAccount.getAccountStatus().equals(AccountStatusType.ACTIVE);
		
	}

}
