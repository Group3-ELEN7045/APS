package za.ac.wits.elen7045.group3.aps.services.managers;

import java.util.List;

import za.ac.wits.elen7045.group3.aps.domain.accounts.repository.BillingAccountRepository;
import za.ac.wits.elen7045.group3.aps.domain.entities.BillingAccount;
import za.ac.wits.elen7045.group3.aps.domain.entities.BillingCompany;
import za.ac.wits.elen7045.group3.aps.services.enumtypes.AccountStatusType;
import za.ac.wits.elen7045.group3.aps.services.exception.ApplicationException;
import za.ac.wits.elen7045.group3.aps.services.exception.DatabaseException;
import za.ac.wits.elen7045.group3.aps.services.specification.ApplicationSpecification;
import za.ac.wits.elen7045.group3.aps.services.specification.Specification;
import za.ac.wits.elen7045.group3.aps.services.specification.credentials.BillingAccountDetailsSpecification;
import za.ac.wits.elen7045.group3.aps.services.util.ApplicationContants;

public class BillingAccountManagerImpl implements BillingAccountManager {
	private BillingAccountRepository billingRepository;

	public BillingAccountManagerImpl(BillingAccountRepository billingRepository) {
		this.billingRepository = billingRepository;
	}

	@Override
	public boolean saveBillingAccount(BillingAccount billingAccount)throws DatabaseException {
		if(billingAccount.getCustomerId() == null){
			throw new DatabaseException("User Id cannot be null accoung should have an ID please fix");
			
		}
		billingRepository.saveBillingAccount(billingAccount);
		return true;
	}

	@Override
	public boolean updateBillingAccountStatus(BillingAccount billingAccount) throws DatabaseException {
		if(billingAccount.getCustomerId() == null){
			throw new DatabaseException("User Id cannot be null account should have an ID please fix");
		}
		billingRepository.updateBillingAccountStatus(billingAccount);
		return false;
	}

	@Override
	public BillingAccount getBillingAccount(BillingAccount accountNumberSearch)	throws DatabaseException {
		if(accountNumberSearch.getCustomerId() == null){
			throw new DatabaseException("User Id cannot be null account should have an ID please fix");
		}
		return billingRepository.getBillingAccount(accountNumberSearch);
	}

	@Override
	public List<BillingAccount> getBillingAccountsByCompanyName(BillingCompany billingCompany) throws DatabaseException {
		return billingRepository.getBillingAccountsByCompanyName(billingCompany);
		
	}


	}
