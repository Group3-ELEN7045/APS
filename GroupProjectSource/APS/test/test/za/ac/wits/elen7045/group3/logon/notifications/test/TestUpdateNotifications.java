package test.za.ac.wits.elen7045.group3.logon.notifications.test;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import test.za.ac.wits.elen7045.group3.mock.proxy.APSMockObjectGenerator;
import za.ac.wits.elen7045.group3.aps.domain.ScrapeLogResultDataAccess;
import za.ac.wits.elen7045.group3.aps.domain.entities.ScrapeLogResult;
import za.ac.wits.elen7045.group3.aps.domain.repository.notification.ScrapeLogResultImpl;
import za.ac.wits.elen7045.group3.aps.domain.repository.notification.ScrapeLogResultRepository;
import za.ac.wits.elen7045.group3.aps.services.enumtypes.NotificationStatus;
import za.ac.wits.elen7045.group3.aps.services.enumtypes.NotificationType;
import za.ac.wits.elen7045.group3.aps.services.exception.DatabaseException;
import za.ac.wits.elen7045.group3.aps.services.pattern.notification.observer.NotificationObserver;

/**
 * @author SilasMahlangu
 r
 */

public class TestUpdateNotifications {

	private ScrapeLogResult notification;
	private List<ScrapeLogResult> notifications;
	private ScrapeLogResultDataAccess notificationDataAccess;
	private ScrapeLogResultRepository notificationRepository;
	private ScrapeLogResultImpl notificationRepositoryImpl;
	private ApplicationContext context;

	@Before
	public void initilize(){
		context = new ClassPathXmlApplicationContext("res/spring/application-context-test.xml");
		notification = context.getBean(ScrapeLogResult.class);
		notificationDataAccess = context.getBean(ScrapeLogResultDataAccess.class);
		notifications = new ArrayList<ScrapeLogResult>();
		notificationRepositoryImpl = new ScrapeLogResultImpl(notificationDataAccess);
		notificationRepository = new APSMockObjectGenerator<ScrapeLogResultImpl>().mock(notificationRepositoryImpl);
	}
	
    @Test
    public void testUpdateLogonNotification(){
        notification.setAccountNumber("123456789");
        notification.setStatsus(NotificationStatus.WAITING.getNotificationStatus());
        notification.setNotificationType(NotificationType.LOGON.getNotificationType());

        NotificationObserver notificationObserver = new NotificationObserver();
        ScrapeLogResult responseNotification = new ScrapeLogResult();

        List<ScrapeLogResult> dbNotifications =(List<ScrapeLogResult>) notificationObserver.checkNotifications(notification, notificationRepository);
        if(dbNotifications != null ){
            for(ScrapeLogResult updateNotification : dbNotifications){
			    updateNotification.setStatsus(NotificationStatus.COMPLETE.getNotificationStatus());
			    try {
			    	System.out.println("Before Notification Update " + dbNotifications.size());
					ScrapeLogResult updatedNotification = notificationRepository.updateScrapeLogResults(updateNotification);
					List<ScrapeLogResult> LastdbNotifications =(List<ScrapeLogResult>) notificationObserver.checkNotifications(notification, notificationRepository);
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
}


