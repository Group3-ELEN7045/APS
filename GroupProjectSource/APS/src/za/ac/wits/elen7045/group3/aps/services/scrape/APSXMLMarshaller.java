package za.ac.wits.elen7045.group3.aps.services.scrape;

import java.io.File;
import za.ac.wits.elen7045.group3.aps.domain.vo.DataPair;

import com.thoughtworks.xstream.XStream;

public class APSXMLMarshaller {
	private  XStream xstream;
	private String filePath;
	public APSXMLMarshaller(String filePath){
		xstream = new XStream();
		this.filePath = filePath;
	}
	public Object convertAccountXMLToObject(Class objectToConvert){
		xstream.alias("scrape-session",objectToConvert);
		xstream.alias("datapair",DataPair.class);
		xstream.useAttributeFor(DataPair.class, "id");
		xstream.addImplicitCollection(objectToConvert, "dataPairs");
		
		return xstream.fromXML(new File(filePath));
	}
	
	public Object convertErrorXMLToObject(Class objectToConvert){
		xstream.alias("scrape-session",objectToConvert);		
		return xstream.fromXML(new File(filePath));
	}
	
}
