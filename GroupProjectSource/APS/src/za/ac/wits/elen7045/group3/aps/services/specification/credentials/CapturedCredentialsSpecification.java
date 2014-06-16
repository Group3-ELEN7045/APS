/**
 * 
 */
package za.ac.wits.elen7045.group3.aps.services.specification.credentials;

import za.ac.wits.elen7045.group3.aps.domain.vo.LogonCredentialsVO;
import za.ac.wits.elen7045.group3.aps.services.specification.ApplicationSpecification;

/**
 * @author SilasMahlangu
 *
 */
public class CapturedCredentialsSpecification extends ApplicationSpecification<LogonCredentialsVO>{
	
	private LogonCredentialsVO logonCredentials;
		
	public CapturedCredentialsSpecification(LogonCredentialsVO logonCredentials){
		this.logonCredentials = logonCredentials;	
	}

	public boolean isSatisfiedBy(LogonCredentialsVO capturedlogonCredentials) {
		return capturedlogonCredentials.getConfirmPasword().equals(capturedlogonCredentials.getPassword());
	}

}