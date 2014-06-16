package za.ac.wits.elen7045.group3.aps.domain.accounts.repository;

import java.util.LinkedList;
import java.util.List;

import za.ac.wits.elen7045.group3.aps.domain.accounts.abtracts.AbstractBillingAccountStatement;
import za.ac.wits.elen7045.group3.aps.domain.accounts.abtracts.AbstractStatement;
import za.ac.wits.elen7045.group3.aps.domain.accounts.interfaces.StatementRepository;

public class AccountStatementRepository implements StatementRepository{
	
	LinkedList<AbstractBillingAccountStatement> data = new LinkedList<AbstractBillingAccountStatement>();
	
	@Override
	public boolean doesAccountEntryExist(AbstractBillingAccountStatement account){
		return data.contains(account);
	}
	
	@Override
	public void addAccount(int index, AbstractBillingAccountStatement account){	
		data.add(index, account);		
	}

	@Override
	public List<AbstractBillingAccountStatement> getAccounts() {
		return data;
	}

}
