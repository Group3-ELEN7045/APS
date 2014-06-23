package za.ac.wits.elen7045.group3.aps.services.util;

import com.thoughtworks.xstream.XStream;

public class StatementDataMarshaller<T> {
	private XStream xstream;
	
	public StatementDataMarshaller(XStream xstream){
		this.xstream = xstream;
	}
	
	public String unMarshallToXML(String alias,Class<T> param,Object instanceObject){
		xstream.alias(alias, param);
		return xstream.toXML(instanceObject);
	}
	
	@SuppressWarnings("unchecked")
	public T marshallToObject(String alias,Class<T> param, String xmlData){
		xstream.alias(alias, param);
		return (T) xstream.fromXML(xmlData);
	}
	
}
