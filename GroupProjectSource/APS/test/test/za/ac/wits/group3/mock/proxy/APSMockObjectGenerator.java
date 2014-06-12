
/**
 * 
 */
package test.za.ac.wits.group3.mock.proxy;

import java.lang.reflect.Proxy;

import za.ac.wits.elen7045.group3.aps.domain.accounts.interfaces.BillingAccountRepository;
import za.ac.wits.elen7045.group3.aps.domain.repository.user.CustomerRepository;

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
