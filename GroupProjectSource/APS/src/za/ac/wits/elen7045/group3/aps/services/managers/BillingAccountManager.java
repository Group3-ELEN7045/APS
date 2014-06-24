package za.ac.wits.elen7045.group3.aps.services.managers;

import java.util.List;

import za.ac.wits.elen7045.group3.aps.domain.accounts.repository.BillingAccountRepository;
import za.ac.wits.elen7045.group3.aps.domain.entities.BillingAccount;
import za.ac.wits.elen7045.group3.aps.domain.entities.BillingCompany;
import za.ac.wits.elen7045.group3.aps.services.dto.BillingAccountDTO;
import za.ac.wits.elen7045.group3.aps.services.dto.BillingCompanyDTO;
import za.ac.wits.elen7045.group3.aps.services.dto.CustomerDTO;
import za.ac.wits.elen7045.group3.aps.services.exception.DatabaseException;

public interface BillingAccountManager{
	public boolean saveBillingAccount(BillingAccountDTO billingAccount) throws DatabaseException;
	public boolean updateBillingAccountStatus(BillingAccountDTO billingAccount) throws DatabaseException;
	public BillingAccountDTO getBillingAccount(String accountNumber) throws DatabaseException;
	public List<BillingAccountDTO> getBillingAccountsByCompanyName(String billingCompanyUrl) throws DatabaseException;
	List<BillingAccountDTO> getBillingAccountStatementByAccountNumberAndPeriod(
			CustomerDTO customer, String period) throws DatabaseException;
	
}
