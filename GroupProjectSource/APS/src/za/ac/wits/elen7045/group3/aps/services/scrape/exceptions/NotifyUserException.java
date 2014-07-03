package za.ac.wits.elen7045.group3.aps.services.scrape.exceptions;

import za.ac.wits.elen7045.group3.aps.services.exception.ApplicationException;

/**
 * 
 * @author boitumelo
 *
 */
public class NotifyUserException extends ApplicationException {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public NotifyUserException(String message) {
		super(message);
	}
}
