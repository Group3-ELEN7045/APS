/**
 * 
 */
package za.ac.wits.elen7045.group3.aps.domain.repository.notification;

import java.util.List;

import za.ac.wits.elen7045.group3.aps.domain.entities.Notification;
import za.ac.wits.elen7045.group3.aps.services.exception.DatabaseException;

/**
 * @author SilasMahlangu
 *
 */
public interface NotificationRepository {
    public boolean updateNotification(Notification notification)throws DatabaseException;
    public List<Notification> getNotifications(Long id,String status) throws DatabaseException;
}
