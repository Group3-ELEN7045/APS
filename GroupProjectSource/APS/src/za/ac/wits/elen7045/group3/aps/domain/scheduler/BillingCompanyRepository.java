package za.ac.wits.elen7045.group3.aps.domain.scheduler;


import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.DomDriver;

import za.ac.wits.elen7045.group3.aps.domain.entities.BillingAccount;
import za.ac.wits.elen7045.group3.aps.domain.entities.BillingCompany;


/**
 * 
 * @author Ronald Menya
 *
 */
public class BillingCompanyRepository implements IBillingCompanyRepository {
    
	/**
	 * 
	 */
    private Collection<BillingCompany> companies = new ArrayList<BillingCompany>();

	/**
	 * 
	 */
	public BillingCompanyRepository() {
		companies = BillingCompaniesConfiguration.getInstance().loadBillingCompanies();
	}
	
	/**
	 * 
	 */
	public Collection<BillingCompany> getAllCompanies() {
		return this.companies;
	}
}
