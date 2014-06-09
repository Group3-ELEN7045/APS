
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
import za.ac.wits.elen7045.group3.aps.domain.vo.PaymentDetails;
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
	
	/** The account details. */
	private List<AccountDetailsVO>     accountDetails = new ArrayList<AccountDetailsVO>();
	
	/** The contact details. */
	private List<ContactInformationVO> contactDetails = new ArrayList<ContactInformationVO>();
	
	private PaymentDetails           paymentDetails = new PaymentDetails();
	
	/**
	 * Gets the account details.
	 *
	 * @return the account details
	 */
	
	public List<AccountDetailsVO> getAccountDetails() {
		return accountDetails;
	}

	/**
	 * Sets the account details.
	 *
	 * @param accountDetails the new account details
	 */
	public void setAccountDetails(List<AccountDetailsVO> accountDetails) {
		this.accountDetails = accountDetails;
	}
	
	/**
	 * Gets the contact details.
	 *
	 * @return the contact details
	 */
	public List<ContactInformationVO> getContactDetails() {
		return contactDetails;
	}

	/**
	 * Sets the contact details.
	 *
	 * @param contactDetails the new contact details
	 */
	public void setContactDetails(List<ContactInformationVO> contactDetails) {
		this.contactDetails = contactDetails;
	}

	public PaymentDetails getPaymentDetails() {
		return paymentDetails;
	}

	public void setPaymentDetails(PaymentDetails paymentDetails) {
		this.paymentDetails = paymentDetails;
	}
	
	
	
	public EncryptionModule getEncryptionModule() {
		return encryptionModule;
	}

	public void setEncryptionModule(EncryptionModule encryptionModule) {
		this.encryptionModule = encryptionModule;
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
