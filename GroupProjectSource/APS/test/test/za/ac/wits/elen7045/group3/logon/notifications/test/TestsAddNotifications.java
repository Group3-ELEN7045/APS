/**
 * 
 */
package test.za.ac.wits.elen7045.group3.logon.notifications.test;
 
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import test.za.ac.wits.elen7045.group3.mock.proxy.APSMockObjectGenerator;
import za.ac.wits.elen7045.group3.aps.domain.ScrapeLogResultDataAccess;
import za.ac.wits.elen7045.group3.aps.domain.accounts.repository.AddBillingAccountRepository;
import za.ac.wits.elen7045.group3.aps.domain.accounts.repository.RetriveBillingAccountRepository;
import za.ac.wits.elen7045.group3.aps.domain.entities.ScrapeLogResult;
import za.ac.wits.elen7045.group3.aps.domain.repository.notification.ScrapeLogResultImpl;
import za.ac.wits.elen7045.group3.aps.domain.repository.notification.ScrapeLogResultRepository;
import za.ac.wits.elen7045.group3.aps.domain.repository.user.CustomerRepository;
import za.ac.wits.elen7045.group3.aps.services.dto.BillingAccountDTO;
import za.ac.wits.elen7045.group3.aps.services.dto.CredentialsDTO;
import za.ac.wits.elen7045.group3.aps.services.dto.CustomerDTO;
import za.ac.wits.elen7045.group3.aps.services.enumtypes.AccountStatusType;
import za.ac.wits.elen7045.group3.aps.services.enumtypes.NotificationStatus;
import za.ac.wits.elen7045.group3.aps.services.enumtypes.NotificationType;
import za.ac.wits.elen7045.group3.aps.services.enumtypes.SrapingResponseTypes;
import za.ac.wits.elen7045.group3.aps.services.exception.ApplicationException;
import za.ac.wits.elen7045.group3.aps.services.exception.DatabaseException;
import za.ac.wits.elen7045.group3.aps.services.managers.AddBillingAccountManager;
import za.ac.wits.elen7045.group3.aps.services.managers.AddBillingAccountManagerImpl;
import za.ac.wits.elen7045.group3.aps.services.managers.RetriveBillingAccountManager;
import za.ac.wits.elen7045.group3.aps.services.managers.RetriveBillingAccountManagerImpl;
import za.ac.wits.elen7045.group3.aps.services.managers.UserManager;
import za.ac.wits.elen7045.group3.aps.services.managers.UserManagerImpl;
import za.ac.wits.elen7045.group3.aps.services.security.EncryptionModule;
import za.ac.wits.elen7045.group3.aps.services.util.ApplicationContants;

/**
 * @author SilasMahlangu
 *
 */

public class TestsAddNotifications {
    
	private ScrapeLogResult           notification;
	private List<ScrapeLogResult>     notifications;
	private ScrapeLogResultDataAccess notificationDataAccess;
	private ScrapeLogResultRepository notificationRepository;
	private ScrapeLogResultImpl       notificationRepositoryImpl;
	private ApplicationContext        context;
	private CredentialsDTO            userCredentials;
	private EncryptionModule          encryptionModule;
	private UserManager	              userManager;
	private UserManagerImpl           userManagerImpl;
	private CustomerRepository        customerRepository;
	private CustomerDTO               customer;
	private AddBillingAccountManager	  billingAccountManager;
	private AddBillingAccountManagerImpl billingAccountManagerImpl;
	private RetriveBillingAccountManager	  retriveBillingAccountManager;
	private RetriveBillingAccountManagerImpl retriveBillingAccountManagerImpl;
	private AddBillingAccountRepository    billingAccountRepository;
	private RetriveBillingAccountRepository    retriveBillingAccountRepository;
	
	@Before
	public void initilize(){
		context                     = new  ClassPathXmlApplicationContext("res/spring/application-context-test.xml");
		notification                = (ScrapeLogResult)context.getBean("notification");
  		encryptionModule            = context.getBean(EncryptionModule.class);
		notifications               = new ArrayList<ScrapeLogResult>();	

		notificationDataAccess      = context.getBean(ScrapeLogResultDataAccess.class);
		notificationRepositoryImpl  = new ScrapeLogResultImpl(notificationDataAccess);
		notificationRepository      = new APSMockObjectGenerator<ScrapeLogResultImpl>().mock(notificationRepositoryImpl);
		
		billingAccountRepository  = context.getBean(AddBillingAccountRepository.class);
		billingAccountManagerImpl = new AddBillingAccountManagerImpl(billingAccountRepository, retriveBillingAccountRepository);
	    billingAccountManager     = new APSMockObjectGenerator<AddBillingAccountManagerImpl>().mock(billingAccountManagerImpl);
	    
	    retriveBillingAccountManagerImpl = new RetriveBillingAccountManagerImpl(retriveBillingAccountRepository);
	    retriveBillingAccountManager     = new APSMockObjectGenerator<RetriveBillingAccountManagerImpl>().mock(retriveBillingAccountManagerImpl);
		
		customer                  = context.getBean(CustomerDTO.class);
        customerRepository        = context.getBean(CustomerRepository.class);
		  
        userManagerImpl           = new UserManagerImpl(customerRepository);
	    userManager               = new APSMockObjectGenerator<UserManagerImpl>().mock(userManagerImpl);
		
	    
		userCredentials             = new CredentialsDTO();
		
		notification.setAccountNumber("123456789");
		notification.setStatsus(NotificationStatus.WAITING.getNotificationStatus());
		notification.setNotificationType(NotificationType.LOGON.getNotificationType());
	}
	
	@Test //Test for logon notification from ebilling (update information and accept new terms and condition)
	public void testInsertNotifiction() throws DatabaseException{
		
		notification.setNotificationDate(new Timestamp(System.currentTimeMillis()));
		
		notification.setStatsus(NotificationStatus.WAITING.getNotificationStatus());
		notification.setMessage(ApplicationContants.NOTIFICATION_MAIL);
		assertTrue("Unble to add Notifiction in Datbse", notificationRepository.insertScrapeLogResult(notification));  
	}
	
	@Test
	public void testValidteInsert() throws DatabaseException{
						
		List<ScrapeLogResult> notifications = notificationRepository.getScrapeLogResult(notification);
		assertNotNull("The databse should have 2 entries", notifications);
	}
	
	@Test //Tests for account status if Inactive notifyuser
	public void sendInactiveAccountNotifications() throws ApplicationException, DatabaseException{
		 userCredentials.setUserName("userName");
	     userCredentials.setPassword("password");
	     userCredentials.setEncryptionModule(encryptionModule);
	     userCredentials.encryptCredentials();
	     
	     CustomerDTO authenticationCustomer = userManager.getCustomerForLogin(userCredentials);		 
		 List<BillingAccountDTO> accountsDTOs = retriveBillingAccountManager.getBillingAccountForCustomer(authenticationCustomer.getId());
		 
		 assertNotNull("No Accounts created for this user" , accountsDTOs);
		 
		 if(accountsDTOs != null){
			 ScrapeLogResult accountInactive = null;
			 for(BillingAccountDTO accountInactiveDTO : accountsDTOs){
				 accountInactive  = new ScrapeLogResult();
			     accountInactive.setAccountNumber(accountInactiveDTO.getAccountNumber());
			     accountInactive.setStatsus(NotificationStatus.WAITING.getNotificationStatus());
			     accountInactive.setResponse(AccountStatusType.INACTIVE.getStatusType());
			     accountInactive.setNotificationType(NotificationType.LOGON.getNotificationType());
			     accountInactive.setMessage(SrapingResponseTypes.ACCOUNT_INACTIVE.getScrapingResponse());
			     notificationRepository.insertScrapeLogResult(notification);
			 }
		 }
		
	}
}
