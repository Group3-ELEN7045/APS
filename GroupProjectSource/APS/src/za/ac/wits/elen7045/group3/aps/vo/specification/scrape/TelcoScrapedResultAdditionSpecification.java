package za.ac.wits.elen7045.group3.aps.vo.specification.scrape;
/**
 * @author bakwanyana
 */

import za.ac.wits.elen7045.group3.aps.domain.scrape.vo.DefaultNumericDataFormatStrategy;
import za.ac.wits.elen7045.group3.aps.domain.scrape.vo.NumericDataFormatter;
import za.ac.wits.elen7045.group3.aps.domain.scrape.vo.ScrapedResult;
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
		calc = numericDataFormatter.getNumericValue(statement.getDataPairList().get(15).getValue())
						+ numericDataFormatter.getNumericValue(statement.getDataPairList().get(16).getValue());
		double newAccCharge =numericDataFormatter.getNumericValue(statement.getDataPairList().get(10).getValue());
		return calc == newAccCharge;

	}

}
