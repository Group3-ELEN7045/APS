/**
 * 
 */
package test.za.ac.wits.elen7045.group3.register.tests.user;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import test.za.ac.wits.elen7045.group3.mock.proxy.APSMockObjectGenerator;
import za.ac.wits.elen7045.group3.aps.domain.repository.user.CustomerRepository;
import za.ac.wits.elen7045.group3.aps.services.dto.CapturedCredentialsDTO;
import za.ac.wits.elen7045.group3.aps.services.dto.ContactInformationDTO;
import za.ac.wits.elen7045.group3.aps.services.dto.CredentialsDTO;
import za.ac.wits.elen7045.group3.aps.services.dto.CustomerDTO;
import za.ac.wits.elen7045.group3.aps.services.dto.PaymentDetailsDTO;
import za.ac.wits.elen7045.group3.aps.services.enumtypes.ContactType;
import za.ac.wits.elen7045.group3.aps.services.enumtypes.PaymentType;
import za.ac.wits.elen7045.group3.aps.services.exception.ApplicationException;
import za.ac.wits.elen7045.group3.aps.services.managers.UserManager;
import za.ac.wits.elen7045.group3.aps.services.managers.UserManagerImpl;
import za.ac.wits.elen7045.group3.aps.services.security.EncryptionModule;
import za.ac.wits.elen7045.group3.aps.services.specification.ApplicationSpecification;
import za.ac.wits.elen7045.group3.aps.services.specification.credentials.CapturedCredentialsSpecification;
import za.ac.wits.elen7045.group3.aps.services.specification.credentials.EncryptedCredentialsSpecification;
import za.ac.wits.elen7045.group3.aps.services.specification.user.EncryptedUserInformationSpecification;
import za.ac.wits.elen7045.group3.aps.services.util.ApplicationContants;
import za.ac.wits.elen7045.group3.aps.services.util.DateUtil;

/**
 * @author SilasMahlangu
 *
 */
public class RegisterUserTest {
    private CapturedCredentialsDTO      logonCredentialsDTO;
    private PaymentDetailsDTO           paymentDetailsDTO;
	private ContactInformationDTO       contactInforMationDTO;
	private CredentialsDTO              credentialDTO;
	private ApplicationContext          context;
	private CustomerRepository          customerRepository;
	
	private EncryptionModule            encryptionModule; 
	private UserManager	                userManager;
	private UserManagerImpl             userManagerImpl;
	private CustomerDTO customer        = null;
	
	//Scenario Registration Customer 
	@Before
	public void init(){
		
		//initializeSpring
		context                = new  ClassPathXmlApplicationContext("res/spring/application-context-test.xml");
		customer               = context.getBean(CustomerDTO.class); 
		logonCredentialsDTO    = context.getBean(CapturedCredentialsDTO.class);
		encryptionModule       = context.getBean(EncryptionModule.class);
		paymentDetailsDTO      = context.getBean(PaymentDetailsDTO.class);
		contactInforMationDTO  = context.getBean(ContactInformationDTO.class);
		customerRepository     = context.getBean(CustomerRepository.class);
		
		customer.setFirstName("Samuel");
		customer.setLastname("Sam");
		customer.setDateOfBirth(DateUtil.formatDate(ApplicationContants.DATE_OF_BIRTH_FORMAT, "12/12/1979"));
	   
		//customer payment details
	    paymentDetailsDTO.setPaymentType(PaymentType.CREDIT_CARD.getPaymentType());
	    paymentDetailsDTO.setValue("111111111111");
	    customer.setPaymentDetails(paymentDetailsDTO);
	    
	    contactInforMationDTO.setContactType(ContactType.EMAIL.getContactType());
	    contactInforMationDTO.setContactValue("bak@hotmail.com");
	    customer.setContactDetails(contactInforMationDTO);
	    
	    //set Encryption model
	    customer.setEncryptionModule(encryptionModule);
	    
	    //Captured Credentials to validate Password and Captured Password;
	    logonCredentialsDTO.setUserName("userName");
	    logonCredentialsDTO.setPassword("password");
	    logonCredentialsDTO.setConfirmPasword("p@ssword!");
	    
	    //Use a dynamic proxy to lookup for interface
	    userManagerImpl  = new UserManagerImpl(customerRepository);
	    userManager      = new APSMockObjectGenerator<UserManagerImpl>().mock(userManagerImpl);
    }
	
	@Test //if password and Confirm password are the same
	public void testValidateCapturedCredentials(){
		ApplicationSpecification<CapturedCredentialsDTO> capturedCredentials = new CapturedCredentialsSpecification(logonCredentialsDTO);
		assertTrue("Captured Password and Confirm Password are not the same",capturedCredentials.isSatisfiedBy(logonCredentialsDTO));
		//For Presentation
		if(capturedCredentials.isSatisfiedBy(logonCredentialsDTO)){
			System.out.println("Captured Password and Confirm Password are valid");
		}
	}
	
	@Test //if parts user Details are Encrypted 
	public void testValidatedUserDetailsEncryption(){
		CustomerDTO validatingUser = new CustomerDTO();
		validatingUser.setDateOfBirth(DateUtil.formatDate(ApplicationContants.DATE_OF_BIRTH_FORMAT, "12/12/1979"));
		PaymentDetailsDTO validatingPaymentsDTO = new PaymentDetailsDTO();
      	validatingPaymentsDTO.setPaymentType(PaymentType.CREDIT_CARD.getPaymentType());
        validatingPaymentsDTO.setValue("111111111111");
        validatingUser.setPaymentDetails(validatingPaymentsDTO);
        
        validatingUser.setEncryptionModule(encryptionModule);
        
        customer.encryptUserInformation();
        validatingUser.encryptUserInformation();
        
		ApplicationSpecification<CustomerDTO> userDetailsSpecification = new EncryptedUserInformationSpecification(customer);
		assertTrue("User details not encrypted properly", userDetailsSpecification.isSatisfiedBy(validatingUser));
	} 
	
	@Test //if username and password are not encrypted
	public void testNotEncryptedValidateUsernamePassword(){
		//Plain Credentials
		credentialDTO = new CredentialsDTO();
		credentialDTO.setUserName("userName");
		credentialDTO.setPassword("pas44sword");
		customer.setCredentials(credentialDTO);
		customer.getCredentials().setEncryptionModule(encryptionModule);
		
		CredentialsDTO credentialsToTestAgainst = new CredentialsDTO();
		credentialsToTestAgainst.setUserName("userName");
		credentialsToTestAgainst.setPassword("pas44sword");
		
				
		ApplicationSpecification<CredentialsDTO> encryptSpecification = new EncryptedCredentialsSpecification(credentialDTO);
		//assertTrue("UserName and password are not Encrypted", encryptSpecification.isSatisfiedBy(credentialsToTestAgainst));
	}
	
	@Test //if username and password are encrypted
	public void testEncryptedValidateUsernamePassword(){
		//Plain Credentials
		credentialDTO = new CredentialsDTO();
		credentialDTO.setUserName("userName");
		credentialDTO.setPassword("pas44sword");
		customer.setCredentials(credentialDTO);
		customer.getCredentials().setEncryptionModule(encryptionModule);
		
		CredentialsDTO credentialDTOEncrypt = new CredentialsDTO();
		credentialDTO.setUserName("userName");
		credentialDTO.setPassword("pas44sword");
		
		credentialDTO = customer.getCredentials().encryptCredentials();
		
		ApplicationSpecification<CredentialsDTO> encryptSpecification = new EncryptedCredentialsSpecification(credentialDTO);
		
		if(!encryptSpecification.isSatisfiedBy(credentialDTO)){
			System.out.println("UserName and password are not Encrypted");
		}
		assertTrue("UserName and password are  Encrypted", !encryptSpecification.isSatisfiedBy(credentialDTOEncrypt));
	}
	
	@Test //test if insertion happened successfully and the insert Specification is met
	public void testRegisterUser() throws ApplicationException{
		
		ApplicationSpecification<CapturedCredentialsDTO> capturedCredentials = new CapturedCredentialsSpecification(logonCredentialsDTO);
		CapturedCredentialsDTO validationCredentials = new CapturedCredentialsDTO();
		validationCredentials.setUserName("userName");
		validationCredentials.setPassword("password");
		validationCredentials.setConfirmPasword("password");
		
System.out.println("*****************************  User Registration Process *****************************");			
System.out.println("   ");
System.out.println("1. Validating Password and Confirm Password   ");
System.out.println("");
System.out.println("");
System.out.println("Password         = " + logonCredentialsDTO.getPassword());
System.out.println("Confirm Password = " + logonCredentialsDTO.getConfirmPasword());
System.out.println("");
System.out.println("Appliying validate captured credentials specification");
System.out.println();
System.out.println("Validation Results = " + capturedCredentials.isSatisfiedBy(validationCredentials));
System.out.println("");
System.out.println("");
System.out.println("Correcting the Confirm Password");
System.out.println("");
logonCredentialsDTO.setConfirmPasword(validationCredentials.getConfirmPasword());
System.out.println("Uptated the Confirm Password");
System.out.println("");
System.out.println("Password         = " + logonCredentialsDTO.getPassword());
System.out.println("Confirm Password = " + logonCredentialsDTO.getConfirmPasword());
System.out.println("");
System.out.println("Appliying validate captured credentials specification again.");
System.out.println("");
System.out.println("Validation Results = " + capturedCredentials.isSatisfiedBy(validationCredentials));
System.out.println("");
System.out.println("");

        //For Presentation  
		//1.  Validate captured Password and CapturedPassword. 
		if(capturedCredentials.isSatisfiedBy(logonCredentialsDTO)){
			System.out.println("Captured Password and Confirm Password are valid");
			
			CustomerDTO validatingUser = new CustomerDTO();
			validatingUser.setDateOfBirth(DateUtil.formatDate(ApplicationContants.DATE_OF_BIRTH_FORMAT, "12/12/1979"));
			PaymentDetailsDTO validatingPaymentsDTO = new PaymentDetailsDTO();
	      	validatingPaymentsDTO.setPaymentType(PaymentType.CREDIT_CARD.getPaymentType());
	        validatingPaymentsDTO.setValue("111111111111");
	        validatingUser.setPaymentDetails(validatingPaymentsDTO);
	        
	        validatingUser.setEncryptionModule(encryptionModule);
			
			customer.encryptUserInformation();
			validatingUser.encryptUserInformation();
			ApplicationSpecification<CustomerDTO> userDetailsSpecification = new EncryptedUserInformationSpecification(customer);
						
			//For Presentation
			//2.  Validate captured Date of Birth and and Payment details are encrypted.
			if(userDetailsSpecification.isSatisfiedBy(validatingUser)){
				System.out.println("User details have been encrypted properly");	
				
				credentialDTO = new CredentialsDTO();
				credentialDTO.setUserName(logonCredentialsDTO.getUserName());
				credentialDTO.setPassword(logonCredentialsDTO.getPassword());
				customer.setCredentials(credentialDTO);
				customer.getCredentials().setEncryptionModule(encryptionModule);
				
				CredentialsDTO credentialDTOEncrypt = new CredentialsDTO();
				credentialDTOEncrypt.setUserName("userName");
				credentialDTOEncrypt.setPassword("password");
				credentialDTOEncrypt.setEncryptionModule(encryptionModule);
				
				credentialDTO = customer.getCredentials().encryptCredentials();
				credentialDTOEncrypt.encryptCredentials();
				
				ApplicationSpecification<CredentialsDTO> encryptSpecification = new EncryptedCredentialsSpecification(credentialDTO);
								
				//For Presentation
				//3.  Validate userEntry.
				if(encryptSpecification.isSatisfiedBy(credentialDTOEncrypt)){
					System.out.println("UserName and password are  Encrypted");
					
					CustomerDTO responseCutomer = userManager.updateUser(customer);
					CustomerDTO insertedUser = userManager.selectCustomer(responseCutomer);
				    assertNotNull("Failed to Insert User" , insertedUser);
				}
			}
		}
	}
	
	
	
	//@Test
	//public void testSendNotification() throws DatabaseException{
	//	Customer insertedCustomer = customerRepository.selectCustomer(customer); 	
	//	ApplicationSpecification<Customer> customerSpecificationById = new UserSpecificationByID(insertedCustomer);
	//	if(customerSpecificationById.isFulfiledBy(customer)){
	//		ConfirmationNotification fileNotification = new FileNotification(ApplicationContants.ACCOUNT_STATUS+"="+customer.getAccount().getAccountStatus());
	//		ApplicationSpecification<ConfirmSendNotification> filSendConfirmSpecification = new ConfirmSendNotification(fileNotification.sendNotification());
	//		assertTrue("Failed to Send Account Activation Message", filSendConfirmSpecification.isFulfiledBy(fileNotification));
	//	}
		
	//}
}
