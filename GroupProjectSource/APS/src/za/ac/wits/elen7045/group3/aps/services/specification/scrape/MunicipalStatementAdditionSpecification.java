package za.ac.wits.elen7045.group3.aps.services.specification.scrape;

import za.ac.wits.elen7045.group3.aps.domain.accounts.abtracts.AbstractBillingAccountStatement;
import za.ac.wits.elen7045.group3.aps.domain.accounts.statement.*;

public class MunicipalStatementAdditionSpecification extends
		AbstractStatementAdditionSpecification {

	@Override
	public boolean isSatisfiedBy(AbstractBillingAccountStatement statement) {
		return commonAdditionSatisfied(statement) && municipalSpecificAdditonSatisfied((MunicipalStatement)statement);
	}
	
	private boolean municipalSpecificAdditonSatisfied(MunicipalStatement statement){
		
		double calc = 0.0;
		calc = Double.parseDouble(statement.getElectricityCharges().substring(1))
				+ Double.parseDouble(statement.getGasCharges().substring(1))
				+ Double.parseDouble(statement.getWaterCharges().substring(1))
				+ Double.parseDouble(statement.getSewerageCharges().substring(1))
				+ Double.parseDouble(statement.getRefuseCharges().substring(1));
		
		double newAccCharge = Double.parseDouble(statement.getAccountNewCharges().substring(1));
		return calc == newAccCharge;
	}

}
