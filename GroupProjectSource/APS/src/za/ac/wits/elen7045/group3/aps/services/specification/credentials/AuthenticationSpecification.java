/**
 * 
 */
package za.ac.wits.elen7045.group3.aps.services.specification.credentials;

import java.io.IOException;

import za.ac.wits.elen7045.group3.aps.domain.vo.CredentialsVO;
import za.ac.wits.elen7045.group3.aps.services.dto.CredentialsDTO;
import za.ac.wits.elen7045.group3.aps.services.specification.ApplicationSpecification;

/**
 * @author SilasMahlangu
 *
 */
public class AuthenticationSpecification extends ApplicationSpecification<CredentialsDTO>{
	
	public CredentialsDTO credentialsVO;

	public AuthenticationSpecification(CredentialsDTO credentialsVO){
			this.credentialsVO = credentialsVO;
	}
	
	@Override
	public boolean isSatisfiedBy(CredentialsDTO credentialsVOParam) {
		       return ((credentialsVO.getUserName().equals(credentialsVOParam.getUserName()))&&
                 (credentialsVO.getPassword().equals(credentialsVOParam.getPassword())));
	}

}
