package za.ac.wits.elen7045.group3.aps.domain.accounts.repository;

import java.util.LinkedList;
import java.util.List;

import za.ac.wits.elen7045.group3.aps.domain.accounts.abtracts.AbstractStatement;
import za.ac.wits.elen7045.group3.aps.domain.accounts.interfaces.StatementRepository;

public class AccountStatementRepository implements StatementRepository{
	
	LinkedList<AbstractStatement> data = new LinkedList<>();
	
	@Override
	public boolean doesAccountEntryExist(AbstractStatement account){
		return data.contains(account);
	}
	
	@Override
	public void addAccount(int index, AbstractStatement account){	
		data.add(index, account);		
	}

	@Override
	public List<AbstractStatement> getAccounts() {
		return data;
	}

}
