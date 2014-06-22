package test.za.ac.wits.group3.scrape;
/**
 * @author bakwanyana
 */
import org.junit.runner.RunWith;
import org.junit.runners.Suite;

@RunWith(Suite.class)
@Suite.SuiteClasses({
   DuplicateStatementDataSpecTest.class,
   MunicipalStatementDataAdditionSpecTest.class,
   StatementVATCalculationSpecTest.class,
   TelcoStatementDataAdditionSpecTest.class,
   ScrapeStatementConverterTests.class,
   ScrapedXMLFileReadTests.class,
   BillingAccountSuitableForScrapeSpecTest.class,
   DuplicateStatementDataSpecTest.class,
   ScrapeAdaptorTests.class
})
public class ScrapeTestSuite {   
}  
