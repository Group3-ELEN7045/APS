package test.za.ac.wits.elen7045.group3.scrape.specification;
/**
 * @author bakwanyana
 */
import java.util.ArrayList;
import java.util.List;
import static org.junit.Assert.*; 
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import za.ac.wits.elen7045.group3.aps.vo.scrape.DataPair;
import za.ac.wits.elen7045.group3.aps.vo.scrape.ScrapedResult;
import za.ac.wits.elen7045.group3.aps.vo.specification.scrape.HasDuplicateScrapedResultErrorSpecification;

public class DuplicateScrapedResultSpecTest {
	
	ScrapedResult scrapedStatement;
	List<DataPair> dataPairsTrue;
	List<DataPair> dataPairsFalse;
	HasDuplicateScrapedResultErrorSpecification duplicateSpec;
	
	@Before
	public void init(){
		
		duplicateSpec = new HasDuplicateScrapedResultErrorSpecification();
		
		dataPairsTrue = new ArrayList<DataPair>();
		dataPairsFalse = new ArrayList<DataPair>();
		
		dataPairsTrue.add(new DataPair("001","qaz","123456789"));
		dataPairsTrue.add(new DataPair("002","qaz","Jack Parcell"));
		dataPairsTrue.add(new DataPair("003","qaz","12/12/2014"));
		dataPairsTrue.add(new DataPair("004","qaz","1122"));
		dataPairsTrue.add(new DataPair("005","qaz","2"));
			
		dataPairsFalse.add(new DataPair("001","qaz","123456789"));
		dataPairsFalse.add(new DataPair("002","qaz","Jack Parcell"));
		dataPairsFalse.add(new DataPair("001","qaz","12/12/2014"));
		dataPairsFalse.add(new DataPair("004","qaz","1122"));
		dataPairsFalse.add(new DataPair("005","qaz","2"));
		
		
	}
	
	@After
	public void tearDown(){
		scrapedStatement = null;
		dataPairsFalse = null;
		dataPairsTrue = null;
	}
	
	@Test
	public void positiveDuplicateCorrelationTest(){
		
		scrapedStatement = new ScrapedResult(null,null,null,dataPairsTrue);
	
		assertFalse(duplicateSpec.isSatisfiedBy(scrapedStatement));
	}
	
	@Test
	public void negativeDuplicateCorrelationTest(){
		scrapedStatement = new ScrapedResult(null,null,null,dataPairsFalse);
		
		assertTrue(duplicateSpec.isSatisfiedBy(scrapedStatement));
	}
}
