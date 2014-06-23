/**
 * 
 */
package test.za.ac.wits.group3.register.tests.notifications;
 
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import test.za.ac.wits.group3.mock.proxy.APSMockObjectGenerator;
import za.ac.wits.elen7045.group3.aps.domain.ScrapeLogResultDataAccess;
import za.ac.wits.elen7045.group3.aps.domain.entities.ScrapeLogResult;
import za.ac.wits.elen7045.group3.aps.domain.repository.notification.ScrapeLogResultImpl;
import za.ac.wits.elen7045.group3.aps.domain.repository.notification.ScrapeLogResultRepository;
import za.ac.wits.elen7045.group3.aps.services.enumtypes.NotificationStatus;
import za.ac.wits.elen7045.group3.aps.services.enumtypes.NotificationType;
import za.ac.wits.elen7045.group3.aps.services.exception.DatabaseException;
import za.ac.wits.elen7045.group3.aps.services.util.ApplicationContants;

/**
 * @author SilasMahlangu
 *
 */

public class TestsAddNotifications {
    
	private ScrapeLogResult               notification;
	private List<ScrapeLogResult>         notifications;
	private ScrapeLogResultDataAccess     notificationDataAccess;
	private ScrapeLogResultRepository     notificationRepository;
	private ScrapeLogResultImpl notificationRepositoryImpl;
	private ApplicationContext         context;
	
	@Before
	public void initilize(){
		context                     = new  ClassPathXmlApplicationContext("res/spring/application-context-test.xml");
		notification                = (ScrapeLogResult)context.getBean("notification");
		notificationDataAccess      = context.getBean(ScrapeLogResultDataAccess.class);
		notifications               = new ArrayList<ScrapeLogResult>();  
		notificationRepositoryImpl  = new ScrapeLogResultImpl(notificationDataAccess);
		notificationRepository      = new APSMockObjectGenerator<ScrapeLogResultImpl>().mock(notificationRepositoryImpl);
		
		notification.setAccountNumber("123456789");
		notification.setStatsus(NotificationStatus.WAITING.getNotificationStatus());
		notification.setNotificationType(NotificationType.LOGON.getNotificationType());
	}
	
	@Test
	public void testInsertNotifiction() throws DatabaseException{
		
		notification.setNotificationDate(new Timestamp(System.currentTimeMillis()));
		
		notification.setStatsus(NotificationStatus.WAITING.getNotificationStatus());
		notification.setMessage(ApplicationContants.NOTIFICATION_MAIL);
		assertTrue("Unble to add Notifiction in Datbse", notificationRepository.insertScrapeLogResult(notification));  
	}
	
	@Test
	public void testValidteInsert() throws DatabaseException{
						
		List<ScrapeLogResult> notifications = notificationRepository.getScrapeLogResult(notification);
		assertEquals("The databse shoud have 2 entries", notifications.size() , 3);
	}
	
}
