package test.za.ac.group3.accounts.test;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import org.junit.Before;
import org.junit.Test;

import static org.mockito.Mockito.*;   

import za.ac.wits.elen7045.group3.aps.domain.accounts.abtracts.AbstractBillingAccountStatement;
import za.ac.wits.elen7045.group3.aps.domain.accounts.accounttypes.CreditCardStatement;
import za.ac.wits.elen7045.group3.aps.domain.accounts.accounttypes.MunicipalStatement;
import za.ac.wits.elen7045.group3.aps.domain.accounts.accounttypes.TelcoStatement;
import za.ac.wits.elen7045.group3.aps.domain.accounts.interfaces.StatementRepository;
import za.ac.wits.elen7045.group3.aps.domain.accounts.repository.AccountRepository;
import za.ac.wits.elen7045.group3.aps.domain.accounts.repository.AccountStatementRepository;
import za.ac.wits.elen7045.group3.aps.domain.accounts.repository.StatementManager;

public class AccountStatementAdditionTest {
	
	StatementRepository repo;
	StatementManager adm;

	@Before
	public void setUp(){
		repo = mock(AccountStatementRepository.class);
		adm = new StatementManager(repo);
	}
	
	@Test
	public void testDuplicateAccounts(){

		//setup account
		AbstractBillingAccountStatement muniaccount 	= new MunicipalStatement("123456");

		//configure mock
		when(repo.doesAccountEntryExist(muniaccount)).thenReturn(false).thenReturn(true);
				
		//exercise SUT
		adm.addCustomerAccount(1, muniaccount);
				
		//verify account only added once
		verify(repo).addAccount(1, muniaccount);

	}
	
	@Test
	public void testAddAccounts() {
		//setup account
		AbstractBillingAccountStatement muniaccount 	= new MunicipalStatement("123456");
		AbstractBillingAccountStatement creditaccount 	= new CreditCardStatement("798101112");
		AbstractBillingAccountStatement telcoaccount 	= new TelcoStatement("1213141516");

		
		//configure mock
		when(repo.doesAccountEntryExist(muniaccount)).thenReturn(false).thenReturn(true);
		when(repo.doesAccountEntryExist(creditaccount)).thenReturn(false).thenReturn(true);
		when(repo.doesAccountEntryExist(telcoaccount)).thenReturn(false).thenReturn(true);
		
		//exercise SUT
		adm.addCustomerAccount(1, muniaccount);
		adm.addCustomerAccount(2, creditaccount);
		adm.addCustomerAccount(3, telcoaccount);
		
		//verify account only added once
		verify(repo).addAccount(1, muniaccount);
	}

}
