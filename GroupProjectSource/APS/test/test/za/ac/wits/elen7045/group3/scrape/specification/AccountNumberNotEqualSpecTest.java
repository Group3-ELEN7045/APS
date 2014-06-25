package test.za.ac.wits.elen7045.group3.scrape.specification;

import za.ac.wits.elen7045.group3.aps.domain.scrape.vo.DataPair;
import za.ac.wits.elen7045.group3.aps.domain.scrape.vo.ScrapedResult;
import za.ac.wits.elen7045.group3.aps.vo.specification.scrape.ScrapedResultAccountNumberMatchesSpecification;

import java.util.ArrayList;

import static org.junit.Assert.*; 

import org.junit.Before;
import org.junit.Test;

public class AccountNumberNotEqualSpecTest {
	ScrapedResultAccountNumberMatchesSpecification accNumberEqualSpec;
	String accountNumber;
	ScrapedResult scrapedData;
	ArrayList<DataPair> dataPairsTrue;
	ArrayList<DataPair> dataPairsFalse;
	@Before
	public void init(){
		accountNumber = "Bak1234T";
		accNumberEqualSpec = new ScrapedResultAccountNumberMatchesSpecification(accountNumber);
		dataPairsTrue = new ArrayList<DataPair>();
		dataPairsFalse = new ArrayList<DataPair>();


	}
	
	@Test
	public void testAccountNumberCorrect(){
		dataPairsTrue.add(new DataPair("001","Account Number","Bak1234T"));
		scrapedData = new ScrapedResult("", "", "", dataPairsTrue);
		assertTrue(accNumberEqualSpec.isSatisfiedBy(scrapedData));
	}
	
	@Test
	public void testAccountNumberIncorrect(){
		dataPairsFalse.add(new DataPair("001","Account Number","bak1234t"));
		scrapedData = new ScrapedResult("", "", "", dataPairsFalse);
		assertFalse(accNumberEqualSpec.isSatisfiedBy(scrapedData));
	}

}
