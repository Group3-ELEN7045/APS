/**
 * 
 */
package test;

import za.ac.wits.elen7045.group3.aps.domain.entities.Customer;

import com.thoughtworks.xstream.XStream;

/**
 * @author SilasMahlangu
 *
 */
public class XSTreamTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Customer cust = new Customer();
		cust.setFirstName("Silas");
		XStream xml = new XStream();
		System.out.println(xml.toXML(cust));
	}

}
