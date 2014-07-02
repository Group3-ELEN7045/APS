package za.ac.wits.elen7045.group3.aps.services.validation;

import za.ac.wits.elen7045.group3.aps.services.dto.CredentialsDTO;
/**
 * @author Livious
 *
 */
public interface APSLogonManager {
	public Boolean validation(CredentialsDTO credentials);
}
