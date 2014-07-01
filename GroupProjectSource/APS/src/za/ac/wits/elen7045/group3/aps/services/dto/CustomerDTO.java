package za.ac.wits.elen7045.group3.aps.services.dto;

import java.io.IOException;
import java.io.Serializable;
import java.util.List;

import za.ac.wits.elen7045.group3.aps.services.security.EncryptionModule;
import za.ac.wits.elen7045.group3.aps.services.util.ApplicationContants;
import za.ac.wits.elen7045.group3.aps.services.util.DateUtil;

public class CustomerDTO extends UserDTO implements Serializable{
	/**
	 * @author SilasMahlangu
	 *
	 */
	private static final long serialVersionUID = 1L;

	private EncryptionModule encryptionModule;
	
	private BillingAccountDTO     account;
	
	private ContactInformationDTO contactDetails = new ContactInformationDTO();
	
	private PaymentDetailsDTO         paymentDetails = new PaymentDetailsDTO();
	
	private List<BillingAccountDTO> 	billingAccounts;
	
	/**
	 * Gets the account details.

	/**
	 * Sets the contact details.
	 *
	 * @param contactDetails the new contact details
	 */
	public void setContactDetails(ContactInformationDTO contactDetails) {
		this.contactDetails = contactDetails;
	}

	public PaymentDetailsDTO getPaymentDetails() {
		return paymentDetails;
	}

	public void setPaymentDetails(PaymentDetailsDTO paymentDetails) {
		this.paymentDetails = paymentDetails;
	}
	
	
	
	public EncryptionModule getEncryptionModule() {
		return encryptionModule;
	}

	public void setEncryptionModule(EncryptionModule encryptionModule) {
		this.encryptionModule = encryptionModule;

	}
		
	public List<BillingAccountDTO> getBillingAccounts() {
		return billingAccounts;
	}

	public void setBillingAccounts(List<BillingAccountDTO> billingAccounts) {
		this.billingAccounts = billingAccounts;
	}
	
	
	
	public ContactInformationDTO getContactDetails() {
		return contactDetails;
	}

	public CustomerDTO encryptUserInformation() {
		String stringDatOfBirth = DateUtil.getDate(this.getDateOfBirth(), ApplicationContants.DATE_OF_BIRTH_FORMAT);
		
		String newPaymentDetails =  encryptionModule.encrypt(getPaymentDetails().getValue());
		stringDatOfBirth = encryptionModule.encrypt(stringDatOfBirth);
		setStringDateOfBirth(stringDatOfBirth);
		
		setStringDateOfBirth(stringDatOfBirth);
		setDateOfBirth(null);
		getPaymentDetails().setValue(newPaymentDetails);
		
		return this;
	}
	
	public CustomerDTO decryptUserInformation() throws IOException {
   	  
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
