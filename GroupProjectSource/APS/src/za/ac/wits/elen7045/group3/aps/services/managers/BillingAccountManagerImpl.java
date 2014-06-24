package za.ac.wits.elen7045.group3.aps.services.managers;

import java.util.ArrayList;
import java.util.List;

import org.dozer.DozerBeanMapper;

import za.ac.wits.elen7045.group3.aps.domain.accounts.repository.BillingAccountRepository;
import za.ac.wits.elen7045.group3.aps.domain.entities.BillingAccount;
import za.ac.wits.elen7045.group3.aps.domain.entities.BillingCompany;
import za.ac.wits.elen7045.group3.aps.services.dto.BillingAccountDTO;
import za.ac.wits.elen7045.group3.aps.services.dto.BillingCompanyDTO;
import za.ac.wits.elen7045.group3.aps.services.dto.CustomerDTO;
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
	public boolean saveBillingAccount(BillingAccountDTO billingAccountdto)
			throws DatabaseException {
		if (billingAccountdto == null) {
			throw new RuntimeException("Billing Account cannot be null");
		}
		ApplicationSpecification<BillingAccountDTO> userBillingAccountDetails = new BillingAccountDetailsSpecification(
				billingAccountdto);
		if (userBillingAccountDetails.isSatisfiedBy(billingAccountdto)) { 
			DozerBeanMapper dozer = new DozerBeanMapper();
			entityBillingAccount = new BillingAccount();
			dozer.map(billingAccountdto, entityBillingAccount);

			// If account already exists update method is called
			BillingAccount existingAccount = billingRepository
					.getBillingAccount(entityBillingAccount.getAccountNumber());
			if (existingAccount != null) {
				entityBillingAccount.setId(existingAccount.getId());
				billingRepository
						.updateBillingAccountStatus(entityBillingAccount);
			} else {
				billingRepository.saveBillingAccount(entityBillingAccount);
			}
		}
		return true;
	}

	@Override
	public boolean updateBillingAccountStatus(
			BillingAccountDTO billingAccountdto) throws DatabaseException {
		ApplicationSpecification<BillingAccountDTO> userBillingAccountDetails = new BillingAccountDetailsSpecification(
				billingAccountdto);
		 //checks if all the required fields of the billing account have been set
		if (userBillingAccountDetails.isSatisfiedBy(billingAccountdto)) {
			DozerBeanMapper dozer = new DozerBeanMapper();
			dozer.map(billingAccountdto, entityBillingAccount);
			billingRepository.updateBillingAccountStatus(entityBillingAccount);
		}
		return true;

	}

	@Override
	public BillingAccountDTO getBillingAccount(String accountNumber)
			throws DatabaseException {
		if (accountNumber == null) {
			throw new RuntimeException("Account number cannot be null");
		}

		DozerBeanMapper dozer = new DozerBeanMapper();
		entityBillingAccount = billingRepository.getBillingAccount(accountNumber);
		if (!(entityBillingAccount == null)) {
			billingAccountdto = new BillingAccountDTO(
					entityBillingAccount.getAccountNumber());
			dozer.map(entityBillingAccount, billingAccountdto);
			return billingAccountdto;
		}
		return null;
	}

	@Override
	public List<BillingAccountDTO> getBillingAccountsByCompanyName(String billingCompanyUrl) throws DatabaseException {
		if (billingCompanyUrl == null) {
			throw new RuntimeException("Billing Company url cannot be null");
		}		
		List<BillingAccountDTO> billingAccount = new ArrayList<BillingAccountDTO>();
		DozerBeanMapper dozer = new DozerBeanMapper();		
		List<BillingAccount> accoutList = billingRepository.getBillingAccountsByCompanyName(billingCompanyUrl);
		System.out.println("list size = " + accoutList.size());
		if((accoutList.size() > 0)){
			for (BillingAccount entity : accoutList) {
				dozer.map(entity, billingAccountdto);
				billingAccount.add(billingAccountdto);
			}
		}
		return billingAccount;
	}
	
	@Override
	public List<BillingAccountDTO> getBillingAccountStatementByAccountNumberAndPeriod(CustomerDTO customer, String period) throws DatabaseException {
		if (customer == null) {
			throw new RuntimeException("Billing Company url cannot be null");
		}
		if (period == null) {
			throw new RuntimeException("Billing period cannot be null");
		}
		List<BillingAccountDTO> billingAccount = new ArrayList<BillingAccountDTO>();
		DozerBeanMapper dozer = new DozerBeanMapper();		
		List<BillingAccount> accoutList = billingRepository.getBillingAccountStatementByAccountNumberAndPeriod(customer.getId(), period);
		if((accoutList.size() > 0)){
			for (BillingAccount entity : accoutList) {
				BillingAccountDTO billingAccountdto1 = new BillingAccountDTO(entity.getAccountNumber());
				dozer.map(entity, billingAccountdto1);
				billingAccount.add(billingAccountdto1);
			}
		}
		return billingAccount;
	}
}
