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
import za.ac.wits.elen7045.group3.aps.domain.ScrapeLogResultDataAccess;
import za.ac.wits.elen7045.group3.aps.domain.entities.ScrapeLogResult;
import za.ac.wits.elen7045.group3.aps.domain.repository.notification.ScrapeLogResultImpl;
import za.ac.wits.elen7045.group3.aps.domain.repository.notification.ScrapeLogResultRepository;
import za.ac.wits.elen7045.group3.aps.services.exception.DatabaseException;

/**
 * @author SilasMahlangu
 *
 */

public class TestsAddNotificationd {
    
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
	}
	
	@Test
	public void testInsertNotifiction() throws DatabaseException{
		notification.setNotificationType("message");
		notification.setStatsus("waiting");
		notification.setMessage("Please Update email address");
		assertTrue("Unble to add Notifiction in Datbse", notificationRepository.updateScrapeLogResult(notification));  
	}
	
	@Test
	public void testValidteInsert() throws DatabaseException{
		List<ScrapeLogResult> notifications = notificationRepository.getScrapeLogResult(Long.valueOf(1), null);
		assertEquals("The databse shoud have 2 entries", notifications.size() , 1);
	}
	
}
