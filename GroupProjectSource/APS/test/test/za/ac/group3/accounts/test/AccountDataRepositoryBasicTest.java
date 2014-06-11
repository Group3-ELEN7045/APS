package test.za.ac.group3.accounts.test;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import za.ac.wits.elen7045.group3.aps.domain.accounts.abtracts.AbstractAccount;
import za.ac.wits.elen7045.group3.aps.domain.accounts.accounttypes.MunicipalAccount;
import za.ac.wits.elen7045.group3.aps.domain.accounts.repository.AccountDataManager;
import za.ac.wits.elen7045.group3.aps.domain.accounts.repository.AccountRepository;


public class AccountDataRepositoryBasicTest {

	AccountDataManager adm;
	
	@Before
	public void setUp(){
		adm = new AccountDataManager(new AccountRepository());
	}

	@Test
	public void test() {
		
		AbstractAccount  account = new MunicipalAccount("123456");
		adm.addCustomerAccount(0, account);
		
		assertEquals(1, adm.getAccounts().size());
	}

}
