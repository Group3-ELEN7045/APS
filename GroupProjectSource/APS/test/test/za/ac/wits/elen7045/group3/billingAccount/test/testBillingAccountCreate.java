package test.za.ac.wits.elen7045.group3.billingAccount.test;

import static org.junit.Assert.*;

import org.junit.Test;

import za.ac.wits.elen7045.group3.aps.domain.accounts.statement.TelcoStatement;
import za.ac.wits.elen7045.group3.aps.domain.entities.BillingAccount;
import za.ac.wits.elen7045.group3.aps.domain.entities.BillingAccountStatement;
import za.ac.wits.elen7045.group3.aps.domain.vo.CredentialsVO;
import za.ac.wits.elen7045.group3.aps.services.dto.BillingAccountDTO;
import za.ac.wits.elen7045.group3.aps.services.dto.CredentialsDTO;
/**
 * @author Livious
 *
 */
public class testBillingAccountCreate {

	  @Test
		public void testBillingAccoutDTOCreate() {
			String accountNumber = "12345";
			BillingAccountDTO billingAccount = new BillingAccountDTO(accountNumber);
			CredentialsDTO credentials = new CredentialsDTO();
			credentials.setUserName("kaka");
			credentials.setPassword("12345");
			billingAccount.setCredentials(credentials);
			assertFalse((billingAccount.getCredentials() == null));
					
		}
	  
	  @Test
		public void testBillingAccoutCreate() {
			BillingAccount billingAccount = new BillingAccount();
			CredentialsVO credentials = new CredentialsVO();
			credentials.setUserName("jojo");
			credentials.setPassword("12345");
			billingAccount.setCredentials(credentials);
			assertFalse((billingAccount.getCredentials() == null));					
		}
	}
