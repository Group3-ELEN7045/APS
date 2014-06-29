package test.za.ac.wits.elen7045.group3.scheduler;


import static org.junit.Assert.*;

import java.util.Calendar;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;


/**
 * 
 * @author Ronald Menya
 *
 */
public class TestPeakTimes {

	/**
	 * 
	 * @throws Exception
	 */
	@Before
	public void setUp() throws Exception {
	}

	/**
	 * 
	 * @throws Exception
	 */
	@After
	public void tearDown() throws Exception {
	}

	/**
	 * 
	 */
	@Test
	public void testPeakPeriodGettersSetters() {/*
		PeakPeriod peakPeriod = new PeakPeriod();
		Calendar calendar = Calendar.getInstance();
		long startTime = calendar.getTimeInMillis();
		peakPeriod.setStartTime(startTime);
		assertTrue(peakPeriod.getStartTime() == startTime);
		calendar.add(Calendar.DATE, 2);
		long endTime = calendar.getTimeInMillis();
		peakPeriod.setEndTime(endTime);
		assertTrue(peakPeriod.getEndTime() == endTime);
		assertFalse(peakPeriod.getStartTime() == peakPeriod.getEndTime());
	*/}
	
	/**
	 * 
	 * 
	 * @throws Exception
	 */
	@Test
	public void testPeakPeriodsEquality() {/*
		PeakPeriod peakPeriod1 = new PeakPeriod();
		PeakPeriod peakPeriod2 = new PeakPeriod();
		assertTrue(peakPeriod1.equals(peakPeriod2));
		Calendar calendar =  Calendar.getInstance();
		long startTime1 = calendar.getTimeInMillis();
		peakPeriod1.setStartTime(startTime1);
		peakPeriod2.setStartTime(startTime1);
		calendar.add(Calendar.DAY_OF_WEEK, 2);
		long endTime = calendar.getTimeInMillis();
		peakPeriod1.setEndTime(endTime);
		calendar.add(Calendar.DAY_OF_WEEK, 3);
		peakPeriod2.setEndTime(calendar.getTimeInMillis());
		assertFalse(peakPeriod1.equals(peakPeriod2));
	*/}

}
