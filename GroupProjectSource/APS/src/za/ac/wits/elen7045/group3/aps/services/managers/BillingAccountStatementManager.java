package za.ac.wits.elen7045.group3.aps.services.managers;

import java.util.List;

import za.ac.wits.elen7045.group3.aps.domain.entities.BillingAccount;

public interface BillingAccountStatementManager {
	public List<BillingAccountStatement> getUserAggrigatedStatement(List<BillingAccount> billingAccountList, String billingPeriod);
}
