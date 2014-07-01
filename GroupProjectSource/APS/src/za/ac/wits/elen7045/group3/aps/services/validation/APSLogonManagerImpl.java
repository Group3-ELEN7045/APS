package za.ac.wits.elen7045.group3.aps.services.validation;


import za.ac.wits.elen7045.group3.aps.domain.entities.User;
import za.ac.wits.elen7045.group3.aps.domain.repository.user.CustomerRepository;
import za.ac.wits.elen7045.group3.aps.domain.vo.CredentialsVO;
import za.ac.wits.elen7045.group3.aps.services.dto.CredentialsDTO;
import za.ac.wits.elen7045.group3.aps.services.exception.LogonException;
import za.ac.wits.elen7045.group3.aps.services.util.ApplicationContants;

public class APSLogonManagerImpl implements APSLogonManager {
	private CustomerRepository customerRepository;
	private Authentication userAuthenticate;
	private User user;
	
	public APSLogonManagerImpl(CustomerRepository customerRepository ){
		this.customerRepository = customerRepository;
	}
	
	public Boolean validation(CredentialsDTO credentials) throws Exception{
					
		user = customerRepository.getCustomerForLogin(credentials);
		
		if(user == null){			
			throw new LogonException(ApplicationContants.USER_NOT_FOUND);
		}
		else
		{
			userAuthenticate = new Authentication();
			return userAuthenticate.authenticate(user, credentials);
		}
	}		
}
