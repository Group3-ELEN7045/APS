package za.ac.wits.elen7045.group3.aps.domain.accounts.repository;

import java.util.List;

import za.ac.wits.elen7045.group3.aps.domain.accounts.abtracts.AbstractStatement;
import za.ac.wits.elen7045.group3.aps.domain.accounts.interfaces.StatementRepository;

public class StatementManager{
	
	private StatementRepository repository;
	
	public StatementManager(StatementRepository adr) {
		repository = adr;
	}

	public void addCustomerAccount(int index, AbstractStatement account){
		//only add account if it does not exist
		if(!repository.doesAccountEntryExist(account)){
			repository.addAccount(index, account);
		}
	}
	
	public List<AbstractStatement> getAccounts(){
		return repository.getAccounts();
		
	}
}
