package test.za.ac.wits.group3.scrape;
/**
 * @author bakwanyana
 */
import org.junit.runner.RunWith;
import org.junit.runners.Suite;

@RunWith(Suite.class)
@Suite.SuiteClasses({
   DuplicateStatementDataSpecTest.class,
   MunicipalAdditionSpecTest.class,
   VATCalculationSpecTest.class,
   TelcoAdditionSpecTest.class,
   ScrapeStatementAdaptorTests.class,
   XMLReadTests.class,
   SuitableForScrapeSpecTest.class
})
public class ScrapeTestSuite {   
}  
