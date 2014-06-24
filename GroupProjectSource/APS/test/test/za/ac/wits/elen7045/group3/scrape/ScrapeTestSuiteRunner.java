package test.za.ac.wits.elen7045.group3.scrape;
/**
 * @author bakwanyana
 */
import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;

public class ScrapeTestSuiteRunner {
	
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
