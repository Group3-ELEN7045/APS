package test.za.ac.wits.group3.scrape;
/**
 * @author bakwanyana
 */
import static org.junit.Assert.*; 

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import za.ac.wits.elen7045.group3.aps.domain.entities.BillingAccount;
import za.ac.wits.elen7045.group3.aps.services.enumtypes.AccountStatusType;
import za.ac.wits.elen7045.group3.aps.vo.specification.scrape.BillingAccountSuitableForScrapeSpecification;
import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class BillingAccountSuitableForScrapeSpecTest {
	
	@Mock BillingAccount activeBillingAccount;
	@Mock BillingAccount tryingBillingAccount;
	@Mock BillingAccount inactiveBillingAccount;
	private BillingAccountSuitableForScrapeSpecification scrapeSpec;
	
	@Before
	public void init(){
		scrapeSpec = new BillingAccountSuitableForScrapeSpecification();
		when(activeBillingAccount.getAccountStatus()).thenReturn(AccountStatusType.ACTIVE.getStatusType());
		when(tryingBillingAccount.getAccountStatus()).thenReturn(AccountStatusType.TRYING.getStatusType());
		when(inactiveBillingAccount.getAccountStatus()).thenReturn(AccountStatusType.INACTIVE.getStatusType());
	}
	
	@After
	public void tearDown(){
		activeBillingAccount = null;
		tryingBillingAccount = null;
		inactiveBillingAccount = null;
	}
	
	@Test
	public void testActiveStatus(){
		assertTrue(scrapeSpec.isSatisfiedBy(activeBillingAccount));
	}
	
	@Test
	public void testInactiveStatus(){
		assertFalse(scrapeSpec.isSatisfiedBy(inactiveBillingAccount));
	}
	
	@Test 
	public void testTryingStatus(){
		assertTrue(scrapeSpec.isSatisfiedBy(tryingBillingAccount));
	}
	
}
