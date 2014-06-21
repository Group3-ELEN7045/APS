/**
 * 
 */
package za.ac.wits.elen7045.group3.aps.services.specification.credentials;

import org.apache.commons.codec.binary.Base64;

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

	@SuppressWarnings("deprecation")
	public boolean isSatisfiedBy(CredentialsDTO capturedlogonCredentials) {
		
		return ((Base64.isArrayByteBase64(capturedlogonCredentials.getPassword().getBytes()))
				 &&
				(Base64.isArrayByteBase64(capturedlogonCredentials.getUserName().getBytes()))
			   );
	}
}