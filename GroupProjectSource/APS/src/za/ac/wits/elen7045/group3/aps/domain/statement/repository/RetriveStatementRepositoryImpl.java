package za.ac.wits.elen7045.group3.aps.domain.statement.repository;

import za.ac.wits.elen7045.group3.aps.domain.RetriveBillingAccountStatementDataAccess;
import za.ac.wits.elen7045.group3.aps.domain.entities.BillingAccountStatement;

public class RetriveStatementRepositoryImpl implements RetriveStatementRepository{
	 
	private RetriveBillingAccountStatementDataAccess statementDataAcces;
	  
	  public RetriveStatementRepositoryImpl(RetriveBillingAccountStatementDataAccess statementResource){
		 this.statementDataAcces = statementResource;
	  }
	  
	  @Override
	  public BillingAccountStatement getMunicipalStatement(String accountNumber, String period){
		  return statementDataAcces.getMunicipalStatement(accountNumber, period);
	}
	  @Override
		public BillingAccountStatement getTelcoStatement(String accountNumber, String period){
			  return statementDataAcces.getTelcoStatement(accountNumber, period);
		}
	  
	  @Override
		public BillingAccountStatement getCreditCardStatement(String accountNumber, String period){
			  return statementDataAcces.getCreditCardStatement(accountNumber, period);
		}
}
