package test.za.ac.wits.group3.scrape;

import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;

public class ScrapeTestRunner {
	
   public static void main(String [] args) {
      Result result = JUnitCore.runClasses(ScrapeTestSuite.class);
      for (Failure failure:result.getFailures()) {
         System.out.println(failure.toString());
      }
      
      if (result.wasSuccessful())
    	  System.out.println("Scrape Test Suite Encountered No Errors");
      else
    	  System.out.println("See Scrape Test Suite Errors Encountered Above");
   }
}  
