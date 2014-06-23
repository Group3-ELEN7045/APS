
/**
 * 
 */
package za.ac.wits.elen7045.group3.aps.domain.repository.user;


import za.ac.wits.elen7045.group3.aps.domain.entities.Customer;
import za.ac.wits.elen7045.group3.aps.domain.vo.CredentialsVO;
import za.ac.wits.elen7045.group3.aps.services.exception.DatabaseException;

/**
 * @author SilasMahlangu
 * 
 */
public interface CustomerRepository {
   public Customer updateUser(Customer customer) throws DatabaseException;
   public Customer selectCustomer(Customer customer) throws DatabaseException;
   public Customer getCustomer(CredentialsVO credentials) throws DatabaseException;
   
}

