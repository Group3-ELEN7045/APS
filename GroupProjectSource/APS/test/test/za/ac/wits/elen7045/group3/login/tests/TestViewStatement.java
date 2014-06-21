package test.za.ac.wits.elen7045.group3.login.tests;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import test.za.ac.wits.group3.mock.proxy.APSMockObjectGenerator;
import za.ac.wits.elen7045.group3.aps.domain.UserDataAccess;
import za.ac.wits.elen7045.group3.aps.domain.accounts.abtracts.AbstractBillingAccountStatement;
import za.ac.wits.elen7045.group3.aps.domain.accounts.repository.BillingAccountRepositoryImpl;
import za.ac.wits.elen7045.group3.aps.domain.accounts.statement.MunicipalStatement;
import za.ac.wits.elen7045.group3.aps.domain.accounts.statement.TelcoStatement;
import za.ac.wits.elen7045.group3.aps.domain.entities.BillingAccount;
import za.ac.wits.elen7045.group3.aps.domain.entities.Customer;
import za.ac.wits.elen7045.group3.aps.domain.entities.User;
import za.ac.wits.elen7045.group3.aps.domain.repository.user.CustomerRepository;
import za.ac.wits.elen7045.group3.aps.domain.repository.user.CustomerRepositoryImpl;
import za.ac.wits.elen7045.group3.aps.services.dto.CapturedCredentialsDTO;
import za.ac.wits.elen7045.group3.aps.services.exception.DatabaseException;
import za.ac.wits.elen7045.group3.aps.services.managers.BillingAccountManager;
import za.ac.wits.elen7045.group3.aps.services.managers.BillingAccountManagerImpl;
import za.ac.wits.elen7045.group3.aps.services.security.EncryptionModule;
import za.ac.wits.elen7045.group3.aps.services.specification.ApplicationSpecification;
import za.ac.wits.elen7045.group3.aps.services.specification.credentials.BillingAccountDetailsSpecification;
import za.ac.wits.elen7045.group3.aps.services.util.ApplicationContants;
import za.ac.wits.elen7045.group3.aps.services.util.DateUtil;

public class TestViewStatement {/*
	private Customer customer;	
	private ApplicationContext context;
	private UserDataAccess userDataRepository;	
	private CustomerRepositoryImpl mockUserDataAccess;
	private CustomerRepository customerRepository;	
	private EncryptionModule encryptionModule;	
	private CapturedCredentialsDTO credentials;	
	BillingAccountRepositoryImpl billingAccountRepository;
	BillingAccount billingAccount ;
	BillingAccount billingAccount2;
	AbstractBillingAccountStatement billingStatement;

	@Before
	public void init() {
		context = new ClassPathXmlApplicationContext("res/spring/application-context-test.xml");
		customer = context.getBean(Customer.class);
		
		userDataRepository = context.getBean(UserDataAccess.class);
		encryptionModule = context.getBean(EncryptionModule.class);		
		credentials = context.getBean(CapturedCredentialsDTO.class);
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
		
		billingAccount = new BillingAccount();
		billingAccount.setAccountNumber("12345");
		billingAccount.setCustomerId(customer.getId());
		billingAccount.setBillingCompanyName("Telcom");
		billingAccount.setCredentials(credentials);
		
		BillingAccount billingAccount2 = new BillingAccount();
		billingAccount2 = new BillingAccount();
		billingAccount2.setAccountNumber("45454");
		billingAccount2.setCustomerId(customer.getId());
		billingAccount2.setBillingCompanyName("Municipal");
		billingAccount2.setCredentials(credentials);
		
		billingStatement = new TelcoStatement("987654321");
		billingStatement.setAccountClosingBalance("R2000");
		billingStatement.setAccountDeductions("R10");
		billingStatement.setAccountNumber("987654321");
		billingStatement.setAccountHolderName("Khaya");
		billingStatement.setAccountStatementMonth("June");
		
		billingAccount.addBillingAccountStatament(billingStatement);
		
		billingStatement = new MunicipalStatement("987654321");
		billingStatement.setAccountClosingBalance("R4560");
		billingStatement.setAccountDeductions("R156");
		billingStatement.setAccountNumber("78655465");
		billingStatement.setAccountHolderName("Khaya");
		billingStatement.setAccountStatementMonth("August");
		billingAccount2.addBillingAccountStatament(billingStatement);
				
		mockUserDataAccess = new CustomerRepositoryImpl(userDataRepository);
		customerRepository = new APSMockObjectGenerator<CustomerRepositoryImpl>().mock(mockUserDataAccess);		
	}
	
	 @Test
	 public void testUserAddBillingAccount() {
	 try {	 	 
	 BillingAccountManager billingManager = new BillingAccountManagerImpl(billingAccountRepository);	 
	 billingManager.addCustomerBillingAccounts(billingAccount);
	 BillingAccount billAccount = billingManager.getBillingAccount("12345");
	 assertNotNull(" Fail to import Billing Account ", billAccount); 
	
	 } catch (Exception e) {
	 // TODO Auto-generated catch block
	 e.printStackTrace();
	 }
	 }
	 
	 @Test
	 public void testViewBillingAccountStatement() {
	 try {	 	 
	 BillingAccountManager billingManager = new BillingAccountManagerImpl(billingAccountRepository);	 
	 billingManager.addCustomerBillingAccounts(billingAccount);
	 BillingAccount billAccount = billingManager.getBillingStatement("12345", "June");
	 //AbstractBillingAccountStatement = statement = billAccount.getBillingStatement();
	 for(AbstractBillingAccountStatement statement : billAccount.getBillingStatement()){
		 System.out.println("Account Number : " + billAccount.getAccountNumber());
		 System.out.println("Account Type : " + billAccount.getBillingCompanyName());
		 System.out.println("Statement Number : " + statement.getAccountNumber());
		 System.out.println("Closing Balance : " + statement.getAccountClosingBalance());
		 System.out.println("Amount Deducted : " + statement.getAccountDeductions());
		 System.out.println("Account Holder : " + statement.getAccountHolderName());
		 System.out.println("Statement Period: " + statement.getAccountStatementMonth());
	 }
	 assertEquals(1,  billAccount.getBillingStatement().size()); 
	
	 } catch (Exception e) {
	 // TODO Auto-generated catch block
	 e.printStackTrace();
	 }
	 }
	 
	 @Test
	 public void testUserAddBillingAccountStatement() {
	 try {	 	 
	 BillingAccountManager billingManager = new BillingAccountManagerImpl(billingAccountRepository);	 
	 billingManager.addCustomerBillingAccounts(billingAccount2);
	 BillingAccount billAccount = billingManager.getBillingStatement("45454", "August");
	 //AbstractBillingAccountStatement = statement = billAccount.getBillingStatement();
	 for(AbstractBillingAccountStatement statement : billAccount.getBillingStatement()){
		 System.out.println("Account Number : " + billAccount.getAccountNumber());
		 System.out.println("Account Type : " + billAccount.getBillingCompanyName());
		 System.out.println("Statement Number : " + statement.getAccountNumber());
		 System.out.println("Closing Balance : " + statement.getAccountClosingBalance());
		 System.out.println("Amount Deducted : " + statement.getAccountDeductions());
		 System.out.println("Account Holder : " + statement.getAccountHolderName());
		 System.out.println("Statement Period: " + statement.getAccountStatementMonth());
	 }
	 assertEquals(1,  billAccount.getBillingStatement().size()); 
	
	 } catch (Exception e) {
	 // TODO Auto-generated catch block
	 e.printStackTrace();
	 }
	 }
	 
*/}

