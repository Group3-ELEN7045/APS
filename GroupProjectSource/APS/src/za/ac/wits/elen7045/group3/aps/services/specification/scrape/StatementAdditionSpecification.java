package za.ac.wits.elen7045.group3.aps.services.specification.scrape;

import za.ac.wits.elen7045.group3.aps.domain.accounts.abtracts.AbstractBillingAccountStatement;
import za.ac.wits.elen7045.group3.aps.services.specification.ApplicationSpecification;

public abstract class StatementAdditionSpecification extends ApplicationSpecification<AbstractBillingAccountStatement>{
	
	public boolean commonAdditionSatisfied(final AbstractBillingAccountStatement statement){
		
		double calc = 0.0;
		calc = Double.parseDouble(statement.getAccountOpeningBalance().substring(1))
						- Double.parseDouble(statement.getAccountPaymentReceived().substring(1))
						+ Double.parseDouble(statement.getAccountNewCharges().substring(1))
						- Double.parseDouble(statement.getAccountDiscount().substring(1))
						- Double.parseDouble(statement.getAccountDeductions().substring(1));
		
		return Double.parseDouble(statement.getAccountTotalDue().substring(1)) == calc;
	}
}
