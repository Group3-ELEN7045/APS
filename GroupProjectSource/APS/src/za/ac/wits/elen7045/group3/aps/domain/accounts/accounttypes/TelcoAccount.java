package za.ac.wits.elen7045.group3.aps.domain.accounts.accounttypes;

import za.ac.wits.elen7045.group3.aps.domain.accounts.abtracts.AbstractAccount;

public class TelcoAccount extends AbstractAccount{

	private String 	telephonenumber;
	private String 	serviceCharges;
	private String 	callCharges;
	private String 	totalCustomerCalls;
	private String	totalCallDuration;
	
	public TelcoAccount(String accountNumber) {
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
	protected String getTotalCustomerCalls() {
		return totalCustomerCalls;
	}
	protected void setTotalCustomerCalls(String totalCustomerCalls) {
		this.totalCustomerCalls = totalCustomerCalls;
	}
	protected String getTotalCallDuration() {
		return totalCallDuration;
	}
	protected void setTotalCallDuration(String totalCallDuration) {
		this.totalCallDuration = totalCallDuration;
	}
}
