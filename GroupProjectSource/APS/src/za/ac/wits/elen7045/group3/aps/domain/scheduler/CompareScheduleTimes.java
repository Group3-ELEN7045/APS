package za.ac.wits.elen7045.group3.aps.domain.scheduler;

import java.util.Date;
/**
 * 
 * @author S. Zwane
 *
 */
public class CompareScheduleTimes   implements itimes
{
	private long scheduletime;  
	private Date curr_time;
 
	public CompareScheduleTimes(long scheduletime, Date curr_time)
	{ 
	  this.scheduletime=scheduletime;
	  this.curr_time=curr_time; 
	}

	 public final int comparetimes()
	 {  
		 if (scheduletime <= 0  ||  curr_time == null) 
		     { 
			  throw new RuntimeException("date name can not be null or Less than 0");
		     }
			 
	     int x;
		  Date datescheduled=new Date(scheduletime);
		  
		  x =  datescheduled.compareTo(curr_time);

		  return Math.abs(x);
	 }
	 
}	
 