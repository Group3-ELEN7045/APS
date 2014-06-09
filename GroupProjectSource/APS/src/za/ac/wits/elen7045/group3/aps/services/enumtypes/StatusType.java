/**
 * 
 */
package za.ac.wits.elen7045.group3.aps.services.enumtypes;

/**
 * @author SilasMahlangu
 *
 */
public enum StatusType {
	TRYING("T"), ACTIVE("A"), INACTIVE("I");
	 
	private String statusType;
 
	private StatusType(String statusType) {
		this.statusType = statusType;
	}
 
	public String getStatusType() {
		return statusType;
	}
} 