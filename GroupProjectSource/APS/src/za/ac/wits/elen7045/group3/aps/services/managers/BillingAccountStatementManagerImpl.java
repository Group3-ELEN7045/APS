
package za.ac.wits.elen7045.group3.aps.services.managers;
import za.ac.wits.elen7045.aps.domain.statement.repository.BillingAccountStatementRepository;
import za.ac.wits.elen7045.group3.aps.domain.entities.BillingAccountStatement;

/**
 * @author Livious
 *
 */

public class BillingAccountStatementManagerImpl<T> implements BillingAccountStatementManager {
	private BillingAccountStatementRepository statementRepository; 

	public BillingAccountStatementManagerImpl(BillingAccountStatementRepository dataStatementAccess){
		this.statementRepository = dataStatementAccess;
	}	
	
	
	//Method to save billing Account statement 
	@Override
	public void saveBillingAccountStatement(BillingAccountStatement statement) {
		if (statement == null) {
			throw new RuntimeException("Billing Account statement cannot be null");
		}
		statementRepository.saveBillingAccountStatement(statement);
		}	

	//Method to retrieve a list of billing statement for a billing account
	@Override
	public T getBillingAccountStatements(String accountNumber, String billingPeriod) {	 
		if(accountNumber == null || billingPeriod ==null){
			throw new RuntimeException("Account number and period must be provided");
		}
		return (T) statementRepository.getBillingAccountStatements(accountNumber, billingPeriod);
	}	
}

