package za.ac.wits.elen7045.group3.aps.vo.specification.scrape;

import za.ac.wits.elen7045.group3.aps.domain.scrape.vo.DefaultNumericDataFormatStrategy;
import za.ac.wits.elen7045.group3.aps.domain.scrape.vo.NumericDataFormatter;
import za.ac.wits.elen7045.group3.aps.domain.scrape.vo.ScrapedResult;
import za.ac.wits.elen7045.group3.aps.services.specification.ApplicationSpecification;

public class HasGenericErrorInScrapedResultSpecification 
		extends ApplicationSpecification<ScrapedResult>{
	
	private final NumericDataFormatter numericDataFormatter;
	
	public HasGenericErrorInScrapedResultSpecification(){
		this.numericDataFormatter = new NumericDataFormatter(new DefaultNumericDataFormatStrategy());
	}
	
	public HasGenericErrorInScrapedResultSpecification(NumericDataFormatter numericDataFormatter){
		this.numericDataFormatter = numericDataFormatter;
	}
	@Override
	public boolean isSatisfiedBy(ScrapedResult statement) {
		double calc = 0.0;
		calc = numericDataFormatter.getNumericValue(statement.getDataPairList().get(7).getValue())
						- numericDataFormatter.getNumericValue(statement.getDataPairList().get(9).getValue())
						+ numericDataFormatter.getNumericValue(statement.getDataPairList().get(10).getValue())
						- numericDataFormatter.getNumericValue(statement.getDataPairList().get(12).getValue())
						- numericDataFormatter.getNumericValue(statement.getDataPairList().get(11).getValue());
		
		return !(numericDataFormatter.getNumericValue(statement.getDataPairList().get(5).getValue()) == calc);
	}

}
