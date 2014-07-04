package za.ac.wits.elen7045.group3.aps.domain.scrape.vo.specification;

import za.ac.wits.elen7045.group3.aps.domain.scrape.vo.ScrapedResult;
import za.ac.wits.elen7045.group3.aps.services.scrape.DefaultNumericDataFormatStrategy;
import za.ac.wits.elen7045.group3.aps.services.scrape.NumericDataFormatter;
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
		calc = numericDataFormatter.getNumericValue(statement.getDataPairListItemValue(7))
						- numericDataFormatter.getNumericValue(statement.getDataPairListItemValue(9))
						+ numericDataFormatter.getNumericValue(statement.getDataPairListItemValue(10))
						- numericDataFormatter.getNumericValue(statement.getDataPairListItemValue(12))
						- numericDataFormatter.getNumericValue(statement.getDataPairListItemValue(11));
		
		return !(numericDataFormatter.getNumericValue(statement.getDataPairListItemValue(5)) == calc);
	}

}
