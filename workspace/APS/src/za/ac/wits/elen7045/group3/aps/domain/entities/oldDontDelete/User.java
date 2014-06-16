package za.ac.wits.elen7045.group3.aps.domain.entities.oldDontDelete;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

@Entity
@Table(name="ApplicationUser")
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
	private Credentials              credentials;
	
	/** The account details. */
	private List<AccountDetails>     accountDetails = new ArrayList<AccountDetails>();
	
	/** The contact details. */
	private List<ContactInformation> contactDetails = new ArrayList<ContactInformation>();
	
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
	@Column(name = "DATE_OF_BIRTH", nullable = false)
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
	
	@OneToOne(cascade=CascadeType.ALL)
	public Credentials getCredentials() {
		return credentials;
	}

	/**
	 * Sets the credentials.
	 *
	 * @param credentials the new credentials
	 */
	public void setCredentials(Credentials credentials) {
		this.credentials = credentials;
	}

	/**
	 * Gets the account details.
	 *
	 * @return the account details
	 */
	
	@OneToMany(cascade=CascadeType.ALL) 
	public List<AccountDetails> getAccountDetails() {
		return accountDetails;
	}

	/**
	 * Sets the account details.
	 *
	 * @param accountDetails the new account details
	 */
	public void setAccountDetails(List<AccountDetails> accountDetails) {
		this.accountDetails = accountDetails;
	}
	
	/**
	 * Gets the contact details.
	 *
	 * @return the contact details
	 */
	
	@LazyCollection(LazyCollectionOption.FALSE)
	@OneToMany(cascade=CascadeType.ALL)
	public List<ContactInformation> getContactDetails() {
		return contactDetails;
	}

	/**
	 * Sets the contact details.
	 *
	 * @param contactDetails the new contact details
	 */
	public void setContactDetails(List<ContactInformation> contactDetails) {
		this.contactDetails = contactDetails;
	}
}
