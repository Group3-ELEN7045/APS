package test.za.ac.wits.elen7045.group3.ebilling.tests;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import test.za.ac.wits.elen7045.group3.mock.proxy.APSMockObjectGenerator;
import za.ac.wits.elen7045.group3.aps.domain.accounts.repository.AddBillingAccountRepository;
import za.ac.wits.elen7045.group3.aps.domain.accounts.repository.RetriveBillingAccountRepository;
import za.ac.wits.elen7045.group3.aps.domain.repository.user.CustomerRepository;
import za.ac.wits.elen7045.group3.aps.services.dto.BillingAccountDTO;
import za.ac.wits.elen7045.group3.aps.services.dto.CredentialsDTO;
import za.ac.wits.elen7045.group3.aps.services.dto.CustomerDTO;
import za.ac.wits.elen7045.group3.aps.services.enumtypes.AccountStatusType;
import za.ac.wits.elen7045.group3.aps.services.exception.ApplicationException;
import za.ac.wits.elen7045.group3.aps.services.exception.DatabaseException;
import za.ac.wits.elen7045.group3.aps.services.managers.AddBillingAccountManager;
import za.ac.wits.elen7045.group3.aps.services.managers.AddBillingAccountManagerImpl;
import za.ac.wits.elen7045.group3.aps.services.managers.RetriveBillingAccountManager;
import za.ac.wits.elen7045.group3.aps.services.managers.RetriveBillingAccountManagerImpl;
import za.ac.wits.elen7045.group3.aps.services.managers.UserManager;
import za.ac.wits.elen7045.group3.aps.services.managers.UserManagerImpl;
import za.ac.wits.elen7045.group3.aps.services.security.EncryptionModule;
import za.ac.wits.elen7045.group3.aps.services.specification.ApplicationSpecification;
import za.ac.wits.elen7045.group3.aps.services.specification.credentials.BillingAccountDetailsSpecification;

public class TestAddBillingAccounts {
	private CustomerDTO customer;
	private BillingAccountDTO           billingAccountDTO;
	private ApplicationContext          context;	
	private AddBillingAccountRepository    addBillingAccountRepository;
	private RetriveBillingAccountRepository    retriveBillingAccountRepository;
	private AddBillingAccountManager	    addBillingAccountManager;
	private AddBillingAccountManagerImpl   addBillingAccountManagerImpl;
	private RetriveBillingAccountManager	    retriveBillingAccountManager;
	private RetriveBillingAccountManagerImpl   retriveBillingAccountManagerImpl;
	private UserManager	                userManager;
	private UserManagerImpl             userManagerImpl;
	private EncryptionModule            encryptionModule;
	private CustomerRepository          customerRepository;
	private CredentialsDTO              userCredentials;

	@Before
	public void init(){
	    context                   = new  ClassPathXmlApplicationContext("res/spring/application-context-test.xml");
		customer                  = context.getBean(CustomerDTO.class);
		userCredentials           = new CredentialsDTO();
		encryptionModule          = context.getBean(EncryptionModule.class);
		addBillingAccountRepository  = context.getBean(AddBillingAccountRepository.class);		    
		retriveBillingAccountRepository  = context.getBean(RetriveBillingAccountRepository.class);		
		customerRepository        = context.getBean(CustomerRepository.class);
		
		userManagerImpl           = new UserManagerImpl(customerRepository);
	    userManager               = new APSMockObjectGenerator<UserManagerImpl>().mock(userManagerImpl);
	    
        addBillingAccountManagerImpl = new AddBillingAccountManagerImpl(addBillingAccountRepository, retriveBillingAccountRepository);
		addBillingAccountManager     = new APSMockObjectGenerator<AddBillingAccountManagerImpl>().mock(addBillingAccountManagerImpl);
		
		retriveBillingAccountManagerImpl = new RetriveBillingAccountManagerImpl(retriveBillingAccountRepository);
		retriveBillingAccountManager     = new APSMockObjectGenerator<RetriveBillingAccountManagerImpl>().mock(retriveBillingAccountManagerImpl);
	    customer.setEncryptionModule(encryptionModule);
    }
	
	
	@Test
	 public void tetBillingAccountFields() {
	 try {	
		 //Tests for the specification which verifies the ebilling account details
		 billingAccountDTO = new BillingAccountDTO("2");
		 ApplicationSpecification<BillingAccountDTO> billingAccountDetails = new BillingAccountDetailsSpecification(billingAccountDTO);
		 assertFalse(billingAccountDetails.isSatisfiedBy(billingAccountDTO));
		 
		 //Tests for a valid user
		 userCredentials.setUserName("userName");
	     userCredentials.setPassword("password");
	     userCredentials.setEncryptionModule(encryptionModule);
	     userCredentials.encryptCredentials();
	     
	     CustomerDTO authenticationCustomer = userManager.getCustomerForLogin(userCredentials);
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
	public void testAccountUserRelationShip() throws ApplicationException, DatabaseException{
		 
		 userCredentials.setUserName("userName");
	     userCredentials.setPassword("password");
	     userCredentials.setEncryptionModule(encryptionModule);
	     userCredentials.encryptCredentials();
	     
	     CustomerDTO authenticationCustomer = userManager.getCustomerForLogin(userCredentials);		 
		 List<BillingAccountDTO> accountsDTO = retriveBillingAccountManager.getBillingAccountForCustomer(authenticationCustomer.getId());
		 
		 assertNotNull("No Accounts created for this user" , accountsDTO);
		
		 
	}
	
	 @Test
	 public void testSaveBillingAccount() {
	 try {	
		 //Tests for the saving of the billing accounts
		 billingAccountDTO = new BillingAccountDTO("3");
		 Assert.assertNull(retriveBillingAccountManager.getBillingAccount(billingAccountDTO.getAccountNumber()));
		 
		 userCredentials.setUserName("userName");
	     userCredentials.setPassword("password");
	     userCredentials.setEncryptionModule(encryptionModule);
	     userCredentials.encryptCredentials();
	     
	     CustomerDTO authenticationCustomer = userManager.getCustomerForLogin(userCredentials);		 
		 billingAccountDTO.setCustomerId(authenticationCustomer.getId());
		 billingAccountDTO.setCredentials(authenticationCustomer.getCredentials());
		 billingAccountDTO.setCompanyUrl("www.telco.co.za");
		 billingAccountDTO.setAccountStatus(AccountStatusType.INACTIVE.getStatusType());
		 addBillingAccountManager.saveBillingAccount(billingAccountDTO);
		 
		 BillingAccountDTO insertedBillingAccount = retriveBillingAccountManager.getBillingAccount(billingAccountDTO.getAccountNumber());
		 assertNotNull("Failed to Insert Billing Account" , insertedBillingAccount);
		 assertEquals("www.telco.co.za", insertedBillingAccount.getCompanyUrl() );
		 
				 
	 } catch (Exception e) {
	 // TODO Auto-generated catch block
	 e.printStackTrace();
	 }
	}
	 
	@Test
	public void testupdateAccount() throws ApplicationException, DatabaseException{
		 billingAccountDTO = new BillingAccountDTO("2");		 	 
		 userCredentials.setUserName("userName");
	     userCredentials.setPassword("password");
	     userCredentials.setEncryptionModule(encryptionModule);
	     userCredentials.encryptCredentials();
	     
	     CustomerDTO authenticationCustomer = userManager.getCustomerForLogin(userCredentials);		 
		 
		 BillingAccountDTO insertedBillingAccount = retriveBillingAccountManager.getBillingAccount(billingAccountDTO.getAccountNumber());
		 assertNotNull("Failed to Insert Billing Account" , insertedBillingAccount);
		 assertEquals("www.telco.co.za", insertedBillingAccount.getCompanyUrl() );
				
		 //Tests for the updating of the billing accounts
		 insertedBillingAccount.setCompanyUrl("www.credit.co.za");
		 addBillingAccountManager.updateBillingAccountStatus(insertedBillingAccount);
		 BillingAccountDTO updateBillingAccount = retriveBillingAccountManager.getBillingAccount("1");
		 System.out.println("Updated 1 = " + updateBillingAccount.getCompanyUrl());
		 assertEquals("www.credit.co.za", updateBillingAccount.getCompanyUrl() );		 
		
	}
	 
	 @Test
	 public void testgetBillingAccountsByCompanyName() {
	 try {
		 
		 //Tests for billing account search
		 BillingAccountDTO insertedBillingAccount = retriveBillingAccountManager.getBillingAccount("1");
		 assertEquals("www.credit.co.za", insertedBillingAccount.getCompanyUrl() );
		 
		 String url = "www.credit.co.za";
		 List<BillingAccountDTO> updateBillingAccount = retriveBillingAccountManager.getBillingAccountsByCompanyUrl(url);
		 assertEquals(1, updateBillingAccount.size() );		 
	 } catch (Exception e) {
	 // TODO Auto-generated catch block
	 e.printStackTrace();
	 }
   }	 
}
