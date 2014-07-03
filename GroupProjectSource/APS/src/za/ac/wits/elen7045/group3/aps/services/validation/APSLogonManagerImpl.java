package za.ac.wits.elen7045.group3.aps.services.validation;


import org.dozer.DozerBeanMapper;

import za.ac.wits.elen7045.group3.aps.domain.entities.User;
import za.ac.wits.elen7045.group3.aps.domain.repository.user.CustomerRepository;
import za.ac.wits.elen7045.group3.aps.domain.vo.CredentialsVO;
import za.ac.wits.elen7045.group3.aps.services.dto.CredentialsDTO;
/**
 * @author Livious
 *
 */
public class APSLogonManagerImpl implements APSLogonManager {
	private CustomerRepository customerRepository;
	private Authentication userAuthenticate;
	private User user;
	
	public APSLogonManagerImpl(CustomerRepository customerRepository ){
		this.customerRepository = customerRepository;
	}
	
	//validation method, validate user
	public Boolean validation(CredentialsDTO credentialsDTO){
		CredentialsVO credentials = new CredentialsVO();
		DozerBeanMapper dozer = new DozerBeanMapper();		
		dozer.map(credentialsDTO, credentials);
		
		user = customerRepository.getCustomerForLogin(credentials);
		
		if(user == null){			
			throw new RuntimeException("Customer not found");
		}
		else
		{
			userAuthenticate = new Authentication();
			try {
				return userAuthenticate.authenticate(user, credentialsDTO);
			} catch (Exception e) {
				throw new RuntimeException("Authenicatin failed");
			}
		}
	}		
}
