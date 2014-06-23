
/**
 * @author bakwanyana
 */

package test.za.ac.wits.group3.scrape.specification;
/**
 * @author bakwanyana
 */
import static org.mockito.Mockito.*;
import static org.junit.Assert.*;    

import java.util.ArrayList;

import org.junit.After;  
import org.junit.Before;  
import org.junit.Test;  
import org.junit.runner.RunWith;  
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner; 

import za.ac.wits.elen7045.group3.aps.vo.scrape.DataPair;
import za.ac.wits.elen7045.group3.aps.vo.scrape.ScrapedResult;
import za.ac.wits.elen7045.group3.aps.vo.specification.scrape.*;

@RunWith(MockitoJUnitRunner.class)
public class MunicipalScrapedResultAdditionSpecTest {
	ArrayList<DataPair> dataPairsTrue;
	ScrapedResult scrapedStatement;
	MunicipalScrapedResultAdditionSpecification muniSpec;;
	
	@Before
	public void init(){
		muniSpec = new MunicipalScrapedResultAdditionSpecification();
		
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
		dataPairsTrue.add(new DataPair("011","New Charges","R200"));
		dataPairsTrue.add(new DataPair("","",""));
		dataPairsTrue.add(new DataPair("","",""));
		dataPairsTrue.add(new DataPair("","",""));
		

		
	}
	
	@Test
	public void testCorrectAddition(){
		dataPairsTrue.add(new DataPair("","",""));
		dataPairsTrue.add(new DataPair("","",""));
		dataPairsTrue.add(new DataPair("017","Electricity Charges","R50.50"));
		dataPairsTrue.add(new DataPair("","",""));
		dataPairsTrue.add(new DataPair("019","Gas Charges","R49.50"));
		dataPairsTrue.add(new DataPair("","",""));
		dataPairsTrue.add(new DataPair("021","Water Charges","R20"));
		dataPairsTrue.add(new DataPair("022","Sewerage Charges","R70"));
		dataPairsTrue.add(new DataPair("023","Refuse Charges","R10"));
		
		scrapedStatement = new ScrapedResult("","","",dataPairsTrue);
		
		assertTrue(muniSpec.isSatisfiedBy(scrapedStatement));
	}
	
	@Test
	public void testIncorrectAddition(){
		dataPairsTrue.add(new DataPair("","",""));
		dataPairsTrue.add(new DataPair("","",""));
		dataPairsTrue.add(new DataPair("017","Electricity Charges","R300"));
		dataPairsTrue.add(new DataPair("","",""));
		dataPairsTrue.add(new DataPair("019","Gas Charges","R49.50"));
		dataPairsTrue.add(new DataPair("","",""));
		dataPairsTrue.add(new DataPair("021","Water Charges","R20"));
		dataPairsTrue.add(new DataPair("022","Sewerage Charges","R70"));
		dataPairsTrue.add(new DataPair("023","Refuse Charges","R10"));
		
		scrapedStatement = new ScrapedResult("","","",dataPairsTrue);
		
		assertFalse(muniSpec.isSatisfiedBy(scrapedStatement));
	}

}
