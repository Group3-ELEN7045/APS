package test.za.ac.wits.elen7045.group3.ebilling.tests;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import test.za.ac.wits.elen7045.group3.mock.proxy.APSMockObjectGenerator;
import za.ac.wits.elen7045.group3.aps.domain.BillingAccountDataAccess;
import za.ac.wits.elen7045.group3.aps.domain.UserDataAccess;
import za.ac.wits.elen7045.group3.aps.domain.accounts.repository.BillingAccountRepository;
import za.ac.wits.elen7045.group3.aps.domain.accounts.repository.BillingAccountRepositoryImpl;
import za.ac.wits.elen7045.group3.aps.domain.accounts.statement.TelcoStatement;
import za.ac.wits.elen7045.group3.aps.domain.entities.BillingAccountStatement;

import za.ac.wits.elen7045.group3.aps.domain.repository.user.CustomerRepository;
import za.ac.wits.elen7045.group3.aps.services.dto.BillingAccountDTO;
import za.ac.wits.elen7045.group3.aps.services.dto.CredentialsDTO;
import za.ac.wits.elen7045.group3.aps.services.dto.CustomerDTO;
import za.ac.wits.elen7045.group3.aps.services.managers.BillingAccountManager;
import za.ac.wits.elen7045.group3.aps.services.managers.BillingAccountManagerImpl;
import za.ac.wits.elen7045.group3.aps.services.managers.BillingAccountStatementManager;
import za.ac.wits.elen7045.group3.aps.services.managers.BillingAccountStatementManagerImpl;
import za.ac.wits.elen7045.group3.aps.services.managers.UserManager;
import za.ac.wits.elen7045.group3.aps.services.managers.UserManagerImpl;
import za.ac.wits.elen7045.group3.aps.services.security.EncryptionModule;
import za.ac.wits.elen7045.group3.aps.services.specification.ApplicationSpecification;
import za.ac.wits.elen7045.group3.aps.services.specification.credentials.BillingAccountDetailsSpecification;



import test.za.ac.wits.elen7045.group3.mock.proxy.APSMockObjectGenerator;
import za.ac.wits.elen7045.aps.domain.statement.repository.BillingAccountStatementRepositoryImpl;
import za.ac.wits.elen7045.group3.aps.domain.BillingAccountStatementDataAccess;
import za.ac.wits.elen7045.group3.aps.domain.UserDataAccess;
import za.ac.wits.elen7045.group3.aps.domain.accounts.repository.BillingAccountRepository;
import za.ac.wits.elen7045.group3.aps.domain.accounts.repository.BillingAccountRepositoryImpl;
import za.ac.wits.elen7045.group3.aps.domain.accounts.statement.MunicipalStatement;
import za.ac.wits.elen7045.group3.aps.domain.accounts.statement.TelcoStatement;
import za.ac.wits.elen7045.group3.aps.domain.entities.BillingAccount;
import za.ac.wits.elen7045.group3.aps.domain.entities.BillingAccountStatement;
import za.ac.wits.elen7045.group3.aps.domain.entities.Customer;
import za.ac.wits.elen7045.group3.aps.domain.entities.User;
import za.ac.wits.elen7045.group3.aps.domain.repository.user.CustomerRepository;
import za.ac.wits.elen7045.group3.aps.domain.repository.user.CustomerRepositoryImpl;
import za.ac.wits.elen7045.group3.aps.services.dto.CapturedCredentialsDTO;
import za.ac.wits.elen7045.group3.aps.services.dto.CredentialsDTO;
import za.ac.wits.elen7045.group3.aps.services.dto.CustomerDTO;
import za.ac.wits.elen7045.group3.aps.services.exception.DatabaseException;
import za.ac.wits.elen7045.group3.aps.services.managers.BillingAccountManager;
import za.ac.wits.elen7045.group3.aps.services.managers.BillingAccountManagerImpl;
import za.ac.wits.elen7045.group3.aps.services.managers.UserManagerImpl;
import za.ac.wits.elen7045.group3.aps.services.security.EncryptionModule;
import za.ac.wits.elen7045.group3.aps.services.specification.ApplicationSpecification;
import za.ac.wits.elen7045.group3.aps.services.specification.credentials.BillingAccountDetailsSpecification;
import za.ac.wits.elen7045.group3.aps.services.util.ApplicationContants;
import za.ac.wits.elen7045.group3.aps.services.util.DateUtil;

public class TestViewStatement {

		private CustomerDTO customer;
		private BillingAccountDTO           billingAccountDTO;
		private ApplicationContext          context;	
		private BillingAccountRepository    billingAccountRepository;
		private BillingAccountManager	    billingAccountManager;
		private BillingAccountManagerImpl   billingAccountManagerImpl;
		private UserManager	                userManager;
		private UserManagerImpl             userManagerImpl;
		private EncryptionModule            encryptionModule;
		private CustomerRepository          customerRepository;
		private CredentialsDTO              userCredenials;

		@Before
		public void init(){
		    context                = new  ClassPathXmlApplicationContext("res/spring/application-context-test.xml");
			customer               = context.getBean(CustomerDTO.class);
			userCredenials         = new CredentialsDTO();
			encryptionModule       = context.getBean(EncryptionModule.class);
			billingAccountRepository     = context.getBean(BillingAccountRepository.class);		    
			billingAccountManagerImpl  = new BillingAccountManagerImpl(billingAccountRepository);
			billingAccountManager      = new APSMockObjectGenerator<BillingAccountManagerImpl>().mock(billingAccountManagerImpl);
			customerRepository     = context.getBean(CustomerRepository.class);
			
			customer.setEncryptionModule(encryptionModule);
			
			userManagerImpl  = new UserManagerImpl(customerRepository);
		    userManager      = new APSMockObjectGenerator<UserManagerImpl>().mock(userManagerImpl);
		    
		    billingAccountManagerImpl  = new BillingAccountManagerImpl(billingAccountRepository);
		    billingAccountManager      = new APSMockObjectGenerator<BillingAccountManagerImpl>().mock(billingAccountManagerImpl);
	    }	
	
		 @Test
		 public void testSaveBillingAccountStatement() {
		 try {	
				 
			 BillingAccountStatementManager statManager = new BillingAccountStatementManagerImpl();
			 BillingAccountStatement statement = new TelcoStatement();
			 statement.setAccountNumber("34566");
			 statement.setAccountClosingBalance("R5000");
			 statement.setAccountStatementMonth("June");
			 statement.setAccountDiscount("R23");
			 statement.setAccountNumber("1234");
			 statManager.saveBillingAccountStatement(statement);
			 
			 BillingAccountStatementManager statManager2 = new BillingAccountStatementManagerImpl();
			 BillingAccountStatement statement2 = new MunicipalStatement();
			 statement.setAccountNumber("34566");
			 statement.setAccountClosingBalance("R5000");
			 statement.setAccountStatementMonth("June");
			 statement.setAccountDiscount("R23");
			 
			 statManager2.saveBillingAccountStatement(statement2);
			 
			 BillingAccountStatementManager statManager3 = new BillingAccountStatementManagerImpl();
			 BillingAccountStatement statement3 = new MunicipalStatement();
			 statement.setAccountNumber("34566");
			 statement.setAccountClosingBalance("R5000");
			 statement.setAccountStatementMonth("June");
			 statement.setAccountDiscount("R23");
			
			 statManager3.saveBillingAccountStatement(statement3);
			 		
			 List<BillingAccountStatement> statement1 = statManager.getBillingAccountStatements("1234", "June");
			 assertEquals(1, statement1.size());
					 
		 } catch (Exception e) {
		 // TODO Auto-generated catch block
		 e.printStackTrace();
		 }
		}
		 
//		 @Test
//		 public void testgetBillingAccountsByCompanyName() {
//		 try {
//			 
//			 //Tests for billing account search
//			 BillingAccountDTO insertedBillingAccount = billingAccountManager.getBillingAccount("12345");
////			 assertEquals("www.credit.co.za", insertedBillingAccount.getCompanyUrl() );
//			 String url = "www.credit.co.za";
//			 List<BillingAccountDTO> updateBillingAccount = billingAccountManager.getBillingAccountsByCompanyName(url);
//			 assertEquals(1, updateBillingAccount.size() );		 
//		 } catch (Exception e) {
//		 // TODO Auto-generated catch block
//		 e.printStackTrace();
//		 }
//		}
		 
//		 @Test
//		 public void testgetBillingAccountsStatements() {
//		 try {
	//
//			 userCredenials.setUserName("userName");
//		     userCredenials.setPassword("password");
//		     CustomerDTO authenticationCustomer = userManager.getCustomer(userCredenials);
//			assertTrue(authenticationCustomer != null);
//			
//			String period = "june";
//			List<BillingAccountDTO> updateBillingAccount = billingAccountManager.getBillingAccountStatementByAccountNumberAndPeriod(authenticationCustomer, period);
//			assertEquals(1, updateBillingAccount.size() );	
//			 for(BillingAccountDTO billingAcc : updateBillingAccount){
//				 
//			 }
//		 } catch (Exception e) {
//		 // TODO Auto-generated catch block
//		 e.printStackTrace();
//		 }
//		}
		 
	}

//	 @Test
//	 public void testViewBillingAccountStatement() {
//	 try {	 	 
//	 BillingAccountManager billingManager = new BillingAccountManagerImpl(billingAccountRepository);	 
//	 billingManager.addCustomerBillingAccounts(billingAccount);
//	 BillingAccount billAccount = billingManager.getBillingStatement("12345", "June");
//	 //AbstractBillingAccountStatement = statement = billAccount.getBillingStatement();
//	 for(AbstractBillingAccountStatement statement : billAccount.getBillingStatement()){
//		 System.out.println("Account Number : " + billAccount.getAccountNumber());
//		 System.out.println("Account Type : " + billAccount.getBillingCompanyName());
//		 System.out.println("Statement Number : " + statement.getAccountNumber());
//		 System.out.println("Closing Balance : " + statement.getAccountClosingBalance());
//		 System.out.println("Amount Deducted : " + statement.getAccountDeductions());
//		 System.out.println("Account Holder : " + statement.getAccountHolderName());
//		 System.out.println("Statement Period: " + statement.getAccountStatementMonth());
//	 }
//	 assertEquals(1,  billAccount.getBillingStatement().size()); 
//	
//	 } catch (Exception e) {
//	 // TODO Auto-generated catch block
//	 e.printStackTrace();
//	 }
//	 }
//	 
//	 @Test
//	 public void testUserAddBillingAccountStatement() {
//	 try {	 	 
//	 BillingAccountManager billingManager = new BillingAccountManagerImpl(billingAccountRepository);	 
//	 billingManager.addCustomerBillingAccounts(billingAccount2);
//	 BillingAccount billAccount = billingManager.getBillingStatement("45454", "August");
//	 //AbstractBillingAccountStatement = statement = billAccount.getBillingStatement();
//	 for(AbstractBillingAccountStatement statement : billAccount.getBillingStatement()){
//		 System.out.println("Account Number : " + billAccount.getAccountNumber());
//		 System.out.println("Account Type : " + billAccount.getBillingCompanyName());
//		 System.out.println("Statement Number : " + statement.getAccountNumber());
//		 System.out.println("Closing Balance : " + statement.getAccountClosingBalance());
//		 System.out.println("Amount Deducted : " + statement.getAccountDeductions());
//		 System.out.println("Account Holder : " + statement.getAccountHolderName());
//		 System.out.println("Statement Period: " + statement.getAccountStatementMonth());
//	 }
//	 assertEquals(1,  billAccount.getBillingStatement().size()); 
//	
//	 } catch (Exception e) {
//	 // TODO Auto-generated catch block
//	 e.printStackTrace();
//	 }
//	 }
//	 
//*/}

