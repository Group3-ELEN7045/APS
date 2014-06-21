
/**
 * 
 */
package za.ac.wits.elen7045.group3.aps.domain.entities;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import za.ac.wits.elen7045.group3.aps.domain.vo.PaymentDetailsVO;
import za.ac.wits.elen7045.group3.aps.services.dto.ContactInformationDTO;

/**
 * @author SilasMahlangu
 *
 */
@Entity
@Table(name="APS_USER")
public class Customer extends User implements Serializable{
	
	private static final long serialVersionUID = 1L;

	private PaymentDetailsVO           paymentDetails = new PaymentDetailsVO();
	
	private List<BillingAccount> 	billingAccounts;
	
	private ContactInformationDTO contactDetails = new ContactInformationDTO();
	
	@Embedded
	public PaymentDetailsVO getPaymentDetails() {
		return paymentDetails;
	}

	public void setPaymentDetails(PaymentDetailsVO paymentDetails) {
		this.paymentDetails = paymentDetails;
	}
	
	@OneToMany(mappedBy="customer",targetEntity=BillingAccount.class,fetch=FetchType.EAGER)
	public List<BillingAccount> getBillingAccounts() {
		return billingAccounts;
	}

	public void setBillingAccounts(List<BillingAccount> billingAccounts) {
		this.billingAccounts = billingAccounts;
	}
    
	@Embedded
	public ContactInformationDTO getContactDetails() {
		return contactDetails;
	}

	public void setContactDetails(ContactInformationDTO contactDetails) {
		this.contactDetails = contactDetails;
	}
}
