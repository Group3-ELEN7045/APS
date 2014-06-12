/**
 * 
 */
package za.ac.wits.elen7045.group3.aps.services.validation;

import za.ac.wits.elen7045.group3.aps.domain.vo.CredentialsVO;
import za.ac.wits.elen7045.group3.aps.domain.vo.LogonCredentials;
import za.ac.wits.elen7045.group3.aps.services.exception.LogonCredentialsValidationException;
import za.ac.wits.elen7045.group3.aps.services.util.ApplicationContants;

/**
 * @author SilasMahlangu
 *
 */
public abstract class LogonCredentialsValidation {
    public CredentialsVO validateCapturedCredentials(LogonCredentials logonCredentials)throws LogonCredentialsValidationException{
    	CredentialsVO credentials = null; 
   	   if(logonCredentials.getPassword().equals(logonCredentials.getConfirmPasword())){
           credentials = new CredentialsVO();
           credentials.setPassword(logonCredentials.getPassword());
           credentials.setUserName(logonCredentials.getUserName()); 
    	   return credentials;
       }
       throw new LogonCredentialsValidationException(ApplicationContants.USER_PASS_NO_MATCH);
    }
}
