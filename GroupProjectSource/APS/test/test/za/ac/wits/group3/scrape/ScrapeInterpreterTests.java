package test.za.ac.wits.group3.scrape;

import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import za.ac.wits.elen7045.group3.aps.vo.scrape.NumericDataFormatter;
import za.ac.wits.elen7045.group3.aps.services.specification.Specification;
import za.ac.wits.elen7045.group3.aps.domain.accounts.abtracts.AbstractBillingAccountStatement;
import za.ac.wits.elen7045.group3.aps.vo.specification.scrape.DuplicateStatementDataSpecification;
import za.ac.wits.elen7045.group3.aps.vo.specification.scrape.GenericStatementDataAdditionSpecification;
import za.ac.wits.elen7045.group3.aps.vo.specification.scrape.MunicipalStatementDataAdditionSpecification;
import za.ac.wits.elen7045.group3.aps.vo.specification.scrape.ScrapeErrorInStatementSpecification;
import za.ac.wits.elen7045.group3.aps.vo.specification.scrape.StatementVATCalculationSpecification;
import za.ac.wits.elen7045.group3.aps.vo.specification.scrape.TelcoStatementDataAdditionSpecification;
import za.ac.wits.elen7045.group3.aps.vo.scrape.DataPair;
import za.ac.wits.elen7045.group3.aps.vo.scrape.DefaultNumericDataFormatStrategy;
import za.ac.wits.elen7045.group3.aps.vo.scrape.ScrapeInterpreter;
import za.ac.wits.elen7045.group3.aps.vo.scrape.ScrapedResult;

public class ScrapeInterpreterTests {
	ScrapeInterpreter interpreter;
	ScrapedResult scrapedStatement;
	List<DataPair> dataPairs;
	DuplicateStatementDataSpecification spec_duplicate;
	GenericStatementDataAdditionSpecification spec_generic;
	MunicipalStatementDataAdditionSpecification spec_municipal;
	ScrapeErrorInStatementSpecification spec_errorInStatement;
	StatementVATCalculationSpecification spec_vat;
	TelcoStatementDataAdditionSpecification spec_telco;
	Specification<AbstractBillingAccountStatement> spec_ALL;
	NumericDataFormatter numericDataFormatter;
	
	
	@Before 
	public void init(){
		dataPairs = new ArrayList<DataPair>();
		numericDataFormatter = new NumericDataFormatter(new DefaultNumericDataFormatStrategy());
		
	}
	
	@After 
	public void tearDown(){
		
	}
	
	/*@Test
	public void testStatementCorrect(){
		
	}
	*/
	@Test
	public void testCommonError(){
		dataPairs = new ArrayList<DataPair>();
		dataPairs.add(new DataPair("001","Scrape Error","InvalidCredentials"));
		
		scrapedStatement = new ScrapedResult("","","",dataPairs);
		
		interpreter = new ScrapeInterpreter(scrapedStatement, spec_ALL, numericDataFormatter);
		
		assertTrue(interpreter.evaluate().equals("InvalidCredentials"));
	}
	
	/*@Test 
	public void testBrokenScript_DuplicateData(){
		
	}
	
	@Test 
	public void testBrokenScript_VatCalculation(){
		
	}*/
}
