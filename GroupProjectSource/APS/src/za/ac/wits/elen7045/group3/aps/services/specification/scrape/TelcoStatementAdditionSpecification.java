package za.ac.wits.elen7045.group3.aps.services.specification.scrape;

import za.ac.wits.elen7045.group3.aps.domain.accounts.abtracts.AbstractBillingAccountStatement;
import za.ac.wits.elen7045.group3.aps.domain.accounts.accounttypes.TelcoStatement;

public class TelcoStatementAdditionSpecification extends
		StatementAdditionSpecification{

	
	@Override
	public boolean isSatisfiedBy(AbstractBillingAccountStatement statement) {
		return commonAdditionSatisfied(statement) && telcoSpecificAdditonSatisfied((TelcoStatement)statement);
	}
	
	public boolean telcoSpecificAdditonSatisfied(TelcoStatement statement){
		
		double calc = 0.0;
		calc = Double.parseDouble(statement.getServiceCharges().substring(1))
						+ Double.parseDouble(statement.getCallCharges().substring(1));
		double newAccCharge = Double.parseDouble(statement.getAccountNewCharges().substring(1));
		return calc == newAccCharge;
	}

}
