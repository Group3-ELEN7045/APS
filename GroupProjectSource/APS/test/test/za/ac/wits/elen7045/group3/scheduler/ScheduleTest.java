package test.za.ac.wits.elen7045.group3.scheduler;
 

import static org.junit.Assert.*;

import java.security.Timestamp;
import java.sql.Time;
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

import java.util.Date;

import org.quartz.CronTrigger;
import org.quartz.SimpleTrigger;
import org.quartz.Scheduler;
import org.quartz.impl.StdSchedulerFactory;
import org.quartz.impl.triggers.CronTriggerImpl;

//import org.jmock.Expectations;
//import org.jmock.Mockery;
//import org.junit.Test;

/**
 * @author Sibusiso
 *
 */


public class ScheduleTest extends TestCase {

	private static final long ScheduledTime = 0;
	CronExpressionWrapper maintenanceWindow1=new CronExpressionWrapper();
	CronExpressionWrapper peakPeriod1=new CronExpressionWrapper();

	CronExpressionWrapper maintenanceWindow2=new CronExpressionWrapper();
	CronExpressionWrapper peakPeriod2=new CronExpressionWrapper();
	 
	@Before
	protected void setUp() throws Exception {
		super.setUp(); 
		
		maintenanceWindow1.setSeconds("05");  
		maintenanceWindow1.setMinutes("15-30");  
		maintenanceWindow1.setHours("17-18"); 
		maintenanceWindow1.setDayOfMonth("26");
		maintenanceWindow1.setDayOfWeek("?");  
		maintenanceWindow1.setMonth("06"); 
		maintenanceWindow1.setYear("14");   
		   
		maintenanceWindow2.setSeconds("05");  
		maintenanceWindow2.setMinutes("15-30");  
		maintenanceWindow2.setHours("09-13"); 
		maintenanceWindow2.setDayOfMonth("20");
		maintenanceWindow2.setDayOfWeek("?");  
		maintenanceWindow2.setMonth("07"); 
		maintenanceWindow2.setYear("14");   
		   
		peakPeriod1.setSeconds("05");  
		peakPeriod1.setMinutes("15-30");  
		peakPeriod1.setHours("17-18"); 
		peakPeriod1.setDayOfMonth("26");
		peakPeriod1.setDayOfWeek("?");  
		peakPeriod1.setMonth("06"); 
		peakPeriod1.setYear("14");   
		   
		   peakPeriod2.setSeconds("05");  
			peakPeriod2.setMinutes("15-30");  
			peakPeriod2.setHours("09-13"); 
			peakPeriod2.setDayOfMonth("20");
			peakPeriod2.setDayOfWeek("?");  
			peakPeriod2.setMonth("07"); 
			peakPeriod2.setYear("14");   
		
		
	}

	@After
	protected void tearDown() throws Exception {
		super.tearDown();
	}
	
/*	@Test
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
		
	}  
	
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
                ac1.setAccountNumber("COJ"); 
                ac1.setId(1225l);
                ac2.setId(1453l); 
                
                billingCompany.addBillingAccounts(ac1);
                billingCompany.addBillingAccounts(ac2); 
            	  
				List<BillingAccount> accounts = billingCompany.getBillingAccounts();
				Iterator<BillingAccount> allaccounts=accounts.iterator();
			     // sc=new Scrape(); 
				while (allaccounts.hasNext()){
					// sc.exScrape(company,allaccounts.next()); 
					tmp=allaccounts.next();
					System.out.println(tmp.getAccountNumber());
		           }
                }
	}
 */

	Date converdate(String sdate,int type) throws ParseException 
	{
		Date returnDate =new Date(); 
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy/MM/dd");
		SimpleDateFormat formatter2 = new SimpleDateFormat("yyyy/MM/dd:hh:mm:ss"); 
        
		 try {
			if (type==1) returnDate = formatter.parse(sdate);
			if (type==2) returnDate = formatter2.parse(sdate);   
	 
			} catch (ParseException e) {
				e.printStackTrace();
			}
		 
		return returnDate;
		
	}
 
	 //@Test
		public void testchecktimesdates() throws ParseException {
		 
	        int returnvalue;
	        
		    Date datesched1 = converdate("2014/05/28",1);;  
	        long lsche=datesched1.getTime();	  
		    Date datesched =  new Date(lsche);

	          
			BillingCycle billingCycle=new BillingCycle(); 
			String dstart="2014/05/28";
	        String dend="2014/05/30";  
			        Date startDate = converdate( dstart,1);
				    Date endDate = converdate(dend,1); 
					  			     
					  
		 			datesched =  new Date(1401141600000l);   //before
			        returnvalue =  datesched.compareTo(startDate) + datesched.compareTo(endDate);
	                assertEquals(Math.abs(returnvalue),2);   

				 	datesched =  new Date(1401487200000l);   //after
			        returnvalue =  datesched.compareTo(startDate) + datesched.compareTo(endDate);
		            assertEquals(Math.abs(returnvalue),2);    
		            
		            datesched =  new Date(1401228000000l);   //between 
			        returnvalue =  datesched.compareTo(startDate) + datesched.compareTo(endDate); 
			         assertNotEquals(Math.abs(returnvalue),2);   
		   
		}
		
		  @Test
		public void testcomparedates() throws ParseException {
		  
	        long lsche;
	        Date datesched1;
	        
	        
			String dstart="2014/05/28";
	        String dend="2014/05/30"; 
			        Date startDate = converdate( dstart,1);
				    Date endDate = converdate(dend,1); 
				    
				    CompareDates cpdatesCompareDates  ;

         datesched1 = converdate("2014/05/28",1);   
		  lsche=datesched1.getTime();	   	
         cpdatesCompareDates=new CompareDates(lsche,startDate,endDate)	;   		    
		  assertNotEquals(cpdatesCompareDates.compareduration(),2);    
		  
		  datesched1 = converdate("2014/05/22",1);;  
		  lsche=datesched1.getTime();	   	
         cpdatesCompareDates=new CompareDates(lsche,startDate,endDate)	;   		    
		  assertEquals(cpdatesCompareDates.compareduration(),2);    
		  

		  datesched1 = converdate("2014/06/05",1);;  
		  lsche=datesched1.getTime();	   	
         cpdatesCompareDates=new CompareDates(lsche,startDate,endDate)	;   		    
		  assertEquals(cpdatesCompareDates.compareduration(),2);    
	 
		}
		
		  @Test
			public void testcomparewrapper() throws ParseException {
			  
		        long lsche;
		        Date datesched1;
		        
		        CompareExpressionWrapper cpExpression;
		        
				  
		         datesched1 = converdate("2014/06/26:18:00:00",2);    
				  lsche=datesched1.getTime();	   	
				  cpExpression=new CompareExpressionWrapper(lsche,this.maintenanceWindow1);
				  assertNotEquals(cpExpression.compareduration(),2);        
    
		         datesched1 = converdate("2014/05/28",1);   
				  lsche=datesched1.getTime();	   	
				  cpExpression=new CompareExpressionWrapper(lsche,this.maintenanceWindow1);
				  assertEquals(cpExpression.compareduration(),2);   
			        
		         datesched1 = converdate("2014/06/27",1);   
				  lsche=datesched1.getTime();	   	
				  cpExpression=new CompareExpressionWrapper(lsche,this.maintenanceWindow1);
				  assertEquals(cpExpression.compareduration(),2);
			 
			}
		  
	  @Test
	public void testItsLegalToSchedule()  throws Exception
	{
		 setUp() ;
 
	        Date datesched1 = converdate("2014/05/15:13:15:05",2);;
	        long lsche=datesched1.getTime();	  
		    Date datesched =  new Date(lsche);
		    
		String dstart="2014/05/28";
        String dend="2014/05/30"; 
		Date 	startDate=converdate(dstart,1),
		     	endDate=converdate(dend,1);	
				BillingCycle billingCycle=new BillingCycle(); 
				 
			    billingCycle.setStartDate(startDate);
			    billingCycle.setEndDate(endDate);
			    
	   
		String companyName="COJ";
		BillingCompany billingCompany = new BillingCompany(companyName); 
		    billingCompany.setBillingcylce(billingCycle);
		    billingCompany.setMaintenancewindow(maintenanceWindow1);
		    billingCompany.setMaintenancewindow(maintenanceWindow2);
		    billingCompany.setPeakperiod(peakPeriod1);
		    billingCompany.setPeakperiod(peakPeriod2); 
            billingCompany.setMaintenancewindow(this.maintenanceWindow1);  

	 	    LegalDuration legality=new LegalDuration(billingCompany, lsche);
                
      	  boolean isLegal=legality.ItsLegalToSchedule(); 
      	   assertTrue(isLegal); 

      	lsche=1401228000000l;
      	//lschedule=endDate.getTime(); 

        datesched1 = converdate("2014/06/26:17:45:05",2);;    
		 // datesched1 = converdate("2014/06/26:18:30:05",2);;
	     // datesched1 = converdate("2014/07/20:13:15:05",2);;
        //datesched1 = converdate("2014/05/28:13:15:05",2); 
      	
          LegalDuration legalityfalse=new LegalDuration(billingCompany, lsche);
           isLegal=legalityfalse.ItsLegalToSchedule();
       	   assertFalse(isLegal);  
	}
 
}

