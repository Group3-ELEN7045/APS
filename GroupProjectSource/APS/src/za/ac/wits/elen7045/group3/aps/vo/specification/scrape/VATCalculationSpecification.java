package za.ac.wits.elen7045.group3.aps.vo.specification.scrape;
/**
 * @author bakwanyana
 */
import za.ac.wits.elen7045.group3.aps.domain.accounts.abtracts.AbstractBillingAccountStatement;
import za.ac.wits.elen7045.group3.aps.services.specification.ApplicationSpecification;

public class VATCalculationSpecification extends 
		ApplicationSpecification<AbstractBillingAccountStatement> {
	
	private double vatPercentage;
	
	public VATCalculationSpecification(double vatPercentage){ // injected % to allow for variable vat change
		this.vatPercentage = vatPercentage;
	}
	@Override
	public boolean isSatisfiedBy(AbstractBillingAccountStatement statement) {
		double calc;
		calc = Double.parseDouble(statement.getAccountNewCharges().substring(1))*vatPercentage/100;	
		double statementVATAmount = Double.parseDouble(statement.getAccountVATAmount().substring(1));
		return calc == statementVATAmount;
	}

	
	
}
