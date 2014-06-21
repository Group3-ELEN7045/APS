/**
 * 
 */
package za.ac.wits.elen7045.group3.aps.services.notification;

import za.ac.wits.elen7045.group3.aps.domain.entities.ScrapeLogResult;

/**
 * @author SilasMahlangu
 *
 */
public interface Notification {
  public boolean email(String notification);
  public boolean database(ScrapeLogResult notification);
  public boolean filesystem(String notification,String filePath);
  public boolean sms(String notification);
  
  public Object getNotification();
}
