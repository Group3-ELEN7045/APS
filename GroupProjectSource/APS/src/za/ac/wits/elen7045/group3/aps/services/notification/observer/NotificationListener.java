/**
 * 
 */
package za.ac.wits.elen7045.group3.aps.services.notification.observer;

import java.util.ArrayList;
import java.util.List;

import za.ac.wits.elen7045.group3.aps.domain.entities.ScrapeLogResult;
import za.ac.wits.elen7045.group3.aps.domain.repository.notification.ScrapeLogResultRepository;
import za.ac.wits.elen7045.group3.aps.domain.vo.NotificationCheck;
import za.ac.wits.elen7045.group3.aps.services.exception.DatabaseException;

/**
 * @author SilasMahlangu
 *
 */
public class NotificationListener implements Observer{
	private NotificationCheck notificationCheck;
	private Subject listener;
	ScrapeLogResultRepository  scrapeResiltsRepository;
	List<ScrapeLogResult>  notifications = new ArrayList<ScrapeLogResult>();
	public NotificationListener(NotificationCheck notificationCheck, ScrapeLogResultRepository  scrapeResiltsRepository){
		this.notificationCheck      = notificationCheck;
		this.scrapeResiltsRepository = scrapeResiltsRepository;
	}

	@Override
	public void update(Object object) {
		try {
		    if(object instanceof NotificationCheck){
		        NotificationCheck notificationCheckInternal = (NotificationCheck) object;
			    notifications = scrapeResiltsRepository.getScrapeLogResult(notificationCheckInternal.getId(), null);
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
