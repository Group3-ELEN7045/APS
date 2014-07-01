package test.za.ac.wits.elen7045.group3.domain.mock;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import javax.persistence.Query;

import za.ac.wits.elen7045.group3.aps.domain.RetriveBillingAccountStatementDataAccess;
import za.ac.wits.elen7045.group3.aps.domain.SaveBillingAccountStatementDataAccess;
import za.ac.wits.elen7045.group3.aps.domain.entities.BillingAccountStatement;
  
public class FakeBillingStatementDB implements SaveBillingAccountStatementDataAccess, RetriveBillingAccountStatementDataAccess  {
	@Override
	public boolean saveBillingAccountStatement(BillingAccountStatement statement) {
		EntityManager entityManager = Persistence.createEntityManagerFactory("apsBackend").createEntityManager();
		 entityManager.getTransaction().begin();
		 entityManager.persist(statement);
		 entityManager.getTransaction().commit();
		 entityManager.close();
	     return true; 
	}

	@Override
	public BillingAccountStatement getMunicipalStatement(String accountNumber, String period) {
		EntityManager entityManager = Persistence.createEntityManagerFactory("apsBackend").createEntityManager();
		 Query query = entityManager.createQuery ("SELECT mustatement FROM MunicipalStatement mustatement WHERE mustatement.AccountNumber =?1 and mustatement.AccountStatementMonth =?2");
		 query.setParameter (1, accountNumber);
		 query.setParameter (2, period);	
		 BillingAccountStatement statement = (BillingAccountStatement)query.getSingleResult();
		 return statement;
	}
	
	@Override
	public BillingAccountStatement getTelcoStatement(String accountNumber, String period) {
		EntityManager entityManager = Persistence.createEntityManagerFactory("apsBackend").createEntityManager();
		 Query query = entityManager.createQuery ("SELECT telcostatement FROM TelcoStatement telcoStatement WHERE telcoStatement.AccountNumber =?1 and telcoStatement.AccountStatementMonth =?2");
		 query.setParameter (1, accountNumber);
		 query.setParameter (2, period);
		 BillingAccountStatement statement = (BillingAccountStatement)query.getSingleResult();
		 return statement;
	}
	
	@Override
	public BillingAccountStatement getCreditCardStatement(String accountNumber, String period) {
		EntityManager entityManager = Persistence.createEntityManagerFactory("apsBackend").createEntityManager();
		 Query query = entityManager.createQuery ("SELECT creditCardStatement FROM CreditCardStatement creditCardStatement WHERE creditCardStatement.AccountNumber =?1 and creditCardStatement.AccountStatementMonth =?2");
		 query.setParameter (1, accountNumber);
		 query.setParameter (2, period);
		 BillingAccountStatement statement = (BillingAccountStatement)query.getSingleResult();
		 return statement;
	}
}
