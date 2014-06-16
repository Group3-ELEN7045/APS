
/**
 * 
 */
package za.ac.wits.elen7045.group3.aps.domain.entities;

import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import za.ac.wits.elen7045.group3.aps.domain.vo.AccountDetailsVO;
import za.ac.wits.elen7045.group3.aps.domain.vo.ContactInformationVO;
import za.ac.wits.elen7045.group3.aps.domain.vo.PaymentDetailsVO;
import za.ac.wits.elen7045.group3.aps.services.security.EncryptionModule;
import za.ac.wits.elen7045.group3.aps.services.util.ApplicationContants;
import za.ac.wits.elen7045.group3.aps.services.util.DateUtil;

/**
 * @author SilasMahlangu
 *
 */
public class Customer extends User implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private EncryptionModule encryptionModule;
	
	private BillingAccount     account = new BillingAccount();
	/** The contact details. */
	private List<ContactInformationVO> contactDetails = new ArrayList<ContactInformationVO>();
	
	private PaymentDetailsVO           paymentDetails = new PaymentDetailsVO();
	
	private List<BillingAccount> 	billingAccounts;
	
	/**
	 * Gets the account details.

	/**
	 * Sets the contact details.
	 *
	 * @param contactDetails the new contact details
	 */
	public void setContactDetails(List<ContactInformationVO> contactDetails) {
		this.contactDetails = contactDetails;
	}

	public PaymentDetailsVO getPaymentDetails() {
		return paymentDetails;
	}

	public void setPaymentDetails(PaymentDetailsVO paymentDetails) {
		this.paymentDetails = paymentDetails;
	}
	
	
	
	public EncryptionModule getEncryptionModule() {
		return encryptionModule;
	}

	public void setEncryptionModule(EncryptionModule encryptionModule) {
		this.encryptionModule = encryptionModule;

	}

	

	
		
	public List<BillingAccount> getBillingAccounts() {
		return billingAccounts;
	}

	public void setBillingAccounts(List<BillingAccount> billingAccounts) {
		this.billingAccounts = billingAccounts;
	}
	
	public Customer encryptUserInformation() {
		String stringDatOfBirth = DateUtil.getDate(getDateOfBirth(), ApplicationContants.DATE_OF_BIRTH_FORMAT);
		
		String newPaymentDetails =  encryptionModule.encrypt(getPaymentDetails().getValue());
		stringDatOfBirth = encryptionModule.encrypt(stringDatOfBirth);
		setStringDateOfBirth(stringDatOfBirth);
		
		setStringDateOfBirth(stringDatOfBirth);
		setDateOfBirth(null);
		getPaymentDetails().setValue(newPaymentDetails);
		
		
		return this;
	}
	
	public Customer decryptUserInformation() throws IOException {
   	  
		String stringDatOfBirth = getStringDateOfBirth();
		String paymentValue     = getPaymentDetails().getValue();
		
		//convert to date
		stringDatOfBirth = encryptionModule.decrypt(stringDatOfBirth);
		java.util.Date dateOfBirth = DateUtil.formatDate(ApplicationContants.DATE_OF_BIRTH_FORMAT, stringDatOfBirth);
		setStringDateOfBirth(null);
		setDateOfBirth(dateOfBirth);
		
		paymentValue = encryptionModule.decrypt(paymentValue);
		getPaymentDetails().setValue(paymentValue);
		
		return this;  
	}
}