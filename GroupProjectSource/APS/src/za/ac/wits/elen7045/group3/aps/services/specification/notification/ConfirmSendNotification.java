/**
 * 
 */
package za.ac.wits.elen7045.group3.aps.services.specification.notification;

import za.ac.wits.elen7045.group3.aps.services.specification.ApplicationSpecification;

/**
 * @author SilasMahlangu
 *
 */
public class ConfirmSendNotification extends ApplicationSpecification<Boolean>{
	private boolean confirmSendNotification = true;
	
	public ConfirmSendNotification (boolean confirmSendNotification){
		this.confirmSendNotification = confirmSendNotification;
	}

	@Override
	public boolean isSatisfiedBy(Boolean bool) {
		return confirmSendNotification == bool.booleanValue();
	}
	
	
}
