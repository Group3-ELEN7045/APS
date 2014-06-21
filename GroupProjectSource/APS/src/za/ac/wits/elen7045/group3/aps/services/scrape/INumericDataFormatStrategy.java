package za.ac.wits.elen7045.group3.aps.services.scrape;
/**
 * @author bakwanyana
 */
public interface INumericDataFormatStrategy {

	public String getFormattedString(String value);
	public double getNumericValue(String value);

}
