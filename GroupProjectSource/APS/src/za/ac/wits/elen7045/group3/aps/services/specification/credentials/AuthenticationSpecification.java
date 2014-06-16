/**
 * 
 */
package za.ac.wits.elen7045.group3.aps.services.specification.credentials;

import java.io.IOException;

import za.ac.wits.elen7045.group3.aps.domain.vo.CredentialsVO;
import za.ac.wits.elen7045.group3.aps.services.specification.ApplicationSpecification;

/**
 * @author SilasMahlangu
 *
 */
public class AuthenticationSpecification extends ApplicationSpecification<CredentialsVO>{
	
	public CredentialsVO credentialsVO;

	public AuthenticationSpecification(CredentialsVO credentialsVO){
			this.credentialsVO = credentialsVO;
	}
	
	@Override
	public boolean isSatisfiedBy(CredentialsVO credentialsVOParam) {
		CredentialsVO authCredentials = new CredentialsVO();
		try {
			authCredentials = this.credentialsVO.decryptCredentals();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
         return ((authCredentials.getUserName().equals(credentialsVOParam.getUserName()))&&
                 (authCredentials.getPassword().equals(credentialsVOParam.getPassword())));
	}

}
