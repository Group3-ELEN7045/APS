
package za.ac.wits.elen7045.group3.aps.domain.entities;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import javax.persistence.Transient;

import za.ac.wits.elen7045.group3.aps.domain.vo.CredentialsVO;

/**
 * @author SilasMahlangu
 *
 */
@MappedSuperclass
public abstract class User implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1244663388016048205L;

	/** The id. */
	private Long              id;
	
	/** The first name. */
	private String           firstName;
	
	/** The lastname. */
	private String           lastname;
	
	/** The date of birth. */
	private Date             dateOfBirth;
	
	/** The credentials. */
	private CredentialsVO   credentials;
		
	private String          stringDateOfBirth;
	
	/**
	 * Gets the id.
	 *
	 * @return the id
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "ID", unique = true, nullable = false)	
	public Long getId() {
		return id;
	}
	
	/**
	 * Sets the id.
	 *
	 * @param id the new id
	 */
	public void setId(Long id) {
		this.id = id;
	}
	
	/**
	 * Gets the first name.
	 *
	 * @return the first name
	 */
	@Column(name = "FIRST_NAME", nullable = false) 
	public String getFirstName() {
		return firstName;
	}
	
	/**
	 * Sets the first name.
	 *
	 * @param firstName the new first name
	 */
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	
	/**
	 * Gets the lastname.
	 *
	 * @return the lastname
	 */
	@Column(name = "LAST_NAME", nullable = false)
	public String getLastname() {
		return lastname;
	}
	
	/**
	 * Sets the lastname.
	 *
	 * @param lastname the new lastname
	 */
	public void setLastname(String lastname) {
		this.lastname = lastname;
	}
	
	/**
	 * Gets the date of birth.
	 *
	 * @return the date of birth
	 */
	@Column(name = "DATE_OF_BIRTH",nullable = true)
	public Date getDateOfBirth() {
		return new Date();
	}
	
	/**
	 * Sets the date of birth.
	 *
	 * @param dateOfBirth the new date of birth
	 */
	public void setDateOfBirth(Date dateOfBirth) {
		this.dateOfBirth = new Date();
	}
	
	/**
	 * Gets the credentials.
	 *
	 * @return the credentials
	 */
	

	/**
	 * Sets the credentials.
	 *
	 * @param credentials the new credentials
	 */
    @Transient
	public String getStringDateOfBirth() {
		return stringDateOfBirth;
	}

	public void setStringDateOfBirth(String stringDateOfBirth) {
		this.stringDateOfBirth = stringDateOfBirth;
	}
	
	public boolean isIDValid(Long id) {
	   return this.id.equals(id);
    }
	
	@Embedded
	public CredentialsVO getCredentials() {
		return credentials;
	}

	public void setCredentials(CredentialsVO credentials) {
		this.credentials = credentials;
	}

}

