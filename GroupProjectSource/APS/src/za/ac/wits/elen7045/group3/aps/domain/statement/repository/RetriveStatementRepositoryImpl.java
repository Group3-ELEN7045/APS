package za.ac.wits.elen7045.group3.aps.domain.statement.repository;

import za.ac.wits.elen7045.group3.aps.domain.RetriveBillingAccountStatementDataAccess;
import za.ac.wits.elen7045.group3.aps.domain.entities.BillingAccountStatement;
import za.ac.wits.elen7045.group3.aps.services.exception.DatabaseException;
/**
 * @author Livious
 *
 */
public class RetriveStatementRepositoryImpl implements RetriveStatementRepository{
	 
	private RetriveBillingAccountStatementDataAccess statementDataAcces;
	  
	  public RetriveStatementRepositoryImpl(RetriveBillingAccountStatementDataAccess statementResource){
		 this.statementDataAcces = statementResource;
	  }
	  
	  @Override
	  public BillingAccountStatement getMunicipalStatement(String accountNumber, String period){
		  try {
			return statementDataAcces.getMunicipalStatement(accountNumber, period);
		} catch (DatabaseException e) {
			throw new RuntimeException("Problem getting Municipal statement");
		}
	}
	  @Override
		public BillingAccountStatement getTelcoStatement(String accountNumber, String period){
			  try {
				return statementDataAcces.getTelcoStatement(accountNumber, period);
			} catch (DatabaseException e) {
				throw new RuntimeException("Problem getting Telco statement");
			}
		}
	  
	  @Override
		public BillingAccountStatement getCreditCardStatement(String accountNumber, String period){
			  try {
				return statementDataAcces.getCreditCardStatement(accountNumber, period);
			} catch (DatabaseException e) {
				throw new RuntimeException("Problem getting Credit Card statement");			}
		}
}
