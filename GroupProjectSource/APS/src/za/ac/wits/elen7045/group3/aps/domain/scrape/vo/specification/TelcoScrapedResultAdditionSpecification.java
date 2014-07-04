package za.ac.wits.elen7045.group3.aps.domain.scrape.vo.specification;
/**
 * @author bakwanyana
 */

import za.ac.wits.elen7045.group3.aps.domain.scrape.vo.ScrapedResult;
import za.ac.wits.elen7045.group3.aps.services.scrape.DefaultNumericDataFormatStrategy;
import za.ac.wits.elen7045.group3.aps.services.scrape.NumericDataFormatter;
import za.ac.wits.elen7045.group3.aps.services.specification.ApplicationSpecification;
public class TelcoScrapedResultAdditionSpecification extends
			ApplicationSpecification<ScrapedResult>{
	
	private final NumericDataFormatter numericDataFormatter; 
	
	public TelcoScrapedResultAdditionSpecification(){
		this.numericDataFormatter = new NumericDataFormatter(new DefaultNumericDataFormatStrategy());
	}
	
	public TelcoScrapedResultAdditionSpecification(NumericDataFormatter numericDataFormatter){
		this.numericDataFormatter = numericDataFormatter;
	}
	
	@Override
	public boolean isSatisfiedBy(ScrapedResult statement) {
		// verify that common data is consistent as well as statement specific data
		return telcoSpecificAdditonSatisfied(statement);
	}
	
	private boolean telcoSpecificAdditonSatisfied(ScrapedResult statement){
		double calc = 0.0;
		calc = numericDataFormatter.getNumericValue(statement.getDataPairListItemValue(15))
						+ numericDataFormatter.getNumericValue(statement.getDataPairListItemValue(16));
		double newAccCharge =numericDataFormatter.getNumericValue(statement.getDataPairListItemValue(10));
		return calc == newAccCharge;

	}

}
