/**
 * 
 */
package za.ac.wits.elen7045.group3.aps.domain.repository.notification;

import java.util.List;

import za.ac.wits.elen7045.group3.aps.domain.NotificationDataAccess;
import za.ac.wits.elen7045.group3.aps.domain.entities.Notification;
import za.ac.wits.elen7045.group3.aps.services.exception.DatabaseException;

/**
 * @author SilasMahlangu
 r
 */
public class NotificationRepositoryImpl implements NotificationRepository{
	
	private NotificationDataAccess notificationDataAccess;
	
	public NotificationRepositoryImpl(NotificationDataAccess notificationDataAccess){
		this.notificationDataAccess = notificationDataAccess;
	}

	@Override
	public boolean updateNotification(Notification notification)
			throws DatabaseException {
		return notificationDataAccess.updateNotification(notification);
	
	}

	@Override
	public List<Notification> getNotifications(Long id, String status) throws DatabaseException {
		return notificationDataAccess.getNotifications(id, status);
	}

}
