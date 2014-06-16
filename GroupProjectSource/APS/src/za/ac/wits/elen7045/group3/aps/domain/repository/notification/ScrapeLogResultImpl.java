/**
 * 
 */
package za.ac.wits.elen7045.group3.aps.domain.repository.notification;

import java.util.List;

import za.ac.wits.elen7045.group3.aps.domain.ScrapeLogResultDataAccess;
import za.ac.wits.elen7045.group3.aps.domain.entities.ScrapeLogResult;
import za.ac.wits.elen7045.group3.aps.services.exception.DatabaseException;

/**
 * @author SilasMahlangu
 r
 */
public class ScrapeLogResultImpl implements ScrapeLogResultRepository{
	
	private ScrapeLogResultDataAccess notificationDataAccess;
	
	public ScrapeLogResultImpl(ScrapeLogResultDataAccess notificationDataAccess){
		this.notificationDataAccess = notificationDataAccess;
	}

	@Override
	public boolean updateScrapeLogResult(ScrapeLogResult notification)
			throws DatabaseException {
		return notificationDataAccess.updateNotification(notification);
	
	}

	@Override
	public List<ScrapeLogResult> getScrapeLogResult(Long id, String status) throws DatabaseException {
		return notificationDataAccess.getNotifications(id, status);
	}

}