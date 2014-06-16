package test.za.ac.group3.accounts.test;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

<<<<<<< HEAD:GroupProjectSource/APS/test/test/za/ac/group3/accounts/test/AccountStatementAdditionTest.java
import org.junit.Before;
import org.junit.Test;

import za.ac.wits.elen7045.group3.aps.domain.accounts.abtracts.AbstractStatement;
import za.ac.wits.elen7045.group3.aps.domain.accounts.accounttypes.CreditCardStatement;
import za.ac.wits.elen7045.group3.aps.domain.accounts.accounttypes.MunicipalStatement;
import za.ac.wits.elen7045.group3.aps.domain.accounts.accounttypes.TelcoStatement;
import za.ac.wits.elen7045.group3.aps.domain.accounts.interfaces.StatementRepository;
import za.ac.wits.elen7045.group3.aps.domain.accounts.repository.AccountStatementRepository;
import za.ac.wits.elen7045.group3.aps.domain.accounts.repository.StatementManager;
=======

import org.junit.Before;
import org.junit.Test;

import static org.mockito.Mockito.*;   

import za.ac.wits.elen7045.group3.aps.domain.accounts.abtracts.AbstractBillingAccountStatement;
import za.ac.wits.elen7045.group3.aps.domain.accounts.accounttypes.CreditCardAccount;
import za.ac.wits.elen7045.group3.aps.domain.accounts.accounttypes.MunicipalAccount;
import za.ac.wits.elen7045.group3.aps.domain.accounts.accounttypes.TelcoAccount;
import za.ac.wits.elen7045.group3.aps.domain.accounts.interfaces.AccountDataRepository;
import za.ac.wits.elen7045.group3.aps.domain.accounts.repository.AccountDataManager;
import za.ac.wits.elen7045.group3.aps.domain.accounts.repository.AccountRepository;
>>>>>>> 334e171862bacecf51ba61bafe29223ce078425e:GroupProjectSource/APS/test/test/za/ac/group3/accounts/test/AccountDataAdditionTest.java

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
<<<<<<< HEAD:GroupProjectSource/APS/test/test/za/ac/group3/accounts/test/AccountStatementAdditionTest.java
		AbstractStatement muniaccount 	= new MunicipalStatement("123456");
=======
		AbstractBillingAccountStatement muniaccount 	= new MunicipalAccount("123456");
>>>>>>> 334e171862bacecf51ba61bafe29223ce078425e:GroupProjectSource/APS/test/test/za/ac/group3/accounts/test/AccountDataAdditionTest.java

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
<<<<<<< HEAD:GroupProjectSource/APS/test/test/za/ac/group3/accounts/test/AccountStatementAdditionTest.java
		AbstractStatement muniaccount 	= new MunicipalStatement("123456");
		AbstractStatement creditaccount 	= new CreditCardStatement("798101112");
		AbstractStatement telcoaccount 	= new TelcoStatement("1213141516");
=======
		AbstractBillingAccountStatement muniaccount 	= new MunicipalAccount("123456");
		AbstractBillingAccountStatement creditaccount 	= new CreditCardAccount("798101112");
		AbstractBillingAccountStatement telcoaccount 	= new TelcoAccount("1213141516");
>>>>>>> 334e171862bacecf51ba61bafe29223ce078425e:GroupProjectSource/APS/test/test/za/ac/group3/accounts/test/AccountDataAdditionTest.java
		
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
