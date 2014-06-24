package za.ac.wits.elen7045.group3.aps.services.managers;

import org.dozer.DozerBeanMapper;

import za.ac.wits.elen7045.group3.aps.domain.entities.Customer;
import za.ac.wits.elen7045.group3.aps.domain.repository.user.CustomerRepository;
import za.ac.wits.elen7045.group3.aps.domain.vo.CredentialsVO;
import za.ac.wits.elen7045.group3.aps.services.dto.CredentialsDTO;
import za.ac.wits.elen7045.group3.aps.services.dto.CustomerDTO;
import za.ac.wits.elen7045.group3.aps.services.exception.DatabaseException;
import za.ac.wits.elen7045.group3.aps.services.pattern.user.factory.UserMapper;
import za.ac.wits.elen7045.group3.aps.services.pattern.user.factory.UserMarshallerFactory;

/**
 * @author SilasMahlangu
 *
 */
public class UserManagerImpl implements UserManager{
	
	public CustomerRepository customerRepository;
	private Customer customerEntity = new Customer();
		
	public UserManagerImpl (CustomerRepository customerRepository){
		this.customerRepository = customerRepository;
	}
	
	@Override
	public CustomerDTO updateUser(CustomerDTO customer) throws DatabaseException {
		
		UserMarshallerFactory userEntity = new UserMapper();
		customerEntity = userEntity.marshallRequest(customer);
		Customer customerEntityRespone = customerRepository.updateUser(customerEntity);
		CustomerDTO customerDTO = userEntity.marshallResponse(customerEntityRespone);
		return customerDTO;
	}

	@Override
	public CustomerDTO selectCustomer(CustomerDTO customer)	throws DatabaseException {
		UserMarshallerFactory userEntity = new UserMapper();
		customerEntity = userEntity.marshallRequest(customer);
		Customer customerEntityRespone = customerRepository.selectCustomer(customerEntity);
		CustomerDTO customerDTO = userEntity.marshallResponse(customerEntityRespone);
		return customerDTO;
	}

	@Override
	public CustomerDTO getCustomer(CredentialsDTO credentials)throws DatabaseException {
		CredentialsVO credentialsVO = new CredentialsVO();
		DozerBeanMapper dozer = new DozerBeanMapper();
		dozer.map(credentials, credentialsVO);
		Customer authenticationResponse = customerRepository.getCustomer(credentialsVO);
		UserMarshallerFactory userEntity = new UserMapper();
		CustomerDTO customerDTO = userEntity.marshallResponse(authenticationResponse);
		return customerDTO;
	}
 
	 
   
}
