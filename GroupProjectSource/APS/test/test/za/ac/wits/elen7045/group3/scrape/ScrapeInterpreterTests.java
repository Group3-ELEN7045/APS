package test.za.ac.wits.elen7045.group3.scrape;
/**
 * @author bakwanyana
 */
import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import za.ac.wits.elen7045.group3.aps.domain.scrape.vo.DataPair;
import za.ac.wits.elen7045.group3.aps.domain.scrape.vo.ScrapedResult;
import za.ac.wits.elen7045.group3.aps.domain.scrape.vo.specification.MunicipalScrapedResultAdditionSpecification;
import za.ac.wits.elen7045.group3.aps.services.scrape.ScrapedResultInterpreter;

public class ScrapeInterpreterTests {
	ScrapedResultInterpreter interpreter;
	ScrapedResult scrapedStatement;
	List<DataPair> dataPairsTrue;
	MunicipalScrapedResultAdditionSpecification spec_municipal;
	@Before 
	public void init(){
		dataPairsTrue = new ArrayList<DataPair>();
		
	}
	
	@Test
	public void testCommonError(){
		dataPairsTrue = new ArrayList<DataPair>();
		dataPairsTrue.add(new DataPair("001","Scrape Error","InvalidCredentials"));
		
		scrapedStatement = new ScrapedResult("","","",dataPairsTrue);
		
		interpreter = new ScrapedResultInterpreter(scrapedStatement);
		
		assertTrue(interpreter.evaluate().equals("InvalidCredentials"));
	}
}
