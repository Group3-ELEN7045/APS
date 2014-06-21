/**
 * 
 */
package za.ac.wits.elen7045.group3.aps.services.specification.user;

import org.apache.commons.codec.binary.Base64;

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

	@SuppressWarnings("deprecation")
	public boolean isSatisfiedBy(CustomerDTO customerParams) {
		return ((Base64.isArrayByteBase64(customerParams.getStringDateOfBirth().getBytes())
				 &&
				(Base64.isArrayByteBase64(customerParams.getPaymentDetails().getValue().getBytes()))
			   ));
	}
}
