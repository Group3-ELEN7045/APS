package test.za.ac.wits.elen7045.group3.login.tests;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import test.za.ac.wits.group3.mock.proxy.APSMockObjectGenerator;
import za.ac.wits.elen7045.group3.aps.domain.BillingAccountDataAccess;
import za.ac.wits.elen7045.group3.aps.domain.UserDataAccess;
import za.ac.wits.elen7045.group3.aps.domain.accounts.repository.BillingAccountRepository;
import za.ac.wits.elen7045.group3.aps.domain.accounts.repository.BillingAccountRepositoryImpl;
import za.ac.wits.elen7045.group3.aps.domain.entities.BillingAccount;
import za.ac.wits.elen7045.group3.aps.domain.entities.Customer;
import za.ac.wits.elen7045.group3.aps.domain.entities.User;
import za.ac.wits.elen7045.group3.aps.domain.repository.user.CustomerRepository;
import za.ac.wits.elen7045.group3.aps.domain.repository.user.CustomerRepositoryImpl;
import za.ac.wits.elen7045.group3.aps.domain.vo.CredentialsVO;
import za.ac.wits.elen7045.group3.aps.domain.vo.CapturedCredentialsVO;
import za.ac.wits.elen7045.group3.aps.domain.vo.PaymentDetailsVO;
import za.ac.wits.elen7045.group3.aps.services.enumtypes.PaymentType;
import za.ac.wits.elen7045.group3.aps.services.enumtypes.AccountStatusType;
import za.ac.wits.elen7045.group3.aps.services.exception.DatabaseException;
import za.ac.wits.elen7045.group3.aps.services.managers.BillingAccountManager;
import za.ac.wits.elen7045.group3.aps.services.managers.BillingAccountManagerImpl;
import za.ac.wits.elen7045.group3.aps.services.security.EncryptionModule;
import za.ac.wits.elen7045.group3.aps.services.security.EncryptionModuleImpl;
import za.ac.wits.elen7045.group3.aps.services.specification.ApplicationSpecification;
import za.ac.wits.elen7045.group3.aps.services.specification.credentials.BillingAccountDetailsSpecification;
import za.ac.wits.elen7045.group3.aps.services.specification.user.UserAuthenticationSpecification;
import za.ac.wits.elen7045.group3.aps.services.util.ApplicationContants;
import za.ac.wits.elen7045.group3.aps.services.util.DateUtil;
import za.ac.wits.elen7045.group3.aps.services.validation.LogonService;

public class testUserLogin {
	private Customer customer;	
	private ApplicationContext context;
	private UserDataAccess userDataRepository;	
	private CustomerRepositoryImpl mockUserDataAccess;
	private CustomerRepository customerRepository;
	private PaymentDetailsVO paymentDetails;
	private EncryptionModule encryptionModule;	
	private CapturedCredentialsVO credentials;	
	
	@Before
	public void init() {
		context = new ClassPathXmlApplicationContext(
				"res/spring/application-context-test.xml");
		customer = context.getBean(Customer.class);		
		userDataRepository = context.getBean(UserDataAccess.class);
		encryptionModule = context.getBean(EncryptionModule.class);
		paymentDetails = context.getBean(PaymentDetailsVO.class);
		credentials = context.getBean(CapturedCredentialsVO.class);		
		

		customer.setId((long) 1);
		customer.setFirstName("Silas");
		customer.setLastname("Mahlangu");
		customer.setDateOfBirth(DateUtil.formatDate(
				ApplicationContants.DATE_OF_BIRTH_FORMAT, "12/12/1979"));

		credentials.setUserName("username");
		credentials.setPassword("password");
		credentials.setConfirmPasword("password");
		credentials.setEncryptionModule(encryptionModule);
		credentials.encryptCredentials();
		customer.setCredentials(credentials);

		paymentDetails.setPaymentType(PaymentType.CREDIT_CARD.getPaymentType());
		paymentDetails.setValue("1234 1234 5678 5678");
		customer.setPaymentDetails(paymentDetails);

		mockUserDataAccess = new CustomerRepositoryImpl(userDataRepository);
		customerRepository = new APSMockObjectGenerator<CustomerRepositoryImpl>()
				.mock(mockUserDataAccess);
		
		try {
			customerRepository.updateUser(customer);
		} catch (DatabaseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}


	@Test
	// test if insertion happened successfull
	public void testRegisterUser() {
		try {		
			User insertedUser = customerRepository.selectCustomer(customer);
			assertNotNull("Failed to Insert User", insertedUser);
		} catch (DatabaseException ex) {
		}
	}
	
	@Test
	// test if insertion happened successfull
	public void testCredentials() {
		try {
		User insertedUser = customerRepository.selectCustomer(customer);
		CredentialsVO insertedCredentials = insertedUser.getCredentials();
		
		CredentialsVO cred = new CredentialsVO();
		cred.setUserName("username");
		cred.setPassword("password");
		EncryptionModule encryptionModule = new EncryptionModuleImpl();
		cred.setEncryptionModule(encryptionModule);
		cred.encryptCredentials();
		
		ApplicationSpecification<CredentialsVO> userAuthenticationSpec = new UserAuthenticationSpecification(insertedCredentials);
		 assertTrue(userAuthenticationSpec.isSatisfiedBy(cred));
		} catch (DatabaseException ex) {
		}
	}	

	@Test
	public void testUserValidationAndAuthenitation() {
		try {			
			CredentialsVO cred = new CredentialsVO();
			cred.setUserName("username");
			cred.setPassword("password");
			EncryptionModule encryptionModule = new EncryptionModuleImpl();
			cred.setEncryptionModule(encryptionModule);
			cred.encryptCredentials();

			User insertedUser = customerRepository.selectCustomer(customer);			
			assertNotNull("Failed to Insert User", insertedUser);
			assertTrue(new LogonService(customerRepository).validation(cred));
		} catch (Exception e) {			
		e.printStackTrace();
		}
	}	 
}
