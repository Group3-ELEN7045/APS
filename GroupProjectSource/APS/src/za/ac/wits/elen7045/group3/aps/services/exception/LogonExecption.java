/**
 * 
 */
package za.ac.wits.elen7045.group3.aps.services.exception;

/**
 * @author SilasMahlangu
 *
 */
public class LogonExecption extends ApplicationException{
	/**
	 * 
	 */
	private static final long serialVersionUID = 5416835724751104231L;

	public LogonExecption() {
		super();
	}

	public LogonExecption(Throwable throwable) {
		super(throwable);
	}

	public LogonExecption(String string) {
		super(string);
	}

	public LogonExecption(String string, Throwable throwable) {
		super(string, throwable);
	} 
}
