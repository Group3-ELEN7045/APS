
/**
 * 
 */
package za.ac.wits.elen7045.group3.aps.domain.repository.user;

import za.ac.wits.elen7045.group3.aps.domain.UserDataAccess;
import za.ac.wits.elen7045.group3.aps.domain.entities.Customer;
import za.ac.wits.elen7045.group3.aps.services.exception.DatabaseException;

/**
 * @author SilasMahlangu
 *
 */
public class CustomerRepositoryImpl implements CustomerRepository{
	private UserDataAccess userDatabase;
	public CustomerRepositoryImpl(UserDataAccess userDatabase){
		this.userDatabase = userDatabase;
	}

	@Override
	public boolean updateUser(Customer customer) throws DatabaseException {
		return userDatabase.updateUser(customer);
	}

	@Override
	public Customer selectCustomer(Customer customer) throws DatabaseException {
		return userDatabase.selectCustomer(customer);
	}
}
