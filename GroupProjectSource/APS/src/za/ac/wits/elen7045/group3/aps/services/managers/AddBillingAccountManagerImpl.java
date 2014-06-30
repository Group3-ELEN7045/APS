package za.ac.wits.elen7045.group3.aps.services.managers;

import org.dozer.DozerBeanMapper;

import za.ac.wits.elen7045.group3.aps.domain.accounts.repository.AddBillingAccountRepository;
import za.ac.wits.elen7045.group3.aps.domain.accounts.repository.RetriveBillingAccountRepository;
import za.ac.wits.elen7045.group3.aps.domain.entities.BillingAccount;
import za.ac.wits.elen7045.group3.aps.services.dto.BillingAccountDTO;
import za.ac.wits.elen7045.group3.aps.services.exception.DatabaseException;
import za.ac.wits.elen7045.group3.aps.services.specification.ApplicationSpecification;
import za.ac.wits.elen7045.group3.aps.services.specification.credentials.BillingAccountDetailsSpecification;

public class AddBillingAccountManagerImpl implements AddBillingAccountManager {
	private AddBillingAccountRepository addBillingRepository;
	private RetriveBillingAccountRepository retriveBillingRepository;
	private BillingAccount entityBillingAccount; 
	private BillingAccountDTO billingAccountdto;

	public AddBillingAccountManagerImpl(AddBillingAccountRepository addBillingRepository, RetriveBillingAccountRepository retriveBillingRepository ) {
		this.addBillingRepository = addBillingRepository;
		this.retriveBillingRepository = retriveBillingRepository;
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
			BillingAccount existingAccount = retriveBillingRepository.getBillingAccount(entityBillingAccount.getAccountNumber());
			if (existingAccount != null) {
				entityBillingAccount.setId(existingAccount.getId());
				addBillingRepository.updateBillingAccountStatus(entityBillingAccount);
			} else {
				addBillingRepository.saveBillingAccount(entityBillingAccount);
			}
		}
		return true;
	}

	@Override
	public boolean updateBillingAccountStatus(
			BillingAccountDTO billingAccountdto) throws DatabaseException {
		ApplicationSpecification<BillingAccountDTO> userBillingAccountDetails = new BillingAccountDetailsSpecification(
				billingAccountdto);
		// checks if all the required fields of the billing account have been set
		if (userBillingAccountDetails.isSatisfiedBy(billingAccountdto)) {
			DozerBeanMapper dozer = new DozerBeanMapper();			
			dozer.map(billingAccountdto, entityBillingAccount);			
			addBillingRepository.updateBillingAccountStatus(entityBillingAccount);
		}
		return true;

	}	
}
