/**
 * 
 */
package za.ac.wits.elen7045.group3.aps.services.enumtypes;

/**
 * @author SilasMahlangu
 *
 */
public enum ContactType {
	EMAIL("E"), CELLPHONE("CL"), PHONEHOME("PH"), PHONEWORK("PW");
	 
	private String contactType;
 
	private ContactType(String contactType) {
		this.contactType = contactType;
	}
 
	public String getContactType() {
		return contactType;
	}
 

}
