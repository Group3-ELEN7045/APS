<<<<<<< HEAD
package za.ac.wits.elen7045.group3.aps.domain;

import java.util.List;

import za.ac.wits.elen7045.group3.aps.domain.entities.BillingAccountStatement;

public interface BillingAccountStatementDataAccess <T>{
	public boolean saveBillingAccountStatement(T t);
	public T getBillingAccountStatements(String accountNumber, String biilingPeriod);
}

=======
package za.ac.wits.elen7045.group3.aps.domain;

import java.util.List;

import za.ac.wits.elen7045.group3.aps.domain.entities.BillingAccountStatement;

public interface BillingAccountStatementDataAccess{
	public boolean saveBillingAccountStatement(BillingAccountStatement statement);
	public List<BillingAccountStatement> getBillingAccountStatements(String accountNumber);
}

>>>>>>> 9282d895db7e514c4c2c8c60f297a9a73436e8a4
