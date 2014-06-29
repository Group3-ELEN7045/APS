package test.za.ac.wits.elen7045.group3.domain.mock;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import javax.persistence.Query;

import za.ac.wits.elen7045.group3.aps.domain.BillingAccountStatementDataAccess;
import za.ac.wits.elen7045.group3.aps.domain.entities.BillingAccountStatement;
  
public class FakeBillingStatementDB implements BillingAccountStatementDataAccess {
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
	public List<BillingAccountStatement> getBillingAccountStatements(String accountNumber) {
		EntityManager entityManager = Persistence.createEntityManagerFactory("apsBackend").createEntityManager();
		 Query query = entityManager.createQuery ("SELECT mustatement FROM MunicipalStatement mustatement WHERE mustatement.AccountNumber =?1");
		 query.setParameter (1, accountNumber);		 
		 List<BillingAccountStatement> accountList = (List<BillingAccountStatement>)query.getResultList();
		 return accountList;
	}
}
