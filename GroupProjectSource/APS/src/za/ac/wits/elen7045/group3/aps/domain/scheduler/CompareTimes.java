package za.ac.wits.elen7045.group3.aps.domain.scheduler;

import java.util.Date;

/**
 * 
 * @author S. Zwane
 *
 */
public class CompareTimes implements itimes
{

	private long scheduletime,  starttime, endtime;
	 
	CompareTimes(long scheduletime, long starttime, long endtime)
	{ 
	  this.scheduletime=scheduletime;
	  this.starttime=starttime;
	  this.endtime=endtime;  
	}
    
	 public final int comparetimes()
	  {  
		 if (scheduletime <= 0  ||  starttime <= 0 ||    endtime <= 0 ) 
		     { 
			  throw new RuntimeException("date name can not be null or Less than 0");
		     }
			 
	      int x;
	      
		  Date datestart=new Date(starttime);
		  Date dateend=new Date(endtime); 
		  Date datescheduled=new Date(scheduletime);
		  
		  x =  datescheduled.compareTo(datestart) + datescheduled.compareTo(dateend);
	 
		  return Math.abs(x);
	  }
}