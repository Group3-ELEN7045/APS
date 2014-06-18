package za.ac.wits.elen7045.group3.aps.domain.entities;

import java.io.Serializable;
import java.util.List;
import za.ac.wits.elen7045.group3.aps.services.enumtypes.ComanyStatementType;

/**
 * @author Livious
 *
 */

public class BillingCompany implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String companyName;
	private String url;
	private List<BillingAccount> billingAccounts; 
	private ComanyStatementType companyType;
	
	public BillingCompany(String companyName){
		this.companyName = companyName;
	}
	
	public List<BillingAccount> getBillingAccounts() {
		return billingAccounts;
	}
	public void setBillingAccounts(List<BillingAccount> billingAccounts) {
		this.billingAccounts = billingAccounts;
	}
	
	public void addBillingAccounts(BillingAccount billingAccount){
		billingAccounts.add(billingAccount);
	}
	public ComanyStatementType getCompanyType() {
		return companyType;
	}
	public void setCompanyType(ComanyStatementType companyType) {
		this.companyType = companyType;
	}

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
