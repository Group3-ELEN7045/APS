
package za.ac.wits.elen7045.group3.aps.domain.vo;

import za.ac.wits.elen7045.group3.aps.services.specification.ApplicationSpecification;
import za.ac.wits.elen7045.group3.aps.services.specification.credentials.CapturedCredentialsSpecification;

/**
 * @author SilasMahlangu
 *
 */
public class CapturedCredentialsVO extends CredentialsVO{
    private String confirmPasword;

	public String getConfirmPasword() {
		return confirmPasword;
	}

	public void setConfirmPasword(String confirmPasword) {
		this.confirmPasword = confirmPasword;
	}
    
	public boolean validateCapturedPasswords(){
		ApplicationSpecification<CapturedCredentialsVO> capturedCredentials = new CapturedCredentialsSpecification(this);
		return capturedCredentials.isSatisfiedBy(this);
	}
}