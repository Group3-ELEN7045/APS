package za.ac.wits.elen7045.group3.aps.domain.entities.oldDontDelete;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="CONTACT_INFORMATION")
public class ContactInformation implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Long   id; 	
	private String contactType;
	private String contactValue;
    
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO) 
	@Column(name = "ID", unique = true, nullable = false)	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	@Column(name = "CONTACT_VALUE", nullable = false)  
	public String getContactValue() {
		return contactValue;
	}

	public void setContactValue(String contactValue) {
		this.contactValue = contactValue;
	}

	@Column(name = "CONTACT_TYPE", nullable = false) 
	public String getContactType() {
		return contactType;
	}

	public void setContactType(String contactType) {
		this.contactType = contactType;
	}
	
}
