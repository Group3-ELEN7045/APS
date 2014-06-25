package test.za.ac.wits.elen7045.group3.domain.mock;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.Persistence;
import javax.persistence.Query;

import za.ac.wits.elen7045.group3.aps.domain.BillingAccountStatementDataAccess;
import za.ac.wits.elen7045.group3.aps.domain.entities.BillingAccount;
import za.ac.wits.elen7045.group3.aps.domain.entities.BillingAccountStatement;

public class FakeBillingStatementDB <T> implements BillingAccountStatementDataAccess {

	@Override
	public boolean saveBillingAccountStatement(Object statement) {
		EntityManager entityManager = Persistence.createEntityManagerFactory("apsBackend").createEntityManager();
		 entityManager.getTransaction().begin();
		 entityManager.merge(statement);
		 entityManager.getTransaction().commit();
		 entityManager.close();
	     return true;
	}

	@Override
	public T getBillingAccountStatements(String accountNumber, String biilingPeriod) {
		EntityManager entityManager = Persistence.createEntityManagerFactory("apsBackend").createEntityManager();
		 Query query = entityManager.createQuery ("SELECT statement FROM TelcoStatement statement WHERE statement.AccountNumber =?1 " +
		 		"and statement.AccountStatementMonth=?2");
		 query.setParameter (1, accountNumber);
		 query.setParameter (2, biilingPeriod);
		 T statement = null;
		 try{
			 statement = (T)query.getSingleResult();		 
			 } catch(NoResultException e) {
			        return null;
			}
			return statement;	
		}
}
