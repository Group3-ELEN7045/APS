package test.za.ac.wits.elen7045.group3.scheduler;
 

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import za.ac.wits.elen7045.group3.aps.domain.entities.BillingCompany;
import junit.framework.TestCase;


/**
 * 
 * @author Sibusiso Zwane
 * @author Ronald Menya
 *
 */
public class TestingBillingCompany extends TestCase {

	@Override
	@Before
	protected void setUp() throws Exception {
		super.setUp();
	}

	@Override
	@After
	protected void tearDown() throws Exception {
		super.tearDown();
	}

	@Test
	public void testBillingCompanyCreation() {
		String companyName = "COJ";
		BillingCompany billingCompany = new BillingCompany(companyName);
		billingCompany.setCompanyName("COJ");
		assertTrue(companyName.equals(billingCompany.getCompanyName()));
		String url = "http://www";
		billingCompany.setURL(url);
		assertTrue(url.equals(billingCompany.getUrl()));
	}	
	
	@Test
	public void testBillingCompanysEquality() {
		String companyName1 = "COJ";
		BillingCompany billingCompany1 = new BillingCompany(companyName1);
		String companyName2 = "COJ";
		BillingCompany billingCompany2 = new BillingCompany(companyName2);
		assertTrue(billingCompany1.equals(billingCompany2));
	}
}
