package za.ac.wits.elen7045.group3.aps.services.validation;


import java.io.IOException;


import za.ac.wits.elen7045.group3.aps.domain.entities.User;
import za.ac.wits.elen7045.group3.aps.domain.repository.user.CustomerRepository;
import za.ac.wits.elen7045.group3.aps.domain.vo.CredentialsVO;
import za.ac.wits.elen7045.group3.aps.services.exception.LogonException;
import za.ac.wits.elen7045.group3.aps.services.specification.ApplicationSpecification;
import za.ac.wits.elen7045.group3.aps.services.specification.credentials.UserAuthenticationSpecification;
import za.ac.wits.elen7045.group3.aps.services.util.ApplicationContants;

public class LogonUserValidation {
	private CustomerRepository customerRepository;
	private User user;
	
	public LogonUserValidation(CustomerRepository customerRepository ){
		this.customerRepository = customerRepository;
	}
	
	public Boolean validation(CredentialsVO credentials) throws Exception{
					
		user = customerRepository.getCustomer(credentials);
		
		if(user == null){			
			throw new LogonException(ApplicationContants.USER_NOT_FOUND);
		}
		else
		{
			return authenitacte(user, credentials);
		}
	}
	
	private Boolean authenitacte(User user, CredentialsVO credentials) throws LogonException, Exception {
		
		CredentialsVO encryptedCredentials = user.getCredentials();	
		
		ApplicationSpecification<CredentialsVO> userAuthenticationSpec = new UserAuthenticationSpecification(credentials);
		if(userAuthenticationSpec.isSatisfiedBy(encryptedCredentials)){
			return true;
		}
		throw new LogonException(ApplicationContants.USER_CREDENTIALS_INCORRECT);
	}
		
}
