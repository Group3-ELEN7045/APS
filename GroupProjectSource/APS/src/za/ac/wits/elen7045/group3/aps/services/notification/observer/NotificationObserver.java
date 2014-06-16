/**
 * 
 */
package za.ac.wits.elen7045.group3.aps.services.notification.observer;

import java.util.ArrayList;
import java.util.List;


import za.ac.wits.elen7045.group3.aps.domain.entities.ScrapeLogResult;
import za.ac.wits.elen7045.group3.aps.domain.repository.notification.ScrapeLogResultRepository;
import za.ac.wits.elen7045.group3.aps.domain.vo.NotificationCheck;

/**
 * @author SilasMahlangu
 *
 */
public class NotificationObserver {
	private  NotificationPublisher pub = new NotificationPublisher();
	
	public List<ScrapeLogResult> checkNotifications(NotificationCheck checkNotification, ScrapeLogResultRepository notificationRepository){ 
	   Observer   = new NotificationListener(checkNotification,notificationRepository);
	   pub.register(one);
	   one.setSubject(pub);
	   one.update(checkNotification);
	   pub.checkNotifications(checkNotification);
	   return (List<ScrapeLogResult>) pub.getResponse(one);
	}
}
