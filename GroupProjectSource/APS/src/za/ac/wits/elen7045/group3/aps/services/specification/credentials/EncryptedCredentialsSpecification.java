/**
 * 
 */
package za.ac.wits.elen7045.group3.aps.services.specification.credentials;

import za.ac.wits.elen7045.group3.aps.services.dto.CredentialsDTO;
import za.ac.wits.elen7045.group3.aps.services.specification.ApplicationSpecification;

/**
 * @author SilasMahlangu
 *
 */
public class EncryptedCredentialsSpecification extends ApplicationSpecification<CredentialsDTO>{
	private CredentialsDTO credentialsDTO;
	
	public EncryptedCredentialsSpecification(CredentialsDTO credentialsDTO){
		this.credentialsDTO = credentialsDTO;	
	}

	public boolean isSatisfiedBy(CredentialsDTO capturedlogonCredentials) {
	  	return ((credentialsDTO.getPassword().equals(capturedlogonCredentials.getPassword()))
				 &&
				(credentialsDTO.getUserName().equals(capturedlogonCredentials.getUserName()))
			   );
	}
}