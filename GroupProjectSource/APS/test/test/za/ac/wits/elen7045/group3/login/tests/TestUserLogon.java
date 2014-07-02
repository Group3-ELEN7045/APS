package test.za.ac.wits.elen7045.group3.login.tests;
import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;  
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import test.za.ac.wits.elen7045.group3.mock.proxy.APSMockObjectGenerator;
import za.ac.wits.elen7045.group3.aps.domain.repository.user.CustomerRepository;
import za.ac.wits.elen7045.group3.aps.services.dto.CredentialsDTO;
import za.ac.wits.elen7045.group3.aps.services.dto.CustomerDTO;
import za.ac.wits.elen7045.group3.aps.services.exception.ApplicationException;
import za.ac.wits.elen7045.group3.aps.services.managers.UserManager;
import za.ac.wits.elen7045.group3.aps.services.managers.UserManagerImpl;
import za.ac.wits.elen7045.group3.aps.services.security.EncryptionModule;
import za.ac.wits.elen7045.group3.aps.services.specification.ApplicationSpecification;
import za.ac.wits.elen7045.group3.aps.services.specification.credentials.AuthenticationSpecification;
import za.ac.wits.elen7045.group3.aps.services.validation.APSLogonManager;
import za.ac.wits.elen7045.group3.aps.services.validation.APSLogonManagerImpl;

/**
 * @author Livious
 *
 */
public class TestUserLogon {
    private CredentialsDTO              userCredenials;
	private ApplicationContext          context;
	private CustomerRepository          customerRepository;
		
	private EncryptionModule            encryptionModule; 
	private UserManager	                userManager;
	private UserManagerImpl             userManagerImpl;
	
	private APSLogonManager	            logonManager;
	private APSLogonManagerImpl         logonManagerImpl;
		
	//User APS Authentication
	@Before
	public void init(){
	    context                = new  ClassPathXmlApplicationContext("res/spring/application-context-test.xml");
		userCredenials         = new CredentialsDTO(); 
		encryptionModule       = context.getBean(EncryptionModule.class);
		customerRepository     = context.getBean(CustomerRepository.class);
		logonManager		   = context.getBean(APSLogonManagerImpl.class);
		userManagerImpl  = new UserManagerImpl(customerRepository);
		userManager      = new APSMockObjectGenerator<UserManagerImpl>().mock(userManagerImpl);
	}
		
    @Test
    public void testCustomerAuthentication() throws ApplicationException {
     System.out.println(" ******************* Starting Logon Process  ********************************");
     System.out.println(" ");
      	
    	
    	userCredenials.setUserName("userName");
    	userCredenials.setPassword("password");
    	userCredenials.setEncryptionModule(encryptionModule);
    	userCredenials.encryptCredentials();
    	
    	try {
			Thread.currentThread();
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    
    	System.out.println(" Finding user with ecrypted username = " + userCredenials.getUserName());
        	
    	CustomerDTO authenticationCustomer = userManager.getCustomerForLogin(userCredenials);
    	assertNotNull("Customer Empty Please Regiser", authenticationCustomer);
    
	    System.out.println(" ");
	    System.out.println(" Found user with Id " + authenticationCustomer.getId());
	    System.out.println("Applyting Authentication specification " );	
	    System.out.println(" ");	
	    
	    assertTrue("Invalid Usernme or Password", logonManager.validation(userCredenials));
	     
	     System.out.println("User Authenticated successfully");
     
     try {
			Thread.currentThread();
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}   
    	
    }
}
