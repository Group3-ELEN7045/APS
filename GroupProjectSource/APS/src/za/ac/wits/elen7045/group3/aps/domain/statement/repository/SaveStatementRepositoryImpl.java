package za.ac.wits.elen7045.group3.aps.domain.statement.repository;

import za.ac.wits.elen7045.group3.aps.domain.SaveBillingAccountStatementDataAccess;
import za.ac.wits.elen7045.group3.aps.domain.entities.BillingAccountStatement;
import za.ac.wits.elen7045.group3.aps.services.exception.DatabaseException;
/**
 * @author Livious
 *
 */
public class SaveStatementRepositoryImpl implements SaveStatementRepository{

  private SaveBillingAccountStatementDataAccess statementDataAcces;
  
  public SaveStatementRepositoryImpl(SaveBillingAccountStatementDataAccess statementResource){
	 this.statementDataAcces = statementResource;
  }


@Override
public boolean addStatement(BillingAccountStatement statement) {
	try {
		return statementDataAcces.saveBillingAccountStatement(statement);
	} catch (DatabaseException e) {
		throw new RuntimeException("Problem saving statement statement");
	}	
  }  
}
