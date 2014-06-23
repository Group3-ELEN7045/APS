package za.ac.wits.elen7045.group3.aps.services.pattern.user.factory;

import za.ac.wits.elen7045.group3.aps.domain.entities.Customer;
import za.ac.wits.elen7045.group3.aps.services.dto.CustomerDTO;
import za.ac.wits.elen7045.group3.aps.services.pattern.user.builder.UserDTOBuilder;
import za.ac.wits.elen7045.group3.aps.services.pattern.user.builder.UserEntityBuilder;

public abstract class UserMarshallerFactory extends AbstractUserFactory{

	
	public Customer marshallRequest(CustomerDTO customerDTO) {
		UserEntityBuilder builder = UserEntityBuilder.newInstance();
		Customer customerEntity = builder.withId(customerDTO.getId())
				                .witFirstName(customerDTO.getFirstName())
				                .withLastName(customerDTO.getLastname())
				                .withCredentials(customerDTO.getCredentials())
				                .withDateOfBirth(customerDTO.getDateOfBirth())
				                .withEncryptedDateOfBirth(customerDTO.getStringDateOfBirth())
				                .withBillingAccounts(customerDTO.getBillingAccounts())
				                .buildCustomerEntity();
		return customerEntity;
	}


	public CustomerDTO marshallResponse(Customer customer) {
		UserDTOBuilder builder = UserDTOBuilder.newInstance();
		CustomerDTO customerDTO = builder.withId(customer.getId())
				                  .withFirstName(customer.getFirstName())
				                  .withLastName(customer.getLastname())
				                  .withCredentials(customer.getCredentials())
				                  .withDateOfBirth(customer.getDateOfBirth())
				                  .withEncryptedDateOfBirth(customer.getStringDateOfBirth())
				                  .withBillingAccounts(customer.getBillingAccounts())
				                  .buildCustomerDTO();
		return customerDTO;
	}
   
}
