/**
 * 
 */
package za.ac.wits.elen7045.group3.aps.services.notification;

import za.ac.wits.elen7045.group3.aps.domain.entities.ScrapeLogResult;

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
	public boolean database(ScrapeLogResult notification) {
		DatabaseNotification databaseNotification = new DatabaseNotification(notification);
		return databaseNotification.sendNotification();
	}

	@Override
	public boolean filesystem(String notification,String filePath) {
		FileNotification fileNotification = new FileNotification(notification,filePath);
		return fileNotification.sendNotification();
	}

	@Override
	public boolean sms(String notification) {
		SMSNotification smsNotification = new SMSNotification(notification);
		return smsNotification.sendNotification();
	}

	
}  
