package test.za.ac.wits.group3.scrape;
/**
 * @author bakwanyana
 */
import org.junit.runner.RunWith;
import org.junit.runners.Suite;

@RunWith(Suite.class)
@Suite.SuiteClasses({
   GenericStatementDataAdditionSpecTest.class,
   DuplicateStatementDataSpecTest.class,
   MunicipalStatementDataAdditionSpecTest.class,
   StatementVATCalculationSpecTest.class,
   TelcoStatementDataAdditionSpecTest.class,
   ScrapeStatementConverterTests.class,
   ScrapedXMLFileReadTests.class,
   BillingAccountSuitableForScrapeSpecTest.class,
   DuplicateStatementDataSpecTest.class,
   ScrapeAdaptorTests.class,
   ScrapeInterpreterTests.class,
})
public class ScrapeTestSuite {   
}  
