package za.ac.wits.elen7045.group3.aps.domain.accounts.statement;
import javax.persistence.Embeddable;

/**
 * @author boitumelo
 */
import za.ac.wits.elen7045.group3.aps.domain.accounts.abtracts.ScrapedData;
@Embeddable
public class TelcoStatement extends ScrapedData{


	private String 	telephonenumber;
	private String 	serviceCharges;
	private String 	callCharges;
	private String 	totalCustomerCalls;
	private String	totalCallDuration;
	
	public TelcoStatement(String accountNumber) {
		setAccountNumber(accountNumber);
	}
	public String getTelephonenumber() {
		return telephonenumber;
	}
	public void setTelephonenumber(String telephonenumber) {
		this.telephonenumber = telephonenumber;
	}
	public String getServiceCharges() {
		return serviceCharges;
	}
	public void setServiceCharges(String serviceCharges) {
		this.serviceCharges = serviceCharges;
	}
	public String getCallCharges() {
		return callCharges;
	}
	public void setCallCharges(String callCharges) {
		this.callCharges = callCharges;
	}
	public String getTotalCustomerCalls() {
		return totalCustomerCalls;
	}
	public void setTotalCustomerCalls(String totalCustomerCalls) {
		this.totalCustomerCalls = totalCustomerCalls;
	}
	public String getTotalCallDuration() {
		return totalCallDuration;
	}
	public void setTotalCallDuration(String totalCallDuration) {
		this.totalCallDuration = totalCallDuration;
	}
}
