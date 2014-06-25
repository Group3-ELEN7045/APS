package za.ac.wits.elen7045.group3.aps.domain.repository.statement;

import java.util.List;

import za.ac.wits.elen7045.group3.aps.domain.entities.BillingAccountStatement;

/**
 * @author SilasMahlangu
 *
 */
public interface StatementRepository {
	public boolean addStatement(BillingAccountStatement statement);
    public List<BillingAccountStatement> getAccountStatement(String accountNumber);
}
