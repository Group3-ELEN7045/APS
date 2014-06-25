package za.ac.wits.elen7045.group3.aps.services.scrape.acl;
/**
 * @author bakwanyana
 */
import java.io.File;

import za.ac.wits.elen7045.group3.aps.domain.scrape.vo.DataPair;

import com.thoughtworks.xstream.XStream;

public class XMLFileMarshall {
	
	public Object convertScrapedDataToObject(Class objectToConvert, String filePath){
		XStream xstream = new XStream();
		xstream.alias("scrape-session",objectToConvert);
		xstream.alias("datapair",DataPair.class);
		xstream.useAttributeFor(DataPair.class, "id");
		xstream.addImplicitCollection(objectToConvert, "dataPairs");
		
		return xstream.fromXML(new File(filePath).getAbsoluteFile());
	}
}
