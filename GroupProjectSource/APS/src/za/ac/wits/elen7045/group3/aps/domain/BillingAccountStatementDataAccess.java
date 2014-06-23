package za.ac.wits.elen7045.group3.aps.domain;

import za.ac.wits.elen7045.group3.aps.domain.accounts.abtracts.ScrapedData;

public interface BillingAccountStatementDataAccess {
	ScrapedData getCustemerStatement(long billingAccountId, String biilingPeriod);
}

