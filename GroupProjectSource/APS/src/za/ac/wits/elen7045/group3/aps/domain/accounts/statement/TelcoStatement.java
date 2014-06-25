package za.ac.wits.elen7045.group3.aps.domain.accounts.statement;
import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;
/**
 * @author boitumelo
 * @author Livious
 */
import za.ac.wits.elen7045.group3.aps.domain.entities.BillingAccountStatement;

@Entity
@Table(name="TELCO")
//@Inheritance(strategy=InheritanceType.SINGLE_TABLE)
public class TelcoStatement extends BillingAccountStatement implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	private String 	telephonenumber;
	private String 	serviceCharges;
	private String 	callCharges;
	private String 	totalCustomerCalls;
	private String	totalCallDuration;
		
	@Column(name = "TELEPHONE_NUMBER",nullable = true)	
	public String getTelephonenumber() {
		return telephonenumber;
	}
	public void setTelephonenumber(String telephonenumber) {
		this.telephonenumber = telephonenumber;
	}
	
	@Column(name = "SERVICE_CHARGES",nullable = true)
	public String getServiceCharges() {
		return serviceCharges;
	}
	public void setServiceCharges(String serviceCharges) {
		this.serviceCharges = serviceCharges;
	}
	
	@Column(name = "CALL_CHARGES",nullable = true)
	public String getCallCharges() {
		return callCharges;
	}
	public void setCallCharges(String callCharges) {
		this.callCharges = callCharges;
	}
	
	@Column(name = "TOTAL_CUSTOMER_CALLS",nullable = true)
	public String getTotalCustomerCalls() {
		return totalCustomerCalls;
	}
	public void setTotalCustomerCalls(String totalCustomerCalls) {
		this.totalCustomerCalls = totalCustomerCalls;
	}
	
	@Column(name = "TOTAL_CALL_DURATION",nullable = true)
	public String getTotalCallDuration() {
		return totalCallDuration;
	}
	public void setTotalCallDuration(String totalCallDuration) {
		this.totalCallDuration = totalCallDuration;
	}
}
