
/**
 * 
 */
package test.za.ac.wits.group3.mock.proxy;

import java.lang.reflect.Proxy;

<<<<<<< HEAD
=======
import za.ac.wits.elen7045.group3.aps.domain.accounts.interfaces.BillingAccountRepository;
import za.ac.wits.elen7045.group3.aps.domain.repository.user.CustomerRepository;

>>>>>>> 334e171862bacecf51ba61bafe29223ce078425e
/**
 * @author SilasMahlangu
 *
 */
public class APSMockObjectGenerator<T> {
    @SuppressWarnings("unchecked")
	public T mock(T proxyName){
        Object T = Proxy.newProxyInstance( this.getClass().
        			                       getClassLoader(), proxyName.getClass().
        			                       getInterfaces(), new MocksInvocationHandler(proxyName)
        	                             );
		  return ((T) T);
     }
}
