/**
 * 
 */
package za.ac.wits.elen7045.group3.aps.services.specification.credentials;

import org.apache.commons.codec.binary.Base64;

import za.ac.wits.elen7045.group3.aps.domain.vo.CredentialsVO;
import za.ac.wits.elen7045.group3.aps.services.specification.ApplicationSpecification;

/**
 * @author SilasMahlangu
 *
 */
public class EncryptedCredentialsSpecification extends ApplicationSpecification<CredentialsVO>{
	private CredentialsVO credentialsVO;
	
	public EncryptedCredentialsSpecification(CredentialsVO credentialsVO){
		this.credentialsVO = credentialsVO;	
	}

	@SuppressWarnings("deprecation")
	public boolean isSatisfiedBy(CredentialsVO capturedlogonCredentials) {
		
		return ((Base64.isArrayByteBase64(capturedlogonCredentials.getPassword().getBytes()))
				 &&
				(Base64.isArrayByteBase64(capturedlogonCredentials.getUserName().getBytes()))
			   );
	}
}
