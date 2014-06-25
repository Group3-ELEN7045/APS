package test.za.ac.wits.elen7045.group3.scrape;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;
import org.junit.Before;
import org.junit.Test;
import za.ac.wits.elen7045.group3.aps.vo.specification.scrape.MunicipalScrapedResultAdditionSpecification;
import za.ac.wits.elen7045.group3.aps.vo.scrape.DataPair;
import za.ac.wits.elen7045.group3.aps.vo.scrape.ScrapeInterpreter;
import za.ac.wits.elen7045.group3.aps.vo.scrape.ScrapedResult;

public class ScrapeInterpreterTests {
	ScrapeInterpreter interpreter;
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
		
		interpreter = new ScrapeInterpreter(scrapedStatement);
		
		assertTrue(interpreter.evaluate().equals("InvalidCredentials"));
	}
}
