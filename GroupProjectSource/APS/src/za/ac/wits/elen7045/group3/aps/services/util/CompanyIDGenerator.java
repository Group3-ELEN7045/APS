package za.ac.wits.elen7045.group3.aps.services.util;
import java.util.Random;
public class CompanyIDGenerator {
	static long range = 1234567L;
	public static long generateCompanyID(){
		return ((long)(new Random().nextDouble()*range));
	}

}
