package test.za.ac.wits.group3.scrape;

import static org.mockito.Mockito.*;
import static org.junit.Assert.*;   

import org.junit.After;  
import org.junit.Before;  
import org.junit.Test;  
import org.junit.runner.RunWith;  
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner; 

import za.ac.wits.elen7045.group3.aps.domain.accounts.statement.*;
import za.ac.wits.elen7045.group3.aps.services.specification.scrape.VATCalculationSpecification;

@RunWith(MockitoJUnitRunner.class)
public class VATCalculationSpecTest {
	
	VATCalculationSpecification vatSpec;
	
	@Mock MunicipalStatement trueStatement;
	@Mock MunicipalStatement falseStatement;

	@Before
	public void init(){
		vatSpec = new VATCalculationSpecification(14);
		when(trueStatement.getAccountNewCharges()).thenReturn("R100");
		when(trueStatement.getAccountVATAmount()).thenReturn("R14.00");
		when(falseStatement.getAccountNewCharges()).thenReturn("R100");
		when(falseStatement.getAccountVATAmount()).thenReturn("R10.14");
		
	}
	
	@After
	public void tearDown(){
		trueStatement = null;
		falseStatement = null;
		vatSpec = null;
	}
	
	@Test
	public void testCorrectCalculation(){
		
		assertTrue("Error validating correct calculation",vatSpec.isSatisfiedBy(trueStatement));
		assertFalse("Error validating incorrect calculation",vatSpec.isSatisfiedBy(falseStatement));
	}

}
