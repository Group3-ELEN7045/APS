package za.ac.wits.elen7045.group3.aps.domain.accounts.statement;

/**
 * @author boitumelo
 */

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

import za.ac.wits.elen7045.group3.aps.domain.entities.BillingAccountStatement;

@Entity
@Table(name="MUNICIPAL_STATEMENT")
@Inheritance(strategy=InheritanceType.SINGLE_TABLE)
public class MunicipalStatement extends BillingAccountStatement implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	private String InstalmentNotice = "";
	private String ElectricityUsed = "";
	private String ElectricityCharges = "";
	private String GasUsed = "";
	private String GasCharges = "";
	private String WaterUsed = "";
	private String WaterCharges = "";
	private String SewerageCharges = "";
	private String RefuseCharges = "";
	
//	public MunicipalStatement(String accountNumber) {
//		setAccountNumber(accountNumber);
//	}
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
