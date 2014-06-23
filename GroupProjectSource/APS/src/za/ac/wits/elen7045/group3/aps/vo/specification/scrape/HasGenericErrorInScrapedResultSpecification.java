package za.ac.wits.elen7045.group3.aps.vo.specification.scrape;

import za.ac.wits.elen7045.group3.aps.domain.accounts.abtracts.ScrapedData;
import za.ac.wits.elen7045.group3.aps.services.specification.ApplicationSpecification;
import za.ac.wits.elen7045.group3.aps.vo.scrape.DefaultNumericDataFormatStrategy;
import za.ac.wits.elen7045.group3.aps.vo.scrape.NumericDataFormatter;

public class GenericStatementDataAdditionSpecification 
		extends ApplicationSpecification<ScrapedData>{
	
	private final NumericDataFormatter numericDataFormatter;
	
	public GenericStatementDataAdditionSpecification(){
		this.numericDataFormatter = new NumericDataFormatter(new DefaultNumericDataFormatStrategy());
	}
	
	public GenericStatementDataAdditionSpecification(NumericDataFormatter numericDataFormatter){
		this.numericDataFormatter = numericDataFormatter;
	}
	@Override
	public boolean isSatisfiedBy(ScrapedData statement) {
		double calc = 0.0;
		calc = numericDataFormatter.getNumericValue(statement.getAccountOpeningBalance())
						- numericDataFormatter.getNumericValue(statement.getAccountPaymentReceived())
						+ numericDataFormatter.getNumericValue(statement.getAccountNewCharges())
						- numericDataFormatter.getNumericValue(statement.getAccountDiscount())
						- numericDataFormatter.getNumericValue(statement.getAccountDeductions());
		
		return numericDataFormatter.getNumericValue(statement.getAccountTotalDue()) == calc;
	}

}
