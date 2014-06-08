package za.ac.wits.elen7045.group3.aps.domain.accounts.repository;

import java.util.List;

import za.ac.wits.elen7045.group3.aps.domain.accounts.abtracts.AbstractAccount;
import za.ac.wits.elen7045.group3.aps.domain.accounts.interfaces.AccountDataRepository;

public class AccountDataManager{
	
	private AccountDataRepository repository;
	
	public AccountDataManager(AccountDataRepository adr) {
		repository = adr;
	}

	public void addCustomerAccount(int index, AbstractAccount account){
		//only add account if it does not exist
		if(!repository.doesAccountEntryExist(account)){
			repository.addAccount(index, account);
		}
	}
	
	public List<AbstractAccount> getAccounts(){
		return repository.getAccounts();
		
	}
}
