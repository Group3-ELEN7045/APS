<<<<<<< HEAD
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
=======
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
>>>>>>> f1d7158b44392326220fefc0c7a7c00174b5ec58
