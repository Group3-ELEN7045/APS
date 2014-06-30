package za.ac.wits.elen7045.group3.aps.services.managers;

import java.util.List;

import za.ac.wits.elen7045.group3.aps.services.dto.BillingAccountDTO;
import za.ac.wits.elen7045.group3.aps.services.exception.DatabaseException;

public interface RetriveBillingAccountManager {
	public BillingAccountDTO getBillingAccount(String accountNumber) throws DatabaseException;
	public List<BillingAccountDTO> getBillingAccountForCustomer(Long customerId)throws DatabaseException;
	public List<BillingAccountDTO> getBillingAccountsByCompanyUrl(String billingCompanyUrl) throws DatabaseException;
}
