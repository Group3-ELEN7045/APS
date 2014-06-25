package za.ac.wits.elen7045.group3.aps.domain.scrape.vo;
/**
 * @author bakwanyana
 */
import java.text.NumberFormat;

public class DefaultNumericDataFormatStrategy implements INumericDataFormatStrategy {


	@Override
	public String getFormattedString(String value) {
		NumberFormat currencyFormat = NumberFormat.getCurrencyInstance();
		String currency = currencyFormat.format(Double.parseDouble(value.substring(1)));
		return currency;
	}

	@Override
	public double getNumericValue(String value) {
		
		return Double.parseDouble(value.substring(1));
	}

}
