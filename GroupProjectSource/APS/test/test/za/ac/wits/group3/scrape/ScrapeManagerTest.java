package test.za.ac.wits.group3.scrape;

/**
 * @author boitumelo
 * 
 */
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import org.junit.Before;
import org.junit.Test;

import za.ac.wits.elen7045.group3.aps.services.scraper.ScrapeManager;

public class ScrapeManagerTest {
	
	ScrapeManager sm;
	 
	@Before
	public void setUp() throws Exception {
		sm = mock(ScrapeManager.class);		
	}

	@Test
	public void test() {
		//configure 	
		when(sm.scrapeAccount()).thenReturn(true);
		
		//exercise
		sm.scrapeAccount();
		
		verify(sm).scrapeAccount();
	}

}
