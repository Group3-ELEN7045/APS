package za.ac.wits.elen7045.group3.aps.services.validation;

import za.ac.wits.elen7045.group3.aps.domain.vo.CredentialsVO;

public interface APSLogonService {
	public Boolean validation(CredentialsVO credentials) throws Exception;
}
