package za.ac.wits.elen7045.group3.aps.services.accounts.statement.generator;

import za.ac.wits.elen7045.group3.aps.domain.entities.BillingAccountStatement;

public class StatementRenderer {
	
  public static StatementRenderer newInstnce(){
	  return new StatementRenderer(); 
  }
  
  private StatementRenderer(){};
	
   public StatementRenderer createHTHMLStateMent(BillingAccountStatement statement,String notifyOption){
	   HTMLRenderer renderer = new HTMLRenderer(statement);  
	   renderer.saveStatement(notifyOption);
       return this;
   }
   
   
}
