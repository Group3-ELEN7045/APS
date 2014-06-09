package za.ac.wits.elen7045.group3.aps.domain.accounts.repository;

import java.util.LinkedList;
import java.util.List;

import za.ac.wits.elen7045.group3.aps.domain.accounts.abtracts.AbstractAccount;
import za.ac.wits.elen7045.group3.aps.domain.accounts.interfaces.AccountDataRepository;

public class AccountRepository implements AccountDataRepository{
	
	LinkedList<AbstractAccount> data = new LinkedList<>();
	
	@Override
	public boolean doesAccountEntryExist(AbstractAccount account){
		return data.contains(account);
	}
	
	@Override
	public void addAccount(int index, AbstractAccount account){	
		data.add(index, account);		
	}

	@Override
	public List<AbstractAccount> getAccounts() {
		return data;
	}

}
