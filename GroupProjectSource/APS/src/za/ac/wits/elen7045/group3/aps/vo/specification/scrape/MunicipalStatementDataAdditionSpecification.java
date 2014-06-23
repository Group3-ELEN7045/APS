package za.ac.wits.elen7045.group3.aps.vo.specification.scrape;
/**
 * @author bakwanyana
 */
import za.ac.wits.elen7045.group3.aps.domain.accounts.abtracts.ScrapedData;
import za.ac.wits.elen7045.group3.aps.domain.accounts.statement.*;
import za.ac.wits.elen7045.group3.aps.services.specification.ApplicationSpecification;
import za.ac.wits.elen7045.group3.aps.vo.scrape.DefaultNumericDataFormatStrategy;
import za.ac.wits.elen7045.group3.aps.vo.scrape.NumericDataFormatter;

public class MunicipalStatementDataAdditionSpecification extends
		ApplicationSpecification<ScrapedData> {

	private final NumericDataFormatter numericDataFormatter;
	
	public MunicipalStatementDataAdditionSpecification(){
		// default the dataFormat conversion if none is specified
		this.numericDataFormatter = new NumericDataFormatter(new DefaultNumericDataFormatStrategy());
	}
	
	public MunicipalStatementDataAdditionSpecification(NumericDataFormatter numericDataFormatter){
		this.numericDataFormatter = numericDataFormatter;
	}
	
	@Override
	public boolean isSatisfiedBy(ScrapedData statement) {
		return municipalSpecificAdditonSatisfied((MunicipalStatement)statement);
	}
	
	private boolean municipalSpecificAdditonSatisfied(MunicipalStatement statement){
		
		double calc = 0.0;
		calc = numericDataFormatter.getNumericValue(statement.getElectricityCharges())
				+ numericDataFormatter.getNumericValue(statement.getGasCharges())
				+ numericDataFormatter.getNumericValue(statement.getWaterCharges())
				+ numericDataFormatter.getNumericValue(statement.getSewerageCharges())
				+ numericDataFormatter.getNumericValue(statement.getRefuseCharges());
		
		double newAccCharge = numericDataFormatter.getNumericValue(statement.getAccountNewCharges());
		return calc == newAccCharge;
	}

}
