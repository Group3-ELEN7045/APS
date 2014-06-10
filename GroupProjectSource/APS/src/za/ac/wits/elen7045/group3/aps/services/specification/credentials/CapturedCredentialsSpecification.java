/**
 * 
 */
package za.ac.wits.elen7045.group3.aps.services.specification.credentials;

import za.ac.wits.elen7045.group3.aps.domain.vo.LogonCredentials;
import za.ac.wits.elen7045.group3.aps.services.specification.ApplicationSpecification;

/**
 * @author SilasMahlangu
 *
 */
public class CapturedCredentialsSpecification extends ApplicationSpecification<LogonCredentials>{
	
	private LogonCredentials logonCredentials;
		
	public CapturedCredentialsSpecification(LogonCredentials logonCredentials){
		this.logonCredentials = logonCredentials;	
	}
   //public boolean isFulfiledBy(LogonCredentials logonCredentialsParam) {
	//	return logonCredentials.getConfirmPasword().equals(logonCredentialsParam.getPassword());
	//}
@Override
public boolean isSatisfiedBy(LogonCredentials logonCredentialsParam) {
	return logonCredentials.getConfirmPasword().equals(logonCredentialsParam.getPassword());
}

}
