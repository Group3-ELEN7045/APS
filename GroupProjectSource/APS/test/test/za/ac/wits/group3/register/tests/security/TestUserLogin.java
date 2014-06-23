package test.za.ac.wits.group3.register.tests.security;

import static org.junit.Assert.*;

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
import za.ac.wits.elen7045.group3.aps.services.dto.CapturedCredentialsDTO;
import za.ac.wits.elen7045.group3.aps.services.dto.CredentialsDTO;
import za.ac.wits.elen7045.group3.aps.services.dto.CustomerDTO;
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
    private CustomerDTO             customer;
	private CapturedCredentialsDTO  capturedCredentialsDTO;
	private CredentialsDTO          userCredenials;
	private ApplicationContext      context;
	private UserDataAccess          userDataRepository;
	private CustomerRepository      customerRepository;
		
	private EncryptionModule        encryptionModule; 
	private UserManager	            userManager;
	private UserManagerImpl         userManagerImpl;
	private String enquiryXML       = null;	
	private StringWriter writer     = null;
	private InputStream inputStream = null;
	private List<CustomerDTO>    customers;    
	
	//Test Authentication Scenario 
	@Before
	public void init(){
	    context                = new  ClassPathXmlApplicationContext("res/spring/application-context-test.xml");
		customer               = context.getBean(CustomerDTO.class); 
		userCredenials         = new CredentialsDTO(); 
		userDataRepository     = context.getBean(UserDataAccess.class);
		encryptionModule       = context.getBean(EncryptionModule.class);
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
		 customers = (List<CustomerDTO>)sxt.fromXML(enquiryXML);
		    
		 customer.setEncryptionModule(encryptionModule);
   	     userManagerImpl  = new UserManagerImpl(customerRepository);
		 userManager      = new APSMockObjectGenerator<UserManagerImpl>().mock(userManagerImpl);
	}
		
    @Test
    public void testCustomerAuthentication() throws DatabaseException {
    	for(CustomerDTO customerDTO : customers){
    	  userCredenials.setUserName(customerDTO.getCredentials().getUserName());
    	  userCredenials.setPassword(customerDTO.getCredentials().getPassword());
    	  CustomerDTO authenticationCustomer = userManager.getCustomer(userCredenials);
    	  authenticationCustomer.getCredentials().setEncryptionModule(encryptionModule);
	      ApplicationSpecification<CredentialsDTO> autentication = new AuthenticationSpecification(userCredenials);
	      CredentialsDTO dbCredentials = authenticationCustomer.getCredentials();
	       assertTrue("Invalid Usernme or Password", autentication.isSatisfiedBy(dbCredentials));
    	}
    }
}
