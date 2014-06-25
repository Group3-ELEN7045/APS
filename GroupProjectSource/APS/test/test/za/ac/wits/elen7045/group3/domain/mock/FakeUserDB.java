
/**
 *  
 */
package test.za.ac.wits.elen7045.group3.domain.mock;

import javax.persistence.EntityManager;
import javax.persistence.NonUniqueResultException;
import javax.persistence.Persistence;
import javax.persistence.Query;

import za.ac.wits.elen7045.group3.aps.domain.UserDataAccess;
import za.ac.wits.elen7045.group3.aps.domain.entities.Customer;
import za.ac.wits.elen7045.group3.aps.domain.vo.CredentialsVO;
import za.ac.wits.elen7045.group3.aps.services.exception.DatabaseException;
import za.ac.wits.elen7045.group3.aps.services.util.ApplicationContants;

/**
 * @author SilasMahlangu
 *
 */		
public class FakeUserDB implements UserDataAccess{
    	 
	public Customer updateUser(Customer customer) throws DatabaseException{
	   Customer      responseCustomer = null; 	
	   EntityManager entityManager =null;
	   try{
		   entityManager= Persistence.createEntityManagerFactory("apsBackend").createEntityManager();
	       entityManager.getTransaction().begin();
	       responseCustomer = entityManager.merge(customer);	   
	       entityManager.getTransaction().commit();
	   }catch(Exception e){
		   throw new DatabaseException(e.getMessage());
	   }finally{
		   if(entityManager != null){
		     entityManager.close();
		   }  
	   }   
       return responseCustomer;
	}
	
	public Customer selectCustomer(Customer customer) throws DatabaseException{
		Customer      responseCustomer = null; 	
		EntityManager entityManager =null;
		try{
			entityManager= Persistence.createEntityManagerFactory("apsBackend").createEntityManager();
			responseCustomer = entityManager.find(Customer.class,customer.getId());
		}catch(Exception e){
			throw new DatabaseException(e.getMessage());
		}finally{
			if(entityManager != null){
			     entityManager.close();
			 }  
		}       
		return responseCustomer;
	}
	
	public Customer getCustomerForLogin(CredentialsVO credentilas) throws DatabaseException{
	    Customer      responseCustomer = null; 	
	    EntityManager entityManager =null;
	    Query         query = null;   
		try{	 
		    entityManager = Persistence.createEntityManagerFactory("apsBackend").createEntityManager();
		    query = entityManager.createQuery ("SELECT customer FROM Customer customer WHERE customer.credentials.userName = ?1");
		    query.setParameter (1, credentilas.getUserName());
		    responseCustomer =(Customer) query.getSingleResult();
		    //entityManager.getTransaction().begin();
		    //query = entityManager.createQuery ("DELETE FROM Customer customer where id >= 0");
		    //query.executeUpdate();
		    entityManager.getTransaction().commit();
		}catch(NonUniqueResultException nure){
			nure.printStackTrace();
			throw new DatabaseException(ApplicationContants.DATABASE_DUPLICATE_ENTRY);
		}catch(Exception e){
			System.out.println(ApplicationContants.USER_NOT_FOUND+" "+credentilas.getUserName());
		}finally{
		    if(entityManager != null){
			   entityManager.close();
			 }  
		}   
		 return responseCustomer;
	}
	
}
