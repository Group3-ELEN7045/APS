package za.ac.wits.elen7045.group3.aps.vo.specification.scrape;
/**
 * @author bakwanyana
 */
import za.ac.wits.elen7045.group3.aps.services.specification.ApplicationSpecification;
import za.ac.wits.elen7045.group3.aps.vo.scrape.DefaultNumericDataFormatStrategy;
import za.ac.wits.elen7045.group3.aps.vo.scrape.NumericDataFormatter;
import za.ac.wits.elen7045.group3.aps.vo.scrape.ScrapedResult;

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
		calc = numericDataFormatter.getNumericValue(statement.getDataPairList().get(16).getValue())
				+ numericDataFormatter.getNumericValue(statement.getDataPairList().get(18).getValue())
				+ numericDataFormatter.getNumericValue(statement.getDataPairList().get(20).getValue())
				+ numericDataFormatter.getNumericValue(statement.getDataPairList().get(21).getValue())
				+ numericDataFormatter.getNumericValue(statement.getDataPairList().get(22).getValue());
		
		double newAccCharge = numericDataFormatter.getNumericValue(statement.getDataPairList().get(10).getValue());
		return calc == newAccCharge;
	}

}
