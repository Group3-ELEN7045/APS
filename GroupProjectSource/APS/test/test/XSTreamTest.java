<<<<<<< HEAD
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
=======
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
>>>>>>> f1d7158b44392326220fefc0c7a7c00174b5ec58
