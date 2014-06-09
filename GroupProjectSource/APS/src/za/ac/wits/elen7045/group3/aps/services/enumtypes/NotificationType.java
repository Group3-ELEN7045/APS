<<<<<<< HEAD
/**
 * 
 */
package za.ac.wits.elen7045.group3.aps.services.enumtypes;

/**
 * @author SilasMahlangu
 *
 */
public enum NotificationType {
	SMS("SMS"), EMAIL("E"), DATABASE("DB"), LOGON("L");
	 
	private String notificationType;
 
	private NotificationType(String notificationType) {
		this.notificationType = notificationType;
	}
 
	public String getNotificationType() {
		return notificationType;
	}
}
=======
/**
 * 
 */
package za.ac.wits.elen7045.group3.aps.services.enumtypes;

/**
 * @author SilasMahlangu
 *
 */
public enum NotificationType {
	SMS("SMS"), EMAIL("E"), DATABASE("DB"), LOGON("L");
	 
	private String notificationType;
 
	private NotificationType(String notificationType) {
		this.notificationType = notificationType;
	}
 
	public String getNotificationType() {
		return notificationType;
	}
}
>>>>>>> f1d7158b44392326220fefc0c7a7c00174b5ec58
