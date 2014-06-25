package za.ac.wits.elen7045.group3.aps.domain.accounts.statement.gnerator;

import za.ac.wits.elen7045.group3.aps.domain.accounts.abtracts.AbstractBillingAccountStatement;

public class StatementRenderer {
	
  public static StatementRenderer newInstnce(){
	  return new StatementRenderer(); 
  }
  
  private StatementRenderer(){};
	
   public StatementRenderer createHTHMLStateMent(AbstractBillingAccountStatement statement,String notifyOption){
	   HTMLRenderer renderer = new HTMLRenderer(statement);  
	   renderer.saveStatement(notifyOption);
       return this;
   }
   
   
}
