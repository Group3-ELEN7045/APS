package za.ac.wits.elen7045.group3.aps.services.specification.user;

import za.ac.wits.elen7045.group3.aps.services.dto.CredentialsDTO;
import za.ac.wits.elen7045.group3.aps.services.specification.ApplicationSpecification;

public class UserAuthenticationSpecification extends ApplicationSpecification<CredentialsDTO>{
	
	private CredentialsDTO credentials;
		
	public UserAuthenticationSpecification(CredentialsDTO credentials){
		this.credentials = credentials;	
	}

	@Override
	public boolean isSatisfiedBy(CredentialsDTO credentialsParam) {
     return(credentials.getPassword().equals(credentialsParam.getPassword()) &&
          credentials.getUserName().equals(credentialsParam.getUserName()));
	}

}