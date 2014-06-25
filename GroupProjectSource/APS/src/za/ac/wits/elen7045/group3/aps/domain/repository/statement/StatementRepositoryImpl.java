package za.ac.wits.elen7045.group3.aps.domain.repository.statement;

import java.util.List;

import za.ac.wits.elen7045.group3.aps.domain.BillingAccountStatementDataAccess;
import za.ac.wits.elen7045.group3.aps.domain.entities.BillingAccountStatement;
/**
 * @author SilasMahlangu
 *
 */
public class StatementRepositoryImpl implements StatementRepository{

  private BillingAccountStatementDataAccess statementResource;
  
  public StatementRepositoryImpl(BillingAccountStatementDataAccess statementResource){
	 this.statementResource = statementResource;
  }	
   
  @Override
  public List<BillingAccountStatement> getAccountStatement(String accountNumber) {
    return statementResource.getBillingAccountStatements(accountNumber);
  }

@Override
public boolean addStatement(BillingAccountStatement statement) {
	statementResource.saveBillingAccountStatement(statement);
	return false;
}
  
  
}
