package za.ac.wits.elen7045.group3.aps.domain.scheduler;
 
 
	public class SpCheckTimes {
	  private itimes algorithm;
	  

	  SpCheckTimes(itimes algorithm)
	  {
		  this.algorithm=algorithm;
	  } 
	  
	   public void setBehavior(itimes algorithm) 
	  {
		  this.algorithm=algorithm;
	  } 
	  
	  public int compare() 
	  {
		  return algorithm.comparetimes();
		  
	  }  
	   
	   
 
	 
    }
	
	
