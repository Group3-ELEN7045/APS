package test.za.ac.wits.group3.scrape;

import static org.junit.Assert.*;    
import static org.mockito.Mockito.*;

import org.junit.After;  
import org.junit.Before;  
import org.junit.Test;  
import org.junit.runner.RunWith;  
import org.mockito.runners.MockitoJUnitRunner;  

import za.ac.wits.elen7045.group3.aps.services.scrape.integrity.DataIntegrity;

@RunWith(MockitoJUnitRunner.class)
public class DataIntegrityTests {
	
	
	
	@Before
	public void init(){
		
	}
	
	@After
	public void tearDown(){
		
	}
	
	@Test
	public void additionCheck(){
		
		assertTrue(DataIntegrity.additionCorrect());
	}

}
