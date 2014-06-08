/**
 * 
 */
package za.ac.wits.elen7045.group3.aps.services.notification;

/**
 * @author SilasMahlangu
 *
 */
public abstract class  ConfirmationNotification  implements Notification{
	
	public abstract boolean sendNotification();

	@Override
	public boolean email(String notification) {
		EmailNotification emailNotification = new EmailNotification(notification);
		return emailNotification.sendNotification();
	}

	@Override
	public boolean database(String notification) {
		DatabaseNotification databaseNotification = new DatabaseNotification(notification);
		return databaseNotification.sendNotification();
	}

	@Override
	public boolean filesystem(String notification) {
		FileNotification fileNotification = new FileNotification(notification);
		return fileNotification.sendNotification();
	}

	@Override
	public boolean sms(String notification) {
		SMSNotification smsNotification = new SMSNotification(notification);
		return smsNotification.sendNotification();
	}

	@Override
	public Notification getNotification(Notification notification) {
		// TODO Auto-generated method stub
		return null;
	}
}  
