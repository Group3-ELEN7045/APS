package test.za.ac.wits.elen7045.group3.scrape.specification;
/**
 * @author bakwanyana
 */
import static org.junit.Assert.*;   
import java.util.ArrayList;
import org.junit.Before;  
import org.junit.Test;  
import za.ac.wits.elen7045.group3.aps.vo.scrape.DataPair;
import za.ac.wits.elen7045.group3.aps.vo.scrape.ScrapedResult;
import za.ac.wits.elen7045.group3.aps.vo.specification.scrape.ScrapedResultHasVATCalculationErrorSpecification;

public class ScrapedResultVATCalculationSpecTest {
	ArrayList<DataPair> dataPairsTrue;
	ScrapedResult scrapedStatement;
	ScrapedResultHasVATCalculationErrorSpecification vatSpec;
	
	@Before
	public void init(){
		vatSpec = new ScrapedResultHasVATCalculationErrorSpecification();
	}
	
	@Test
	public void testCorrectCalculation(){
		dataPairsTrue = new ArrayList<DataPair>();
		dataPairsTrue.add(new DataPair("","",""));
		dataPairsTrue.add(new DataPair("","",""));
		dataPairsTrue.add(new DataPair("","",""));
		dataPairsTrue.add(new DataPair("","",""));
		dataPairsTrue.add(new DataPair("","",""));
		dataPairsTrue.add(new DataPair("","",""));
		dataPairsTrue.add(new DataPair("","",""));
		dataPairsTrue.add(new DataPair("","",""));
		dataPairsTrue.add(new DataPair("","",""));
		dataPairsTrue.add(new DataPair("","",""));
		dataPairsTrue.add(new DataPair("011","New Charges","R100"));
		dataPairsTrue.add(new DataPair("","",""));
		dataPairsTrue.add(new DataPair("","",""));
		dataPairsTrue.add(new DataPair("014","Vat Amount","R14"));
		
		scrapedStatement = new ScrapedResult("","","",dataPairsTrue);
		
		assertFalse(vatSpec.isSatisfiedBy(scrapedStatement));
	}
	
	@Test
	public void testIncorrectCalculation(){
		dataPairsTrue = new ArrayList<DataPair>();
		dataPairsTrue.add(new DataPair("","",""));
		dataPairsTrue.add(new DataPair("","",""));
		dataPairsTrue.add(new DataPair("","",""));
		dataPairsTrue.add(new DataPair("","",""));
		dataPairsTrue.add(new DataPair("","",""));
		dataPairsTrue.add(new DataPair("","",""));
		dataPairsTrue.add(new DataPair("","",""));
		dataPairsTrue.add(new DataPair("","",""));
		dataPairsTrue.add(new DataPair("","",""));
		dataPairsTrue.add(new DataPair("","",""));
		dataPairsTrue.add(new DataPair("011","New Charges","R100"));
		dataPairsTrue.add(new DataPair("","",""));
		dataPairsTrue.add(new DataPair("","",""));
		dataPairsTrue.add(new DataPair("014","Vat Amount","R14.10"));
		
		scrapedStatement = new ScrapedResult("","","",dataPairsTrue);
		
		assertTrue(vatSpec.isSatisfiedBy(scrapedStatement));
	}

}
