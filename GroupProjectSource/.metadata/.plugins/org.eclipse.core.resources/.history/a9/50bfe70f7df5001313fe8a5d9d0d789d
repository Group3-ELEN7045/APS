/**
 * 
 */
package za.ac.wits.elen7045.group3.aps.services.specification.notification;

import za.ac.wits.elen7045.group3.aps.domain.entities.Notification;
import za.ac.wits.elen7045.group3.aps.services.enumtypes.NotificationStatus;
import za.ac.wits.elen7045.group3.aps.services.specification.ApplicationSpecification;

/**
 * @author SilasMahlangu
 *
 */
public class CheckNotificationSpecification extends ApplicationSpecification<Notification>{
 
    private Notification notification;	
	
	public CheckNotificationSpecification(Notification notification){
		this.notification = notification;
	}
	
	@Override
	public boolean isSatisfiedBy(Notification param) {
		return param.getStatsus().equals(NotificationStatus.WAITING.getNotificationStatus());
	}
}
