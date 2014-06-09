<<<<<<< HEAD
/**
 * 
 */
package test.za.ac.wits.group3.domain.mock;

import java.util.HashMap;
import java.util.Map;

import za.ac.wits.elen7045.group3.aps.domain.UserDataAccess;
import za.ac.wits.elen7045.group3.aps.domain.entities.Customer;
import za.ac.wits.elen7045.group3.aps.services.exception.DatabaseException;
import za.ac.wits.elen7045.group3.aps.services.specification.Specification;
import za.ac.wits.elen7045.group3.aps.services.specification.user.UserSpecificationByID;
import za.ac.wits.elen7045.group3.aps.services.util.ApplicationContants;

/**
 * @author SilasMahlangu
 *
 */
public class MockUserDAOImpl implements UserDataAccess{
    private static Map<Long, Customer> userDatabase = new HashMap<Long, Customer>();
 
	public boolean updateUser(Customer customer) throws DatabaseException{
		if(customer.getId() == null){
			int newGeneratedId = userDatabase.size();
			if(newGeneratedId == 0){
			 ++newGeneratedId; //crate newID
			}
			customer.setId((long)newGeneratedId);
		}
		
		if(!userDatabase.containsKey(customer.getId())){
			userDatabase.put(customer.getId(), customer);
			return true;
		}  
		throw new DatabaseException(ApplicationContants.USER_Dupicate); 
	}

	public Customer selectCustomer(Customer customer) throws DatabaseException{
		Customer customerSearch = null;
		Specification speUserSpecification = new UserSpecificationByID(customer);
		customerSearch =  userDatabase.get(customer.getId());
		if(customerSearch != null && speUserSpecification.isFulfiledBy(customerSearch)){
			return customerSearch;		
		}
		throw new DatabaseException(ApplicationContants.USER_NOT_FOUND); 
	}
}
=======
/**
 * 
 */
package test.za.ac.wits.group3.domain.mock;

import java.util.HashMap;
import java.util.Map;

import za.ac.wits.elen7045.group3.aps.domain.UserDataAccess;
import za.ac.wits.elen7045.group3.aps.domain.entities.Customer;
import za.ac.wits.elen7045.group3.aps.services.exception.DatabaseException;
import za.ac.wits.elen7045.group3.aps.services.specification.Specification;
import za.ac.wits.elen7045.group3.aps.services.specification.user.UserSpecificationByID;
import za.ac.wits.elen7045.group3.aps.services.util.ApplicationContants;

/**
 * @author SilasMahlangu
 *
 */
public class MockUserDAOImpl implements UserDataAccess{
    private static Map<Long, Customer> userDatabase = new HashMap<Long, Customer>();
 
	public boolean updateUser(Customer customer) throws DatabaseException{
		if(customer.getId() == null){
			int newGeneratedId = userDatabase.size();
			if(newGeneratedId == 0){
			 ++newGeneratedId; //crate newID
			}
			customer.setId((long)newGeneratedId);
		}
		
		if(!userDatabase.containsKey(customer.getId())){
			userDatabase.put(customer.getId(), customer);
			return true;
		}  
		throw new DatabaseException(ApplicationContants.USER_Dupicate); 
	}

	public Customer selectCustomer(Customer customer) throws DatabaseException{
		Customer customerSearch = null;
		Specification speUserSpecification = new UserSpecificationByID(customer);
		customerSearch =  userDatabase.get(customer.getId());
		if(customerSearch != null && speUserSpecification.isFulfiledBy(customerSearch)){
			return customerSearch;		
		}
		throw new DatabaseException(ApplicationContants.USER_NOT_FOUND); 
	}
}
>>>>>>> f1d7158b44392326220fefc0c7a7c00174b5ec58
