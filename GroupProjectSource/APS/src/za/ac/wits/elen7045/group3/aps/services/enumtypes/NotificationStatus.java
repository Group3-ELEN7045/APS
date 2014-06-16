/**
 * 
 */
package za.ac.wits.elen7045.group3.aps.services.enumtypes;

/**
 * @author SilasMahlangu
 *
 */
public enum NotificationStatus {
	WAITING("w"), COMPLETE("C");
	 
	private String notificationStatus;
 
	private NotificationStatus(String notificationStatus) {
		this.notificationStatus = notificationStatus;
	}
 
	public String getNotificationStatus() {
		return notificationStatus;
	}
}
