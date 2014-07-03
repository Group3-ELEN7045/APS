package za.ac.wits.elen7045.group3.aps.domain.scheduler;

  
import java.util.Date;



import java.util.Iterator;
import java.util.List;


//import za.ac.wits.elen7045.group3.aps.domain.scheduler.*;
import za.ac.wits.elen7045.group3.aps.domain.entities.BillingCompany;

public class LegalDuration {

	//private boolean isLegal; 
	private long ScheduledTime; 
	
	private BillingCycle billingCycle;
	private List<CronExpressionWrapper> maintenance;
	private List<CronExpressionWrapper> peak;
	private Iterator<CronExpressionWrapper> allpeak;
	private Iterator<CronExpressionWrapper> allmaintenance;
    private SpCheckDuration sptimes;
    private CompareDates cpdates;
	  
    public LegalDuration(BillingCompany billingCompany,Long ScheduledTime)
    {
    	this.billingCycle=billingCompany.getBillingcylce();
		this.maintenance  = billingCompany.getMaintenancewindows() ; 
	    this.peak = billingCompany.getPeakperiod();
	    this.allpeak=peak.iterator();
		this.allmaintenance=maintenance.iterator(); 
    	this.ScheduledTime=ScheduledTime;  

   	 sptimes=new SpCheckDuration(cpdates); 
    }
      
    public boolean IsLegal() {
    	
    	boolean times =false;
        int results=6;

 
   	    sptimes.setBehavior(new CompareDates(ScheduledTime,billingCycle.getStartDate(),billingCycle.getEndDate()));
   	      results=sptimes.compare();   
 
         if (results==2)     
        { return  times=true; }   
		 return times;
 	 } 
    
    public boolean IsLegal(Iterator<CronExpressionWrapper> myiterator) {

    	CronExpressionWrapper tmpPeriod;
         	boolean times =false;
             int  iperiod=-1; 
             int x=0;
             while (myiterator.hasNext()){ 
 				tmpPeriod=myiterator.next();

 	        	sptimes.setBehavior(new CompareExpressionWrapper(ScheduledTime,tmpPeriod));
 	        	  
 	        	iperiod=sptimes.compare(); 
 	        	x+=1;
 				if (iperiod==2 )times=true;
 				else times=false;
 				 if (times==false) return  times;
 	           }
       return times;
      	 }
    
      
    
    public boolean ItsLegalToSchedule()
    {
    	boolean LegalToSchedule=false;
    	
    	if (IsLegal()==true && IsLegal(allpeak) == true && IsLegal(allmaintenance)==true)
    		LegalToSchedule=true;
    	
    	return LegalToSchedule;
    	 
    }
    
    
     
}
 