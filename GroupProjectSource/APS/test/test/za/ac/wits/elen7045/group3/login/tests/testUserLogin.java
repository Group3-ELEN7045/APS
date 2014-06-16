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
import za.ac.wits.elen7045.group3.aps.domain.vo.LogonCredentialsVO;
import za.ac.wits.elen7045.group3.aps.domain.vo.PaymentDetailsVO;
import za.ac.wits.elen7045.group3.aps.services.enumtypes.PaymentType;
import za.ac.wits.elen7045.group3.aps.services.enumtypes.StatusType;
import za.ac.wits.elen7045.group3.aps.services.exception.DatabaseException;
import za.ac.wits.elen7045.group3.aps.services.managers.BillingAccountManager;
import za.ac.wits.elen7045.group3.aps.services.managers.BillingAccountManagerImpl;
import za.ac.wits.elen7045.group3.aps.services.security.EncryptionModule;
import za.ac.wits.elen7045.group3.aps.services.security.EncryptionModuleImpl;
import za.ac.wits.elen7045.group3.aps.services.util.ApplicationContants;
import za.ac.wits.elen7045.group3.aps.services.util.DateUtil;
import za.ac.wits.elen7045.group3.aps.services.validation.LogonService;

public class testUserLogin {
	private Customer customer;
	// private LogonCredentials logonCredentials;
	private ApplicationContext context;
	private UserDataAccess userDataRepository;
	// private UserDataAccess userDataRepository;
	private CustomerRepositoryImpl mockUserDataAccess;
	private CustomerRepository customerRepository;
	private PaymentDetailsVO paymentDetails;
	private EncryptionModule encryptionModule;
	// private CredentialsVO credentialVO;
	private LogonCredentialsVO credentials;
	private LogonService logonUserValidation;
	private BillingAccountRepository billingAccountRepository;
	private BillingAccountRepositoryImpl billingAccountD;
	private BillingAccountDataAccess billingDataAccess;

	@Before
	public void init() {
		context = new ClassPathXmlApplicationContext(
				"res/spring/application-context-test.xml");
		customer = context.getBean(Customer.class);
		// logonCredentials = context.getBean(LogonCredentials.class);
		userDataRepository = context.getBean(UserDataAccess.class);
		encryptionModule = context.getBean(EncryptionModule.class);
		paymentDetails = context.getBean(PaymentDetailsVO.class);
		credentials = context.getBean(LogonCredentialsVO.class);
		billingAccountRepository = context
				.getBean(BillingAccountRepositoryImpl.class);
		billingDataAccess = context.getBean(BillingAccountDataAccess.class);

		customer.setId((long) 1);
		customer.setFirstName("Silas");
		customer.setLastname("Mahlangu");
		customer.setDateOfBirth(DateUtil.formatDate(
				ApplicationContants.DATE_OF_BIRTH_FORMAT, "12/12/1979"));

		credentials.setUserName("username");
		credentials.setPassword("password");
		credentials.setConfirmPasword("password1");
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
	
	@After
	public void clearDB(){
		try {
			customerRepository.clearData(customer);
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
			assertTrue(new LogonService(customerRepository)
					.validation(cred));
		} catch (Exception e) {			
			e.printStackTrace();
		}
	}	

	 @Test
	 public void testUserAddBillingAccount() {
	 try {	
	 // ----------------------testAddBillingAccounts------------------------
	 List<BillingAccount> accountList = new ArrayList<BillingAccount>();
	 
	 CredentialsVO cred = new CredentialsVO();
	 cred.setUserName("username");
	 cred.setPassword("password");
	 
	 CredentialsVO cred2 = new CredentialsVO();
	 cred2.setUserName("kaka");
	 cred2.setPassword("password123");
	 
	 BillingAccount billingAccount = new BillingAccount();
	 billingAccount.setAccountNumber("12345");
	 billingAccount.setAccountStatus(StatusType.TRYING.getStatusType());
	 billingAccount.setBillingCompanyName("Telcom");
	 billingAccount.setCredentials(cred);
	 accountList.add(billingAccount);
	
	 BillingAccount billingAccount2 = new BillingAccount();
	 billingAccount2.setAccountNumber("123456");
	 billingAccount2.setAccountStatus(StatusType.TRYING.getStatusType());
	 billingAccount2.setBillingCompanyName("Municipality");
	 billingAccount2.setCredentials(cred2);
	 accountList.add(billingAccount2);
	
	 BillingAccountManager billingManager = new BillingAccountManagerImpl(
	 customer, billingAccountRepository);
	 billingManager.addCustomerBillingAccounts(accountList);
	
	 Customer cust = customerRepository.selectCustomer(customer);
	 assertEquals(2, cust.getBillingAccounts().size());
	
	 BillingAccount acc = billingManager.getBillingAccount("123456");
	 assertEquals("Municipality", acc.getBillingCompanyName());
	
	 // ------------------TestUpdateBillingAccount----------------
	 acc.setBillingCompanyName("MTN");
	
	 billingManager.updateCustomerBillingAccounts(acc);
	
	 BillingAccount acc2 = billingManager.getBillingAccount("123456");
	 assertEquals("MTN", acc2.getBillingCompanyName());
	
	 // ------------------------------------------------------
	
	 } catch (Exception e) {
	 // TODO Auto-generated catch block
	 e.printStackTrace();
	 }
	 }
	 
	 @Test
		public void testUserViewStatements() {
			try {
				CredentialsVO cred = new CredentialsVO();
				cred.setUserName("username");
				cred.setPassword("password1");
				EncryptionModule encryptionModule = new EncryptionModuleImpl();
				cred.setEncryptionModule(encryptionModule);
				cred.encryptCredentials();
							
				new LogonService(customerRepository).validation(cred);
				fail("When credentilas are incorrect and execption is not throw");
			} catch (Exception e) {			
				e.printStackTrace();
			}
		}	 
	 
}
