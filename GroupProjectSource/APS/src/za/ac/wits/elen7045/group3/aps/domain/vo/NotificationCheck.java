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
	
	private static final long serialVersionUID = 1L;
	private String accountNumber;
	private String notificationStatus;
		
	public String getAccountNumber() {
		return accountNumber;
	}
	public void setAccountNumber(String accountNumber) {
		this.accountNumber = accountNumber;
	}
	public String getNotificationStatus() {
		return notificationStatus;
	}
	public void setNotificationStatus(String notificationStatus) {
		this.notificationStatus = notificationStatus;
	}


}
