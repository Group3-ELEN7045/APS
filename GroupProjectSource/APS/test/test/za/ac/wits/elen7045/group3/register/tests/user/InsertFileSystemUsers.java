/**
 * 
 */
package test.za.ac.wits.elen7045.group3.register.tests.user;

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

import test.za.ac.wits.elen7045.group3.mock.proxy.APSMockObjectGenerator;
import za.ac.wits.elen7045.group3.aps.domain.UserDataAccess;
import za.ac.wits.elen7045.group3.aps.domain.repository.user.CustomerRepository;
import za.ac.wits.elen7045.group3.aps.services.dto.CustomerDTO;
import za.ac.wits.elen7045.group3.aps.services.exception.ApplicationException;
import za.ac.wits.elen7045.group3.aps.services.exception.DatabaseException;
import za.ac.wits.elen7045.group3.aps.services.managers.UserManager;
import za.ac.wits.elen7045.group3.aps.services.managers.UserManagerImpl;
import za.ac.wits.elen7045.group3.aps.services.security.EncryptionModule;

/**
 * @author SilasMahlangu
 *
 */
public class InsertFileSystemUsers {
    	
	private ApplicationContext          context;
	private UserDataAccess              userDataRepository;
	private CustomerRepository          customerRepository;
	
	private EncryptionModule            encryptionModule; 
	private UserManager	                userManager;
	private UserManagerImpl             userManagerImpl;
	private String enquiryXML           = null;
	private StringWriter writer         = null;
	private InputStream inputStream     = null;
	private List<CustomerDTO> customers;
		
	//Insert Multiple Users; 
	@Before
	public void init(){
		
		//initializeSpring
		context                = new  ClassPathXmlApplicationContext("res/spring/application-context-test.xml");
		userDataRepository     = context.getBean(UserDataAccess.class);
		customerRepository     = context.getBean(CustomerRepository.class);
		encryptionModule       = context.getBean(EncryptionModule.class);
		
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
		customers = (List<CustomerDTO>) sxt.fromXML(enquiryXML);
	    	    
	    //Use a dynamic proxy to lookup for inter face
	    userManagerImpl  = new UserManagerImpl(customerRepository);
	    userManager      = new APSMockObjectGenerator<UserManagerImpl>().mock(userManagerImpl);
    }
	
	@Test //test if insertion happened successfult
	public void testRegisterUser() throws DatabaseException, ApplicationException{
		int numberOfUsersToInsert = customers.size();
		int insertedUsers = 0;
		for(CustomerDTO custDTO : customers){
			custDTO.setEncryptionModule(encryptionModule);
			custDTO.encryptUserInformation();
			custDTO.getCredentials().setEncryptionModule(encryptionModule);
			custDTO.getCredentials().encryptCredentials();
			userManager.updateUser(custDTO);
		    ++insertedUsers;
		}
	    
	    assertTrue("Not All users were added", (numberOfUsersToInsert == insertedUsers));
	}
	
}
