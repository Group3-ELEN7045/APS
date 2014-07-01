package za.ac.wits.elen7045.group3.aps.services.validation;

import za.ac.wits.elen7045.group3.aps.domain.entities.User;
import za.ac.wits.elen7045.group3.aps.domain.vo.CredentialsVO;
import za.ac.wits.elen7045.group3.aps.services.exception.LogonException;
import za.ac.wits.elen7045.group3.aps.services.specification.ApplicationSpecification;
import za.ac.wits.elen7045.group3.aps.services.specification.user.UserAuthenticationSpecification;
import za.ac.wits.elen7045.group3.aps.services.util.ApplicationContants;

 public class Authentication  {

	 protected Boolean authenticate(User user, CredentialsVO credentials) throws LogonException, Exception {
		
		CredentialsVO encryptedCredentials = user.getCredentials();	
		
		ApplicationSpecification<CredentialsVO> userAuthenticationSpec = new UserAuthenticationSpecification(credentials);
		if(userAuthenticationSpec.isSatisfiedBy(encryptedCredentials)){
			return true;
		}
		throw new LogonException(ApplicationContants.USER_CREDENTIALS_INCORRECT);
	}
}
