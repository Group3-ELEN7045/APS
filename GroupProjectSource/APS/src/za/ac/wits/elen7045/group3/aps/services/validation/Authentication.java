package za.ac.wits.elen7045.group3.aps.services.validation;

import org.dozer.DozerBeanMapper;

import za.ac.wits.elen7045.group3.aps.domain.entities.User;
import za.ac.wits.elen7045.group3.aps.domain.vo.CredentialsVO;
import za.ac.wits.elen7045.group3.aps.services.dto.CredentialsDTO;
import za.ac.wits.elen7045.group3.aps.services.exception.LogonException;
import za.ac.wits.elen7045.group3.aps.services.specification.ApplicationSpecification;
import za.ac.wits.elen7045.group3.aps.services.specification.user.UserAuthenticationSpecification;
import za.ac.wits.elen7045.group3.aps.services.util.ApplicationContants;
/**
 * @author Livious
 *
 */
public class Authentication {

	protected Boolean authenticate(User user, CredentialsDTO credentials) throws LogonException, Exception {
		CredentialsDTO credentialsDTO = new CredentialsDTO();
		
		DozerBeanMapper dozer = new DozerBeanMapper();		
		CredentialsVO encryptedCredentials = user.getCredentials();
		dozer.map(encryptedCredentials, credentialsDTO);

		ApplicationSpecification<CredentialsDTO> userAuthenticationSpec = new UserAuthenticationSpecification(
				credentials);
		if (userAuthenticationSpec.isSatisfiedBy(credentialsDTO)) {
			return true;
		}
		throw new LogonException(ApplicationContants.USER_CREDENTIALS_INCORRECT);
	}
}
