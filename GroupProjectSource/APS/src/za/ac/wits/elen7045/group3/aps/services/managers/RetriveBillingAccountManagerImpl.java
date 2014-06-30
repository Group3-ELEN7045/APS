package za.ac.wits.elen7045.group3.aps.services.managers;

import java.util.ArrayList;
import java.util.List;

import org.dozer.DozerBeanMapper;

import za.ac.wits.elen7045.group3.aps.domain.entities.BillingAccount;
import za.ac.wits.elen7045.group3.aps.domain.repository.accounts.AddBillingAccountRepository;
import za.ac.wits.elen7045.group3.aps.domain.repository.accounts.RetriveBillingAccountRepository;
import za.ac.wits.elen7045.group3.aps.services.dto.BillingAccountDTO;
import za.ac.wits.elen7045.group3.aps.services.dto.CredentialsDTO;
import za.ac.wits.elen7045.group3.aps.services.dto.CustomerDTO;
import za.ac.wits.elen7045.group3.aps.services.exception.DatabaseException;

public class RetriveBillingAccountManagerImpl implements RetriveBillingAccountManager {
	private RetriveBillingAccountRepository billingRepository;
	private BillingAccount entityBillingAccount; // = new BillingAccount();
	private BillingAccountDTO billingAccountdto;
	

	public RetriveBillingAccountManagerImpl(RetriveBillingAccountRepository billingRepository) {
		this.billingRepository = billingRepository;
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
	public List<BillingAccountDTO> getBillingAccountsByCompanyUrl(String billingCompanyUrl) throws DatabaseException {
		if (billingCompanyUrl == null) {
			throw new RuntimeException("Billing Company url cannot be null");
		}		
		List<BillingAccountDTO> billingAccount = new ArrayList<BillingAccountDTO>();
		DozerBeanMapper dozer = new DozerBeanMapper();		
		List<BillingAccount> accoutList = billingRepository.getBillingAccountsByCompanyUrl(billingCompanyUrl);
		if((accoutList.size() > 0)){
			for (BillingAccount entity : accoutList) {
				dozer.map(entity, billingAccountdto);
				billingAccount.add(billingAccountdto);
			}
		}
		return billingAccount;
	}

	@Override
	public List<BillingAccountDTO> getBillingAccountForCustomer(Long customerId) throws DatabaseException {
		if (customerId == null) {
			throw new RuntimeException("Billing Account Id cannot be null");
		}
		List<BillingAccountDTO> billingAccountList = new ArrayList<BillingAccountDTO>();
		DozerBeanMapper dozer = new DozerBeanMapper();		
		List<BillingAccount> accoutList = (List<BillingAccount>) billingRepository.getBillingAcountsForCustomer(customerId);
		if((accoutList.size() > 0)){
			for (BillingAccount entity : accoutList) {
				if (!(entity == null)) {
					billingAccountdto = new BillingAccountDTO(entity.getAccountNumber());									
					dozer.map(entity, billingAccountdto);
					billingAccountList.add(billingAccountdto);
				}
			}
		}
		return billingAccountList;		
	}	
}