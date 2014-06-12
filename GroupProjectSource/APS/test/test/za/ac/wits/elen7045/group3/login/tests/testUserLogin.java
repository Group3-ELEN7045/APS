package test.za.ac.wits.elen7045.group3.login.tests;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import test.za.ac.wits.group3.mock.proxy.APSMockObjectGenerator;
import za.ac.wits.elen7045.group3.aps.domain.BillingAccountDataAccess;
import za.ac.wits.elen7045.group3.aps.domain.UserDataAccess;
import za.ac.wits.elen7045.group3.aps.domain.accounts.interfaces.BillingAccountRepository;
import za.ac.wits.elen7045.group3.aps.domain.accounts.repository.BillingAccountRepositoryImpl;
import za.ac.wits.elen7045.group3.aps.domain.entities.BillingAccount;
import za.ac.wits.elen7045.group3.aps.domain.entities.BillingAccountManager;
import za.ac.wits.elen7045.group3.aps.domain.entities.BillingAccountManagerBean;
import za.ac.wits.elen7045.group3.aps.domain.entities.BillingCompany;
import za.ac.wits.elen7045.group3.aps.domain.entities.Customer;
import za.ac.wits.elen7045.group3.aps.domain.entities.User;
import za.ac.wits.elen7045.group3.aps.domain.repository.user.CustomerRepository;
import za.ac.wits.elen7045.group3.aps.domain.repository.user.CustomerRepositoryImpl;
import za.ac.wits.elen7045.group3.aps.domain.vo.CredentialsVO;
import za.ac.wits.elen7045.group3.aps.domain.vo.LogonCredentials;
import za.ac.wits.elen7045.group3.aps.domain.vo.PaymentDetails;
import za.ac.wits.elen7045.group3.aps.services.enumtypes.PaymentType;
import za.ac.wits.elen7045.group3.aps.services.enumtypes.StatusType;
import za.ac.wits.elen7045.group3.aps.services.exception.DatabaseException;
import za.ac.wits.elen7045.group3.aps.services.security.EncryptionModule;
import za.ac.wits.elen7045.group3.aps.services.security.EncryptionModuleImpl;
import za.ac.wits.elen7045.group3.aps.services.util.ApplicationContants;
import za.ac.wits.elen7045.group3.aps.services.util.DateUtil;
import za.ac.wits.elen7045.group3.aps.services.validation.LogonUserValidation;



public class testUserLogin {
	private Customer customer;
//	private LogonCredentials       logonCredentials;
	private ApplicationContext     context;
	private UserDataAccess         userDataRepository;
	//private UserDataAccess         userDataRepository;
	private CustomerRepositoryImpl mockUserDataAccess;	
	private CustomerRepository     customerRepository;
	private PaymentDetails         paymentDetails;
	private EncryptionModule       encryptionModule; 
//	private CredentialsVO          credentialVO;
	private LogonCredentials          credentials;
	private LogonUserValidation 	logonUserValidation;
	private BillingAccountRepository 	billingAccountRepository;
	private BillingAccountRepositoryImpl 	billingAccountD;
	private BillingAccountDataAccess 	billingDataAccess;

	@Before
	public void init(){
		context             = new  ClassPathXmlApplicationContext("res/spring/application-context-test.xml");
		customer            = context.getBean(Customer.class); 
	//	logonCredentials    = context.getBean(LogonCredentials.class);
		userDataRepository  = context.getBean(UserDataAccess.class);
		encryptionModule    = context.getBean(EncryptionModule.class);
		paymentDetails      = context.getBean(PaymentDetails.class);
		credentials			= context.getBean(LogonCredentials.class);
		billingAccountRepository = context.getBean(BillingAccountRepositoryImpl.class);
		billingDataAccess  = context.getBean(BillingAccountDataAccess.class);
	
		
		customer.setId((long) 1);
		customer.setFirstName("Silas");
		customer.setLastname("Mahlangu");
		customer.setDateOfBirth(DateUtil.formatDate(ApplicationContants.DATE_OF_BIRTH_FORMAT, "12/12/1979"));
	   
		credentials.setUserName("username");
		credentials.setPassword("password");
		credentials.setConfirmPasword("password");
		credentials.setAccountStatus(StatusType.INACTIVE.getStatusType());
		credentials.setEncryptionModule(encryptionModule);
		credentials.encryptCredentials();
	    customer.setCredentials(credentials); 

	    
	    paymentDetails.setPaymentType(PaymentType.CREDIT_CARD.getPaymentType());
	    paymentDetails.setValue("1234 1234 5678 5678");
	    customer.setPaymentDetails(paymentDetails);
	    
	    mockUserDataAccess = new CustomerRepositoryImpl(userDataRepository);
	    customerRepository = new APSMockObjectGenerator<CustomerRepositoryImpl>().mock(mockUserDataAccess);
	    
	  //  billingAccountRepository = new BillingAccountRepositoryImpl(billingDataAccess);
	    
	}
//	
//	@Test //test if insertion happened successfull
//	public void testRegisterUser() throws DatabaseException{
//		customerRepository.updateUser(customer);
//	    User insertedUser = customerRepository.selectCustomer(customer);
//	    assertNotNull("Failed to Insert User" , insertedUser);
//	}

//	@Test
//	public void testUserValidationAndAuthenitation(){
//		try {
//			customerRepository.updateUser(customer);
//			
//			CredentialsVO cred = new CredentialsVO();
//			cred.setUserName("username");
//			cred.setPassword("password");
//			EncryptionModule encryptionModule = new EncryptionModuleImpl();			
//			cred.setEncryptionModule(encryptionModule);
//			cred.encryptCredentials();
//			
//			User insertedUser = customerRepository.selectCustomer(customer);
//		    assertNotNull("Failed to Insert User" , insertedUser);
//			assertTrue(new LogonUserValidation(customerRepository).validation(cred));
//		} catch (Exception e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}		
//	}
//	

@Test
public void testUserRegValidationAddBillingCompany(){
	try {
		customerRepository.updateUser(customer);
		
		CredentialsVO cred = new CredentialsVO();
		cred.setUserName("username");
		cred.setPassword("password");
		EncryptionModule encryptionModule = new EncryptionModuleImpl();			
		cred.setEncryptionModule(encryptionModule);
		cred.encryptCredentials();
		
		User insertedUser = customerRepository.selectCustomer(customer);
	    assertNotNull("Failed to Insert User" , insertedUser);
		assertTrue(new LogonUserValidation(customerRepository).validation(cred));
		
		List<BillingAccount>  accountList = new ArrayList<BillingAccount>();
		
		BillingAccount billingAccount = new BillingAccount();
		billingAccount.setAccountNumber("12345");
		billingAccount.setAccountStatus(StatusType.TRYING);
		billingAccount.setBillingCompanyName("Telcom");
		billingAccount.setCredentials(cred);
		accountList.add(billingAccount);
		
		BillingAccount billingAccount2 = new BillingAccount();
		billingAccount2.setAccountNumber("123456");
		billingAccount2.setAccountStatus(StatusType.TRYING);
		billingAccount2.setBillingCompanyName("Municipality");
		billingAccount2.setCredentials(cred);
		accountList.add(billingAccount2);		
	//	customer.setBillingAccounts(accountList);
		
		BillingAccountManager billingManager = new BillingAccountManagerBean(customer, billingAccountRepository);
		billingManager.addCustomerBillingAccounts(accountList);
		
		User user = customerRepository.selectCustomer(customer);
		assertEquals(2 , user.getBillingAccounts().size());	
		
		BillingAccount acc = billingManager.getBillingAccount("123456");
		assertEquals("Municipality" , acc.getBillingCompanyName());
		acc.setBillingCompanyName("MTN");
		
		billingManager.updateCustomerBillingAccounts(acc);
		
		BillingAccount acc2 = billingManager.getBillingAccount("123456");
		assertEquals("MTN" , acc2.getBillingCompanyName());
		
	} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}		
}
}
