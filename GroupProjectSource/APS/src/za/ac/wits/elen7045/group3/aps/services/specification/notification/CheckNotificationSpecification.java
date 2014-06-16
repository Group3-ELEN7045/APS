/**
 * 
 */
package za.ac.wits.elen7045.group3.aps.services.specification.notification;

import za.ac.wits.elen7045.group3.aps.domain.entities.ScrapeLogResult;
import za.ac.wits.elen7045.group3.aps.services.enumtypes.NotificationStatus;
import za.ac.wits.elen7045.group3.aps.services.specification.ApplicationSpecification;

/**
 * @author SilasMahlangu
 *
 */
public class CheckNotificationSpecification extends ApplicationSpecification<ScrapeLogResult>{
 
    private ScrapeLogResult notification;	
	
	public CheckNotificationSpecification(ScrapeLogResult notification){
		this.notification = notification;
	}
	
	@Override
	public boolean isSatisfiedBy(ScrapeLogResult param) {
		return param.getStatsus().equals(NotificationStatus.WAITING.getNotificationStatus());
	}
}
