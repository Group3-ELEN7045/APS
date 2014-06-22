package za.ac.wits.elen7045.group3.aps.domain.scheduler; 

import java.util.Date;

public class CompareDates  implements itimes
	{    
		
	
	private long scheduletime;  
	private Date starttime , endtime;

	CompareDates(long scheduletime, Date starttime, Date endtime)
	{ 
	  this.scheduletime=scheduletime;
	  this.starttime=starttime;
	  this.endtime=endtime;  
	}

	public int comparetimes()
	 {  
		 if (scheduletime <= 0  ||  starttime == null ||   endtime == null) 
		     { 
			  throw new RuntimeException("date name can not be null or Less than 0");
		     }
			 
	     int x;
		  Date datescheduled=new Date(scheduletime);
		  
		  x =  datescheduled.compareTo(starttime) + datescheduled.compareTo(endtime);

		  return Math.abs(x);
	 }

	}