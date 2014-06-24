package test.za.ac.wits.elen7045.group3.scrape;
/**
 * @author bakwanyana
 */
import org.junit.runner.RunWith;
import org.junit.runners.Suite;

import test.za.ac.wits.elen7045.group3.scrape.specification.AccountNumberNotEqualSpecTest;
import test.za.ac.wits.elen7045.group3.scrape.specification.DuplicateScrapedResultSpecTest;
import test.za.ac.wits.elen7045.group3.scrape.specification.GenericScrapedResultAdditionSpecTest;
import test.za.ac.wits.elen7045.group3.scrape.specification.MunicipalScrapedResultAdditionSpecTest;
import test.za.ac.wits.elen7045.group3.scrape.specification.ScrapedResultVATCalculationSpecTest;
import test.za.ac.wits.elen7045.group3.scrape.specification.TelcoScrapedResultAdditionSpecTest;

@RunWith(Suite.class)
@Suite.SuiteClasses({
   GenericScrapedResultAdditionSpecTest.class,
   DuplicateScrapedResultSpecTest.class,
   MunicipalScrapedResultAdditionSpecTest.class,
   ScrapedResultVATCalculationSpecTest.class,
   TelcoScrapedResultAdditionSpecTest.class,
   ScrapedXMLFileReadTests.class,
   DuplicateScrapedResultSpecTest.class,
   ScrapeAdaptorTests.class,
   ScrapeInterpreterTests.class,
   AccountNumberNotEqualSpecTest.class,
})
public class ScrapeTestSuite {   
}  
