package za.ac.wits.elen7045.group3.aps.services.dto;

import java.io.Serializable;
import java.util.List;

import za.ac.wits.elen7045.group3.aps.domain.entities.BillingAccount;
import za.ac.wits.elen7045.group3.aps.services.enumtypes.CompanyStatementType;

public class BillingCompanyDTO implements Serializable{
	
	/**
	 * @author SilasMahlangu
	 *
	 */
	
	private static final long serialVersionUID = 1L;
	private String companyName;
	private String url;
	private List<BillingAccount> billingAccounts; 
	private CompanyStatementType companyType;
	
	
	public List<BillingAccount> getBillingAccounts() {
		return billingAccounts;
	}
	public void setBillingAccounts(List<BillingAccount> billingAccounts) {
		this.billingAccounts = billingAccounts;
	}
	
	public void addBillingAccounts(BillingAccount billingAccount){
		billingAccounts.add(billingAccount);
	}
	public CompanyStatementType getCompanyType() {
		return companyType;
	}
	public void setCompanyType(CompanyStatementType companyType) {
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
