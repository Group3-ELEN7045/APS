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
