package za.ac.wits.elen7045.group3.aps.vo.specification.scrape;
/**
 * @author bakwanyana
 */
import za.ac.wits.elen7045.group3.aps.domain.accounts.abtracts.ScrapedData;
import za.ac.wits.elen7045.group3.aps.services.specification.ApplicationSpecification;
import za.ac.wits.elen7045.group3.aps.vo.scrape.DefaultNumericDataFormatStrategy;
import za.ac.wits.elen7045.group3.aps.vo.scrape.NumericDataFormatter;

public class StatementVATCalculationSpecification extends 
		ApplicationSpecification<ScrapedData> {
	
	private final double vatPercentage;
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
	public boolean isSatisfiedBy(ScrapedData statement) {
		double calc = 0.0;
		calc = numericDataFormatter.getNumericValue(statement.getAccountNewCharges())*vatPercentage/100;	
		double statementVATAmount = numericDataFormatter.getNumericValue(statement.getAccountVATAmount());
		return calc == statementVATAmount;
		
	}

	
	
}
