<<<<<<< HEAD
/**
 * 
 */
package za.ac.wits.elen7045.group3.aps.services.notification;

/**
 * @author SilasMahlangu
 *
 */
public class DatabaseNotification extends ConfirmationNotification{
    private String notificationData;
    
    public DatabaseNotification(String notificationData){
    	this.notificationData = notificationData;
    }
	
	@Override
	public boolean sendNotification() {
		System.out.println("Database Notification" + notificationData);
		return true;
	}

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
public class DatabaseNotification extends ConfirmationNotification{
    private String notificationData;
    
    public DatabaseNotification(String notificationData){
    	this.notificationData = notificationData;
    }
	
	@Override
	public boolean sendNotification() {
		System.out.println("Database Notification" + notificationData);
		return true;
	}

}
>>>>>>> f1d7158b44392326220fefc0c7a7c00174b5ec58
