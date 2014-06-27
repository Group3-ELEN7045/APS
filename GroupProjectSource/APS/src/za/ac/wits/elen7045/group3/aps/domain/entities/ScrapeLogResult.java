
/**
 * 
 */
package za.ac.wits.elen7045.group3.aps.domain.entities;

import java.io.Serializable;
import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Table;

/**
 * @author SilasMahlangu
 *
 */
@Entity
@Table(name="Notifications")
public class ScrapeLogResult implements Serializable{
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "ID", unique = true, nullable = false)	
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
	
	@Column(name = "NOTIFICATION_STATUS")
	public String getStatsus() {
		return statsus;
	}
	public void setStatsus(String statsus) {
		this.statsus = statsus;
	}

	@Column(name = "NOTIFICATION_RESPONSE", columnDefinition="varchar(1000)")
	public String getResponse() {
		return response;
	}
	public void setResponse(String response) {
		this.response = response;
	}
	
	@Column(name = "NOTIFICATION_MESSAGE")
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	
	@Column(name = "NOTIFICATION_DATE")
	public Timestamp getNotificationDate() {
		return notificationDate;
	}
	public void setNotificationDate(Timestamp notificationDate) {
		this.notificationDate = notificationDate;
	}
	
	@Column(name = "NOTIFICATION_ACCONTNUMBER")
	public String getAccountNumber() {
		return accountNumber;
	}
	public void setAccountNumber(String accountNumber) {
		this.accountNumber = accountNumber;
	}
	
	@Override
	public String toString() {
		return "\n Account Number : ".concat(this.accountNumber.concat("\n scraped on: ".concat(null!=notificationDate?notificationDate.toString():"")
				.concat("\n status: ".concat(null!=statsus?statsus:""))
				.concat("\n ------ \n ".concat(null!=response?response:""))));
	}
}
