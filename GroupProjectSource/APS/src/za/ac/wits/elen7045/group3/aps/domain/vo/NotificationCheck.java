/**
 * 
 */
package za.ac.wits.elen7045.group3.aps.domain.vo;

import java.io.Serializable;

/**
 * @author SilasMahlangu
 *
 */

//review

public class NotificationCheck implements Serializable{
	
	private Long id;
	private String notificationStatus;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	
	public String getNotificationStatus() {
		return notificationStatus;
	}
	public void setNotificationStatus(String notificationStatus) {
		this.notificationStatus = notificationStatus;
	}


}
