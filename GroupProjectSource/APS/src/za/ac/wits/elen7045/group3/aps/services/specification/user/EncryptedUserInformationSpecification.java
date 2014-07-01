/**
 * 
 */
package za.ac.wits.elen7045.group3.aps.services.specification.user;

import za.ac.wits.elen7045.group3.aps.services.dto.CustomerDTO;
import za.ac.wits.elen7045.group3.aps.services.specification.ApplicationSpecification;

/**
 * @author SilasMahlangu
 *
 */
public class EncryptedUserInformationSpecification extends ApplicationSpecification<CustomerDTO>{
private CustomerDTO customer;
	
	public EncryptedUserInformationSpecification(CustomerDTO customer){
		this.customer = customer;	
	}

	@Override
	public boolean isSatisfiedBy(CustomerDTO customerParams) {
		return ((customer.getStringDateOfBirth().equals(customerParams.getStringDateOfBirth()))
				 &&
				(customer.getPaymentDetails().getValue().equals(customerParams.getPaymentDetails().getValue()))
			   );
	}
}
