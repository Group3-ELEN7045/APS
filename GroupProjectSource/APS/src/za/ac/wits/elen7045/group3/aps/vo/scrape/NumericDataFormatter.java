package za.ac.wits.elen7045.group3.aps.vo.scrape;
/**
 * @author bakwanyana
 */
public class NumericDataFormatter {
	INumericDataFormatStrategy dataConverter;
	
	public NumericDataFormatter(INumericDataFormatStrategy dataConverter){
		this.dataConverter = dataConverter;
	}
	
	public double getNumericValue(String value) {
		
		return dataConverter.getNumericValue(value);
	}
	
	public String getFormattedString(String value){
		return dataConverter.getFormattedString(value);
	}
}
