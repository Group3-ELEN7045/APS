package test.za.ac.wits.elen7045.group3.scheduler;

import static org.junit.Assert.*;

import java.text.SimpleDateFormat; 
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.text.ParseException;

import junit.framework.TestCase;
import za.ac.wits.elen7045.group3.aps.domain.entities.*;
import za.ac.wits.elen7045.group3.aps.domain.scheduler.*;

import org.jmock.Expectations;
import org.jmock.Mockery;
import org.junit.Test;

/**
 * @author Sibusiso
 *
 */


public class ScheduleTest extends TestCase {

	@Before
	protected void setUp() throws Exception {
		super.setUp();
	}

	@After
	protected void tearDown() throws Exception {
		super.tearDown();
	}
	
	@Test
	public void testBillingCompanydatetimes() throws ParseException {
		String companyName="COJ";
		BillingCompany billingCompany = new BillingCompany(companyName);
		
		String dstart="2014/05/28";
        String dend="2014/05/30";
        long lstart=1406524199000l;
        long lend=1406534299000l;
					
				BillingCycle billingCycle=new BillingCycle();
		        MaintenanceWindow maintenanceWindow=new MaintenanceWindow();
				PeakPeriod peakPeriod=new PeakPeriod();
		//String expectedPattern = ;
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy/MM/dd");
		 try {
		
		        Date startDate = formatter.parse(dstart);
			    Date endDate = formatter.parse(dend); 
			    
			    billingCycle.setStartDate(startDate);
			    billingCycle.setEndDate(endDate);
			    maintenanceWindow.setStartTime(lstart);
			    maintenanceWindow.setEndTime(lend);
			    peakPeriod.setStartTime(lstart);
			    peakPeriod.setEndTime(lend);
			    
			    assertNotEquals(billingCompany.getBillingcylce(),billingCycle); 
			    billingCompany.setBillingcylce(billingCycle);
			    assertEquals(billingCompany.getBillingcylce(),billingCycle); 
			    
			    assertNotEquals(billingCompany.getMaintenancewindow(),maintenanceWindow); 
                billingCompany.setMaintenancewindow(maintenanceWindow);;
			    assertEquals(billingCompany.getMaintenancewindow(),maintenanceWindow); 
			    
			    
			    assertNotEquals(billingCompany.getPeakperiod(),peakPeriod); 
                billingCompany.setPeakperiod(peakPeriod);;
			    assertEquals(billingCompany.getPeakperiod(),peakPeriod); 
	 
			} catch (ParseException e) {
				e.printStackTrace();
			}
		  
	}
	
/*	@Test
	   @SuppressWarnings("deprecation")
	public void testaccount()   throws Exception { 
		        // set up

		        Mockery context = new Mockery();

		        final BillingAccount mockTranslator = context.mock(BillingAccount.class);

		        BillingCompany account = new BillingCompany ("COJ");

		        // expectations

		        context.checking(new Expectations() {{

		            one (mockTranslator).getAccountNumber();

		            will(returnValue(123));

		        }});
		        
		        List<BillingAccount> accounts = account.getBillingAccounts();
				Iterator<BillingAccount> allaccounts=accounts.iterator(); 
				while (allaccounts.hasNext()){ 
					System.out.println(allaccounts.next().getAccountNumber()); 
				}
		      //  assertEquals(123, x);

		        // verify

		       // context.assertIsSatisfied();
		
	} */
	
	@Test
	public void testcomparetimes() throws ParseException {

        long lstart=1406524199000l;
        long lend=1406611299000l; 
        //long lsche=1406584199000l; // between
        //long lsche=1406404199000l; //before
        long lsche=1406781299000l;   //after
        
			    Date date=new Date(lstart);
			    Date date2=new Date(lend); 
			    Date datesched=new Date(lsche); 
		        int x =  datesched.compareTo(date) + datesched.compareTo(date2);
              //  System.out.println(x); 
		        
//		        if stime between x=0;
//		        if stime before x=-2;
//		        if stime after x=2;

//		        if stime eq start < end x=-1;
//		        if stime eq end   > start  x=1;
		 
	}
	@Test
	public void testchecktimeslong() throws ParseException {
       // long lstart;   
		
        long lstart=1406524199000l;
        long lend=1406611299000l; 
        long lsche=1406584199000l; // between
        int returnvalue;
        
       // returnvalue=schedulertimes.comparetimes(lsche, lstart, lend);
        //assertEquals(returnvalue,0); 
         
        lsche=1406404199000l; //before 
       // returnvalue=schedulertimes.comparetimes(lsche, lstart, lend);
        //assertEquals(returnvalue,2); 
           
        lsche=1406781299000l;   //after 
       // returnvalue=schedulertimes.comparetimes(lsche, lstart, lend);
        //assertEquals(returnvalue,2);   
	}
	
	@Test
	public void testchecktimesdates() throws ParseException {
		String companyName="COJ";
		BillingCompany billingCompany = new BillingCompany(companyName); 
        int returnvalue;
         
        long lsche=1406404199000l;//1406530200000l
	    Date datesched ;  
	    
		BillingCycle billingCycle=new BillingCycle(); 
		String dstart="2014/07/28";
        String dend="2014/07/30";  
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy/MM/dd");
		 try {
		
		        Date startDate = formatter.parse(dstart);
			    Date endDate = formatter.parse(dend); 
				  			    
			    billingCycle.setStartDate(startDate);
			    billingCycle.setEndDate(endDate);  
			    billingCompany.setBillingcylce(billingCycle); 
			      
			}
	        catch (ParseException e) {
				 e.printStackTrace();
			} 
		 

		    BillingCycle mybillingCycle=billingCompany.getBillingcylce();  
		      
		       lsche=1406781299000l;   //after
		        datesched=new Date(lsche); 
	//	        returnvalue=schedulertimes.comparetimes(lsche, mybillingCycle.getStartDate(), mybillingCycle.getEndDate());
	//	        assertEquals(returnvalue,2);     
			    
			    lsche=1406281299000l;   //before
			    datesched=new Date(lsche); 
	//	        returnvalue=schedulertimes.comparetimes(lsche,mybillingCycle.getStartDate(), mybillingCycle.getEndDate());
	//	        assertEquals(returnvalue,2);   
			     
			    lsche=1406591299000l;   //between
			    datesched=new Date(lsche); 
	//	        returnvalue=schedulertimes.comparetimes(lsche,mybillingCycle.getStartDate(), mybillingCycle.getEndDate());
	//	        assertEquals(returnvalue,0); 
	 		    

			    lsche=1406671200000l;   //scheduletime
			    datesched=new Date(lsche); 
		 //       returnvalue=schedulertimes.comparetimes(lsche,mybillingCycle.getEndDate(), mybillingCycle.getEndDate());
		       // assertEquals(returnvalue,0);     
			    
	   
	}
	
	
	@Test
	public void testLegaltimes() throws ParseException {
		String companyName="COJ";
		BillingCompany billingCompany = new BillingCompany(companyName); 

	    long lschedule=1406671200000l;    
		String dstart="2014/05/28";
        String dend="2014/05/30";
        long lstart=1406524199000l;
        long lend=1406534299000l;
		Date 	startDate, 	endDate;	
				BillingCycle billingCycle=new BillingCycle();
		        MaintenanceWindow maintenanceWindow=new MaintenanceWindow();
				PeakPeriod peakPeriod=new PeakPeriod();
				
		//String expectedPattern = ;
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy/MM/dd");
		 try {
		         startDate = formatter.parse(dstart);
			     endDate = formatter.parse(dend); 
			    
			    billingCycle.setStartDate(startDate);
			    billingCycle.setEndDate(endDate);
			    maintenanceWindow.setStartTime(lstart);
			    maintenanceWindow.setEndTime(lend);
			    peakPeriod.setStartTime(lstart);
			    peakPeriod.setEndTime(lend);

	 
			} catch (ParseException e) {
				e.printStackTrace();
			}
		 
			    billingCompany.setBillingcylce(billingCycle);   
                billingCompany.setMaintenancewindow(maintenanceWindow); 
                billingCompany.setPeakperiod(peakPeriod); 
	 
		  LegalTimes legality=new LegalTimes(billingCompany, lschedule);
		  boolean isLegal=legality.IsLegal();
		  assertTrue(isLegal);
		  boolean isScheduleTime=legality.IsLegal(new Date(lschedule)); 
		  assertTrue(isLegal);
		    lschedule=1401351200000l; //During Peak
		    legality=new LegalTimes(billingCompany, lschedule);
		     isLegal=legality.IsLegal();
			  assertFalse(isLegal);
	}
	
	
	@Test
	public void testSchedulingTask() 
	{
		String companyName="COJ";
		BillingCompany billingCompany = new BillingCompany(companyName); 

	    long lschedule=1406671200000l;    
		String dstart="2014/05/28";
        String dend="2014/05/30";
        long lstart=1406524199000l;
        long lend=1406534299000l;
		Date 	startDate, 	endDate;	
				BillingCycle billingCycle=new BillingCycle();
		        MaintenanceWindow maintenanceWindow=new MaintenanceWindow();
				PeakPeriod peakPeriod=new PeakPeriod();
				
		//String expectedPattern = ;
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy/MM/dd");
		 try {
		         startDate = formatter.parse(dstart);
			     endDate = formatter.parse(dend); 
			    
			    billingCycle.setStartDate(startDate);
			    billingCycle.setEndDate(endDate);
			    maintenanceWindow.setStartTime(lstart);
			    maintenanceWindow.setEndTime(lend);
			    peakPeriod.setStartTime(lstart);
			    peakPeriod.setEndTime(lend);

	 
			} catch (ParseException e) {
				e.printStackTrace();
			}
		 
			    billingCompany.setBillingcylce(billingCycle);   
                billingCompany.setMaintenancewindow(maintenanceWindow); 
                billingCompany.setPeakperiod(peakPeriod); 
                LegalTimes legality=new LegalTimes(billingCompany, lschedule);
                
      		  boolean isLegal=legality.IsLegal();
      		  assertTrue(isLegal);
 
      		  boolean isScheduleTime=legality.IsLegal(new Date(lschedule)); 
      		  assertTrue(isScheduleTime);

                   if (isScheduleTime && isLegal)      
                {
                BillingAccount ac1=new BillingAccount(); 
                BillingAccount ac2=new BillingAccount();
                BillingAccount tmp=new BillingAccount();
                
                ac1.setAccountNumber("123");
                ac2.setAccountNumber("521");
                ac1.setBillingCompanyName("COJ");
                ac2.setBillingCompanyName("COJ"); 
                ac1.setId(1225l);
                ac2.setId(1453l); 
                
                billingCompany.addBillingAccounts(ac1);
                billingCompany.addBillingAccounts(ac2); 
				List<BillingAccount> accounts = billingCompany.getBillingAccounts();
				Iterator<BillingAccount> allaccounts=accounts.iterator();
			     // sc=new Scrape(); 
				while (allaccounts.hasNext()){
					tmp=allaccounts.next();

					// sc.exScrape(billingCompany.getCompanyName(),tmp); 
					System.out.println(tmp.getAccountNumber());
		           }
                }
	}
 
 
	 
}