/**
 * 
 */
package test.za.ac.wits.group3.domain.mock;

import java.util.HashMap;
import java.util.Map;

import za.ac.wits.elen7045.group3.aps.domain.UserDataAccess;
import za.ac.wits.elen7045.group3.aps.domain.entities.Customer;
import za.ac.wits.elen7045.group3.aps.domain.vo.CredentialsVO;
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
    private static Map<String, Customer> customerDatabase = new HashMap<String, Customer>();
 
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
		}
		if(!customerDatabase.containsKey(customer.getCredentials().getUserName())){
			customerDatabase.put(customer.getCredentials().getUserName(), customer);
			return true;
		}  
		throw new DatabaseException(ApplicationContants.USER_Dupicate); 
	}

	public Customer selectCustomer(Customer customer) throws DatabaseException{
		Customer customerSearch = null;
		Specification speUserSpecification = new UserSpecificationByID(customer);
		customerSearch =  userDatabase.get(customer.getId());
		if(customerSearch != null && speUserSpecification.isSatisfiedBy(customerSearch)){
			return customerSearch;		
		}
		throw new DatabaseException(ApplicationContants.USER_NOT_FOUND); 
	}
	public Customer getCustomer(CredentialsVO credentilas) throws DatabaseException{
		Customer customerSearch = null;
		customerSearch =  customerDatabase.get(credentilas.getUserName());
		if(customerSearch != null){
			return customerSearch;		
		}
		throw new DatabaseException(ApplicationContants.USER_NOT_FOUND); 
	}
	
}
