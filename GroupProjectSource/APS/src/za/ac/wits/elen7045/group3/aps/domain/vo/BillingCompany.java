package za.ac.wits.elen7045.group3.aps.domain.vo;

import za.ac.wits.elen7045.group3.aps.domain.accounts.abtracts.AccountType;
import za.ac.wits.elen7045.group3.aps.services.util.CompanyIDGenerator;

public class BillingCompany {
	/**
	 * @author BakwanyanaThobela
	 *
	 */
	private long companyID;
	private String name = "";
	private String URL = "";
	private String accountType;
	
	public BillingCompany(String name, String URL, String accountType)
	{
		this.accountType = accountType;
		this.URL = URL;
		this.name = name;
		companyID = CompanyIDGenerator.generateCompanyID();
	}

	@Override
	public String toString() {
		return "BillingCompany [companyID=" + companyID + ", name=" + name
				+ ", URL=" + URL + ", accountType=" + accountType + "]";
	}
	
	
	

}