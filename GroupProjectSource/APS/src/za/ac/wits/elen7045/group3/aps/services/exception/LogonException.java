/**
 * 
 */
package za.ac.wits.elen7045.group3.aps.services.exception;

/**
 * @author SilasMahlangu
 *
 */
public class LogonException extends ApplicationException{
	/**
	 * 
	 */
	private static final long serialVersionUID = 5416835724751104231L;

	public LogonException() {
		super();
	}

	public LogonException(Throwable throwable) {
		super(throwable);
	}

	public LogonException(String string) {
		super(string);
	}

	public LogonException(String string, Throwable throwable) {
		super(string, throwable);
	} 
}
