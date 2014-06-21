package za.ac.wits.elen7045.group3.aps.domain;

import za.ac.wits.elen7045.group3.aps.domain.accounts.abtracts.AbstractBillingAccountStatement;

public interface BillingAccountStatementDataAccess {
	AbstractBillingAccountStatement getCustemerStatement(long billingAccountId, String biilingPeriod);
}

