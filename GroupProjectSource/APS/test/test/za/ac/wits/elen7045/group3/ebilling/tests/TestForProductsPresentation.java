package test.za.ac.wits.elen7045.group3.ebilling.tests;

import static org.junit.Assert.*;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.quartz.JobDetail;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import test.za.ac.wits.elen7045.group3.mock.proxy.APSMockObjectGenerator;
import za.ac.wits.elen7045.group3.aps.domain.SaveBillingAccountStatementDataAccess;
import za.ac.wits.elen7045.group3.aps.domain.ScrapeLogResultDataAccess;
import za.ac.wits.elen7045.group3.aps.domain.accounts.repository.AddBillingAccountRepository;
import za.ac.wits.elen7045.group3.aps.domain.accounts.repository.RetriveBillingAccountRepository;
import za.ac.wits.elen7045.group3.aps.domain.entities.BillingAccountStatement;
import za.ac.wits.elen7045.group3.aps.domain.entities.ScrapeLogResult;
import za.ac.wits.elen7045.group3.aps.domain.repository.notification.ScrapeLogResultImpl;
import za.ac.wits.elen7045.group3.aps.domain.repository.notification.ScrapeLogResultRepository;
import za.ac.wits.elen7045.group3.aps.domain.repository.user.CustomerRepository;
import za.ac.wits.elen7045.group3.aps.domain.scheduler.SchedularLauncher;
import za.ac.wits.elen7045.group3.aps.domain.scheduler.Timer;
import za.ac.wits.elen7045.group3.aps.domain.scheduler.TimerJob;
import za.ac.wits.elen7045.group3.aps.domain.scheduler.TimerTask;
import za.ac.wits.elen7045.group3.aps.domain.scheduler.WorkManager;
import za.ac.wits.elen7045.group3.aps.domain.statement.repository.SaveStatementRepository;
import za.ac.wits.elen7045.group3.aps.domain.statement.repository.SaveStatementRepositoryImpl;
import za.ac.wits.elen7045.group3.aps.services.accounts.statement.generator.StatementRenderer;
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
import za.ac.wits.elen7045.group3.aps.services.managers.UserManager;
import za.ac.wits.elen7045.group3.aps.services.managers.UserManagerImpl;
import za.ac.wits.elen7045.group3.aps.services.pattern.notification.observer.NotificationObserver;
import za.ac.wits.elen7045.group3.aps.services.security.EncryptionModule;
import za.ac.wits.elen7045.group3.aps.services.specification.ApplicationSpecification;
import za.ac.wits.elen7045.group3.aps.services.specification.credentials.BillingAccountDetailsSpecification;
import za.ac.wits.elen7045.group3.aps.services.util.ApplicationContants;

public class TestForProductsPresentation {
	private CustomerDTO customer;
	private BillingAccountDTO           billingAccountDTO;
	private ApplicationContext          context;	
	private AddBillingAccountRepository    billingAccountRepository;
	private RetriveBillingAccountRepository    retriveBillingAccountRepository;
	private AddBillingAccountManager	    billingAccountManager;
	private AddBillingAccountManagerImpl   billingAccountManagerImpl;
	private UserManager	                userManager;
	private UserManagerImpl             userManagerImpl;
	private EncryptionModule            encryptionModule;
	private CustomerRepository          customerRepository;
	private CredentialsDTO              userCredentials;

	private ScrapeLogResultDataAccess notificationDataAccess;
	private ScrapeLogResultRepository notificationRepository;
	private ScrapeLogResultImpl       notificationRepositoryImpl;
	
	private SaveBillingAccountStatementDataAccess statementDataAcces;
	private SaveStatementRepository      statementDataRepository;
	private SaveStatementRepositoryImpl  statementRepositoryImpl;
	              
	
	@Before
	public void init(){
	    context                   = new  ClassPathXmlApplicationContext("res/spring/application-context-test.xml");
		customer                  = context.getBean(CustomerDTO.class);
		userCredentials           = new CredentialsDTO();
		encryptionModule          = context.getBean(EncryptionModule.class);
		billingAccountRepository  = context.getBean(AddBillingAccountRepository.class);		    
		billingAccountManagerImpl = new AddBillingAccountManagerImpl(billingAccountRepository, retriveBillingAccountRepository);
		billingAccountManager     = new APSMockObjectGenerator<AddBillingAccountManagerImpl>().mock(billingAccountManagerImpl);
		customerRepository        = context.getBean(CustomerRepository.class);
		
		userManagerImpl           = new UserManagerImpl(customerRepository);
	    userManager               = new APSMockObjectGenerator<UserManagerImpl>().mock(userManagerImpl);
	    
	    billingAccountManagerImpl = new AddBillingAccountManagerImpl(billingAccountRepository,retriveBillingAccountRepository);
	    billingAccountManager     = new APSMockObjectGenerator<AddBillingAccountManagerImpl>().mock(billingAccountManagerImpl);
	    
	    billingAccountManagerImpl = new AddBillingAccountManagerImpl(billingAccountRepository,retriveBillingAccountRepository);
	    billingAccountManager     = new APSMockObjectGenerator<AddBillingAccountManagerImpl>().mock(billingAccountManagerImpl);
	    
	    customer.setEncryptionModule(encryptionModule);
	    
	    notificationDataAccess      = context.getBean(ScrapeLogResultDataAccess.class);
		notificationRepositoryImpl  = new ScrapeLogResultImpl(notificationDataAccess);
		notificationRepository      = new APSMockObjectGenerator<ScrapeLogResultImpl>().mock(notificationRepositoryImpl);
		
		statementDataAcces          = context.getBean(SaveBillingAccountStatementDataAccess.class);
		
		statementDataRepository     = context.getBean(SaveStatementRepository.class) ;
		statementRepositoryImpl     = new SaveStatementRepositoryImpl(statementDataAcces);          
		statementDataRepository     = new APSMockObjectGenerator<SaveStatementRepositoryImpl>().mock(statementRepositoryImpl);
		
		  
	}
	
	
	
	private CustomerDTO customerStuff() throws ApplicationException{
		userCredentials.setUserName("userName");
	     userCredentials.setPassword("password");
	     userCredentials.setEncryptionModule(encryptionModule);
	     userCredentials.encryptCredentials();
	     
	     CustomerDTO authenticationCustomer = userManager.getCustomerForLogin(userCredentials);
		 assertTrue(authenticationCustomer != null);
		 
		 try {
				Thread.currentThread();
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		 
        System.out.println("Checking whether user has accounts");
        System.out.println(" ");
		return authenticationCustomer;
	}
	
	private List<BillingAccountDTO>  checkForActiveAccounts(CustomerDTO customer) throws DatabaseException{
		List<BillingAccountDTO> accountsDTO = billingAccountManager.getBillingAccountsByUserId(customer.getId()); 
		 
		 if(accountsDTO == null || accountsDTO.size() == 0){
			 
			 List<BillingAccountDTO>  billingAccounts = new ArrayList<BillingAccountDTO>();
			 System.out.println("User doesn't have account");
			 System.out.println(" ");
			 System.out.println("Setting up account");
			 
			 billingAccountDTO = new BillingAccountDTO("2");
			 billingAccountDTO.setCustomerId(customer.getId());
			 billingAccountDTO.setCredentials(customer.getCredentials());
			 billingAccountDTO.setCompanyUrl("Municipal.xml");
			 billingAccountDTO.setAccountStatus(AccountStatusType.INACTIVE.getStatusType());
			 System.out.println(" ");
			 System.out.println("Saving the account For Municipal");
			 System.out.println(" ");
			 billingAccounts.add(billingAccountDTO);
			 
			 billingAccountDTO = new BillingAccountDTO("3");
			 billingAccountDTO.setCustomerId(customer.getId());
			 billingAccountDTO.setCredentials(customer.getCredentials());
			 billingAccountDTO.setCompanyUrl("creditcard.xml");
			 billingAccountDTO.setAccountStatus(AccountStatusType.INACTIVE.getStatusType());
			 System.out.println(" ");
			 System.out.println("Saving the account For CreditCard");
			 System.out.println(" ");
			 billingAccounts.add(billingAccountDTO);
			 
			 
			 billingAccountDTO = new BillingAccountDTO("4");
			 billingAccountDTO.setCustomerId(customer.getId());
			 billingAccountDTO.setCredentials(customer.getCredentials());
			 billingAccountDTO.setCompanyUrl("telco.xml");
			 billingAccountDTO.setAccountStatus(AccountStatusType.INACTIVE.getStatusType());
			 System.out.println(" ");
			 System.out.println("Saving the account For Telecoms");
			 System.out.println(" ");
			 billingAccounts.add(billingAccountDTO);
			 System.out.println(" ");
			 
			 for(BillingAccountDTO dto : billingAccounts){
			     billingAccountManager.saveBillingAccount(dto);
			     System.out.println(" ");
			     System.out.println("Checking if ccount exist");
			     BillingAccountDTO accountDTO =  billingAccountManager.getBillingAccount(dto.getAccountNumber());
			 	 try {
					  Thread.currentThread();
					Thread.sleep(2000);
				  } catch (InterruptedException e) {
					  e.printStackTrace();
				  }
			 
			      if(accountDTO != null){
				      List<BillingAccountDTO> accountsDTOs = billingAccountManager.getBillingAccountsByUserId(customer.getId());
				 
				      System.out.println(" ");
				      System.out.println("User has account(s)");
				      System.out.println(" ");
				 
				     if(accountsDTOs != null){
					     ScrapeLogResult accountInactive = null;
					     System.out.println(" ");
					     System.out.println("Sending inactive account notification");
					     for(BillingAccountDTO accountInactiveDTO : accountsDTOs){
						     accountInactive  = new ScrapeLogResult();
					         accountInactive.setAccountNumber(accountInactiveDTO.getAccountNumber());
					         accountInactive.setStatsus(NotificationStatus.WAITING.getNotificationStatus());
					         accountInactive.setResponse(AccountStatusType.INACTIVE.getStatusType());
					         accountInactive.setNotificationType(NotificationType.LOGON.getNotificationType());
					         accountInactive.setMessage(SrapingResponseTypes.ACCOUNT_INACTIVE.getScrapingResponse());
					         notificationRepository.insertScrapeLogResult(accountInactive);
					     }
				      }else{
					      System.out.println(" ");
					      System.out.println("User has active no accounts accounts"); 
				      }
				      ScrapeLogResult notification =new ScrapeLogResult();
				      notification.setAccountNumber("123456");
				      notification.setNotificationType(NotificationType.LOGON.getNotificationType());
				      notification.setNotificationDate(new Timestamp(System.currentTimeMillis()));
				      notification.setStatsus(NotificationStatus.WAITING.getNotificationStatus());
				      notification.setMessage(ApplicationContants.NOTIFICATION_MAIL);
				      notificationRepository.insertScrapeLogResult(notification);
				 
				      ScrapeLogResult noti =new ScrapeLogResult();
				      noti.setAccountNumber("123456");
				      noti.setNotificationType(NotificationType.LOGON.getNotificationType());
				      noti.setNotificationDate(new Timestamp(System.currentTimeMillis()));
				      noti.setStatsus(NotificationStatus.WAITING.getNotificationStatus());
				      noti.setMessage("Please accept new terms and Conditions");
				      notificationRepository.insertScrapeLogResult(noti);
			     }
		     } 
	    }	 
		return accountsDTO;	 
	}
	
	public void checkUserNotifications(){
		 System.out.println(" ");
		 System.out.println("Checking user notifications ");
		   		 
		 ScrapeLogResult logonNotification =new ScrapeLogResult();
	  	  logonNotification.setAccountNumber("123456789");
		  logonNotification.setStatsus(NotificationStatus.WAITING.getNotificationStatus());
		  logonNotification.setNotificationType(NotificationType.LOGON.getNotificationType());

	        NotificationObserver notificationObserver = new NotificationObserver();
	        ScrapeLogResult responseNotification = new ScrapeLogResult();

	        List<ScrapeLogResult> dbNotifications =notificationObserver.checkNotifications(logonNotification, notificationRepository);
	        
	        if(dbNotifications != null ){
	            for(ScrapeLogResult updateNotification : dbNotifications){
	            	System.out.println(" ");
	       		    System.out.println("User Updating Notification ");
	       		   	System.out.println("Response " + updateNotification.getMessage());
	       		    System.out.println(" ");
	       		    System.out.println("User Takes action");
				    updateNotification.setStatsus(NotificationStatus.COMPLETE.getNotificationStatus());
				    try {
				    	System.out.println("Before Notification Update " + dbNotifications.size());
						ScrapeLogResult updatedNotification = notificationRepository.updateScrapeLogResults(updateNotification);
						List<ScrapeLogResult> LastdbNotifications =notificationObserver.checkNotifications(logonNotification, notificationRepository);
						  if(LastdbNotifications != null){
							  dbNotifications = LastdbNotifications;
							  System.out.println("After Notification Update " + dbNotifications.size());
						  }
					} catch (DatabaseException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
			    }
	         }
	  }
	
	public void checkActiveInactiveNotifications(){
	 System.out.println(" ");
     System.out.println("Chcking Account Inactive messages");
		 ScrapeLogResult accountNotification =new ScrapeLogResult();
		 accountNotification.setAccountNumber("2");
		 accountNotification.setStatsus(NotificationStatus.WAITING.getNotificationStatus());
		 accountNotification.setNotificationType(NotificationType.LOGON.getNotificationType());

	        NotificationObserver notificationObserverAcc = new NotificationObserver();
	        ScrapeLogResult responseNotificationt = new ScrapeLogResult();

	        List<ScrapeLogResult> dbNotificationst =notificationObserverAcc.checkNotifications(accountNotification, notificationRepository);
	        
	        if(dbNotificationst != null ){
	            for(ScrapeLogResult updateNotification : dbNotificationst){
	            	System.out.println(" ");
	       		    System.out.println("User Updating Notification ");
	       		   	System.out.println("Response " + updateNotification.getMessage() + " = Inactive Account");
	       		    System.out.println(" ");
	       		    System.out.println("User Takesaction Activates");
				    updateNotification.setStatsus(NotificationStatus.COMPLETE.getNotificationStatus());
				    try {
				    	System.out.println("Before Notification Update " + dbNotificationst.size());
						ScrapeLogResult updatedNotification = notificationRepository.updateScrapeLogResults(updateNotification);
						List<ScrapeLogResult> LastdbNotifications =notificationObserverAcc.checkNotifications(accountNotification, notificationRepository);
						  if(LastdbNotifications != null){
							  dbNotificationst = LastdbNotifications;
							  System.out.println("After Notification Update " + dbNotificationst.size());
						  }
					} catch (DatabaseException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
			    }
	        }
	}
	
	
	public void checkActiveNotifications(){
		 System.out.println(" ");
	     System.out.println("Chcking Active Accouts message");
			 ScrapeLogResult accountNotification =new ScrapeLogResult();
			 accountNotification.setAccountNumber("2");
			 accountNotification.setStatsus(NotificationStatus.COMPLETE.getNotificationStatus());
			 accountNotification.setNotificationType(NotificationType.LOGON.getNotificationType());

		        NotificationObserver notificationObserverAcc = new NotificationObserver();
		        ScrapeLogResult responseNotificationt = new ScrapeLogResult();

		        List<ScrapeLogResult> dbNotificationst =notificationObserverAcc.checkNotifications(accountNotification, notificationRepository);
		        
		        if(dbNotificationst != null ){
		            for(ScrapeLogResult updateNotification : dbNotificationst){
		            	System.out.println(" ");
		       		    System.out.println("User Updating Notification ");
		       		   	System.out.println("Response " + updateNotification.getMessage() + " = Active Account");
		       		    System.out.println(" ");
		       		    System.out.println("User Takesaction Activates");
				    }
		        }
		}       

	
	@Test
	 public void tetBillingAccountFields() throws ApplicationException, DatabaseException {
		addNotifications();
		CustomerDTO customer = 	customerStuff();
		try {
			Thread.currentThread();
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		List<BillingAccountDTO> accountsDTO = checkForActiveAccounts(customer);
        try {
				Thread.currentThread();
				Thread.sleep(2000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		 checkUserNotifications(); 
		   try {
				Thread.currentThread();
				Thread.sleep(2000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	 	       	        
		   checkActiveInactiveNotifications();       
		   
		   try {
				Thread.currentThread();
				Thread.sleep(2000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		   
		   checkActiveNotifications();
		   
		   try {
				Thread.currentThread();
				Thread.sleep(2000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		   
		 new SchedularLauncher().launch(); 
		 
		 try {
				Thread.currentThread();
				Thread.sleep(10000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		 
		 
		 System.out.println("  ");
		 System.out.println("Check Accounts");
		 System.out.println("  ");
		    
		List<BillingAccountStatement> statements =  statementDataRepository.getAccountStatement("123456789");  
		StatementRenderer statement = StatementRenderer.newInstnce();
		for(BillingAccountStatement accountStatement : statements){
			statement.createHTHMLStateMent(accountStatement, 
                    ApplicationContants.USER_STATEMENT_PATH+"\\"+accountStatement.getAccountNumber()+"\\"+accountStatement.getAccountNumber()+".xml");	
		}
		
		
		
		
	}
	
	private void startSchedule(){
		 ApplicationContext applicationContext = new ClassPathXmlApplicationContext("res/spring/application-context-test.xml");
			Timer timer = (Timer) applicationContext.getBean("timer");
			int numOfWorkers = 5;
			WorkManager workManager = WorkManager.getInstance(numOfWorkers);
			TimerTask task = new TimerTask(workManager, applicationContext);
	    	JobDetail jobdetail = new JobDetail();
	    	jobdetail.setName("APS Timer JOB");
	    	jobdetail.setJobClass(TimerJob.class);
	    	Map<String, TimerTask> dataMap = jobdetail.getJobDataMap();
	    	dataMap.put(jobdetail.getName(), task);
			
			timer.setJob(jobdetail);
			timer.schedule();
		   
	}
	
	
	private void addNotifications() throws DatabaseException{
		ScrapeLogResult notification = new ScrapeLogResult();
		notification.setAccountNumber("123456789");
		notification.setStatsus(NotificationStatus.WAITING.getNotificationStatus());
		notification.setNotificationType(NotificationType.LOGON.getNotificationType());
		notification.setNotificationDate(new Timestamp(System.currentTimeMillis()));
		notification.setStatsus(NotificationStatus.WAITING.getNotificationStatus());
		notification.setMessage(ApplicationContants.NOTIFICATION_MAIL);
		 notificationRepository.insertScrapeLogResult(notification);
		 
		 ScrapeLogResult notificationf = new ScrapeLogResult();
		 notificationf.setAccountNumber("123456789");
		 notificationf.setStatsus(NotificationStatus.WAITING.getNotificationStatus());
		 notificationf.setNotificationType(NotificationType.LOGON.getNotificationType());
		 notificationf.setNotificationDate(new Timestamp(System.currentTimeMillis()));
		 notificationf.setStatsus(NotificationStatus.WAITING.getNotificationStatus());
		 notificationf.setMessage(ApplicationContants.NOTIFICATION_MAIL);
		 notificationRepository.insertScrapeLogResult(notification);
	  }
}
		 
		 

