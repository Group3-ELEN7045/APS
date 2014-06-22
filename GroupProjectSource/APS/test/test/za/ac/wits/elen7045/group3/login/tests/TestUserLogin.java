package test.za.ac.wits.elen7045.group3.login.tests;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

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
import za.ac.wits.elen7045.group3.aps.services.specification.credentials.AuthenticationSpecification;

/**
 * @author SilasMahlangu
 *
 */
public class TestUserLogin {
    private CustomerDTO customer;
	private CapturedCredentialsDTO      capturedCredentialsDTO;
	private PaymentDetailsDTO           paymentDetailsDTO;
	private ContactInformationDTO       contactInforMationDTO;
	private BillingAccountDTO           billingAccountDTO;
	private List<BillingAccountDTO>     billingAccountDTOs;
	private CredentialsDTO              userCredenials;
	private ApplicationContext          context;
	private UserDataAccess              userDataRepository;
	private CustomerRepository          customerRepository;
		
	private EncryptionModule            encryptionModule; 
	private UserManager	                userManager;
	private UserManagerImpl             userManagerImpl;
		
	//Scenario Registration Customer 
	@Before
	public void init(){
	    context                = new  ClassPathXmlApplicationContext("res/spring/application-context-test.xml");
		customer               = context.getBean(CustomerDTO.class); 
		userCredenials         = new CredentialsDTO(); 
		userDataRepository     = context.getBean(UserDataAccess.class);
		encryptionModule       = context.getBean(EncryptionModule.class);
		paymentDetailsDTO      = context.getBean(PaymentDetailsDTO.class);
		billingAccountDTO      = context.getBean(BillingAccountDTO.class);
		contactInforMationDTO  = context.getBean(ContactInformationDTO.class);
		customerRepository     = context.getBean(CustomerRepository.class);
		billingAccountDTOs     = new ArrayList<BillingAccountDTO>();
			
	    customer.setEncryptionModule(encryptionModule);
   	    userManagerImpl  = new UserManagerImpl(customerRepository);
		userManager      = new APSMockObjectGenerator<UserManagerImpl>().mock(userManagerImpl);
		    
	}
	
	 @Test
	    public void testCredentials() throws DatabaseException {
	    	userCredenials.setUserName("username1");
	    	userCredenials.setPassword("password");    	
		    ApplicationSpecification<CredentialsDTO> autentication = new AuthenticationSpecification(userCredenials);
		    assertTrue("Invalid Usernme or Password", autentication.isSatisfiedBy(userCredenials));
	    }
	
    @Test
    public void testCustomerAuthentication() throws DatabaseException {
    	userCredenials.setUserName("username1");
    	userCredenials.setPassword("password");
    	CustomerDTO authenticationCustomer = userManager.getCustomer(userCredenials);
    	authenticationCustomer.getCredentials().setEncryptionModule(encryptionModule);
	    ApplicationSpecification<CredentialsDTO> autentication = new AuthenticationSpecification(userCredenials);
	    CredentialsDTO dbCredentials = authenticationCustomer.getCredentials();
	    assertTrue("Invalid Usernme or Password", autentication.isSatisfiedBy(dbCredentials));
    }
}
