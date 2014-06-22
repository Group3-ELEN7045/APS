package za.ac.wits.elen7045.group3.aps.vo.scrape;
/**
 * @author bakwanyana
 */
import java.io.Serializable;

public class DataPair implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String id;
	private String text;
	private String value;

	public String getText() {
		return text;
	}
	public String getValue() {
		return value;
	}

	public String getId() {
		return id;
	}
	@Override
	public String toString() {
		return "DataPair [text=" + text + ", value=" + value + "]";
	}

	public DataPair(DataPair copy)
	{
		this.id = copy.getId();
		this.text = copy.getText();
		this.value = copy.getValue();
	}

	public DataPair(String id, String text, String value)
	{
		this.id = id;
		this.text = text;
		this.value = value;
	}
}
