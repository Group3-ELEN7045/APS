package za.ac.wits.elen7045.group3.aps.services.pattern.user.factory;

import za.ac.wits.elen7045.group3.aps.domain.entities.Customer;
import za.ac.wits.elen7045.group3.aps.services.dto.CustomerDTO;

public class UserMapper extends UserMarshallerFactory{

	@Override
	public Object marshallRequest(Object tParam) {
		CustomerDTO customerDTO = (CustomerDTO) tParam;
		return super.marshallRequest(customerDTO);
	}

	@Override
	public Object marshallResponse(Object tParam) {
		Customer customer = (Customer) tParam; 
		return super.marshallResponse(customer);
	}
  
}
