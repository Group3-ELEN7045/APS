

package test.za.ac.wits.elen7045.group3.ebilling.tests;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import java.util.List;

import test.za.ac.wits.elen7045.group3.mock.proxy.APSMockObjectGenerator;
import za.ac.wits.elen7045.group3.aps.domain.accounts.statement.CreditCardStatement;
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
			 
			 BillingAccountStatement telcoStatement = new TelcoStatement();
			 telcoStatement.setAccountNumber("34566");
			 telcoStatement.setAccountDeductions("R30");
			 telcoStatement.setAccountDueDate("2014/06/26");
			 telcoStatement.setAccountHolderName("John");
			 telcoStatement.setAccountNewCharges("R26");
			 telcoStatement.setAccountOpeningBalance("R3000");
			 telcoStatement.setAccountPaymentReceived("R200");
			 telcoStatement.setAccountStatementDate("2014/06/20");
			 telcoStatement.setAccountTotalDue("R233");
			 telcoStatement.setAccountTotalDue("R230");
			 telcoStatement.setAccountDeductions("R328");
			 telcoStatement.setAccountVATAmount("R33");
			 telcoStatement.setAccountStatementNumber("1234");
			 telcoStatement.setAccountClosingBalance("R5000");
			 telcoStatement.setAccountStatementMonth("June");
			 telcoStatement.setAccountDiscount("R23");
			 
			 billingAccountStatementManagerImpl.saveBillingAccountStatement(telcoStatement);
			 
			  BillingAccountStatement telcoStat = 
					 (BillingAccountStatement) billingAccountStatementManagerImpl.getBillingAccountStatements(telcoStatement.getAccountNumber(), telcoStatement.getAccountStatementMonth());
				 assertNotNull("Billing Account not null" , telcoStat);
				 
			 BillingAccountStatement municipalStatement = new MunicipalStatement();
			 municipalStatement.setAccountNumber("14566");
			 municipalStatement.setAccountDeductions("R35");
			 municipalStatement.setAccountDueDate("2014/06/26");
			 municipalStatement.setAccountHolderName("John");
			 municipalStatement.setAccountNewCharges("R45");
			 municipalStatement.setAccountOpeningBalance("R3050");
			 municipalStatement.setAccountPaymentReceived("R250");
			 municipalStatement.setAccountStatementDate("2014/06/15");
			 municipalStatement.setAccountTotalDue("R435");
			 municipalStatement.setAccountTotalDue("R56");
			 municipalStatement.setAccountDeductions("R36");
			 municipalStatement.setAccountVATAmount("R40");
			 municipalStatement.setAccountStatementNumber("565656");
			 municipalStatement.setAccountClosingBalance("R670");
			 municipalStatement.setAccountStatementMonth("June");
			 municipalStatement.setAccountDiscount("R0");;
			 
			 billingAccountStatementManagerImpl.saveBillingAccountStatement(municipalStatement);
			 
			 BillingAccountStatement municipalStat = 
				 (BillingAccountStatement) billingAccountStatementManagerImpl.getBillingAccountStatements(municipalStatement.getAccountNumber(), municipalStatement.getAccountStatementMonth());
			 assertNotNull("Billing Account not null" , municipalStat);
			 
			 BillingAccountStatement creditCardStatement = new CreditCardStatement();
			 creditCardStatement.setAccountNumber("45549");
			 creditCardStatement.setAccountDeductions("R23");
			 creditCardStatement.setAccountDueDate("2014/06/26");
			 creditCardStatement.setAccountHolderName("John");
			 creditCardStatement.setAccountNewCharges("R56");
			 creditCardStatement.setAccountOpeningBalance("R456");
			 creditCardStatement.setAccountPaymentReceived("R0");
			 creditCardStatement.setAccountStatementDate("2014/06/13");
			 creditCardStatement.setAccountTotalDue("R879");
			 creditCardStatement.setAccountTotalDue("R1290");
			 creditCardStatement.setAccountDeductions("R78");
			 creditCardStatement.setAccountVATAmount("R76");
			 creditCardStatement.setAccountStatementNumber("98765");
			 creditCardStatement.setAccountClosingBalance("R432");
			 creditCardStatement.setAccountStatementMonth("June");
			 creditCardStatement.setAccountDiscount("R0");;
			 
			 billingAccountStatementManagerImpl.saveBillingAccountStatement(creditCardStatement);
			 		
			 BillingAccountStatement creditCardStat = 
				 (BillingAccountStatement) billingAccountStatementManagerImpl.getBillingAccountStatements(creditCardStatement.getAccountNumber(), creditCardStatement.getAccountStatementMonth());
			 assertNotNull("Billing Account not null" , creditCardStat);
					 
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


