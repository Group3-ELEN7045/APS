
/**
 * 
 */
package za.ac.wits.elen7045.group3.aps.domain.repository.user;

import za.ac.wits.elen7045.group3.aps.domain.entities.Customer;
import za.ac.wits.elen7045.group3.aps.services.exception.DatabaseException;

/**
 * @author SilasMahlangu
 *
 */
public interface CustomerRepository {
   boolean updateUser(Customer customer) throws DatabaseException;
   Customer selectCustomer(Customer customer) throws DatabaseException;
  
}