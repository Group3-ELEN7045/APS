package za.ac.wits.elen7045.group3.aps.vo.specification.scrape;
/**
 * @author bakwanyana
 */
import za.ac.wits.elen7045.group3.aps.domain.accounts.abtracts.AbstractBillingAccountStatement;
import za.ac.wits.elen7045.group3.aps.domain.accounts.statement.TelcoStatement;
import za.ac.wits.elen7045.group3.aps.services.scrape.DefaultNumericDataFormatStrategy;
import za.ac.wits.elen7045.group3.aps.services.scrape.NumericDataFormatter;
import za.ac.wits.elen7045.group3.aps.services.specification.ApplicationSpecification;
public class TelcoStatementDataAdditionSpecification extends
			ApplicationSpecification<AbstractBillingAccountStatement>{
	
	private NumericDataFormatter numericDataFormatter;
	
	public TelcoStatementDataAdditionSpecification(){
		this.numericDataFormatter = new NumericDataFormatter(new DefaultNumericDataFormatStrategy());
	}
	
	public TelcoStatementDataAdditionSpecification(NumericDataFormatter numericDataFormatter){
		this.numericDataFormatter = numericDataFormatter;
	}
	
	@Override
	public boolean isSatisfiedBy(AbstractBillingAccountStatement statement) {
		// verify that common data is consistent as well as statement specific data
		return telcoSpecificAdditonSatisfied((TelcoStatement)statement);
	}
	
	private boolean telcoSpecificAdditonSatisfied(TelcoStatement statement){
		
		double calc = 0.0;
		calc = numericDataFormatter.getNumericValue(statement.getServiceCharges())
						+ numericDataFormatter.getNumericValue(statement.getCallCharges());
		double newAccCharge =numericDataFormatter.getNumericValue(statement.getAccountNewCharges());
		return calc == newAccCharge;
	}

}
