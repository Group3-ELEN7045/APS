package test.za.ac.wits.group3.domain.mock;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import javax.persistence.Query;

import za.ac.wits.elen7045.group3.aps.domain.BillingAccountDataAccess;
import za.ac.wits.elen7045.group3.aps.domain.entities.BillingAccount;
import za.ac.wits.elen7045.group3.aps.domain.entities.BillingCompany;
import za.ac.wits.elen7045.group3.aps.services.exception.DatabaseException;

public class MockBillingDAOImpl implements BillingAccountDataAccess {
	@Override
	public boolean saveBillingAccount(BillingAccount billingAccount){
		 EntityManager entityManager = Persistence.createEntityManagerFactory("apsBackend").createEntityManager();
		 entityManager.getTransaction().begin();
		 entityManager.persist(billingAccount);
		 entityManager.getTransaction().commit();
		 entityManager.close();
	     return true;
	}	
    
	@Override
	public boolean updateBillingAccountStatus(BillingAccount billingAccount)throws DatabaseException {
		 EntityManager entityManager = Persistence.createEntityManagerFactory("apsBackend").createEntityManager();
		 BillingAccount billingAccountUpdate = entityManager.find(BillingAccount.class, billingAccount.getAccountNumber());
		 entityManager.getTransaction().begin();
		 billingAccountUpdate = billingAccount;
		 entityManager.getTransaction().commit();
		 entityManager.close();
		 return true;
	}

	@Override
	public List<BillingAccount> getBillingAccountsByCompanyName(BillingCompany billingCompanyType)throws DatabaseException {
		EntityManager entityManager = Persistence.createEntityManagerFactory("apsBackend").createEntityManager();
		 Query query = entityManager.createQuery ("SELECT account FROM BillingAccount account WHERE account.billingCompanyName = ?1");
		 query.setParameter (1, billingCompanyType.getCompanyName());
		 
		 List<BillingAccount> accountList = (List<BillingAccount>) query.getResultList();
		 return accountList;
	}

	@Override
	public BillingAccount getBillingAccount(String accountNumber) throws DatabaseException {
		EntityManager entityManager = Persistence.createEntityManagerFactory("apsBackend").createEntityManager();
		 Query query = entityManager.createQuery ("SELECT account FROM BillingAccount account WHERE account.accountNumber = ?1");
		 query.setParameter (1, accountNumber);
		 
		 BillingAccount account = (BillingAccount)query.getSingleResult();
		 return account;
	}

	//@Override
	//public List<BillingAccount> getBillingAccountStatementByAccountNumberAndPeriod(BillingAccount accountNumberPeriodSeach) throws DatabaseException {
	//	EntityManager entityManager = Persistence.createEntityManagerFactory("apsBackend").createEntityManager();
	//	 Query query = entityManager.createQuery ("SELECT account FROM BillingAccount account WHERE account.billingCompanyName = ?1 and ");
	//	 query.setParameter (1, billingCompanyType.getCompanyName());
	//	 
	//	 List<BillingAccount> accountList = (List<BillingAccount>) query.getResultList();
	//	 return accountList;
	//}
}
