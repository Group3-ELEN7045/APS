package za.ac.wits.elen7045.group3.aps.domain.scheduler;
 
 
	public class SpCheckDuration {
	  private IDuration algorithm;
	  

	  public SpCheckDuration(IDuration algorithm)
	  {
		  this.algorithm=algorithm;
	  } 
	  
	   public void setBehavior(IDuration algorithm) 
	  {
		  this.algorithm=algorithm;
	  } 
	  
	  public int compare() 
	  {
		  return Math.abs(algorithm.compareduration());
		  
	  }  
	    
	 
    }
	
	
