package za.ac.wits.elen7045.group3.aps.services.pattern.user.builder;

import java.util.ArrayList;
import java.util.Date;
import java.util.List; 

import za.ac.wits.elen7045.group3.aps.domain.entities.BillingAccount;
import za.ac.wits.elen7045.group3.aps.domain.vo.ContactInformationVO;
import za.ac.wits.elen7045.group3.aps.domain.vo.CredentialsVO;
import za.ac.wits.elen7045.group3.aps.services.dto.BillingAccountDTO;
import za.ac.wits.elen7045.group3.aps.services.dto.ContactInformationDTO;
import za.ac.wits.elen7045.group3.aps.services.dto.CredentialsDTO;
import za.ac.wits.elen7045.group3.aps.services.dto.CustomerDTO;
import za.ac.wits.elen7045.group3.aps.services.dto.PaymentDetailsDTO;

/**
 * @author SilasMahlangu
 *
 */

public class UserDTOBuilder {
  
	private CustomerDTO customerDTO = new CustomerDTO();
	
	/** The id. */
	private Long                 id;
	private String               firstName;
	private String               lastName;
	private Date                 dateOfBirth;
	private CredentialsDTO       credentials;
	private String               stringDateOfBirth;
    private PaymentDetailsDTO    paymentDetails = new PaymentDetailsDTO();
	private List<BillingAccountDTO> billingAccounts;
	private ContactInformationDTO contactDetails = new ContactInformationDTO();
	
	public static UserDTOBuilder newInstance() {
	    return new UserDTOBuilder();
	}

	
	public UserDTOBuilder withId(Long id) {
		this.id = id;
		return this;
	}

	public UserDTOBuilder withFirstName(String firstName) {
		this.firstName = firstName;
		return this;
	}

	public UserDTOBuilder withLastName(String lastName) {
		this.lastName = lastName;
		return this;
	}

	public UserDTOBuilder withDateOfBirth(Date dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
		return this;
	}

	public UserDTOBuilder withCredentials(CredentialsVO credentialsVO) {
		CredentialsDTO credentialsDTO = new CredentialsDTO();
		credentialsDTO.setPassword(credentialsVO.getPassword());
		credentialsDTO.setUserName(credentialsVO.getUserName());
		this.credentials = credentialsDTO;
		return this;
	}

	public UserDTOBuilder withEncryptedDateOfBirth(String stringDateOfBirth) {
		this.stringDateOfBirth = stringDateOfBirth;
		return this;
	}

	public UserDTOBuilder withBillingAccounts(List<BillingAccount> billingAccounts) {
		List<BillingAccountDTO> billingAccountsDTO = new ArrayList<BillingAccountDTO>();
		BillingAccountDTO billingAccountDTO = null;
		if(billingAccounts != null){
		    for(BillingAccount account : billingAccounts){
		    	billingAccountDTO = new BillingAccountDTO(account.getAccountNumber());
		    	billingAccountDTO.setAccountNumber(account.getAccountNumber());
		    	billingAccountDTO.setAccountStatus(account.getAccountStatus());
		    	billingAccountDTO.setCompanyUrl(account.getCompanyUrl());
		    				
			    CredentialsVO credentials = account.getCredentials();
			    CredentialsDTO credentialsDTO = new CredentialsDTO();
			    credentialsDTO.setPassword(credentials.getPassword());
			    credentialsDTO.setPassword(credentials.getUserName());
			    billingAccountDTO.setCredentials(credentialsDTO);
			    billingAccountDTO.setCustomerId(billingAccountDTO.getCustomerId());
			    billingAccountsDTO.add(billingAccountDTO);
		   }
		
		   this.billingAccounts = billingAccountsDTO;
		}
		return this;
	}

	public UserDTOBuilder setContactDetails(ContactInformationVO contactDetails) {
		ContactInformationDTO contactInformationDTO = new ContactInformationDTO();
		contactInformationDTO.setContactType(contactDetails.getContactType());
		contactInformationDTO.setContactValue(contactDetails.getContactValue());
		this.contactDetails = contactInformationDTO;
		return this;
	}
	
	public CustomerDTO buildCustomerDTO(){
		customerDTO.setId(id);
		customerDTO.setFirstName(firstName);
		customerDTO.setDateOfBirth(dateOfBirth);
		customerDTO.setLastname(lastName);
		customerDTO.setContactDetails(contactDetails);
		customerDTO.setBillingAccounts(billingAccounts);
		customerDTO.setCredentials(credentials);
		customerDTO.setPaymentDetails(paymentDetails);
		customerDTO.setStringDateOfBirth(stringDateOfBirth);
		return customerDTO;
	}
}
