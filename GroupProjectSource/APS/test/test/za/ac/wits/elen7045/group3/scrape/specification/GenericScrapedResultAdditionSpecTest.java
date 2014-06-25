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
import za.ac.wits.elen7045.group3.aps.vo.specification.scrape.HasGenericErrorInScrapedResultSpecification;

public class GenericScrapedResultAdditionSpecTest {
	
	HasGenericErrorInScrapedResultSpecification dataSpec;
	ArrayList<DataPair> dataPairs;
	ScrapedResult scrapedStatement;
	@Before
	public void init(){
		
		dataSpec = new HasGenericErrorInScrapedResultSpecification();
	}
	
	@Test
	public void testCorrectAddition(){
		dataPairs = new ArrayList<DataPair>();
		dataPairs.add(new DataPair("","",""));
		dataPairs.add(new DataPair("","",""));
		dataPairs.add(new DataPair("","",""));
		dataPairs.add(new DataPair("","",""));
		dataPairs.add(new DataPair("","",""));
		dataPairs.add(new DataPair("006","Total Due","R1750"));
		dataPairs.add(new DataPair("","",""));
		dataPairs.add(new DataPair("008","Opening Balance","R2000"));
		dataPairs.add(new DataPair("","",""));
		dataPairs.add(new DataPair("010","Payments Received","R300"));
		dataPairs.add(new DataPair("011","New Charges","R200"));
		dataPairs.add(new DataPair("012","Deductions","R100"));
		dataPairs.add(new DataPair("013","Discount","R50"));
		dataPairs.add(new DataPair("","",""));
		scrapedStatement = new ScrapedResult("","","",dataPairs);
		assertFalse(dataSpec.isSatisfiedBy(scrapedStatement));
	}
	@Test
	public void testIncorrectAddition(){
		dataPairs = new ArrayList<DataPair>();
		dataPairs.add(new DataPair("","",""));
		dataPairs.add(new DataPair("","",""));
		dataPairs.add(new DataPair("","",""));
		dataPairs.add(new DataPair("","",""));
		dataPairs.add(new DataPair("","",""));
		dataPairs.add(new DataPair("006","Total Due","R1800"));
		dataPairs.add(new DataPair("","",""));
		dataPairs.add(new DataPair("008","Opening Balance","R2000"));
		dataPairs.add(new DataPair("","",""));
		dataPairs.add(new DataPair("010","Payments Received","R300"));
		dataPairs.add(new DataPair("011","New Charges","R200"));
		dataPairs.add(new DataPair("012","Deductions","R100"));
		dataPairs.add(new DataPair("013","Discount","R50"));
		dataPairs.add(new DataPair("","",""));
		scrapedStatement = new ScrapedResult("","","",dataPairs);
		assertTrue(dataSpec.isSatisfiedBy(scrapedStatement));
	}

}
