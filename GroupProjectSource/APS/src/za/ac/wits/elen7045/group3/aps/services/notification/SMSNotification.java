<<<<<<< HEAD
/**
 * 
 */
package za.ac.wits.elen7045.group3.aps.services.notification;

/**
 * @author SilasMahlangu
 *
 */
public class SMSNotification extends ConfirmationNotification{
    
	private String notificationData;
	
	public SMSNotification(String notificatioData){
		this.notificationData = notificatioData;
	}

	@Override
	public boolean sendNotification() {
		System.out.println("Beep Beep  Beeep " + this.notificationData);
		return false;
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
public class SMSNotification extends ConfirmationNotification{
    
	private String notificationData;
	
	public SMSNotification(String notificatioData){
		this.notificationData = notificatioData;
	}

	@Override
	public boolean sendNotification() {
		System.out.println("Beep Beep  Beeep " + this.notificationData);
		return false;
	}
	
	
}
>>>>>>> f1d7158b44392326220fefc0c7a7c00174b5ec58
