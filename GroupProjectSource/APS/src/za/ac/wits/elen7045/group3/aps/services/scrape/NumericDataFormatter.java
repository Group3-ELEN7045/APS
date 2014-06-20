package za.ac.wits.elen7045.group3.aps.services.scrape;
/**
 * @author bakwanyana
 */
public class NumericDataFormatter {
	INumericDataFormatStrategy dataConverter;
	
	public NumericDataFormatter(INumericDataFormatStrategy dataConverter){
		this.dataConverter = dataConverter;
	}
	
	public String format(String value){
		
		return dataConverter.getFormattedString(value);
	}
}
