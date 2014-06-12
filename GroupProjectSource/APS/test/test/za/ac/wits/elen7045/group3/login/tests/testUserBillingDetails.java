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
import za.ac.wits.elen7045.group3.aps.domain.entities.BillingAccount;
import za.ac.wits.elen7045.group3.aps.domain.entities.BillingCompany;
import za.ac.wits.elen7045.group3.aps.domain.entities.Customer;
import za.ac.wits.elen7045.group3.aps.domain.entities.User;
import za.ac.wits.elen7045.group3.aps.domain.repository.user.CustomerRepository;
import za.ac.wits.elen7045.group3.aps.domain.repository.user.CustomerRepositoryImpl;
import za.ac.wits.elen7045.group3.aps.domain.vo.LogonCredentials;
import za.ac.wits.elen7045.group3.aps.domain.vo.PaymentDetails;
import za.ac.wits.elen7045.group3.aps.services.enumtypes.PaymentType;
import za.ac.wits.elen7045.group3.aps.services.enumtypes.StatusType;
import za.ac.wits.elen7045.group3.aps.services.exception.DatabaseException;
import za.ac.wits.elen7045.group3.aps.services.security.EncryptionModule;
import za.ac.wits.elen7045.group3.aps.services.util.ApplicationContants;
import za.ac.wits.elen7045.group3.aps.services.util.DateUtil;
import za.ac.wits.elen7045.group3.aps.services.validation.LogonUserValidation;

public class testUserBillingDetails {
	
	private Customer customer;
//	private LogonCredentials       logonCredentials;
	private ApplicationContext     context;
	private UserDataAccess         userDataRepository;
	private CustomerRepositoryImpl mockUserDataAccess;	
	private CustomerRepository     customerRepository;
	private PaymentDetails         paymentDetails;
	private EncryptionModule       encryptionModule; 
//	private CredentialsVO          credentialVO;
	private LogonCredentials          credentials;
	private LogonUserValidation 	logonUserValidation;
	private BillingAccount			billingAccuont;
	private StatusType				accountStatus;
	private BillingCompany			billingCompany;
	
	@Before
	public void init(){
		context             = new  ClassPathXmlApplicationContext("res/spring/application-context-test.xml");
		customer            = context.getBean(Customer.class); 
	//	logonCredentials    = context.getBean(LogonCredentials.class);
		userDataRepository  = context.getBean(UserDataAccess.class);
		encryptionModule    = context.getBean(EncryptionModule.class);
		paymentDetails      = context.getBean(PaymentDetails.class);
		credentials			= context.getBean(LogonCredentials.class); 
		billingAccuont		= context.getBean(BillingAccount.class);
	//	billingCompany		= context.getBean(BillingCompany.class);
		
		List<BillingAccount> billingAccountList = new ArrayList<BillingAccount>();
		
		customer.setId((long) 1);
		customer.setFirstName("Silas");
		customer.setLastname("Mahlangu");
		customer.setDateOfBirth(DateUtil.formatDate(ApplicationContants.DATE_OF_BIRTH_FORMAT, "12/12/1979"));
	   
		credentials.setUserName("username");
		credentials.setPassword("password");
		credentials.setConfirmPasword("password");
		credentials.setAccountStatus(StatusType.INACTIVE.getStatusType());
	    customer.setCredentials(credentials);
	    
//	    billingCompany.setCompanyName("Municipality");
//	    billingCompany.setUrl("www.municipality.co.za");
	    
	    billingAccuont.setAccountNumber("2380889");
	    billingAccuont.setAccountStatus(accountStatus.TRYING);
	    billingAccuont.setBillingCompanyName("Municipality");
	    billingAccuont.setCredentials(credentials);
	    billingAccountList.add(billingAccuont);
	    customer.setBillingAccounts(billingAccountList);
	    
	    paymentDetails.setPaymentType(PaymentType.CREDIT_CARD.getPaymentType());
	    paymentDetails.setValue("1234 1234 5678 5678");
	    customer.setPaymentDetails(paymentDetails);
	    
	    mockUserDataAccess = new CustomerRepositoryImpl(userDataRepository);
	    customerRepository = new APSMockObjectGenerator<CustomerRepositoryImpl>().mock(mockUserDataAccess);
	    try {
			customerRepository.updateUser(customer);
		} catch (DatabaseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@Test //test if insertion happened successfult
	public void testRegisterUser() throws DatabaseException{
		customerRepository.updateUser(customer);
	    User insertedUser = customerRepository.selectCustomer(customer);
	    assertNotNull("Failed to Insert User" , insertedUser);
	}

	@Test
	public void testUserValidationAndAuthenitation(){
		try {
			customerRepository.updateUser(customer);
		//	logonUserValidation.validation(credentials);
			assertTrue(logonUserValidation.validation(credentials));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
	}

//	@Test
//	public void testBillingAccountDetailsProvided(){
//		try {
//			customerRepository.updateUser(customer);
//			logonUserValidation.validation(credentials);
//			assertTrue(logonUserValidation.validation(credentials));
//		} catch (Exception e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}		
//	}	
//	
//	@Test
//	public void testBillingAccountCredentiasProvided(){
//		try {
//			customerRepository.updateUser(customer);
//			logonUserValidation.validation(credentials);
//			assertTrue(logonUserValidation.validation(credentials));
//		} catch (Exception e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}		
//	}
	
}
