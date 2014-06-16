/**
 * 
 */
package test.za.ac.wits.group3.register.tests.notifications;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import test.za.ac.wits.group3.mock.proxy.APSMockObjectGenerator;
import za.ac.wits.elen7045.group3.aps.domain.NotificationDataAccess;
import za.ac.wits.elen7045.group3.aps.domain.entities.Notification;
import za.ac.wits.elen7045.group3.aps.domain.repository.notification.NotificationRepository;
import za.ac.wits.elen7045.group3.aps.domain.repository.notification.NotificationRepositoryImpl;
import za.ac.wits.elen7045.group3.aps.services.exception.DatabaseException;

/**
 * @author SilasMahlangu
 *
 */

public class TestsAddNotificationd {
    
	private Notification               notification;
	private List<Notification>         notifications;
	private NotificationDataAccess     notificationDataAccess;
	private NotificationRepository     notificationRepository;
	private NotificationRepositoryImpl notificationRepositoryImpl;
	private ApplicationContext         context;
	
	@Before
	public void initilize(){
		context                     = new  ClassPathXmlApplicationContext("res/spring/application-context-test.xml");
		notification                = context.getBean(Notification.class);
		notificationDataAccess      = context.getBean(NotificationDataAccess.class);
		notifications               = new ArrayList<Notification>();  
		notificationRepositoryImpl  = new NotificationRepositoryImpl(notificationDataAccess);
		notificationRepository      = new APSMockObjectGenerator<NotificationRepositoryImpl>().mock(notificationRepositoryImpl);
	}
	
	@Test
	public void testInsertNotifiction() throws DatabaseException{
		notification.setNotificationType("message");
		notification.setStatsus("waiting");
		notification.setMessage("Please Update email address");
		assertTrue("Unble to add Notifiction in Datbse", notificationRepository.updateNotification(notification));  
	}
	
	@Test
	public void testValidteInsert() throws DatabaseException{
		List<Notification> notifications = notificationRepository.getNotifications(Long.valueOf(1), null);
		assertEquals("The databse shoud have 2 entries", notifications.size() , 1);
	}
	
}
