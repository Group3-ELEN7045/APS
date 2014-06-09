<<<<<<< HEAD
/**
 * 
 */
package test.za.ac.wits.group3.mock.proxy;

import java.lang.reflect.Proxy;

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
=======
/**
 * 
 */
package test.za.ac.wits.group3.mock.proxy;

import java.lang.reflect.Proxy;

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
>>>>>>> f1d7158b44392326220fefc0c7a7c00174b5ec58
