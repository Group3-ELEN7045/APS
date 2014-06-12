package za.ac.wits.elen7045.group3.aps.domain.accounts.accounttypes;

import za.ac.wits.elen7045.group3.aps.domain.accounts.abtracts.AbstractStatement;

public class TelcoStatement extends AbstractStatement{

	private String 	telephonenumber;
	private String 	serviceCharges;
	private String 	callCharges;
	private int 	totalCustomerCalls;
	private float	totalCallDuration;
	
	public TelcoStatement(String accountNumber) {
		setAccountNumber(accountNumber);
	}
	protected String getTelephonenumber() {
		return telephonenumber;
	}
	protected void setTelephonenumber(String telephonenumber) {
		this.telephonenumber = telephonenumber;
	}
	protected String getServiceCharges() {
		return serviceCharges;
	}
	protected void setServiceCharges(String serviceCharges) {
		this.serviceCharges = serviceCharges;
	}
	protected String getCallCharges() {
		return callCharges;
	}
	protected void setCallCharges(String callCharges) {
		this.callCharges = callCharges;
	}
	protected int getTotalCustomerCalls() {
		return totalCustomerCalls;
	}
	protected void setTotalCustomerCalls(int totalCustomerCalls) {
		this.totalCustomerCalls = totalCustomerCalls;
	}
	protected float getTotalCallDuration() {
		return totalCallDuration;
	}
	protected void setTotalCallDuration(float totalCallDuration) {
		this.totalCallDuration = totalCallDuration;
	}
}