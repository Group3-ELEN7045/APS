/**
 * 
 */
package za.ac.wits.elen7045.group3.aps.services.notification.observer;

import java.util.ArrayList;
import java.util.List;

import test.za.ac.wits.group3.mock.proxy.APSMockObjectGenerator;
import za.ac.wits.elen7045.group3.aps.domain.entities.Notification;
import za.ac.wits.elen7045.group3.aps.domain.repository.notification.NotificationRepository;
import za.ac.wits.elen7045.group3.aps.domain.repository.notification.NotificationRepositoryImpl;
import za.ac.wits.elen7045.group3.aps.domain.vo.NotificationCheck;
import za.ac.wits.elen7045.group3.aps.services.exception.DatabaseException;

/**
 * @author SilasMahlangu
 *
 */
public class NotificationListener implements Observer{
	private NotificationCheck notificationCheck;
	private Subject listener;
	NotificationRepository  notificationRepository;
	List<Notification>  notifications = new ArrayList<Notification>();
	public NotificationListener(NotificationCheck notificationCheck, NotificationRepository  notificationRepository){
		this.notificationCheck      = notificationCheck;
		this.notificationRepository = notificationRepository;
	}

	@Override
	public void update(Object object) {
		try {
		    if(object instanceof NotificationCheck){
		        NotificationCheck notificationCheckInternal = (NotificationCheck) object;
			    notifications = notificationRepository.getNotifications(notificationCheckInternal.getId(), null);
			    listener.setResponse(notifications);
			 }
		} catch (DatabaseException e) {
		   e.printStackTrace();
		}
	}

	@Override
	public void setSubject(Subject subject) {
		this.listener = subject;
	}
}
