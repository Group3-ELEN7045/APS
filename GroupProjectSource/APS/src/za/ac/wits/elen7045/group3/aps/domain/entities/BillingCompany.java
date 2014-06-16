package za.ac.wits.elen7045.group3.aps.domain.entities;

import java.io.Serializable;


/**
 * @author Livious
 *
 */

public class BillingCompany implements Serializable{
	private String companyName;
	private String url;
		
	public String getCompanyName() {
		return companyName;
	}
	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}	
}
