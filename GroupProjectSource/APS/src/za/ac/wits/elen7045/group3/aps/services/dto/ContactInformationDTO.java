package za.ac.wits.elen7045.group3.aps.services.dto;

public class ContactInformationDTO {
	private String contactType;
	private String contactValue;
    
	public String getContactValue() {
		return contactValue;
	}

	public void setContactValue(String contactValue) {
		this.contactValue = contactValue;
	}

	public String getContactType() {
		return contactType;
	}

	public void setContactType(String contactType) {
		this.contactType = contactType;
	}
}
