package test.za.ac.group3.accounts.test;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import za.ac.wits.elen7045.group3.aps.domain.accounts.abtracts.AbstractBillingAccountStatement;
import za.ac.wits.elen7045.group3.aps.domain.accounts.repository.AccountRepository;
import za.ac.wits.elen7045.group3.aps.domain.accounts.statement.MunicipalStatement;
import za.ac.wits.elen7045.group3.aps.services.managers.StatementManager;


public class AccountDataRepositoryBasicTest {

	StatementManager adm;
	
	@Before
	public void setUp(){
		adm = new StatementManager(new AccountRepository());
	}

	@Test
	public void test() {
		
		AbstractBillingAccountStatement  account = new MunicipalStatement("123456");
		adm.addCustomerAccount(0, account);
		
		assertEquals(1, adm.getAccounts().size());
	}

}
