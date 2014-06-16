/**
 * 
 */
package test.za.ac.wits.group3.register.tests.user;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import test.za.ac.wits.group3.mock.proxy.APSMockObjectGenerator;
import za.ac.wits.elen7045.group3.aps.domain.UserDataAccess;
import za.ac.wits.elen7045.group3.aps.domain.entities.Customer;
import za.ac.wits.elen7045.group3.aps.domain.entities.User;
import za.ac.wits.elen7045.group3.aps.domain.repository.user.CustomerRepository;
import za.ac.wits.elen7045.group3.aps.domain.repository.user.CustomerRepositoryImpl;
import za.ac.wits.elen7045.group3.aps.domain.vo.CredentialsVO;
import za.ac.wits.elen7045.group3.aps.domain.vo.LogonCredentialsVO;
import za.ac.wits.elen7045.group3.aps.domain.vo.PaymentDetailsVO;
import za.ac.wits.elen7045.group3.aps.services.enumtypes.PaymentType;
import za.ac.wits.elen7045.group3.aps.services.enumtypes.StatusType;
import za.ac.wits.elen7045.group3.aps.services.exception.DatabaseException;
import za.ac.wits.elen7045.group3.aps.services.notification.ConfirmationNotification;
import za.ac.wits.elen7045.group3.aps.services.notification.FileNotification;
import za.ac.wits.elen7045.group3.aps.services.security.EncryptionModule;
import za.ac.wits.elen7045.group3.aps.services.specification.ApplicationSpecification;
import za.ac.wits.elen7045.group3.aps.services.specification.Specification;
import za.ac.wits.elen7045.group3.aps.services.specification.credentials.CapturedCredentialsSpecification;
import za.ac.wits.elen7045.group3.aps.services.specification.credentials.EncryptedCredentialsSpecification;
import za.ac.wits.elen7045.group3.aps.services.specification.notification.ConfirmSendNotification;
import za.ac.wits.elen7045.group3.aps.services.specification.user.EncryptedUserInformationSpecification;
import za.ac.wits.elen7045.group3.aps.services.specification.user.UserSpecificationByID;
import za.ac.wits.elen7045.group3.aps.services.util.ApplicationContants;
import za.ac.wits.elen7045.group3.aps.services.util.DateUtil;

/**
 * @author SilasMahlangu
 *
 */
public class InsertUserTest {
    private Customer customer;
	private LogonCredentialsVO       logonCredentials;
	private ApplicationContext     context;
	private UserDataAccess         userDataRepository;
	private CustomerRepositoryImpl mockUserDataAccess;	
	private CustomerRepository     customerRepository;
	private PaymentDetailsVO         paymentDetails;
	private EncryptionModule       encryptionModule; 
	private CredentialsVO          credentialVO;
	//Scenario Registration Customer 
	@Before
	public void init(){
		context             = new  ClassPathXmlApplicationContext("res/spring/application-context-test.xml");
		customer            = context.getBean(Customer.class); 
		logonCredentials    = context.getBean(LogonCredentialsVO.class);
		userDataRepository  = context.getBean(UserDataAccess.class);
		encryptionModule    = context.getBean(EncryptionModule.class);
		paymentDetails      = context.getBean(PaymentDetailsVO.class);
		
		customer.setId((long) 1);
		customer.setFirstName("Silas");
		customer.setLastname("Mahlangu");
		customer.setDateOfBirth(DateUtil.formatDate(ApplicationContants.DATE_OF_BIRTH_FORMAT, "12/12/1979"));
	   
	    logonCredentials.setUserName("username");
	    logonCredentials.setPassword("password");
	    logonCredentials.setConfirmPasword("P@ssword");
	    customer.setCredentials(logonCredentials);
	    
	    paymentDetails.setPaymentType(PaymentType.CREDIT_CARD.getPaymentType());
	    paymentDetails.setValue("1234 1234 5678 5678");
	    customer.setPaymentDetails(paymentDetails);
	    
	    mockUserDataAccess = new CustomerRepositoryImpl(userDataRepository);
	    customerRepository = new APSMockObjectGenerator<CustomerRepositoryImpl>().mock(mockUserDataAccess);
	}
	
	@Test //if password and Confirm password are the same
	public void testValidateCapturedCredentials(){
		Specification capturedCredentials = new CapturedCredentialsSpecification(logonCredentials);
		assertTrue("Captured Password and Confirm Password are not the same",capturedCredentials.isSatisfiedBy(customer.getCredentials()));
	}
	
	@Test //if parts user Details are Encrypted 
	public void testValidatedUserEncryption(){
		customer.setEncryptionModule(encryptionModule);
		customer.encryptUserInformation();
		Specification userDetailsSpecification = new EncryptedUserInformationSpecification(customer);
		assertTrue("User details not encrypted properly", userDetailsSpecification.isSatisfiedBy(userDetailsSpecification));
	} 
	
	@Test //if username and password are encrypted
	public void testValidateUsernamePasswordEncryption(){
		customer.getCredentials().setEncryptionModule(encryptionModule);
		credentialVO = customer.getCredentials().encryptCredentials();
		Specification encryptSpecification = new EncryptedCredentialsSpecification(credentialVO);
		assertTrue("UserName and password are not Encrypted", encryptSpecification.isSatisfiedBy(credentialVO));	
	}
	
	@Test //test if insertion happened successfult
	public void testRegisterUser() throws DatabaseException{
		customerRepository.updateUser(customer);
	    User insertedUser = customerRepository.selectCustomer(customer);
	    assertNotNull("Failed to Insert User" , insertedUser);
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
