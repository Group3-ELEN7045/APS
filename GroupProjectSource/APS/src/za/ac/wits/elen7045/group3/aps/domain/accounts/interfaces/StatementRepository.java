package za.ac.wits.elen7045.group3.aps.domain.accounts.interfaces;

import java.util.List;

import za.ac.wits.elen7045.group3.aps.domain.accounts.abtracts.AbstractBillingAccountStatement;
import za.ac.wits.elen7045.group3.aps.domain.accounts.abtracts.AbstractStatement;

public interface StatementRepository {
	boolean doesAccountEntryExist(AbstractBillingAccountStatement account);
	void addAccount(int index, AbstractBillingAccountStatement account);
	List<AbstractBillingAccountStatement> getAccounts();
}
