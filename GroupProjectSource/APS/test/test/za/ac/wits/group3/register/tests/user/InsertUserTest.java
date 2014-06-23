/**
 * 
 */
package test.za.ac.wits.group3.register.tests.user;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.io.IOException;
import java.io.InputStream;
import java.io.StringWriter;
import java.util.List;

import org.apache.commons.io.IOUtils;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.thoughtworks.xstream.XStream;

import test.za.ac.wits.group3.mock.proxy.APSMockObjectGenerator;
import za.ac.wits.elen7045.group3.aps.domain.UserDataAccess;
import za.ac.wits.elen7045.group3.aps.domain.repository.user.CustomerRepository;
import za.ac.wits.elen7045.group3.aps.services.dto.BillingAccountDTO;
import za.ac.wits.elen7045.group3.aps.services.dto.CapturedCredentialsDTO;
import za.ac.wits.elen7045.group3.aps.services.dto.ContactInformationDTO;
import za.ac.wits.elen7045.group3.aps.services.dto.CredentialsDTO;
import za.ac.wits.elen7045.group3.aps.services.dto.CustomerDTO;
import za.ac.wits.elen7045.group3.aps.services.dto.PaymentDetailsDTO;
import za.ac.wits.elen7045.group3.aps.services.exception.DatabaseException;
import za.ac.wits.elen7045.group3.aps.services.managers.UserManager;
import za.ac.wits.elen7045.group3.aps.services.managers.UserManagerImpl;
import za.ac.wits.elen7045.group3.aps.services.security.EncryptionModule;
import za.ac.wits.elen7045.group3.aps.services.specification.ApplicationSpecification;
import za.ac.wits.elen7045.group3.aps.services.specification.credentials.CapturedCredentialsSpecification;
import za.ac.wits.elen7045.group3.aps.services.specification.credentials.EncryptedCredentialsSpecification;
import za.ac.wits.elen7045.group3.aps.services.specification.user.EncryptedUserInformationSpecification;

/**
 * @author SilasMahlangu
 *
 */
public class InsertUserTest {
    private CapturedCredentialsDTO      logonCredentialsDTO;
	private PaymentDetailsDTO           paymentDetailsDTO;
	private ContactInformationDTO       contactInforMationDTO;
	private List<BillingAccountDTO>     billingAccountDTOs;
	private CredentialsDTO              credentialDTO;
	private ApplicationContext          context;
	private UserDataAccess              userDataRepository;
	private CustomerRepository          customerRepository;
	
	private EncryptionModule            encryptionModule; 
	private UserManager	                userManager;
	private UserManagerImpl             userManagerImpl;
	private String enquiryXML           = null;
	private StringWriter writer         = null;
	private InputStream inputStream     = null;
	private CustomerDTO customer        = null;
	
	//Scenario Registration Customer 
	@Before
	public void init(){
		
		//initializeSpring
		context                = new  ClassPathXmlApplicationContext("res/spring/application-context-test.xml");
		customer               = context.getBean(CustomerDTO.class); 
		logonCredentialsDTO    = context.getBean(CapturedCredentialsDTO.class);
		userDataRepository     = context.getBean(UserDataAccess.class);
		encryptionModule       = context.getBean(EncryptionModule.class);
		paymentDetailsDTO      = context.getBean(PaymentDetailsDTO.class);
		contactInforMationDTO  = context.getBean(ContactInformationDTO.class);
		customerRepository     = context.getBean(CustomerRepository.class);
		
	    writer = new StringWriter();
		try {
			inputStream = this.getClass().getResourceAsStream("customers.xml");
			IOUtils.copy(inputStream, writer, "UTF-8");
			enquiryXML = writer.toString();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		XStream sxt = new XStream();
		sxt.alias("Customers", List.class);
		//parse the data for file system users.
		List<CustomerDTO> customers = (List<CustomerDTO>)sxt.fromXML(enquiryXML);
	    
	    //test with one user
	    customer = customers.get(0);
	    
	    //inject encryption module
	    customer.setEncryptionModule(encryptionModule);
	    
	    //Captured Credentials to validate Password and Captured Password;
	    logonCredentialsDTO.setUserName("userName");
	    logonCredentialsDTO.setPassword("password");
	    logonCredentialsDTO.setConfirmPasword("P@ssw0rd");
	    
	    //Use a dynamic proxy to lookup for inter face
	    userManagerImpl  = new UserManagerImpl(customerRepository);
	    userManager      = new APSMockObjectGenerator<UserManagerImpl>().mock(userManagerImpl);
    }
	
	@Test //if password and Confirm password are the same
	public void testValidateCapturedCredentials(){
		ApplicationSpecification<CapturedCredentialsDTO> capturedCredentials = new CapturedCredentialsSpecification(logonCredentialsDTO);
		assertTrue("Captured Password and Confirm Password are not the same",capturedCredentials.isSatisfiedBy(logonCredentialsDTO));
	}
	
	@Test //if parts user Details are Encrypted 
	public void testValidatedUserEncryption(){
		customer.encryptUserInformation();
		ApplicationSpecification<CustomerDTO> userDetailsSpecification = new EncryptedUserInformationSpecification(customer);
		assertTrue("User details not encrypted properly", userDetailsSpecification.isSatisfiedBy(customer));
	} 
	
	@Test //if username and password are encrypted
	public void testValidateUsernamePasswordEncryption(){
		customer.getCredentials().setEncryptionModule(encryptionModule);
		credentialDTO = customer.getCredentials().encryptCredentials();
		ApplicationSpecification<CredentialsDTO> encryptSpecification = new EncryptedCredentialsSpecification(credentialDTO);
		assertTrue("UserName and password are not Encrypted", encryptSpecification.isSatisfiedBy(credentialDTO));	
	}
	
	@Test //test if insertion happened successfult
	public void testRegisterUser() throws DatabaseException{
		userManager.updateUser(customer);
		customer.setId(Long.valueOf(26));
	    CustomerDTO insertedUser = userManager.selectCustomer(customer);
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
