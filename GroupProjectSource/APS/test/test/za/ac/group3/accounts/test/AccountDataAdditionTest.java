package test.za.ac.group3.accounts.test;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;


import org.junit.Before;
import org.junit.Test;

import static org.mockito.Mockito.*;   

import za.ac.wits.elen7045.group3.aps.domain.accounts.abtracts.AbstractAccount;
import za.ac.wits.elen7045.group3.aps.domain.accounts.accounttypes.CreditCardAccount;
import za.ac.wits.elen7045.group3.aps.domain.accounts.accounttypes.MunicipalAccount;
import za.ac.wits.elen7045.group3.aps.domain.accounts.accounttypes.TelcoAccount;
import za.ac.wits.elen7045.group3.aps.domain.accounts.interfaces.AccountDataRepository;
import za.ac.wits.elen7045.group3.aps.domain.accounts.repository.AccountDataManager;
import za.ac.wits.elen7045.group3.aps.domain.accounts.repository.AccountRepository;

public class AccountDataAdditionTest {
	
	AccountDataRepository repo;
	AccountDataManager adm;

	@Before
	public void setUp(){
		repo = mock(AccountRepository.class);
		adm = new AccountDataManager(repo);
	}
	
	@Test
	public void testDuplicateAccounts(){

		//setup account
		AbstractAccount muniaccount 	= new MunicipalAccount("123456");

		//configure mock
		when(repo.doesAccountEntryExist(muniaccount)).thenReturn(false).thenReturn(true);
		when(repo.doesAccountEntryExist(muniaccount)).thenReturn(true).thenReturn(true);
		
		//exercise SUT
		adm.addCustomerAccount(1, muniaccount);
		adm.addCustomerAccount(1, muniaccount);
		
		//verify account only added once
		verify(repo).addAccount(1, muniaccount);

	}
	
	@Test
	public void testAddAccounts() {
		//setup account
		AbstractAccount muniaccount 	= new MunicipalAccount("123456");
		AbstractAccount creditaccount 	= new CreditCardAccount("798101112");
		AbstractAccount telcoaccount 	= new TelcoAccount("1213141516");
		
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
