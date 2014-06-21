package za.ac.wits.elen7045.group3.aps.vo.specification.scrape;
/**
 * @author bakwanyana
 */
import za.ac.wits.elen7045.group3.aps.domain.accounts.abtracts.AbstractBillingAccountStatement;
import za.ac.wits.elen7045.group3.aps.services.scrape.DefaultNumericDataFormatStrategy;
import za.ac.wits.elen7045.group3.aps.services.scrape.NumericDataFormatter;
import za.ac.wits.elen7045.group3.aps.services.specification.ApplicationSpecification;

public class StatementVATCalculationSpecification extends 
		ApplicationSpecification<AbstractBillingAccountStatement> {
	
	private double vatPercentage;
	private NumericDataFormatter numericDataFormatter;
	
	public StatementVATCalculationSpecification(){ // use default values
		this.vatPercentage = 14;
		this.numericDataFormatter = new NumericDataFormatter(new DefaultNumericDataFormatStrategy());
	}
	
	public StatementVATCalculationSpecification(double vatPercentage, NumericDataFormatter numericDataFormatter){ // injected % to allow for variable vat change
		this.vatPercentage = vatPercentage;
		this.numericDataFormatter = numericDataFormatter;
	}
	@Override
	public boolean isSatisfiedBy(AbstractBillingAccountStatement statement) {
		double calc = 0.0;
		calc = numericDataFormatter.getNumericValue(statement.getAccountNewCharges())*vatPercentage/100;	
		double statementVATAmount = numericDataFormatter.getNumericValue(statement.getAccountVATAmount());
		return calc == statementVATAmount;
		
	}

	
	
}
