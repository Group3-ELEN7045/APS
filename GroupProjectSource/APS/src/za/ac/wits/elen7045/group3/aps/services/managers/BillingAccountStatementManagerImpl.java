package za.ac.wits.elen7045.group3.aps.services.managers;

import java.util.List;

import za.ac.wits.elen7045.group3.aps.domain.entities.BillingAccountStatement;
import za.ac.wits.elen7045.group3.aps.domain.repository.statement.StatementRepository;

public class BillingAccountStatementManagerImpl implements BillingAccountStatementManager{
	
	private StatementRepository statementRepo;
	
	public BillingAccountStatementManagerImpl(StatementRepository statementRepo){
		this.statementRepo = statementRepo;
	}

	@Override
	public boolean addStatement(BillingAccountStatement statement) {
	    return statementRepo.addStatement(statement);
	}

	@Override
	public List<BillingAccountStatement> getAccountStatement(String accountNumber) {
			return statementRepo.getAccountStatement(accountNumber);
	}

}
