package za.ac.wits.elen7045.group3.aps.services.util;

import com.thoughtworks.xstream.XStream;

public class APSXMLMarshaller {
	private XStream xstream;
	public APSXMLMarshaller(XStream xstream){
		this.xstream = xstream;
	}
	public String objectToXML(String aliasName, Object instanceVar){
		xstream.alias(aliasName, instanceVar.getClass());
		return xstream.toXML(instanceVar);
	}
	
	public String objectToXMLWithId(String aliasName, String attributeName, Object instanceVar){
		xstream.useAttributeFor(instanceVar.getClass(), attributeName);
		xstream.alias(aliasName, instanceVar.getClass());
		return xstream.toXML(instanceVar);
	}
	
	/*public Object XMLtoObject(){
		return ;
	}*/

}
