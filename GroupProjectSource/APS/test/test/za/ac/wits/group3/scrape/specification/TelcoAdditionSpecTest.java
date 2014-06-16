package test.za.ac.wits.group3.scrape.specification;

import static org.mockito.Mockito.*;
import static org.junit.Assert.*;   

import org.junit.After;  
import org.junit.Before;  
import org.junit.Test;  
import org.junit.runner.RunWith;  
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner; 

import za.ac.wits.elen7045.group3.aps.domain.accounts.accounttypes.TelcoStatement;
import za.ac.wits.elen7045.group3.aps.services.specification.scrape.TelcoStatementAdditionSpecification;

@RunWith(MockitoJUnitRunner.class)
public class TelcoAdditionSpecTest {
	
	TelcoStatementAdditionSpecification telcoSpec;
	@Mock TelcoStatement trueStatement;
	@Mock TelcoStatement falseStatement;
	
	@Before
	public void init(){
		
		telcoSpec = new TelcoStatementAdditionSpecification();
		
		when(trueStatement.getAccountOpeningBalance()).thenReturn("R2000");
		when(trueStatement.getAccountPaymentReceived()).thenReturn("R300");
		when(trueStatement.getAccountNewCharges()).thenReturn("R200");
		when(trueStatement.getAccountDiscount()).thenReturn("R50");
		when(trueStatement.getAccountDeductions()).thenReturn("R100");
		when(trueStatement.getAccountTotalDue()).thenReturn("R1750");
		
		when(trueStatement.getServiceCharges()).thenReturn("R50.50");
		when(trueStatement.getCallCharges()).thenReturn("R149.50");
		
		
		when(falseStatement.getAccountOpeningBalance()).thenReturn("R2000");
		when(falseStatement.getAccountPaymentReceived()).thenReturn("R300");
		when(falseStatement.getAccountNewCharges()).thenReturn("R200");
		when(falseStatement.getAccountDiscount()).thenReturn("R50");
		when(falseStatement.getAccountDeductions()).thenReturn("R100");
		when(falseStatement.getAccountTotalDue()).thenReturn("R1750.50");
		
		when(falseStatement.getServiceCharges()).thenReturn("R50.50");
		when(falseStatement.getCallCharges()).thenReturn("R149.50");
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
