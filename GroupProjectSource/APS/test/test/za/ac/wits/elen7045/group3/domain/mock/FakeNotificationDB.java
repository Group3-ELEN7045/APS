package test.za.ac.wits.elen7045.group3.domain.mock;
import java.util.List; 

import za.ac.wits.elen7045.group3.aps.domain.ScrapeLogResultDataAccess;
import za.ac.wits.elen7045.group3.aps.domain.entities.ScrapeLogResult;
import za.ac.wits.elen7045.group3.aps.services.exception.DatabaseException;
import za.ac.wits.elen7045.group3.aps.services.notification.ConfirmationNotification;
import za.ac.wits.elen7045.group3.aps.services.notification.DatabaseNotification;
/**
 * @author SilasMahlangu
 r
 */
public class FakeNotificationDB implements ScrapeLogResultDataAccess{
	@Override
	public boolean updateScrapeLogResult(ScrapeLogResult notification)throws DatabaseException {
		ConfirmationNotification databaseNotification = new DatabaseNotification(notification);
		return databaseNotification.sendNotification();
	}

	@Override
	public List<ScrapeLogResult> getScrapeLogResults(ScrapeLogResult notification)throws DatabaseException {
		ConfirmationNotification databaseNotification = new DatabaseNotification(notification);
		@SuppressWarnings("unchecked")
		List<ScrapeLogResult> notificationResults = (List<ScrapeLogResult>) databaseNotification.getNotification();
		return notificationResults;		
	}

	@Override
	public ScrapeLogResult updateScrapeLogResults(ScrapeLogResult notification)	throws DatabaseException {
		DatabaseNotification databaseNotification = new DatabaseNotification(notification);
		ScrapeLogResult notificationResult = databaseNotification.updateNotification();
	    return notificationResult;
	}
}
