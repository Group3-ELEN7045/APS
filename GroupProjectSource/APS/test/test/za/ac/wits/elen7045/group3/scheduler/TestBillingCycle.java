package test.za.ac.wits.elen7045.group3.scheduler;


import java.util.Calendar;
import java.util.Date;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import za.ac.wits.elen7045.group3.aps.domain.scheduler.BillingCycle;
import junit.framework.TestCase;


/**
 * 
 * @author Ronald Menya
 *
 */
public class TestBillingCycle extends TestCase {

	/**
	 * 
	 */
	@Before
	public void init() {
		
	}
	
	/**
	 * 
	 * 
	 * @throws Exception
	 */
	@Override
	@Before
	protected void setUp() throws Exception {
		super.setUp();
		 
	}

	/**
	 * 
	 * 
	 * @throws Exception
	 */
	@Override
	@After
	protected void tearDown() throws Exception {
		super.tearDown();
		
	}

	/**
	 * 
	 */
	@Test
	public void testBillingCycleGettersSetters() {
		BillingCycle billingCycle = new BillingCycle();
		Calendar calendar =  Calendar.getInstance();
		Date startDate = calendar.getTime();
		billingCycle.setStartDate(startDate);
		assertTrue(billingCycle.getStartDate().equals(startDate));
		calendar.add(startDate.getDay(), 25);
		Date endDate = calendar.getTime();
		billingCycle.setEndDate(endDate);
		assertTrue(billingCycle.getEndDate().equals(endDate));
		assertFalse(billingCycle.getStartDate().equals(billingCycle.getEndDate()));
	}
	
	/**
	 * 
	 */
	@Test
	public void testBillingCyclesEquality() {
		BillingCycle billingCycle1 = new BillingCycle();
		BillingCycle billingCycle2 = new BillingCycle();
		assertTrue(billingCycle1.equals(billingCycle2));
		Calendar calendar =  Calendar.getInstance();
		Date startDate = calendar.getTime();
		billingCycle1.setStartDate(startDate);
		billingCycle2.setStartDate(startDate);
		calendar.add(startDate.getDay(), 25);
		Date endDate = calendar.getTime();
		billingCycle1.setEndDate(endDate);
		calendar.add(startDate.getDay(), 26);
		billingCycle2.setEndDate(calendar.getTime());
		assertFalse(billingCycle1.equals(billingCycle2));
	}
}
