package za.ac.wits.elen7045.group3.aps.domain.entities;

import java.io.Serializable;
import java.util.Date;

import za.ac.wits.elen7045.group3.aps.domain.vo.LogonCredentials;

public class User implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1244663388016048205L;

	/** The id. */
	
	private Long                     id;
	
	/** The first name. */
	private String                   firstName;
	
	/** The lastname. */
	private String                   lastname;
	
	/** The date of birth. */
	private Date                     dateOfBirth;
	
	/** The credentials. */
	private LogonCredentials              credentials;
	
		
	private String                    stringDateOfBirth;
	
	
	/**
	 * Gets the id.
	 *
	 * @return the id
	 */
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
	public Date getDateOfBirth() {
		return dateOfBirth;
	}
	
	/**
	 * Sets the date of birth.
	 *
	 * @param dateOfBirth the new date of birth
	 */
	public void setDateOfBirth(Date dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}
	
	/**
	 * Gets the credentials.
	 *
	 * @return the credentials
	 */
	
	public LogonCredentials getCredentials() {
		return credentials;
	}

	/**
	 * Sets the credentials.
	 *
	 * @param credentials the new credentials
	 */
	public void setCredentials(LogonCredentials credentials) {
		this.credentials = credentials;
	}

	public String getStringDateOfBirth() {
		return stringDateOfBirth;
	}

	public void setStringDateOfBirth(String stringDateOfBirth) {
		this.stringDateOfBirth = stringDateOfBirth;
	}
	
	public boolean isIDValid(Long id) {
	   return this.id.equals(id);
    }
}
