
package za.ac.wits.elen7045.group3.aps.services.scrape;

import java.text.NumberFormat;

public class DefaultNumericDataConverterStrategy implements INumericDataConverterStrategy {


	@Override
	public String convert(String value) {
		NumberFormat currencyFormat = NumberFormat.getCurrencyInstance();
		String currency = currencyFormat.format(Double.parseDouble(value.substring(1)));
		return currency;
	}

}
