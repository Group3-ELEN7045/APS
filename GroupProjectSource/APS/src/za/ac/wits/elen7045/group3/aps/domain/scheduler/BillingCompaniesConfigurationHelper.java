package za.ac.wits.elen7045.group3.aps.domain.scheduler;


import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import za.ac.wits.elen7045.group3.aps.domain.entities.BillingCompany;


/**
 * 
 * @author Ronald Menya
 *
 */
class BillingCompaniesConfigurationHelper {

	/**
	 * 
	 */
	private List<BillingCompany> companies = new ArrayList<BillingCompany>();

	/**
	 * 
	 * @return
	 */
	public Collection<BillingCompany> getCompanies() {
		return companies;
	}
}
