package za.ac.wits.elen7045.group3.aps.domain.entities;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @author Livious
 *
 */
@Entity
@Table(name="BILLING_COMPANY")
public class BillingCompany implements Serializable{
	
	private static final long serialVersionUID = 1L;
	private Long id;
	private String companyName;
	private String url;
	private String companyStatementType;
		
	@Column(name = "COMPANY_NAME", nullable = false) 
	public String getCompanyName() {
		return companyName;
	}
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "ID", unique = true, nullable = false)	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	@Column(name = "COMPANY_STATEMENT_TYPE", nullable = false) 
	public String getCompanyStatementType() {
		return companyStatementType;
	}
	public void setCompanyStatementType(String companyStatementType) {
		this.companyStatementType = companyStatementType;
	}
	
	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}
	@Column(name = "URL", nullable = false) 
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}	
}
