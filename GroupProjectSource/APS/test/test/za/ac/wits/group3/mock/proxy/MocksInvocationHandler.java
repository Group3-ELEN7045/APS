<<<<<<< HEAD
/**
 * 
 */
package test.za.ac.wits.group3.mock.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * @author SilasMahlangu
 *
 */
public class MocksInvocationHandler implements InvocationHandler{
	
	private Object response;
	
	public MocksInvocationHandler(Object response){
		this.response = response;
	}
	
	public Object getResponse() {
		return response;
	}

	public void setResponse(Object response) {
		this.response = response;
	}

	@Override
	public Object invoke(Object proxy, Method method, Object[] parameters) throws Throwable {
		Object requestResponse = method.invoke(response, parameters);
		return requestResponse;
	}
   
}
=======
/**
 * 
 */
package test.za.ac.wits.group3.mock.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * @author SilasMahlangu
 *
 */
public class MocksInvocationHandler implements InvocationHandler{
	
	private Object response;
	
	public MocksInvocationHandler(Object response){
		this.response = response;
	}
	
	public Object getResponse() {
		return response;
	}

	public void setResponse(Object response) {
		this.response = response;
	}

	@Override
	public Object invoke(Object proxy, Method method, Object[] parameters) throws Throwable {
		Object requestResponse = method.invoke(response, parameters);
		return requestResponse;
	}
   
}
>>>>>>> f1d7158b44392326220fefc0c7a7c00174b5ec58
