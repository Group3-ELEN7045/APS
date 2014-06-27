
package za.ac.wits.elen7045.group3.aps.domain;

//statement data access 
public interface BillingAccountStatementDataAccess <T>{
	public boolean saveBillingAccountStatement(T t);
	public T getBillingAccountStatements(String accountNumber, String biilingPeriod);
}


