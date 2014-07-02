package za.ac.wits.elen7045.group3.aps.services.managers;

import org.dozer.DozerBeanMapper;

import za.ac.wits.elen7045.group3.aps.domain.entities.Customer;
import za.ac.wits.elen7045.group3.aps.domain.repository.user.CustomerRepository;
import za.ac.wits.elen7045.group3.aps.domain.vo.CredentialsVO;
import za.ac.wits.elen7045.group3.aps.services.dto.CredentialsDTO;
import za.ac.wits.elen7045.group3.aps.services.dto.CustomerDTO;
import za.ac.wits.elen7045.group3.aps.services.exception.ApplicationException;
import za.ac.wits.elen7045.group3.aps.services.exception.DatabaseException;
import za.ac.wits.elen7045.group3.aps.services.pattern.user.factory.UserMapper;
import za.ac.wits.elen7045.group3.aps.services.pattern.user.factory.UserMarshallerFactory;
import za.ac.wits.elen7045.group3.aps.services.specification.ApplicationSpecification;
import za.ac.wits.elen7045.group3.aps.services.specification.user.UserSpecificationByID;


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
	public CustomerDTO updateUser(CustomerDTO customer) throws ApplicationException {
		
		UserMarshallerFactory userEntity = new UserMapper();
		customerEntity = userEntity.marshallRequest(customer);
		Customer customerEntityRespone;
		CustomerDTO customerDTO = null;
		
		try {
			customerEntityRespone = customerRepository.updateUser(customerEntity);
		} catch (DatabaseException e) {
			throw new ApplicationException(e.getMessage());
		}
		
		if(customerEntityRespone != null){
		    customerDTO = userEntity.marshallResponse(customerEntityRespone);
		}    
		return customerDTO;
	}

	@Override
	public CustomerDTO selectCustomer(CustomerDTO customer)	throws ApplicationException {
		
		UserMarshallerFactory userEntity = new UserMapper();
		customerEntity = userEntity.marshallRequest(customer);
		Customer customerEntityRespone;
		CustomerDTO customerDTO = null; 
		
		try {
			customerEntityRespone = customerRepository.selectCustomer(customerEntity);
		} catch (DatabaseException e) {
			throw new ApplicationException(e.getMessage());
		}
				
		if(customerEntityRespone != null){
			customerDTO = userEntity.marshallResponse(customerEntityRespone);
		}
		return customerDTO;
	}

	@Override
	public CustomerDTO getCustomerForLogin(CredentialsDTO credentials)throws ApplicationException {
		CredentialsVO credentialsVO = new CredentialsVO();
		Customer    customerEntityRespone;
		CustomerDTO customerDTO = null;
		
		DozerBeanMapper dozer = new DozerBeanMapper();
		dozer.map(credentials, credentialsVO);				
		customerEntityRespone = customerRepository.getCustomerForLogin(credentialsVO);
				
		if(customerEntityRespone != null){		
		   UserMarshallerFactory userEntity = new UserMapper();
		   customerDTO = userEntity.marshallResponse(customerEntityRespone);
		}
		return customerDTO;
	}
}
