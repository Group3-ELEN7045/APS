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
public class TestMaintainaceWindow extends TestCase {

	/**
	 * 
	 * 
	 * @throws Exception
	 */
	@Before
	protected void setUp() throws Exception {
		super.setUp();
	}

	/**
	 * 
	 * 
	 * @throws Exception
	 */
	@After
	protected void tearDown() throws Exception {
		super.tearDown();
	}

	
	/**
	 * 
	 * 
	 * @throws Exception
	 */
	@Test
	public void testMaintenanceWindowGettersSetters() {/*
		MaintenanceWindow  maintenanceWindow = new MaintenanceWindow();
		Calendar calendar = Calendar.getInstance();
		long startTime = calendar.getTimeInMillis();
		maintenanceWindow.setStartTime(startTime);
		assertTrue(maintenanceWindow.getStartTime() == startTime);
		calendar.add(Calendar.DATE, 2);
		long endTime = calendar.getTimeInMillis();
		maintenanceWindow.setEndTime(endTime);
		assertTrue(maintenanceWindow.getEndTime() == endTime);
		assertFalse(maintenanceWindow.getStartTime() == maintenanceWindow.getEndTime());
	*/}
	
	/**
	 * 
	 * 
	 * @throws Exception
	 */
	@Test
	public void testMaintenanceWindowsEquality() {/*
		MaintenanceWindow maintenanceWindow1 = new MaintenanceWindow();
		MaintenanceWindow maintenanceWindow2 = new MaintenanceWindow();
		assertTrue(maintenanceWindow1.equals(maintenanceWindow2));
		Calendar calendar =  Calendar.getInstance();
		long startTime1 = calendar.getTimeInMillis();
		maintenanceWindow1.setStartTime(startTime1);
		maintenanceWindow2.setStartTime(startTime1);
		calendar.add(Calendar.DAY_OF_WEEK, 2);
		long endTime = calendar.getTimeInMillis();
		maintenanceWindow1.setEndTime(endTime);
		calendar.add(Calendar.DAY_OF_WEEK, 3);
		maintenanceWindow2.setEndTime(calendar.getTimeInMillis());
		assertFalse(maintenanceWindow1.equals(maintenanceWindow2));
	*/}
}
