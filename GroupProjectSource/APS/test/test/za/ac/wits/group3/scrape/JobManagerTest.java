package test.za.ac.wits.group3.scrape;

import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

public class JobManagerTest {
	
	JobManagerMock jmo;
	
	@Before
	public void setUp() throws Exception {
		jmo = new JobManagerMock();
	}

	@Test
	public void test() {
		assertTrue(jmo.getSm().scrapeAccount());
	}

}
