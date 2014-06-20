package za.ac.wits.elen7045.group3.aps.services.scrape;
/**
 * @author bakwanyana
 */
public class NumericDataConverter {
	INumericDataConverterStrategy dataConverter;
	
	public NumericDataConverter(INumericDataConverterStrategy dataConverter){
		this.dataConverter = dataConverter;
	}
	
	public String convert(String value){
		
		return dataConverter.convert(value);
	}
}
