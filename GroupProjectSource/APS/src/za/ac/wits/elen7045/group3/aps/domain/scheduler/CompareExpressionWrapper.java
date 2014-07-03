package za.ac.wits.elen7045.group3.aps.domain.scheduler; 

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
 
public class CompareExpressionWrapper implements IDuration
	{    
		
	
	private long scheduletime;   
	private CronExpressionWrapper duration;
	private Date startdate, enddate;
	
	public CompareExpressionWrapper(long scheduletime, CronExpressionWrapper duration)
	{ 
	  this.scheduletime=scheduletime; 
      this.duration=duration;   
      this.startdate = new Date();
      this.enddate = new Date();
	}


        public int compareduration() 
	 {   
		 setdates() ; 
	    if (scheduletime <= 0  ||  startdate == null ||   enddate == null) 
		  { 
			 throw new RuntimeException("date name can not be null or Less than 0");
		  }
					 
		 int x;
		 Date datescheduled=new Date(scheduletime); 
				  
		 x =  datescheduled.compareTo(startdate) + datescheduled.compareTo(enddate);  

	 
      	  return Math.abs(x);
	 }

         private void setdates()  
         {
        	 try{
        		 startdate= getDate(1);
        		 enddate= getDate(2);
          	    }
               catch (ParseException e) 
               {
      			e.printStackTrace();
               }     	       
         }

      	private Date getDate(int type) throws ParseException 
    	{   
      		Date myDate = new Date();
      		  SimpleDateFormat formatter = new SimpleDateFormat("yyyy/MM/dd:hh:mm:ss"); 
              try{
     
            	  String day,month,year,hour,mins,secs,dates,time;
            	    day=subtype(duration.getDayOfMonth(),type);
            	    month=subtype(duration.getMonth(),type);
            	    year=subtype(duration.getYear(),type);
            	    dates="20"+year+"/"+month+"/"+day;
     
            	    hour=subtype(duration.getHours(),type)  ;
            	    mins=subtype(duration.getMinutes(),type)  ;
            	    secs=subtype(duration.getSeconds(),type)  ;
            	    time=hour+":"+mins+":"+secs;
     		       myDate= formatter.parse(dates+":"+time);
    	      		return myDate;	
              }
               catch (ParseException e) {
      			e.printStackTrace();
      			
      	}
			return myDate; 
    	}
      	 
      	private String  subtype(String tmp,int type)
      	{
		  //type=1 for start and 2 for end;
      		String sub=tmp;
      		int x=tmp.indexOf("-");
      		if (x > 1 && type==1)  sub=tmp.substring(0,x); 
      		if (x > 1 && type==2)  sub=tmp.substring(x+1); 
      		return sub;
      	}
      	  
	}