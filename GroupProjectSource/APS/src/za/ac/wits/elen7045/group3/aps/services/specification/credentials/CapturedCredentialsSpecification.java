/**
 * 
 */
package za.ac.wits.elen7045.group3.aps.services.specification.credentials;

import za.ac.wits.elen7045.group3.aps.domain.vo.CapturedCredentialsVO;
import za.ac.wits.elen7045.group3.aps.services.specification.ApplicationSpecification;

/**
 * @author SilasMahlangu
 *
 */
public class CapturedCredentialsSpecification extends ApplicationSpecification<CapturedCredentialsVO>{
	
	private CapturedCredentialsVO logonCredentials;
		
	public CapturedCredentialsSpecification(CapturedCredentialsVO logonCredentials){
		this.logonCredentials = logonCredentials;	
	}

	public boolean isSatisfiedBy(CapturedCredentialsVO capturedlogonCredentials) {
		return capturedlogonCredentials.getConfirmPasword().equals(capturedlogonCredentials.getPassword());
	}

}
