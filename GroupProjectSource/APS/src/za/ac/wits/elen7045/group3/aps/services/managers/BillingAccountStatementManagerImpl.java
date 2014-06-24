package za.ac.wits.elen7045.group3.aps.services.managers;

import java.util.List;

import org.dozer.DozerBeanMapper;

import test.za.ac.wits.elen7045.group3.domain.mock.FakeBillingStatementDB;

import za.ac.wits.elen7045.aps.domain.statement.repository.BillingAccountStatementRepository;
import za.ac.wits.elen7045.aps.domain.statement.repository.BillingAccountStatementRepositoryImpl;
import za.ac.wits.elen7045.group3.aps.domain.BillingAccountDataAccess;
import za.ac.wits.elen7045.group3.aps.domain.BillingAccountStatementDataAccess;
import za.ac.wits.elen7045.group3.aps.domain.entities.BillingAccount;
import za.ac.wits.elen7045.group3.aps.domain.entities.BillingAccountStatement;
import za.ac.wits.elen7045.group3.aps.domain.entities.BillingCompany;
import za.ac.wits.elen7045.group3.aps.services.dto.BillingAccountDTO;
import za.ac.wits.elen7045.group3.aps.services.exception.DatabaseException;
import za.ac.wits.elen7045.group3.aps.services.specification.ApplicationSpecification;
import za.ac.wits.elen7045.group3.aps.services.specification.credentials.BillingAccountDetailsSpecification;

/**
 * @author Livious
 *
 */

public class BillingAccountStatementManagerImpl implements BillingAccountStatementManager {
	private BillingAccountStatementRepository statementRepository =
		new BillingAccountStatementRepositoryImpl(new FakeBillingStatementDB());

//	public BillingAccountStatementManagerImpl(BillingAccountStatementRepository dataStatementAccess){
//		this.statementRepository = dataStatementAccess;
//	}	
	@Override
	public void saveBillingAccountStatement(BillingAccountStatement statement) {
		if (statement == null) {
			throw new RuntimeException("Billing Account statement cannot be null");
		}
		statementRepository.saveBillingAccountStatement(statement);
		}	

	@Override
	public List<BillingAccountStatement> getBillingAccountStatements(
			String accountNumber, String billingPeriod) {	 
		if(accountNumber == null || billingPeriod ==null){
			throw new RuntimeException("Account number and period must be provided");
		}
		return statementRepository.getBillingAccountStatements(accountNumber, billingPeriod);
	}	
}
