<<<<<<< HEAD

package test.za.ac.wits.elen7045.group3.ebilling.tests;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import java.util.ArrayList;
import java.util.List;

import test.za.ac.wits.elen7045.group3.mock.proxy.APSMockObjectGenerator;
import za.ac.wits.elen7045.group3.aps.domain.BillingAccountDataAccess;
import za.ac.wits.elen7045.group3.aps.domain.UserDataAccess;
import za.ac.wits.elen7045.group3.aps.domain.accounts.statement.TelcoStatement;
import za.ac.wits.elen7045.group3.aps.domain.entities.BillingAccountStatement;

import za.ac.wits.elen7045.group3.aps.domain.repository.accounts.BillingAccountRepository;
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

import za.ac.wits.elen7045.aps.domain.statement.repository.BillingAccountStatementRepository;
import za.ac.wits.elen7045.aps.domain.statement.repository.BillingAccountStatementRepositoryImpl;
import za.ac.wits.elen7045.group3.aps.domain.accounts.statement.MunicipalStatement;

public class TestViewStatement {

		
		private ApplicationContext          	 context;	
		private BillingAccountStatementManager	 billingAccountStatementManager;
		private BillingAccountStatementManagerImpl   billingAccountStatementManagerImpl;
		private BillingAccountStatementRepository statementRepository;
		private UserManager	                	userManager;
		private UserManagerImpl             	userManagerImpl;
		private CustomerRepository          customerRepository;
		private CustomerDTO 				customer;
		private EncryptionModule            encryptionModule;	
		private CredentialsDTO              userCredenials;
		private BillingAccountRepository    billingAccountRepository;
		private BillingAccountManager	    billingAccountManager;
		private BillingAccountManagerImpl   billingAccountManagerImpl;
		
		@Before
		public void init(){
		    context               		 = new  ClassPathXmlApplicationContext("res/spring/application-context-test.xml");
			statementRepository    		 = context.getBean(BillingAccountStatementRepositoryImpl.class);		    
			customerRepository     		 = context.getBean(CustomerRepository.class);
			customer               		 = context.getBean(CustomerDTO.class);
			userCredenials         		 = new CredentialsDTO();			
			encryptionModule       		 = context.getBean(EncryptionModule.class);
			
			customer.setEncryptionModule(encryptionModule);
			userManagerImpl  = new UserManagerImpl(customerRepository);
		    userManager      = new APSMockObjectGenerator<UserManagerImpl>().mock(userManagerImpl);
		    
		    billingAccountRepository     = context.getBean(BillingAccountRepository.class);		    
			
			billingAccountManagerImpl  = new BillingAccountManagerImpl(billingAccountRepository);
			billingAccountManager      = new APSMockObjectGenerator<BillingAccountManagerImpl>().mock(billingAccountManagerImpl);
			
		    billingAccountStatementManagerImpl  	= new BillingAccountStatementManagerImpl(statementRepository);
			billingAccountStatementManager     	 	= new APSMockObjectGenerator<BillingAccountStatementManagerImpl>().mock(billingAccountStatementManagerImpl);
		}
	
		 @Test
		 public void testSaveBillingAccountStatement() {
		 try {				 
			 
			 BillingAccountStatement statement = new TelcoStatement();
			 statement.setAccountNumber("34566");
			 statement.setAccountStatementNumber("1234");
			 statement.setAccountClosingBalance("R5000");
			 statement.setAccountStatementMonth("June");
			 statement.setAccountDiscount("R23");
			 statement.setAccountNumber("1234");
			 billingAccountStatementManagerImpl.saveBillingAccountStatement(statement);
			 
			 BillingAccountStatement statement2 = new MunicipalStatement();
			 statement.setAccountNumber("34566");
			 statement.setAccountStatementNumber("12345");
			 statement.setAccountClosingBalance("R5000");
			 statement.setAccountStatementMonth("June");
			 statement.setAccountDiscount("R23");
			 
			 billingAccountStatementManagerImpl.saveBillingAccountStatement(statement2);
			 
			 BillingAccountStatement statement3 = new MunicipalStatement();
			 statement.setAccountNumber("34566");
			 statement.setAccountStatementNumber("123456");
			 statement.setAccountClosingBalance("R5000");
			 statement.setAccountStatementMonth("June");
			 statement.setAccountDiscount("R23");
			 
			 billingAccountStatementManagerImpl.saveBillingAccountStatement(statement3);
			 		
			 BillingAccountStatement statement1 = (BillingAccountStatement) billingAccountStatementManagerImpl.getBillingAccountStatements("1234", "June");
			 assertNotNull("Billing Account not null" , statement1);
					 
		 } catch (Exception e) {
		 // TODO Auto-generated catch block
		 e.printStackTrace();
		 }
		}

	 @Test
	 public void testViewBillingAccountStatement() {
	 try {		 
		 customer.setFirstName("Samuel");		
		 userCredenials.setUserName("userName");
	     userCredenials.setPassword("password");
	     customer.setCredentials(userCredenials);
		 customer.setId(Long.valueOf(1));
		 CustomerDTO logedUser = userManager.selectCustomer(customer);
		 assertNotNull("Failed to Insert User" , logedUser);
		 
		 List<BillingAccountDTO> customereBillingAccounts = billingAccountManager.getBillingAcountsForCustomer(customer.getId());
		 assertEquals(1, customereBillingAccounts.size() );		 
		 
		 for(BillingAccountDTO billingAccounts : customereBillingAccounts){
			 String period = "June";
			 System.out.println("Account number " + billingAccounts.getAccountNumber());
			 BillingAccountStatement statement =(BillingAccountStatement) billingAccountStatementManagerImpl.getBillingAccountStatements(billingAccounts.getAccountNumber(), period);
				 System.out.println("Billing Account Number = " + statement.getAccountNumber());
				 System.out.println("Statement ID = " + statement.getId());
				 System.out.println("Statement Date = " + statement.getAccountStatementDate());
				 System.out.println("Statement Closing Balance = " + statement.getAccountClosingBalance());
				 System.out.println("Statement Discount = " + statement.getAccountDiscount());
				 System.out.println("Statement Period = " + statement.getAccountStatementMonth());
			 }
		
		 } catch (Exception e) {
		 // TODO Auto-generated catch block
		 e.printStackTrace();
	 }	 
	}	 
}


