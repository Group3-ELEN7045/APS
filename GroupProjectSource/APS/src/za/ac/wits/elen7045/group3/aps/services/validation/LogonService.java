package za.ac.wits.elen7045.group3.aps.services.validation;


import za.ac.wits.elen7045.group3.aps.domain.entities.User;
import za.ac.wits.elen7045.group3.aps.domain.repository.user.CustomerRepository;
import za.ac.wits.elen7045.group3.aps.domain.vo.CredentialsVO;
import za.ac.wits.elen7045.group3.aps.services.exception.LogonException;
import za.ac.wits.elen7045.group3.aps.services.specification.ApplicationSpecification;
import za.ac.wits.elen7045.group3.aps.services.specification.user.UserAuthenticationSpecification;
import za.ac.wits.elen7045.group3.aps.services.util.ApplicationContants;

public interface LogonService {
	public Boolean validation(CredentialsVO credentials) throws Exception;
}
