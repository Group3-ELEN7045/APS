package test.za.ac.wits.elen7045.group3.scrape;

/**
 * @author boitumelo
 * 
 */
import static org.mockito.Mockito.verify;

import org.junit.Before;
import org.junit.Test;

import za.ac.wits.elen7045.group3.aps.domain.entities.BillingAccount;
import za.ac.wits.elen7045.group3.aps.domain.vo.CredentialsVO;
import za.ac.wits.elen7045.group3.aps.services.scrape.ScrapeManagerImpl;
import za.ac.wits.elen7045.group3.aps.services.scrape.exceptions.ScrapeRetryException;

public class ScrapeManagerTest {
	
	ScrapeManagerImpl scrapeManagerImpl;
	BillingAccount billingAccount;
	@Before
	public void setUp() throws Exception {
		scrapeManagerImpl = new ScrapeManagerImpl();
	}

	@Test
	public void test() {
		billingAccount = new BillingAccount(2L,98654L,"9098666546");
		billingAccount.setCredentials(new CredentialsVO());
//		billingAccount.setCompanyUrl("creditcard.xml");
		billingAccount.setCompanyUrl("municipal.xml");

		//exercise
		try {
			scrapeManagerImpl.scrapeAccount(billingAccount);
		} catch (ScrapeRetryException e) {
			e.printStackTrace();
		}
		
		try {
			verify(scrapeManagerImpl).scrapeAccount(billingAccount);
		} catch (ScrapeRetryException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
