package za.ac.wits.elen7045.group3.aps.services.specification.user;

import za.ac.wits.elen7045.group3.aps.domain.vo.CredentialsVO;
import za.ac.wits.elen7045.group3.aps.services.specification.ApplicationSpecification;

public class UserAuthenticationSpecification extends ApplicationSpecification<CredentialsVO>{
	
	private CredentialsVO credentials;
		
	public UserAuthenticationSpecification(CredentialsVO credentials){
		this.credentials = credentials;	
	}

	public boolean isSatisfiedBy(CredentialsVO credentialsParam) {
     return(credentials.getPassword().equals(credentialsParam.getPassword()) &&
          credentials.getUserName().equals(credentialsParam.getUserName()));
	}

}