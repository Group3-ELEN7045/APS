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
import za.ac.wits.elen7045.group3.aps.vo.specification.scrape.*;

@RunWith(MockitoJUnitRunner.class)
public class MunicipalStatementDataAdditionSpecTest {
	
	MunicipalStatementDataAdditionSpecification municipalSpec;
	StatementVATCalculationSpecification vatSpec;
	DuplicateStatementDataSpecification dupSpec;
	@Mock MunicipalStatement trueStatement;
	@Mock MunicipalStatement falseStatement;
	
	@Before
	public void init(){
		
		municipalSpec = new MunicipalStatementDataAdditionSpecification();
		
		when(trueStatement.getAccountNewCharges()).thenReturn("R200");
		
		when(trueStatement.getElectricityCharges()).thenReturn("R50.50");
		when(trueStatement.getGasCharges()).thenReturn("R49.50");
		when(trueStatement.getSewerageCharges()).thenReturn("R70");
		when(trueStatement.getRefuseCharges()).thenReturn("R10");
		when(trueStatement.getWaterCharges()).thenReturn("R20");
		
		when(falseStatement.getAccountNewCharges()).thenReturn("R200");
		
		when(falseStatement.getElectricityCharges()).thenReturn("R50.50");
		when(falseStatement.getGasCharges()).thenReturn("R49.50");
		when(falseStatement.getSewerageCharges()).thenReturn("R70");
		when(falseStatement.getRefuseCharges()).thenReturn("R10");
		when(falseStatement.getWaterCharges()).thenReturn("R20.01");
		
	}
	
	@After
	public void tearDown(){
		trueStatement = null;
		falseStatement = null;
	}
	
	@Test
	public void testCorrectAddition(){
		
		assertTrue(municipalSpec.isSatisfiedBy(trueStatement));
		assertFalse(municipalSpec.isSatisfiedBy(falseStatement));
	}

}
