package test.za.ac.wits.elen7045.group3.login.tests;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

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
import za.ac.wits.elen7045.group3.aps.domain.vo.CapturedCredentialsVO;
import za.ac.wits.elen7045.group3.aps.domain.vo.ContactDetailsVO;
import za.ac.wits.elen7045.group3.aps.domain.vo.CredentialsVO;
import za.ac.wits.elen7045.group3.aps.domain.vo.PaymentDetailsVO;
import za.ac.wits.elen7045.group3.aps.services.enumtypes.PaymentType;
import za.ac.wits.elen7045.group3.aps.services.exception.DatabaseException;
import za.ac.wits.elen7045.group3.aps.services.managers.BillingAccountManager;
import za.ac.wits.elen7045.group3.aps.services.managers.BillingAccountManagerImpl;
import za.ac.wits.elen7045.group3.aps.services.security.EncryptionModule;
import za.ac.wits.elen7045.group3.aps.services.security.EncryptionModuleImpl;
import za.ac.wits.elen7045.group3.aps.services.specification.ApplicationSpecification;
import za.ac.wits.elen7045.group3.aps.services.specification.Specification;
import za.ac.wits.elen7045.group3.aps.services.specification.credentials.AuthenticationSpecification;
import za.ac.wits.elen7045.group3.aps.services.specification.credentials.BillingAccountDetailsSpecification;
import za.ac.wits.elen7045.group3.aps.services.specification.credentials.CapturedCredentialsSpecification;
import za.ac.wits.elen7045.group3.aps.services.specification.user.EncryptedUserInformationSpecification;
import za.ac.wits.elen7045.group3.aps.services.util.ApplicationContants;
import za.ac.wits.elen7045.group3.aps.services.util.DateUtil;
import za.ac.wits.elen7045.group3.aps.services.validation.LogonManagerImpl;

public class testAddBillingAccounts {
	private Customer customer;	
	private ApplicationContext context;
	private UserDataAccess userDataRepository;	
	private CustomerRepositoryImpl mockUserDataAccess;
	private CustomerRepository customerRepository;	
	private EncryptionModule encryptionModule;	
	private CapturedCredentialsVO credentials;	
	BillingAccountRepositoryImpl billingAccountRepository;
	BillingAccount billingAccount ;

	@Before
	public void init() {
		context = new ClassPathXmlApplicationContext("res/spring/application-context-test.xml");
		customer = context.getBean(Customer.class);
		
		userDataRepository = context.getBean(UserDataAccess.class);
		encryptionModule = context.getBean(EncryptionModule.class);		
		credentials = context.getBean(CapturedCredentialsVO.class);
		billingAccountRepository = context.getBean(BillingAccountRepositoryImpl.class);		

		customer.setId((long) 1);
		customer.setFirstName("John");
		customer.setLastname("Smith");
		customer.setDateOfBirth(DateUtil.formatDate(ApplicationContants.DATE_OF_BIRTH_FORMAT, "12/12/1979"));

		credentials.setUserName("username");
		credentials.setPassword("password");
		credentials.setConfirmPasword("password");
		credentials.setEncryptionModule(encryptionModule);
		credentials.encryptCredentials();
		customer.setCredentials(credentials);
		
		billingAccount = new BillingAccount("12345");
		billingAccount.setCustomerId(customer.getId());
		billingAccount.setBillingCompanyName("Telcom");
		billingAccount.setCredentials(credentials);
				
		mockUserDataAccess = new CustomerRepositoryImpl(userDataRepository);
		customerRepository = new APSMockObjectGenerator<CustomerRepositoryImpl>().mock(mockUserDataAccess);		
	}


	@Test
	// test if insertion happened successfull
	public void testRegisterUser() {
		try {
			customerRepository.updateUser(customer);
			User insertedUser = customerRepository.selectCustomer(customer);
			assertNotNull("Failed to Insert User", insertedUser);
		} catch (DatabaseException ex) {
		}
	}
	
	@Test
	 public void tetBillingAccountFields() {
	 try {	 	 
		 ApplicationSpecification<BillingAccount> userBillingAccountDetails = new BillingAccountDetailsSpecification(
					billingAccount);
		 assertTrue(userBillingAccountDetails.isSatisfiedBy(billingAccount));
	
	 } catch (Exception e) {
		 // TODO Auto-generated catch block
		 e.printStackTrace();
		 }
	 }
	
	 @Test
	 public void testUserAddBillingAccount() {
	 try {	 	 
	 BillingAccountManager billingManager = new BillingAccountManagerImpl(billingAccountRepository);	 
	 billingManager.addCustomerBillingAccounts(billingAccount);
	 BillingAccount billAccount = billingManager.getBillingAccount("123459");
	 assertNotNull(" Fail to import Billing Account ", billAccount); 
	
	 } catch (Exception e) {
	 // TODO Auto-generated catch block
	 e.printStackTrace();
	 }
	 }
	 
}
