package za.ac.wits.elen7045.group3.aps.domain;

import java.util.List;

import za.ac.wits.elen7045.group3.aps.domain.entities.BillingAccountStatement;

public interface BillingAccountStatementDataAccess <T>{
	public boolean saveBillingAccountStatement(T t);
	public List<BillingAccountStatement> getBillingAccountStatements(String accountNumber, String biilingPeriod);
}

