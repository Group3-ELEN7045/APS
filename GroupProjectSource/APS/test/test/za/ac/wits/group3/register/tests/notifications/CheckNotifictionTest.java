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
import za.ac.wits.elen7045.group3.aps.services.enumtypes.NotificationType;
import za.ac.wits.elen7045.group3.aps.services.exception.DatabaseException;
import za.ac.wits.elen7045.group3.aps.services.pattern.notification.observer.NotificationObserver;
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
		private NotificationCheck checkNotification;
		@Before
		public void initilize(){
			context                     = new  ClassPathXmlApplicationContext("res/spring/application-context-test.xml");
			notification                = context.getBean(ScrapeLogResult.class);
			notificationDataAccess      = context.getBean(ScrapeLogResultDataAccess.class);
			notifications               = new ArrayList<ScrapeLogResult>();  
			notificationRepositoryImpl  = new ScrapeLogResultImpl(notificationDataAccess);
			notificationRepository      = new APSMockObjectGenerator<ScrapeLogResultImpl>().mock(notificationRepositoryImpl);
			
			
		}
					
		//Check Notifiction Test
		@Test
		public void checkNotifictionObserverTest(){
			NotificationCheck checkNotification = new NotificationCheck();
			checkNotification.setAccountNumber("123456789");
			checkNotification.setNotificationStatus(NotificationType.LOGON.getNotificationType());
			
			NotificationObserver notificationObserver = new NotificationObserver();  
			ScrapeLogResult responseNotification = new ScrapeLogResult();
			
			List<ScrapeLogResult> dbNotifications = new ArrayList<ScrapeLogResult>();
			dbNotifications = notificationObserver.checkNotifications(checkNotification, notificationRepository);
			
			responseNotification =  dbNotifications.get(0);
			
			ApplicationSpecification<ScrapeLogResult> notificationSpecification = new CheckNotificationSpecification(notification);
		    assertTrue("Not logon Notifications", notificationSpecification.isSatisfiedBy(responseNotification));	
		}
}
