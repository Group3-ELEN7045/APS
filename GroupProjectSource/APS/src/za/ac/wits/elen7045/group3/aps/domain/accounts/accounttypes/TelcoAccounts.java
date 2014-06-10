package za.ac.wits.elen7045.group3.aps.domain.accounts.accounttypes;

import za.ac.wits.elen7045.group3.aps.domain.accounts.abtracts.AbstractAccounts;
import za.ac.wits.elen7045.group3.aps.domain.vo.DataPair;

public class TelcoAccounts extends AbstractAccounts{

	private DataPair 	telephonenumber;
	private DataPair 	serviceCharges;
	private DataPair 	callCharges;
	private DataPair 	totalCustomerCalls;
	private DataPair	totalCallDuration;
	
	public TelcoAccounts(DataPair accountNumber) {
		setAccountNumber(new DataPair(accountNumber));
	}
	
	public DataPair getTelephonenumber() {
		return new DataPair(telephonenumber);
	}

	public void setTelephonenumber(DataPair telephonenumber) {
		this.telephonenumber = new DataPair(telephonenumber);
	}

	public DataPair getServiceCharges() {
		return new DataPair(serviceCharges);
	}

	public void setServiceCharges(DataPair serviceCharges) {
		this.serviceCharges = new DataPair(serviceCharges);
	}

	public DataPair getCallCharges() {
		return new DataPair(callCharges);
	}

	public void setCallCharges(DataPair callCharges) {
		this.callCharges = new DataPair(callCharges);
	}

	public DataPair getTotalCustomerCalls() {
		return new DataPair(totalCustomerCalls);
	}

	public void setTotalCustomerCalls(DataPair totalCustomerCalls) {
		this.totalCustomerCalls = new DataPair(totalCustomerCalls);
	}

	public DataPair getTotalCallDuration() {
		return new DataPair(totalCallDuration);
	}

	public void setTotalCallDuration(DataPair totalCallDuration) {
		this.totalCallDuration = new DataPair(totalCallDuration);
	}
	
}
