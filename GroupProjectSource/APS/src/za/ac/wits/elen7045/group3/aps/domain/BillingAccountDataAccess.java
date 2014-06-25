package za.ac.wits.elen7045.group3.aps.domain;

import java.util.List;

import za.ac.wits.elen7045.group3.aps.domain.entities.BillingAccount;
import za.ac.wits.elen7045.group3.aps.domain.entities.BillingAccountStatement;
import za.ac.wits.elen7045.group3.aps.services.dto.BillingAccountDTO;
import za.ac.wits.elen7045.group3.aps.services.exception.DatabaseException;

public interface BillingAccountDataAccess {
	public boolean saveBillingAccount(BillingAccount billingAccount) throws DatabaseException;
	public boolean updateBillingAccountStatus(BillingAccount billingAccount) throws DatabaseException;
	public BillingAccount getBillingAccount(String accountNumber) throws DatabaseException;
	public List<BillingAccount> getBillingAccountsByCompanyUrl(String billingCompanyUrl) throws DatabaseException;
	public List<BillingAccount> getBillingAcountsForCustomer(Long customerId)throws DatabaseException;
}
