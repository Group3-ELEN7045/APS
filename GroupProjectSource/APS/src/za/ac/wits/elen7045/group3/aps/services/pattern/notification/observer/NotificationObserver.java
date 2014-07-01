/**
 * 
 */
package za.ac.wits.elen7045.group3.aps.services.pattern.notification.observer;

import java.util.List;

import za.ac.wits.elen7045.group3.aps.domain.entities.ScrapeLogResult;
import za.ac.wits.elen7045.group3.aps.domain.repository.notification.ScrapeLogResultRepository;

/**
 * @author SilasMahlangu
 *
 */
public class NotificationObserver {
	private  NotificationPublisher notificationPublisher = new NotificationPublisher();
	
	public List<ScrapeLogResult> checkNotifications(ScrapeLogResult checkNotification, ScrapeLogResultRepository notificationRepository){ 
	   Observer notificationListenr   = new NotificationListener(checkNotification,notificationRepository);
	   notificationPublisher.register(notificationListenr);
	   notificationListenr.setSubject(notificationPublisher);
	   notificationListenr.update(checkNotification);
	   notificationPublisher.checkNotifications(checkNotification);
	   List<ScrapeLogResult> gg = (List<ScrapeLogResult>)notificationPublisher.getResponse(notificationListenr);
	   return gg;
	}
}
