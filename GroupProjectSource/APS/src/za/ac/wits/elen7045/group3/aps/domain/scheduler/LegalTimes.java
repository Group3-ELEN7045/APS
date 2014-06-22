package za.ac.wits.elen7045.group3.aps.domain.scheduler;

  
import java.util.Date;



//import za.ac.wits.elen7045.group3.aps.domain.scheduler.*;
import za.ac.wits.elen7045.group3.aps.domain.entities.BillingCompany;

public class LegalTimes {

	//private boolean isLegal;
	private long ScheduledTime;
	//private CheckTimes checktimes;
	
	private BillingCycle billingCycle;
	private MaintenanceWindow maintenanceWindow;
	private PeakPeriod peakPeriod; 
    private SpCheckTimes sptimes;
    private CompareDates cpdates;
	  
    public LegalTimes(BillingCompany billingCompany,Long ScheduledTime)
    {
    	this.billingCycle=billingCompany.getBillingcylce();
    	this.maintenanceWindow=billingCompany.getMaintenancewindow();
    	this.peakPeriod=billingCompany.getPeakperiod(); 
    	this.ScheduledTime=ScheduledTime;  

   	 sptimes=new SpCheckTimes(cpdates); 
    }
      
    public boolean IsLegal() {
    	
    	boolean times =true;
        int ibillingcycle=-1, imaintenance=-1, ipeak=-1; 

 
   	    sptimes.setBehavior(new CompareDates(ScheduledTime,billingCycle.getStartDate(),billingCycle.getEndDate()));
	    ibillingcycle=sptimes.compare();   
	    
    	sptimes.setBehavior(new CompareTimes(ScheduledTime,peakPeriod.getStartTime(),peakPeriod.getEndTime()));
    	ipeak=sptimes.compare(); 
  
 	    sptimes.setBehavior(new CompareTimes(ScheduledTime,maintenanceWindow.getStartTime(),maintenanceWindow.getEndTime()));
 	    imaintenance=sptimes.compare(); 
 
		  
 	    int total= ibillingcycle + imaintenance + ipeak ; 
         if (ibillingcycle==0 || imaintenance==0 || ipeak==0 ||total==-3)     
        { return  times=false; }  
 	   return times;
 	 } 
     
     public boolean IsLegal(Date currTime) {
         int itstime=-1; 
      	  sptimes.setBehavior(new CompareScheduleTimes(ScheduledTime,currTime));
      	  itstime=sptimes.compare();
   	     
          if (itstime==0)     
          { return true ; }  
   	   return false ;
   	 } 
     
}
 