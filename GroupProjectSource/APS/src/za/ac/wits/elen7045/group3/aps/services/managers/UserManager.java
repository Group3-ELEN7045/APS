package za.ac.wits.elen7045.group3.aps.services.managers;

import za.ac.wits.elen7045.group3.aps.services.dto.CredentialsDTO;
import za.ac.wits.elen7045.group3.aps.services.dto.CustomerDTO;
import za.ac.wits.elen7045.group3.aps.services.exception.ApplicationException;

/**
 * @author SilasMahlangu
 *
 */
public interface UserManager {
	public CustomerDTO updateUser(CustomerDTO customer) throws ApplicationException;
	public CustomerDTO selectCustomer(CustomerDTO customer) throws ApplicationException;
	public CustomerDTO getCustomerForLogin(CredentialsDTO credentials) throws ApplicationException; 
}
