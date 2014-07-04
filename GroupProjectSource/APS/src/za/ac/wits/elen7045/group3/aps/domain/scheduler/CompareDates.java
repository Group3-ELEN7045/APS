package za.ac.wits.elen7045.group3.aps.domain.scheduler; 

import java.util.Date;
/**
 * 
 * @author S. Zwane
 *
 */
public class CompareDates  implements IDuration
	{    
		
	
	private long scheduletime;  
	private Date starttime , endtime;

	public CompareDates(long scheduletime, Date starttime, Date endtime)
	{ 
	  this.scheduletime=scheduletime;
	  this.starttime=starttime;
	  this.endtime=endtime;  
	}

	public int compareduration()
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