package za.ac.wits.elen7045.group3.aps.domain.accounts.accounttypes;

<<<<<<< HEAD:GroupProjectSource/APS/src/za/ac/wits/elen7045/group3/aps/domain/accounts/accounttypes/MunicipalStatement.java
import za.ac.wits.elen7045.group3.aps.domain.accounts.abtracts.AbstractStatement;

public class MunicipalStatement extends AbstractStatement {
=======
import za.ac.wits.elen7045.group3.aps.domain.accounts.abtracts.AbstractBillingAccountStatement;

public class MunicipalAccount extends AbstractBillingAccountStatement {
>>>>>>> 334e171862bacecf51ba61bafe29223ce078425e:GroupProjectSource/APS/src/za/ac/wits/elen7045/group3/aps/domain/accounts/accounttypes/MunicipalAccount.java

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
	public String getInstalmentNotice() {
		return InstalmentNotice;
	}
	public void setInstalmentNotice(String instalmentNotice) {
		InstalmentNotice = instalmentNotice;
	}
	public String getElectricityUsed() {
		return ElectricityUsed;
	}
	public void setElectricityUsed(String electricityUsed) {
		ElectricityUsed = electricityUsed;
	}
	public String getElectricityCharges() {
		return ElectricityCharges;
	}
	public void setElectricityCharges(String electricityCharges) {
		ElectricityCharges = electricityCharges;
	}
	public String getGasUsed() {
		return GasUsed;
	}
	public void setGasUsed(String gasUsed) {
		GasUsed = gasUsed;
	}
	public String getGasCharges() {
		return GasCharges;
	}
	public void setGasCharges(String gasCharges) {
		GasCharges = gasCharges;
	}
	public String getWaterUsed() {
		return WaterUsed;
	}
	public void setWaterUsed(String waterUsed) {
		WaterUsed = waterUsed;
	}
	public String getWaterCharges() {
		return WaterCharges;
	}
	public void setWaterCharges(String waterCharges) {
		WaterCharges = waterCharges;
	}
	public String getSewerageCharges() {
		return SewerageCharges;
	}
	public void setSewerageCharges(String sewerageCharges) {
		SewerageCharges = sewerageCharges;
	}
	public String getRefuseCharges() {
		return RefuseCharges;
	}
	public void setRefuseCharges(String refuseCharges) {
		RefuseCharges = refuseCharges;
	}
}
