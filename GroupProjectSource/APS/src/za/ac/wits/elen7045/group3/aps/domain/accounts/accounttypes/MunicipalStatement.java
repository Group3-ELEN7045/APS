package za.ac.wits.elen7045.group3.aps.domain.accounts.accounttypes;

import za.ac.wits.elen7045.group3.aps.domain.accounts.abtracts.AbstractStatement;

public class MunicipalStatement extends AbstractStatement {

	private String InstalmentNotice = "";
	private String ElectricityUsed = "";
	private String ElectricityCharges = "";
	private String GasUsed = "";
	private String GasCharges = "";
	private String WaterUsed = "";
	private String WaterCharges = "";
	private String SewerageCharges = "";
	private String RefuseCharges = "";
	
	public MunicipalStatement(String accountNumber) {
		setAccountNumber(accountNumber);
	}
	protected String getInstalmentNotice() {
		return InstalmentNotice;
	}
	protected void setInstalmentNotice(String instalmentNotice) {
		InstalmentNotice = instalmentNotice;
	}
	protected String getElectricityUsed() {
		return ElectricityUsed;
	}
	protected void setElectricityUsed(String electricityUsed) {
		ElectricityUsed = electricityUsed;
	}
	protected String getElectricityCharges() {
		return ElectricityCharges;
	}
	protected void setElectricityCharges(String electricityCharges) {
		ElectricityCharges = electricityCharges;
	}
	protected String getGasUsed() {
		return GasUsed;
	}
	protected void setGasUsed(String gasUsed) {
		GasUsed = gasUsed;
	}
	protected String getGasCharges() {
		return GasCharges;
	}
	protected void setGasCharges(String gasCharges) {
		GasCharges = gasCharges;
	}
	protected String getWaterUsed() {
		return WaterUsed;
	}
	protected void setWaterUsed(String waterUsed) {
		WaterUsed = waterUsed;
	}
	protected String getWaterCharges() {
		return WaterCharges;
	}
	protected void setWaterCharges(String waterCharges) {
		WaterCharges = waterCharges;
	}
	protected String getSewerageCharges() {
		return SewerageCharges;
	}
	protected void setSewerageCharges(String sewerageCharges) {
		SewerageCharges = sewerageCharges;
	}
	protected String getRefuseCharges() {
		return RefuseCharges;
	}
	protected void setRefuseCharges(String refuseCharges) {
		RefuseCharges = refuseCharges;
	}
}
