package za.ac.wits.elen7045.group3.aps.domain;

import java.util.List;

import za.ac.wits.elen7045.group3.aps.domain.entities.BillingAccount;
import za.ac.wits.elen7045.group3.aps.domain.entities.BillingAccountStatement;
import za.ac.wits.elen7045.group3.aps.services.exception.DatabaseException;

public interface BillingAccountDataAccess {
	public boolean saveBillingAccount(BillingAccount billingAccount) throws DatabaseException;
	public boolean updateBillingAccountStatus(BillingAccount billingAccount) throws DatabaseException;
	public BillingAccount getBillingAccount(String accountNumber) throws DatabaseException;
	public List<BillingAccount> getBillingAccountsByCompanyName(String billingCompanyUrl) throws DatabaseException;
	public List<BillingAccount> getBillingAccountStatementByAccountNumberAndPeriod(Long customerId, String period) throws DatabaseException;
	boolean updateBillingAccountStatement(BillingAccountStatement billingAccountStatement)throws DatabaseException;
	
}
