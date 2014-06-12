
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