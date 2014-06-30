/**
 * 
 */
package za.ac.wits.elen7045.group3.aps.services.specification.credentials;

import za.ac.wits.elen7045.group3.aps.services.dto.CapturedCredentialsDTO;
import za.ac.wits.elen7045.group3.aps.services.specification.ApplicationSpecification;

/**
 * @author SilasMahlangu
 *
 */
public class CapturedCredentialsSpecification extends ApplicationSpecification<CapturedCredentialsDTO>{
	
	private CapturedCredentialsDTO logonCredentials;
		
	public CapturedCredentialsSpecification(CapturedCredentialsDTO logonCredentials){
		this.logonCredentials = logonCredentials;	
	}

	@Override
	public boolean isSatisfiedBy(CapturedCredentialsDTO validationCredentials) {
		return logonCredentials.getConfirmPasword().equals(validationCredentials.getPassword());
	}

}
