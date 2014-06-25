/**
 * 
 */
package za.ac.wits.elen7045.group3.aps.domain;

import za.ac.wits.elen7045.group3.aps.domain.entities.Customer;
import za.ac.wits.elen7045.group3.aps.domain.vo.CredentialsVO;
import za.ac.wits.elen7045.group3.aps.services.exception.DatabaseException;


/**
 * @author SilasMahlangu
 *
 */
public interface UserDataAccess {
	public Customer updateUser(Customer customer) throws DatabaseException;
	public Customer selectCustomer(Customer customer) throws DatabaseException;
	public Customer getCustomerForLogin(CredentialsVO credentials) throws DatabaseException;
}
