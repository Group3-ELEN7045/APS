package test.za.ac.wits.group3.scrape;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import za.ac.wits.elen7045.group3.aps.vo.scrape.NumericDataFormatter;
import za.ac.wits.elen7045.group3.aps.services.specification.Specification;
import za.ac.wits.elen7045.group3.aps.domain.accounts.abtracts.ScrapedData;
import za.ac.wits.elen7045.group3.aps.vo.specification.scrape.DuplicateStatementDataSpecification;
import za.ac.wits.elen7045.group3.aps.vo.specification.scrape.HasGenericErrorInScrapedResultSpecification;
import za.ac.wits.elen7045.group3.aps.vo.specification.scrape.MunicipalStatementDataAdditionSpecification;
import za.ac.wits.elen7045.group3.aps.vo.specification.scrape.ErrorinScrapedResultSpecification;
import za.ac.wits.elen7045.group3.aps.vo.specification.scrape.StatementVATCalculationSpecification;
import za.ac.wits.elen7045.group3.aps.vo.specification.scrape.TelcoStatementDataAdditionSpecification;
import za.ac.wits.elen7045.group3.aps.vo.scrape.DataPair;
import za.ac.wits.elen7045.group3.aps.vo.scrape.DefaultNumericDataFormatStrategy;
import za.ac.wits.elen7045.group3.aps.vo.scrape.ScrapeInterpreter;
import za.ac.wits.elen7045.group3.aps.vo.scrape.ScrapedResult;

public class ScrapeInterpreterTests {
	ScrapeInterpreter interpreter;
	ScrapedResult scrapedStatement;
	List<DataPair> dataPairsTrue;
	DuplicateStatementDataSpecification spec_duplicate;
	HasGenericErrorInScrapedResultSpecification spec_generic;
	MunicipalStatementDataAdditionSpecification spec_municipal;
	ErrorinScrapedResultSpecification spec_errorInStatement;
	StatementVATCalculationSpecification spec_vat;
	TelcoStatementDataAdditionSpecification spec_telco;
	Specification<ScrapedData> spec_ALL;
	NumericDataFormatter numericDataFormatter;
	
	
	@Before 
	public void init(){
		dataPairsTrue = new ArrayList<DataPair>();
		numericDataFormatter = new NumericDataFormatter(new DefaultNumericDataFormatStrategy());
		
	}
	
	@After 
	public void tearDown(){
		dataPairsTrue = null;
	}
	
	@Test
	public void testCommonError(){
		dataPairsTrue = new ArrayList<DataPair>();
		dataPairsTrue.add(new DataPair("001","Scrape Error","InvalidCredentials"));
		
		scrapedStatement = new ScrapedResult("","","",dataPairsTrue);
		
		interpreter = new ScrapeInterpreter(scrapedStatement);
		
		assertTrue(interpreter.evaluate().equals("InvalidCredentials"));
	}
	
	/*]@Test 
	public void testBrokenScript_DuplicateData(){
		dataPairsTrue = new ArrayList<DataPair>();
		dataPairsTrue.add(new DataPair("000","","1"));
		dataPairsTrue.add(new DataPair("001","","10202"));
		dataPairsTrue.add(new DataPair("000","","2"));
		dataPairsTrue.add(new DataPair("000","","1"));
		scrapedStatement = new ScrapedResult("","","",dataPairsTrue);
		
		interpreter = new ScrapeInterpreter(scrapedStatement, spec_ALL, numericDataFormatter);
		
		assertTrue(interpreter.evaluate().equals("BrokenScript"));
	}*/
	
	/*@Test 
	public void testBrokenScript_NoVatCalculationError(){
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
		dataPairsTrue.add(new DataPair("011","New Account Charges","R100.0"));
		dataPairsTrue.add(new DataPair("","",""));
		dataPairsTrue.add(new DataPair("","",""));
		dataPairsTrue.add(new DataPair("014","Vat Amount","R14.0"));
		scrapedStatement = new ScrapedResult("","","",dataPairsTrue);
		
		interpreter = new ScrapeInterpreter(scrapedStatement, spec_ALL, numericDataFormatter);
		
		assertTrue(interpreter.evaluate().equals("000"));

	}*/
	
	/*@Test 
	public void testBrokenScript_HasVatCalculationError(){
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
		dataPairsTrue.add(new DataPair("011","New Account Charges","R01.0"));
		dataPairsTrue.add(new DataPair("","",""));
		dataPairsTrue.add(new DataPair("","",""));
		dataPairsTrue.add(new DataPair("014","Vat Amount","R14.0"));
		scrapedStatement = new ScrapedResult("","","",dataPairsTrue);
		
		interpreter = new ScrapeInterpreter(scrapedStatement, spec_ALL, numericDataFormatter);
		
		assertTrue(interpreter.evaluate().equals("BrokenScript"));

	}*/
}
