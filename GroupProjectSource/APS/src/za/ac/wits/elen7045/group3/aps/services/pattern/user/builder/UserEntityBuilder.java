package za.ac.wits.elen7045.group3.aps.services.pattern.user.builder;

import java.util.ArrayList;
import java.util.Date;
import java.util.List; 

import za.ac.wits.elen7045.group3.aps.domain.entities.BillingAccount;
import za.ac.wits.elen7045.group3.aps.domain.entities.Customer;
import za.ac.wits.elen7045.group3.aps.domain.vo.ContactInformationVO;
import za.ac.wits.elen7045.group3.aps.domain.vo.CredentialsVO;
import za.ac.wits.elen7045.group3.aps.domain.vo.PaymentDetailsVO;
import za.ac.wits.elen7045.group3.aps.services.dto.BillingAccountDTO;
import za.ac.wits.elen7045.group3.aps.services.dto.ContactInformationDTO;
import za.ac.wits.elen7045.group3.aps.services.dto.CredentialsDTO;

/**
 * @author SilasMahlangu
 *
 */

public class UserEntityBuilder {
  
	private Customer customerEntity = new Customer();
	
	/** The id. */
	private Long                 id;
	private String               firstName;
	private String               lastName;
	private Date                 dateOfBirth;
	private CredentialsVO        credentials;
	private String               stringDateOfBirth;
    private PaymentDetailsVO     paymentDetails = new PaymentDetailsVO();
	private List<BillingAccount> billingAccounts;
	private ContactInformationVO contactDetails = new ContactInformationVO();
	
	public static UserEntityBuilder newInstance() {
	    return new UserEntityBuilder();
	}

	
	public UserEntityBuilder withId(Long id) {
		this.id = id;
		return this;
	}

	public UserEntityBuilder witFirstName(String firstName) {
		this.firstName = firstName;
		return this;
	}

	public UserEntityBuilder withLastName(String lastName) {
		this.lastName = lastName;
		return this;
	}

	public UserEntityBuilder withDateOfBirth(Date dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
		return this;
	}

	public UserEntityBuilder withCredentials(CredentialsDTO credentialsDTO) {
		CredentialsVO credentialsVO = new CredentialsVO();
		credentialsVO.setPassword(credentialsDTO.getPassword());
		credentialsVO.setUserName(credentialsDTO.getUserName());
		this.credentials = credentialsVO;
		return this;
	}

	public UserEntityBuilder withEncryptedDateOfBirth(String stringDateOfBirth) {
		this.stringDateOfBirth = stringDateOfBirth;
		return this;
	}

	public UserEntityBuilder withBillingAccounts(List<BillingAccountDTO> billingAccountsDTO) {
		List<BillingAccount> billingAccounts = new ArrayList<BillingAccount>();
		BillingAccount billingAccount = null;
		if(billingAccountsDTO != null){
		    for(BillingAccountDTO accountDTO : billingAccountsDTO){
			    billingAccount = new BillingAccount();
			    billingAccount.setAccountNumber(accountDTO.getAccountNumber());
			    billingAccount.setAccountStatus(accountDTO.getAccountStatus());
			    billingAccount.setCompanyUrl(accountDTO.getCompanyUrl());
			
			    CredentialsDTO credentialsDTO = accountDTO.getCredentials();
			    CredentialsVO credentialsVO = new CredentialsVO();
			    credentialsVO.setPassword(credentialsDTO.getPassword());
			    credentialsVO.setPassword(credentialsDTO.getUserName());
			    billingAccount.setCredentials(credentials);
			    billingAccount.setCustomerId(billingAccount.getCustomerId());
			    billingAccounts.add(billingAccount);
		   }
		
		   this.billingAccounts = billingAccounts;
		}
		return this;
	}

	public UserEntityBuilder setContactDetails(ContactInformationDTO contactDetails) {
		ContactInformationVO contactInformationVO = new ContactInformationVO();
		contactInformationVO.setContactType(contactDetails.getContactType());
		contactInformationVO.setContactValue(contactDetails.getContactValue());
		this.contactDetails = contactInformationVO;
		return this;
	}
	
	public Customer buildCustomerEntity(){
		customerEntity.setId(id);
		customerEntity.setFirstName(firstName);
		customerEntity.setDateOfBirth(dateOfBirth);
		customerEntity.setLastname(lastName);
		customerEntity.setContactDetails(contactDetails);
		customerEntity.setBillingAccounts(billingAccounts);
		customerEntity.setCredentials(credentials);
		customerEntity.setPaymentDetails(paymentDetails);
		customerEntity.setStringDateOfBirth(stringDateOfBirth);
		return customerEntity;
	}
}
