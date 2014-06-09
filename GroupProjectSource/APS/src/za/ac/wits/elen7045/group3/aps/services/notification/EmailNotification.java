<<<<<<< HEAD
/**
 * 
 */
package za.ac.wits.elen7045.group3.aps.services.notification;

/**
 * @author SilasMahlangu
 *
 */
public class EmailNotification extends ConfirmationNotification{
    
	private String notificationData;
	public  EmailNotification(String notificationData){
		this.notificationData = notificationData;
	}
	
	@Override
	public boolean sendNotification() {
		System.out.println("Sending email Natification " + notificationData);
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
public class EmailNotification extends ConfirmationNotification{
    
	private String notificationData;
	public  EmailNotification(String notificationData){
		this.notificationData = notificationData;
	}
	
	@Override
	public boolean sendNotification() {
		System.out.println("Sending email Natification " + notificationData);
		return true;
	}
   
}
>>>>>>> f1d7158b44392326220fefc0c7a7c00174b5ec58
