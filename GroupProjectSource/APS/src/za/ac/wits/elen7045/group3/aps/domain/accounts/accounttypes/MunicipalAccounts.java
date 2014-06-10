package za.ac.wits.elen7045.group3.aps.domain.accounts.accounttypes;
import za.ac.wits.elen7045.group3.aps.domain.accounts.abtracts.AbstractAccounts;
import za.ac.wits.elen7045.group3.aps.domain.vo.DataPair;

public class MunicipalAccounts extends AbstractAccounts {

	private DataPair InstalmentNotice;
	private DataPair ElectricityUsed;
	private DataPair ElectricityCharges;
	private DataPair GasUsed;
	private DataPair GasCharges;
	private DataPair WaterUsed;
	private DataPair WaterCharges;
	private DataPair SewerageCharges;
	private DataPair RefuseCharges;
	
	public MunicipalAccounts(DataPair accountNumber) {
		setAccountNumber(new DataPair(accountNumber));
	}
	
	public DataPair getInstalmentNotice() {
		return new DataPair(InstalmentNotice);
	}

	public void setInstalmentNotice(DataPair instalmentNotice) {
		InstalmentNotice = new DataPair(instalmentNotice);
	}

	public DataPair getElectricityUsed() {
		return new DataPair(ElectricityUsed);
	}

	public void setElectricityUsed(DataPair electricityUsed) {
		ElectricityUsed = new DataPair(electricityUsed);
	}

	public DataPair getElectricityCharges() {
		return new DataPair(ElectricityCharges);
	}

	public void setElectricityCharges(DataPair electricityCharges) {
		ElectricityCharges = new DataPair(electricityCharges);
	}

	public DataPair getGasUsed() {
		return new DataPair(GasUsed);
	}

	public void setGasUsed(DataPair gasUsed) {
		GasUsed = new DataPair(gasUsed);
	}

	public DataPair getGasCharges() {
		return new DataPair(GasCharges);
	}

	public void setGasCharges(DataPair gasCharges) {
		GasCharges = new DataPair(gasCharges);
	}

	public DataPair getWaterUsed() {
		return new DataPair(WaterUsed);
	}

	public void setWaterUsed(DataPair waterUsed) {
		WaterUsed = new DataPair(waterUsed);
	}

	public DataPair getWaterCharges() {
		return new DataPair(WaterCharges);
	}

	public void setWaterCharges(DataPair waterCharges) {
		WaterCharges = new DataPair(waterCharges);
	}

	public DataPair getSewerageCharges() {
		return new DataPair(SewerageCharges);
	}

	public void setSewerageCharges(DataPair sewerageCharges) {
		SewerageCharges = new DataPair(sewerageCharges);
	}

	public DataPair getRefuseCharges() {
		return new DataPair(RefuseCharges);
	}

	public void setRefuseCharges(DataPair refuseCharges) {
		RefuseCharges = new DataPair(refuseCharges);
	}

	
}
