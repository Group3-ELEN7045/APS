
/**
 * 
 */
package za.ac.wits.elen7045.group3.aps.services.specification.notification;

import za.ac.wits.elen7045.group3.aps.services.specification.ApplicationSpecification;

/**
 * @author SilasMahlangu
 *
 */
public class ConfirmSendNotification extends ApplicationSpecification<ConfirmSendNotification>{
	private boolean confirmSendNotification;
	
	public ConfirmSendNotification (boolean confirmSendNotification){
		this.confirmSendNotification = confirmSendNotification;
	}

	@Override
	public boolean isFulfiledBy(Object object) {
		return confirmSendNotification;
	}
	
	
}
