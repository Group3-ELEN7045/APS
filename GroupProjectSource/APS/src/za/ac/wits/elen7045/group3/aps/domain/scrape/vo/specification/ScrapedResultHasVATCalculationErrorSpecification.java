package za.ac.wits.elen7045.group3.aps.domain.scrape.vo.specification;
/**
 * @author bakwanyana
 */
import za.ac.wits.elen7045.group3.aps.domain.scrape.vo.ScrapedResult;
import za.ac.wits.elen7045.group3.aps.services.scrape.DefaultNumericDataFormatStrategy;
import za.ac.wits.elen7045.group3.aps.services.scrape.NumericDataFormatter;
import za.ac.wits.elen7045.group3.aps.services.specification.ApplicationSpecification;

public class ScrapedResultHasVATCalculationErrorSpecification extends 
		ApplicationSpecification<ScrapedResult> {
	
	private final double vatPercentage;
	private NumericDataFormatter numericDataFormatter;
	
	public ScrapedResultHasVATCalculationErrorSpecification(){ // use default values
		this.vatPercentage = 14;
		this.numericDataFormatter = new NumericDataFormatter(new DefaultNumericDataFormatStrategy());
	}
	
	public ScrapedResultHasVATCalculationErrorSpecification(double vatPercentage, NumericDataFormatter numericDataFormatter){ // injected % to allow for variable vat change
		this.vatPercentage = vatPercentage;
		this.numericDataFormatter = numericDataFormatter;
	}
	@Override
	public boolean isSatisfiedBy(ScrapedResult statement) {
		double calc = 0.0;
		calc = numericDataFormatter.getNumericValue(statement.getDataPairList().get(10).getValue())*vatPercentage/100;	
		double statementVATAmount = numericDataFormatter.getNumericValue(statement.getDataPairList().get(13).getValue());
		return calc != statementVATAmount;
		
	}

	
	
}
