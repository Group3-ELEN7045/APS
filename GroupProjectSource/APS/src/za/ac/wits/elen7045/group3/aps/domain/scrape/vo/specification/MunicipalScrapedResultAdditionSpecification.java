package za.ac.wits.elen7045.group3.aps.domain.scrape.vo.specification;
/**
 * @author bakwanyana
 */
import za.ac.wits.elen7045.group3.aps.domain.scrape.vo.ScrapedResult;
import za.ac.wits.elen7045.group3.aps.services.scrape.DefaultNumericDataFormatStrategy;
import za.ac.wits.elen7045.group3.aps.services.scrape.NumericDataFormatter;
import za.ac.wits.elen7045.group3.aps.services.specification.ApplicationSpecification;

public class MunicipalScrapedResultAdditionSpecification 
		extends ApplicationSpecification<ScrapedResult> {
	private final NumericDataFormatter numericDataFormatter;
	
	public MunicipalScrapedResultAdditionSpecification(){
		// default the dataFormat conversion if none is specified
		this.numericDataFormatter = new NumericDataFormatter(new DefaultNumericDataFormatStrategy());
	}
	
	public MunicipalScrapedResultAdditionSpecification(NumericDataFormatter numericDataFormatter){
		this.numericDataFormatter = numericDataFormatter;
	}
	
	@Override
	public boolean isSatisfiedBy(ScrapedResult statement) {
		return municipalSpecificAdditonSatisfied(statement);
	}
	
	private boolean municipalSpecificAdditonSatisfied(ScrapedResult statement){
		
		double calc = 0.0;
		calc = numericDataFormatter.getNumericValue(statement.getDataPairListItemValue(16))
				+ numericDataFormatter.getNumericValue(statement.getDataPairListItemValue(18))
				+ numericDataFormatter.getNumericValue(statement.getDataPairListItemValue(20))
				+ numericDataFormatter.getNumericValue(statement.getDataPairListItemValue(21))
				+ numericDataFormatter.getNumericValue(statement.getDataPairListItemValue(22));
		
		double newAccCharge = numericDataFormatter.getNumericValue(statement.getDataPairListItemValue(10));
		return calc == newAccCharge;
	}

}
