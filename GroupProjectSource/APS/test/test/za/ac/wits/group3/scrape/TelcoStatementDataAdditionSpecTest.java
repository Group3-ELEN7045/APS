package test.za.ac.wits.group3.scrape;
/**
 * @author bakwanyana
 */
import static org.mockito.Mockito.*;
import static org.junit.Assert.*;   

import org.junit.After;  
import org.junit.Before;  
import org.junit.Test;  
import org.junit.runner.RunWith;  
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner; 

import za.ac.wits.elen7045.group3.aps.domain.accounts.statement.*;
import za.ac.wits.elen7045.group3.aps.vo.specification.scrape.TelcoStatementDataAdditionSpecification;

@RunWith(MockitoJUnitRunner.class)
public class TelcoStatementDataAdditionSpecTest {
	
	TelcoStatementDataAdditionSpecification telcoSpec;
	@Mock TelcoStatement trueStatement;
	@Mock TelcoStatement falseStatement;
	
	@Before
	public void init(){
		
		telcoSpec = new TelcoStatementDataAdditionSpecification();
		
		when(trueStatement.getAccountNewCharges()).thenReturn("R200");
		when(trueStatement.getServiceCharges()).thenReturn("R50.50");
		when(trueStatement.getCallCharges()).thenReturn("R149.50");
		
		when(falseStatement.getAccountNewCharges()).thenReturn("R200");
		when(falseStatement.getServiceCharges()).thenReturn("R50.50");
		when(falseStatement.getCallCharges()).thenReturn("R149.51");
	}
	
	@After
	public void tearDown(){
		trueStatement = null;
		falseStatement = null;
	}
	
	@Test
	public void testCorrectAddition(){
		
		assertTrue(telcoSpec.isSatisfiedBy(trueStatement));
		assertFalse(telcoSpec.isSatisfiedBy(falseStatement));
	}

}
