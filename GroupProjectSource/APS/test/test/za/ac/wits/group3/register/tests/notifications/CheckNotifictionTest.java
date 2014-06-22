/**
 * 
 */
package test.za.ac.wits.group3.register.tests.notifications;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import test.za.ac.wits.group3.mock.proxy.APSMockObjectGenerator;
import za.ac.wits.elen7045.group3.aps.domain.ScrapeLogResultDataAccess;
import za.ac.wits.elen7045.group3.aps.domain.entities.ScrapeLogResult;
import za.ac.wits.elen7045.group3.aps.domain.repository.notification.ScrapeLogResultImpl;
import za.ac.wits.elen7045.group3.aps.domain.repository.notification.ScrapeLogResultRepository;
import za.ac.wits.elen7045.group3.aps.domain.vo.NotificationCheck;
import za.ac.wits.elen7045.group3.aps.services.enumtypes.NotificationStatus;
import za.ac.wits.elen7045.group3.aps.services.exception.DatabaseException;
import za.ac.wits.elen7045.group3.aps.services.notification.observer.NotificationObserver;
import za.ac.wits.elen7045.group3.aps.services.specification.ApplicationSpecification;
import za.ac.wits.elen7045.group3.aps.services.specification.notification.CheckNotificationSpecification;

/**
 * @author SilasMahlangu
 *
 */
public class CheckNotifictionTest {

		private ScrapeLogResult               notification;
		private List<ScrapeLogResult>         notifications;
		private ScrapeLogResultDataAccess     notificationDataAccess;
		private ScrapeLogResultRepository     notificationRepository;
		private ScrapeLogResultImpl notificationRepositoryImpl;
		private ApplicationContext         context;
		
		@Before
		public void initilize(){
			context                     = new  ClassPathXmlApplicationContext("res/spring/application-context-test.xml");
			notification                = context.getBean(ScrapeLogResult.class);
			notificationDataAccess      = context.getBean(ScrapeLogResultDataAccess.class);
			notifications               = new ArrayList<ScrapeLogResult>();  
			notificationRepositoryImpl  = new ScrapeLogResultImpl(notificationDataAccess);
			notificationRepository      = new APSMockObjectGenerator<ScrapeLogResultImpl>().mock(notificationRepositoryImpl);
		}
		
		@Test
		public void testInsertNotifiction() throws DatabaseException{
			notification.setNotificationType("message");
			notification.setStatsus(NotificationStatus.WAITING.getNotificationStatus());
			notification.setMessage("Please Update email address");
			assertTrue("Unble to add Notifiction in Datbse", notificationRepository.updateScrapeLogResult(notification));  
		}
		
		@Test
		public void testValidteInsert() throws DatabaseException{
			List<ScrapeLogResult> notifications = notificationRepository.getScrapeLogResult(Long.valueOf(1), null);
			assertEquals("The databse shoud have 2 entries", notifications.size() , 1);
		}
		
		//Check Notifiction Test
		@Test
		public void checkNotifictionTest(){
			NotificationCheck checkNotification = new NotificationCheck();
			NotificationObserver notificationObserver = new NotificationObserver();  
			ScrapeLogResult responseNotification = new ScrapeLogResult();
			
			checkNotification.setId(Long.valueOf(1));
			checkNotification.setNotificationStatus(NotificationStatus.WAITING.getNotificationStatus());
			
			List<ScrapeLogResult> dbNotifications = new ArrayList<ScrapeLogResult>();
			dbNotifications = notificationObserver.checkNotifications(checkNotification, notificationRepository);
			
			responseNotification = dbNotifications.get(0);
			
			ApplicationSpecification<ScrapeLogResult> notificationSpecification = new CheckNotificationSpecification(notification);
		    assertTrue("No Notifications in a wait state", notificationSpecification.isSatisfiedBy(responseNotification));	
		}
}
