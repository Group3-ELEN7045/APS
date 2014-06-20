package test.za.ac.wits.group3.scrape;
/**
 * @author bakwanyana
 */
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*; 

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import za.ac.wits.elen7045.group3.aps.domain.vo.DataPair;
import za.ac.wits.elen7045.group3.aps.services.scrape.StatementScrapedData;
import za.ac.wits.elen7045.group3.aps.vo.specification.scrape.DuplicateStatementDataSpecification;

public class DuplicateStatementDataSpecTest {
	
	StatementScrapedData scrapedStatement;
	List<DataPair> dataPairsTrue;
	List<DataPair> dataPairsFalse;
	DuplicateStatementDataSpecification duplicateSpec;
	
	@Before
	public void init(){
		scrapedStatement = new StatementScrapedData();
		
		duplicateSpec = new DuplicateStatementDataSpecification();
		
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
		scrapedStatement.setDataPairList(dataPairsTrue);
	
		assertTrue(duplicateSpec.isSatisfiedBy(scrapedStatement));
	}
	
	@Test
	public void negativeDuplicateCorrelationTest(){
		scrapedStatement.setDataPairList(dataPairsFalse);
		
		assertFalse(duplicateSpec.isSatisfiedBy(scrapedStatement));
	}
}
