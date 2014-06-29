package za.ac.wits.elen7045.group3.aps.services.validation;


import za.ac.wits.elen7045.group3.aps.domain.entities.User;
import za.ac.wits.elen7045.group3.aps.domain.repository.user.CustomerRepository;
import za.ac.wits.elen7045.group3.aps.domain.vo.CredentialsVO;
import za.ac.wits.elen7045.group3.aps.services.exception.LogonException;
import za.ac.wits.elen7045.group3.aps.services.specification.ApplicationSpecification;
import za.ac.wits.elen7045.group3.aps.services.specification.user.UserAuthenticationSpecification;
import za.ac.wits.elen7045.group3.aps.services.util.ApplicationContants;

public class LogonServiceImpl {
	private CustomerRepository customerRepository;
	private Authentication userAuthenticate;
	private User user;
	
	public LogonServiceImpl(CustomerRepository customerRepository ){
		this.customerRepository = customerRepository;
	}
	
	public Boolean validation(CredentialsVO credentials) throws Exception{
					
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
