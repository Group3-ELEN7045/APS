/**
 * 
 */
package za.ac.wits.elen7045.group3.aps.services.notification.observer;

import java.util.List;


import za.ac.wits.elen7045.group3.aps.domain.entities.ScrapeLogResult;
import za.ac.wits.elen7045.group3.aps.domain.repository.notification.ScrapeLogResultRepository;
import za.ac.wits.elen7045.group3.aps.domain.vo.NotificationCheck;

/**
 * @author SilasMahlangu
 *
 */
public class NotificationObserver {
	private  NotificationPublisher notificationPublisher = new NotificationPublisher();
	
	public List<ScrapeLogResult> checkNotifications(NotificationCheck checkNotification, ScrapeLogResultRepository notificationRepository){ 
	   Observer notificationListenr   = new NotificationListener(checkNotification,notificationRepository);
	   notificationPublisher.register(notificationListenr);
	   notificationListenr.setSubject(notificationPublisher);
	   notificationListenr.update(checkNotification);
	   notificationPublisher.checkNotifications(checkNotification);
	   return (List<ScrapeLogResult>) notificationPublisher.getResponse(notificationListenr);
	}
}
