package test.za.ac.wits.elen7045.group3.domain.mock;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.Persistence;
import javax.persistence.Query;

import za.ac.wits.elen7045.group3.aps.domain.AddBillingAccountDataAccess;
import za.ac.wits.elen7045.group3.aps.domain.RetriveBillingAccountDataAccess;
import za.ac.wits.elen7045.group3.aps.domain.entities.BillingAccount;
import za.ac.wits.elen7045.group3.aps.domain.entities.BillingAccountStatement;
import za.ac.wits.elen7045.group3.aps.domain.entities.BillingCompany;
import za.ac.wits.elen7045.group3.aps.domain.entities.Customer;
import za.ac.wits.elen7045.group3.aps.services.exception.DatabaseException;

public class FakeBillingDB implements AddBillingAccountDataAccess, RetriveBillingAccountDataAccess  {
	
	@Override
	public boolean saveBillingAccount(BillingAccount billingAccount){
		 EntityManager entityManager = Persistence.createEntityManagerFactory("apsBackend").createEntityManager();
		 entityManager.getTransaction().begin();
		 entityManager.merge(billingAccount);
		 entityManager.getTransaction().commit();
		 entityManager.close();
	     return true;
	}	
    
	@Override
	public boolean updateBillingAccountStatus(BillingAccount billingAccount)throws DatabaseException {
		 EntityManager entityManager = Persistence.createEntityManagerFactory("apsBackend").createEntityManager();
	//	 BillingAccount billingAccountUpdate = entityManager.find(BillingAccount.class, billingAccount.getId());
		 entityManager.getTransaction().begin();		
		 entityManager.merge(billingAccount);
		 entityManager.getTransaction().commit();
		 entityManager.close();
		 return true;
	}	

	@Override
	public List<BillingAccount> getBillingAccountsByCompanyUrl(String billingCompanyUrl)throws DatabaseException {
		EntityManager entityManager = Persistence.createEntityManagerFactory("apsBackend").createEntityManager();
		 Query query = entityManager.createQuery ("SELECT account FROM BillingAccount account WHERE account.companyUrl = ?1");
		 query.setParameter (1, billingCompanyUrl);
		 
		 List<BillingAccount> accountList = query.getResultList();
		 return accountList;
	}

	@Override
	public BillingAccount getBillingAccount(String accountNumber){
		 BillingAccount account = null;
		EntityManager entityManager = Persistence.createEntityManagerFactory("apsBackend").createEntityManager();
		 Query query = entityManager.createQuery ("SELECT account FROM BillingAccount account WHERE account.accountNumber = ?1");
		 query.setParameter (1, accountNumber);
		 try{
		  account = (BillingAccount)query.getSingleResult();		 
		 } catch(NoResultException e) {
		        return null;
		}
		return account;
	}


	@Override
	public List<BillingAccount> getBillingAccountForCustomer(Long id)throws DatabaseException {
		EntityManager entityManager = Persistence.createEntityManagerFactory("apsBackend").createEntityManager();
		 Query query = entityManager.createQuery ("SELECT account FROM BillingAccount account WHERE account.customerId =?1");
		 query.setParameter (1, id);
		 
		 List<BillingAccount> accountList = query.getResultList();
		 return accountList;
	}
	
	
}
