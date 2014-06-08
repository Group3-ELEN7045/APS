/**
 * 
 */
package za.ac.wits.elen7045.group3.aps.services.specification.user;

import org.apache.commons.codec.binary.Base64;

import za.ac.wits.elen7045.group3.aps.domain.entities.Customer;
import za.ac.wits.elen7045.group3.aps.services.specification.ApplicationSpecification;

/**
 * @author SilasMahlangu
 *
 */
public class EncryptedUserInformationSpecification extends ApplicationSpecification<Customer>{
private Customer customer;
	
	public EncryptedUserInformationSpecification(Customer customer){
		this.customer = customer;	
	}

	@SuppressWarnings("deprecation")
	public boolean isFulfiledBy(Object capturedlogonCredentials) {
		return ((Base64.isArrayByteBase64(customer.getStringDateOfBirth().getBytes())
				 &&
				(Base64.isArrayByteBase64(customer.getPaymentDetails().getValue().getBytes()))
			   ));
	}
}
