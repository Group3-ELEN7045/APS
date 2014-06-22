package za.ac.wits.elen7045.group3.aps.services.managers;

import java.util.List;

import org.dozer.DozerBeanMapper;

import za.ac.wits.elen7045.group3.aps.domain.accounts.repository.BillingAccountRepository;
import za.ac.wits.elen7045.group3.aps.domain.entities.BillingAccount;
import za.ac.wits.elen7045.group3.aps.domain.entities.BillingCompany;
import za.ac.wits.elen7045.group3.aps.services.dto.BillingAccountDTO;
import za.ac.wits.elen7045.group3.aps.services.enumtypes.AccountStatusType;
import za.ac.wits.elen7045.group3.aps.services.exception.ApplicationException;
import za.ac.wits.elen7045.group3.aps.services.exception.DatabaseException;
import za.ac.wits.elen7045.group3.aps.services.specification.ApplicationSpecification;
import za.ac.wits.elen7045.group3.aps.services.specification.Specification;
import za.ac.wits.elen7045.group3.aps.services.specification.credentials.BillingAccountDetailsSpecification;
import za.ac.wits.elen7045.group3.aps.services.util.ApplicationContants;

public class BillingAccountManagerImpl implements BillingAccountManager {
	private BillingAccountRepository billingRepository;
	private BillingAccount entityBillingAccount = new BillingAccount();
	private BillingAccountDTO billingAccountdto;

	public BillingAccountManagerImpl(BillingAccountRepository billingRepository) {
		this.billingRepository = billingRepository;
	}

	@Override
	public boolean saveBillingAccount(BillingAccountDTO billingAccountdto)throws DatabaseException {
		if (billingAccountdto == null) {
			// throw new LogonException(ApplicationContants.USER_NOT_FOUND);
		}	
		ApplicationSpecification<BillingAccountDTO> userBillingAccountDetails = new BillingAccountDetailsSpecification(
				billingAccountdto);
		if (userBillingAccountDetails.isSatisfiedBy(billingAccountdto)) {  //checks is all fields on the billing account have been set
			billingAccountdto.setAccountStatus(AccountStatusType.ACTIVE.getStatusType());		//set the billing account status to trying
			
			DozerBeanMapper dozer = new DozerBeanMapper();
			entityBillingAccount = new BillingAccount();
			dozer.map(billingAccountdto, entityBillingAccount);
			
			billingRepository.saveBillingAccount(entityBillingAccount);
		}			
		return true;
	}

	@Override
	public boolean updateBillingAccountStatus(BillingAccountDTO billingAccountdto) throws DatabaseException {
		   ApplicationSpecification<BillingAccountDTO> userBillingAccountDetails = new BillingAccountDetailsSpecification(
					billingAccountdto);
			if (userBillingAccountDetails.isSatisfiedBy(billingAccountdto)) {  //checks is all fields on the billing account have been set
				billingAccountdto.setAccountStatus(AccountStatusType.ACTIVE.getStatusType());		//set the billing account status to trying
				
				DozerBeanMapper dozer = new DozerBeanMapper();
				dozer.map(billingAccountdto, entityBillingAccount);
				billingRepository.updateBillingAccountStatus(entityBillingAccount);
			}			
		return true;
		
	}

	@Override
	public BillingAccount getBillingAccount(String accountNumber)throws DatabaseException {
		if(accountNumber == null){
			throw new DatabaseException("Account Number cannot be null account should have an ID please fix");
		}
		
		DozerBeanMapper dozer = new DozerBeanMapper();
		entityBillingAccount = billingRepository.getBillingAccount(accountNumber);
		if(entityBillingAccount == null){
			billingAccountdto = new BillingAccountDTO(entityBillingAccount.getAccountNumber());
			dozer.map(billingAccountdto, entityBillingAccount);
		}
							
		return billingRepository.getBillingAccount(accountNumber);
	}

	@Override
	public List<BillingAccount> getBillingAccountsByCompanyName(BillingCompany billingCompany) throws DatabaseException {
		return billingRepository.getBillingAccountsByCompanyName(billingCompany);
		
	}


	}
