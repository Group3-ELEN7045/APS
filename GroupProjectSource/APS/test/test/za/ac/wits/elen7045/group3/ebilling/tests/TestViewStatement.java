package test.za.ac.wits.elen7045.group3.ebilling.tests;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import test.za.ac.wits.elen7045.group3.mock.proxy.APSMockObjectGenerator;
import za.ac.wits.elen7045.group3.aps.domain.UserDataAccess;
import za.ac.wits.elen7045.group3.aps.domain.accounts.statement.TelcoStatement;
import za.ac.wits.elen7045.group3.aps.domain.entities.BillingAccountStatement;
import za.ac.wits.elen7045.group3.aps.domain.repository.accounts.BillingAccountRepository;
import za.ac.wits.elen7045.group3.aps.domain.repository.statement.StatementRepository;
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
import za.ac.wits.elen7045.group3.aps.domain.accounts.statement.MunicipalStatement;


public class TestViewStatement {

		private CustomerDTO customer;
		private BillingAccountDTO                  billingAccountDTO;
		private ApplicationContext                 context;	
		private StatementRepository                statementRepository;
		private BillingAccountStatementManager     billingAccountstatementManager;
		private BillingAccountStatementManagerImpl billingAccountStatementManagerImpl;
		private UserManager	                       userManager;
		private UserManagerImpl                    userManagerImpl;
		private EncryptionModule                   encryptionModule;
		private CustomerRepository                 customerRepository;
		private CredentialsDTO                     userCredenials;
		
		private BillingAccountRepository           billingAccountRepository;
		private BillingAccountManagerImpl          billingAccountManagerImpl;
		private BillingAccountManager              billingAccountManager; 

		@Before
		public void init(){
		    context                            = new  ClassPathXmlApplicationContext("res/spring/application-context-test.xml");
			customer                           = context.getBean(CustomerDTO.class);
			userCredenials                     = new CredentialsDTO();
			encryptionModule                   = context.getBean(EncryptionModule.class);
			statementRepository                = context.getBean(StatementRepository.class);		    
			billingAccountStatementManagerImpl = new BillingAccountStatementManagerImpl(statementRepository);
			billingAccountstatementManager     = new APSMockObjectGenerator<BillingAccountStatementManagerImpl>().mock(billingAccountStatementManagerImpl);
			customerRepository                 = context.getBean(CustomerRepository.class);
			
			customer.setEncryptionModule(encryptionModule);
			
			userManagerImpl  = new UserManagerImpl(customerRepository);
		    userManager      = new APSMockObjectGenerator<UserManagerImpl>().mock(userManagerImpl);
		    
		    billingAccountRepository   = context.getBean(BillingAccountRepository.class);
		    billingAccountManagerImpl  = new BillingAccountManagerImpl(billingAccountRepository);
		    billingAccountManager      = new APSMockObjectGenerator<BillingAccountManagerImpl>().mock(billingAccountManagerImpl);
	    }	
	
		 @Test
		 public void testSaveBillingAccountStatement() {
		 try {	
				 
			
			 BillingAccountStatement statement = new TelcoStatement("1");
			 statement.setAccountNumber("1");
			 statement.setAccountClosingBalance("R5000");
			 statement.setAccountStatementMonth("June");
			 statement.setAccountDiscount("R23");
			 statement.setAccountNumber("1234");
			 billingAccountstatementManager.addStatement(statement); 		
			 List<BillingAccountStatement> statement1 =billingAccountstatementManager.getAccountStatement("1"); //statManager.getBillingAccountStatements("1234", "June");
			 assertEquals(1, statement1.size());
					 
		 } catch (Exception e) {
		 	 e.printStackTrace();
	     }
     }	
}

