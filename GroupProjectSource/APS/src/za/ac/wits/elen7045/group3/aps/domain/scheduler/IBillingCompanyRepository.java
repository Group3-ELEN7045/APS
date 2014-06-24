package za.ac.wits.elen7045.group3.aps.domain.scheduler;


import java.util.Collection;
import za.ac.wits.elen7045.group3.aps.domain.entities.BillingCompany;


/**
 * 
 * @author Ronald Menya
 *
 */
public interface IBillingCompanyRepository {

	public Collection<BillingCompany> getAllCompanies();
}
