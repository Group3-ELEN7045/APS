package za.ac.wits.elen7045.group3.aps.services.managers;

import org.dozer.DozerBeanMapper;

import za.ac.wits.elen7045.group3.aps.domain.entities.Customer;
import za.ac.wits.elen7045.group3.aps.domain.repository.user.CustomerRepository;
import za.ac.wits.elen7045.group3.aps.domain.vo.CredentialsVO;
import za.ac.wits.elen7045.group3.aps.services.dto.CredentialsDTO;
import za.ac.wits.elen7045.group3.aps.services.dto.CustomerDTO;
import za.ac.wits.elen7045.group3.aps.services.exception.DatabaseException;

public class UserManagerImpl implements UserManager{
	
	public CustomerRepository customerRepository;
	private Customer customerEntity = new Customer();
		
	public UserManagerImpl (CustomerRepository customerRepository){
		this.customerRepository = customerRepository;
	}
	
	@Override
	public boolean updateUser(CustomerDTO customer) throws DatabaseException {
		
		DozerBeanMapper dozer = new DozerBeanMapper();
		customer.encryptUserInformation();
		dozer.map(customer, customerEntity);
		
		customerRepository.updateUser(customerEntity);
		return true;
	}

	@Override
	public CustomerDTO selectCustomer(CustomerDTO customer)	throws DatabaseException {
		DozerBeanMapper dozer = new DozerBeanMapper();
		customer.encryptUserInformation();
		dozer.map(customer, customerEntity);
		Customer customerEntityRespone = customerRepository.selectCustomer(customerEntity);
		CustomerDTO customerDTO = new CustomerDTO();
		dozer.map(customerEntityRespone, customerDTO);
		return customerDTO;
	}

	@Override
	public CustomerDTO getCustomer(CredentialsDTO credentials)throws DatabaseException {
		CredentialsVO credentialsVO = new CredentialsVO();
		DozerBeanMapper dozer = new DozerBeanMapper();
		dozer.map(credentials, credentialsVO);
		Customer authenticationResponse = customerRepository.getCustomer(credentialsVO);
		CustomerDTO customerDTO = new CustomerDTO();
		dozer.map(authenticationResponse, customerDTO);
		return customerDTO;
	}
 
	 
   
}
