package za.ac.wits.elen7045.group3.aps.domain.statement.repository;

import java.util.List;

import za.ac.wits.elen7045.group3.aps.domain.SaveBillingAccountStatementDataAccess;
import za.ac.wits.elen7045.group3.aps.domain.entities.BillingAccountStatement;
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
	return statementDataAcces.saveBillingAccountStatement(statement);
	
}  
  
}
