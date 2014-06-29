package za.ac.wits.elen7045.group3.aps.domain.repository.statement;

import java.util.List;

import za.ac.wits.elen7045.group3.aps.domain.BillingAccountStatementDataAccess;
import za.ac.wits.elen7045.group3.aps.domain.entities.BillingAccountStatement;
/**
 * @author SilasMahlangu
 *
 */
public class StatementRepositoryImpl implements StatementRepository{

  private BillingAccountStatementDataAccess statementDataAcces;
  
  public StatementRepositoryImpl(BillingAccountStatementDataAccess statementResource){
	 this.statementDataAcces = statementResource;
  }	
   
  @Override
  public List<BillingAccountStatement> getAccountStatement(String accountNumber) {
    return statementDataAcces.getBillingAccountStatements(accountNumber);
  }

@Override
public boolean addStatement(BillingAccountStatement statement) {
	return statementDataAcces.saveBillingAccountStatement(statement);
	
}
  
  
}
