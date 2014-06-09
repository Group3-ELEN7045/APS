<<<<<<< HEAD
/**
 * 
 */
package za.ac.wits.elen7045.group3.aps.services.notification;

/**
 * @author SilasMahlangu
 *
 */
public interface Notification {
  public boolean email(String notification);
  public boolean database(String notification);
  public boolean filesystem(String notification);
  public boolean sms(String notification);
  
  public Notification getNotification(Notification notification);
}
=======
/**
 * 
 */
package za.ac.wits.elen7045.group3.aps.services.notification;

/**
 * @author SilasMahlangu
 *
 */
public interface Notification {
  public boolean email(String notification);
  public boolean database(String notification);
  public boolean filesystem(String notification);
  public boolean sms(String notification);
  
  public Notification getNotification(Notification notification);
}
>>>>>>> f1d7158b44392326220fefc0c7a7c00174b5ec58
