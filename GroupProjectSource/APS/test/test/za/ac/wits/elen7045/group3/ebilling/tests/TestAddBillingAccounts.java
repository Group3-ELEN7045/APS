package test.za.ac.wits.elen7045.group3.ebilling.tests;

import static org.junit.Assert.*;

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

public class TestAddBillingAccounts {
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
	
    }
	
	
	@Test
	 public void tetBillingAccountFields() {
	 try {	
		 //Tests for the specification which verifues the nbilling account details
		 billingAccountDTO = new BillingAccountDTO("12345");
		 ApplicationSpecification<BillingAccountDTO> billingAccountDetails = new BillingAccountDetailsSpecification(
				 billingAccountDTO);
		 assertFalse(billingAccountDetails.isSatisfiedBy(billingAccountDTO));
		 
		 //Tests for a valid user
		 userCredenials.setUserName("userName");
	     userCredenials.setPassword("password");
	     CustomerDTO authenticationCustomer = userManager.getCustomer(userCredenials);
		assertTrue(authenticationCustomer != null);
		
		//Tests if all the required fields for billing account are set
		billingAccountDTO.setCustomerId(authenticationCustomer.getId());
		billingAccountDTO.setCredentials(authenticationCustomer.getCredentials());
		billingAccountDTO.setCompanyUrl("www.telco.co.za");
		ApplicationSpecification<BillingAccountDTO> billingAccountDetail = new BillingAccountDetailsSpecification(
				 billingAccountDTO);
		 assertTrue(billingAccountDetails.isSatisfiedBy(billingAccountDTO));
		
	 } catch (Exception e) {
		 // TODO Auto-generated catch block
		 e.printStackTrace();
		 }
	} 
	
	 @Test
	 public void testSaveBillingAccount() {
	 try {	
		 //Tests for the saving of the billing accounts
		 billingAccountDTO = new BillingAccountDTO("12345");		 	 
		 userCredenials.setUserName("userName");
	     userCredenials.setPassword("password");
	     CustomerDTO authenticationCustomer = userManager.getCustomer(userCredenials);		 
		 billingAccountDTO.setCustomerId(authenticationCustomer.getId());
		 billingAccountDTO.setCredentials(authenticationCustomer.getCredentials());
		 billingAccountDTO.setCompanyUrl("www.telco.co.za");
		 
		 billingAccountManager.saveBillingAccount(billingAccountDTO);
		 
		 BillingAccountDTO insertedBillingAccount = billingAccountManager.getBillingAccount("12345");
		 assertNotNull("Failed to Insert Billing Account" , insertedBillingAccount);
		 assertEquals("www.telco.co.za", insertedBillingAccount.getCompanyUrl() );
		 
		 //Tests for the updating of the billing accounts
		 insertedBillingAccount.setCompanyUrl("www.credit.co.za");
		 billingAccountManager.updateBillingAccountStatus(insertedBillingAccount);
		 BillingAccountDTO updateBillingAccount = billingAccountManager.getBillingAccount("12345");
		 System.out.println("Updated 1 = " + updateBillingAccount.getCompanyUrl());
		 assertEquals("www.credit.co.za", updateBillingAccount.getCompanyUrl() );		 
				 
	 } catch (Exception e) {
	 // TODO Auto-generated catch block
	 e.printStackTrace();
	 }
	}
	 
	 @Test
	 public void testgetBillingAccountsByCompanyName() {
	 try {
		 
		 //Tests for billing account search
		 BillingAccountDTO insertedBillingAccount = billingAccountManager.getBillingAccount("12345");
		 assertEquals("www.credit.co.za", insertedBillingAccount.getCompanyUrl() );
		 
		 String url = "www.credit.co.za";
		 List<BillingAccountDTO> updateBillingAccount = billingAccountManager.getBillingAccountsByCompanyUrl(url);
		 assertEquals(1, updateBillingAccount.size() );		 
	 } catch (Exception e) {
	 // TODO Auto-generated catch block
	 e.printStackTrace();
	 }
	}	 
}
