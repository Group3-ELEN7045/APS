/**
 * 
 */
package za.ac.wits.elen7045.group3.aps.domain.entities;

import java.io.Serializable;
import java.sql.Timestamp;

/**
 * @author SilasMahlangu
 *
 */
public class ScrapeLogResult implements Serializable{
	private Long id;
	private String notificationType;
	private String accountNumber;
	private String statsus;
	private String response;
	private String message;
	
	private Timestamp notificationDate;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getNotificationType() {
		return notificationType;
	}
	public void setNotificationType(String notificationType) {
		this.notificationType = notificationType;
	}
	public String getStatsus() {
		return statsus;
	}
	public void setStatsus(String statsus) {
		this.statsus = statsus;
	}
	public String getResponse() {
		return response;
	}
	public void setResponse(String response) {
		this.response = response;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public Timestamp getNotificationDate() {
		return notificationDate;
	}
	public void setNotificationDate(Timestamp notificationDate) {
		this.notificationDate = notificationDate;
	}
	
}
