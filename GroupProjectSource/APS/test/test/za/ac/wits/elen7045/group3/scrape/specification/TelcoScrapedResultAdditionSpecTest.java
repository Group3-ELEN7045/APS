package test.za.ac.wits.elen7045.group3.scrape.specification;
/**
 * @author bakwanyana
 */

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Before;  
import org.junit.Test;  

import za.ac.wits.elen7045.group3.aps.domain.scrape.vo.DataPair;
import za.ac.wits.elen7045.group3.aps.domain.scrape.vo.ScrapedResult;
import za.ac.wits.elen7045.group3.aps.domain.scrape.vo.specification.TelcoScrapedResultAdditionSpecification;

public class TelcoScrapedResultAdditionSpecTest {
	ArrayList<DataPair> dataPairsTrue;
	ScrapedResult scrapedStatement;
	TelcoScrapedResultAdditionSpecification telcoAddSpec;
	
	@Before
	public void init(){
		telcoAddSpec = new TelcoScrapedResultAdditionSpecification();
		
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
		dataPairsTrue.add(new DataPair("","",""));
	}
	
	@Test
	public void testCorrectAddition(){

		dataPairsTrue.add(new DataPair("","",""));
		dataPairsTrue.add(new DataPair("016","Service Charges","R50"));
		dataPairsTrue.add(new DataPair("017","Call Charges","R50"));
		dataPairsTrue.add(new DataPair("","",""));
		dataPairsTrue.add(new DataPair("","",""));
		scrapedStatement = new ScrapedResult("","","",dataPairsTrue);
		
		assertTrue(telcoAddSpec.isSatisfiedBy(scrapedStatement));
		
		
	}
	
	@Test
	public void testIncorrectAddition(){

		dataPairsTrue.add(new DataPair("","",""));
		dataPairsTrue.add(new DataPair("016","Service Charges","R501"));
		dataPairsTrue.add(new DataPair("017","Call Charges","R50"));
		dataPairsTrue.add(new DataPair("","",""));
		dataPairsTrue.add(new DataPair("","",""));
		scrapedStatement = new ScrapedResult("","","",dataPairsTrue);
		
		assertFalse(telcoAddSpec.isSatisfiedBy(scrapedStatement));
		
		
	}
}
