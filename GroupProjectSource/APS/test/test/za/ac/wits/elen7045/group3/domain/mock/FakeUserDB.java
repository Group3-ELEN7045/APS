
/**
 *  
 */
package test.za.ac.wits.elen7045.group3.domain.mock;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import javax.persistence.Query;

import za.ac.wits.elen7045.group3.aps.domain.UserDataAccess;
import za.ac.wits.elen7045.group3.aps.domain.entities.Customer;
import za.ac.wits.elen7045.group3.aps.domain.vo.CredentialsVO;
import za.ac.wits.elen7045.group3.aps.services.exception.DatabaseException;

/**
 * @author SilasMahlangu
 *
 */		
public class FakeUserDB implements UserDataAccess{
    	 
	public Customer updateUser(Customer customer) throws DatabaseException{
	   //DI Inject This
	   EntityManager entityManager = Persistence.createEntityManagerFactory("apsBackend").createEntityManager();
	   entityManager.getTransaction().begin();
	   entityManager.merge(customer);	   
	   entityManager.getTransaction().commit();
	   entityManager.close();
       return customer;
	}
	
	public Customer selectCustomer(Customer customer) throws DatabaseException{
		//DI Inject This
		 EntityManager entityManager = Persistence.createEntityManagerFactory("apsBackend").createEntityManager();
		 Customer customerResponse = entityManager.find(Customer.class,customer.getId());
		 entityManager.close();
		 return customerResponse;
	}
	
	public Customer getCustomer(CredentialsVO credentilas) throws DatabaseException{
		//DI Inject This
		 EntityManager entityManager = Persistence.createEntityManagerFactory("apsBackend").createEntityManager();
		 Query query = entityManager.createQuery ("SELECT distinct customer FROM Customer customer WHERE customer.credentials.userName = ?1");
		 query.setParameter (1, credentilas.getUserName());
		 Customer custResult =(Customer) query.getSingleResult();
		 entityManager.close();
		 return custResult;
	}
	
}
