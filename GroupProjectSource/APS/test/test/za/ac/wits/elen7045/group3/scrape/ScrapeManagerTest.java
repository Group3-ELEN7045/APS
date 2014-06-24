package test.za.ac.wits.elen7045.group3.scrape;

/**
 * @author boitumelo
 * 
 */
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

import org.junit.Before;
import org.junit.Test;

import za.ac.wits.elen7045.group3.aps.domain.entities.BillingAccount;
import za.ac.wits.elen7045.group3.aps.domain.vo.CredentialsVO;
import za.ac.wits.elen7045.group3.aps.services.scrape.ScrapeManagerImpl;
import za.ac.wits.elen7045.group3.aps.services.scrape.exceptions.ScrapeRetryException;

public class ScrapeManagerTest {
	
	ScrapeManagerImpl sm;
	BillingAccount billingAccount;
	@Before
	public void setUp() throws Exception {
		sm = mock(ScrapeManagerImpl.class);		
	}

	@Test
	public void test() {
		billingAccount = new BillingAccount(2L,98654L,"9098666546");
		billingAccount.setCredentials(new CredentialsVO());
		billingAccount.setCompanyUrl("creditcard.xml");
		//configure 	
//		when(sm.scrapeAccount(billingAccount)).thenReturn(true);
		
		//exercise
		try {
			sm.scrapeAccount(billingAccount);
		} catch (ScrapeRetryException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		try {
			verify(sm).scrapeAccount(billingAccount);
		} catch (ScrapeRetryException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private Object when(Object scrapeAccount) {
		// TODO Auto-generated method stub
		return null;
	}

}
