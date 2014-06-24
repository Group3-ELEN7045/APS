package za.ac.wits.elen7045.group3.aps.services.managers;

import za.ac.wits.elen7045.group3.aps.services.dto.CredentialsDTO;
import za.ac.wits.elen7045.group3.aps.services.dto.CustomerDTO;
import za.ac.wits.elen7045.group3.aps.services.exception.DatabaseException;

/**
 * @author SilasMahlangu
 *
 */
public interface UserManager {
	public CustomerDTO updateUser(CustomerDTO customer) throws DatabaseException;
	public CustomerDTO selectCustomer(CustomerDTO customer) throws DatabaseException;
	public CustomerDTO getCustomer(CredentialsDTO credentials) throws DatabaseException; 
}
