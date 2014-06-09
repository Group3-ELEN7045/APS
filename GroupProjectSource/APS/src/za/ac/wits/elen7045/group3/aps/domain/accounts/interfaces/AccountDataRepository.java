package za.ac.wits.elen7045.group3.aps.domain.accounts.interfaces;

import java.util.List;

import za.ac.wits.elen7045.group3.aps.domain.accounts.abtracts.AbstractAccount;

public interface AccountDataRepository {
	boolean doesAccountEntryExist(AbstractAccount account);
	void addAccount(int index, AbstractAccount account);
	List<AbstractAccount> getAccounts();
}
