/**
 * 
 */
package za.ac.wits.elen7045.group3.aps.services.specification.user;

import za.ac.wits.elen7045.group3.aps.domain.entities.Customer;
import za.ac.wits.elen7045.group3.aps.services.specification.ApplicationSpecification;

/**
 * @author SilasMahlangu
 *
 */
public class UserSpecificationByID extends ApplicationSpecification<Customer>{

	private Customer customer;
	
	public UserSpecificationByID(Customer customer){
		this.customer = customer;
	}
	
	@Override
	public boolean isFulfiledBy(Object object) {
		return (customer.getId() != null);
	}
}
