package za.ac.wits.elen7045.group3.aps.domain;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
/**
 * 
 * @author boitumelo
 * @author ronald
 * @author silas
 * @author livious
 * @author bakwanyana
 * @author sibusiso
 */
public class APSFactory {
	public static ApplicationContext getAPSContext(){
		return new ClassPathXmlApplicationContext("res/spring/application-context-test.xml"); 
	}
}
