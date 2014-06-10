package za.ac.wits.elen7045.group3.aps.domain.vo;

public class DataPair {
	String id;
	String text;
	String value;
	public String getText() {
		return text;
	}
	public void setText(String text) {
		this.text = text;
	}
	public String getValue() {
		return value;
	}
	public void setValue(String value) {
		this.value = value;
	}

	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
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
