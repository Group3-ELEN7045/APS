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
	
	public MunicipalStatement(String accountNumber){
		this.setAccountNumber(accountNumber);
	}

	@Column(name = "INSTALMENT_NOTICE",nullable = true)
	public String getInstalmentNotice() {
		return InstalmentNotice;
	}
	public void setInstalmentNotice(String instalmentNotice) {
		InstalmentNotice = instalmentNotice;
	}
	
	@Column(name = "ELECTRICITY_USED",nullable = true)
	public String getElectricityUsed() {
		return ElectricityUsed;
	}
	public void setElectricityUsed(String electricityUsed) {
		ElectricityUsed = electricityUsed;
	}
	
	@Column(name = "ELECTRICITY_CHARGED",nullable = true)
	public String getElectricityCharges() {
		return ElectricityCharges;
	}
	public void setElectricityCharges(String electricityCharges) {
		ElectricityCharges = electricityCharges;
	}
	
	@Column(name = "GAS_USED",nullable = true)
	public String getGasUsed() {
		return GasUsed;
	}
	public void setGasUsed(String gasUsed) {
		GasUsed = gasUsed;
	}
	
	@Column(name = "GAS_CHARGED",nullable = true)
	public String getGasCharges() {
		return GasCharges;
	}
	public void setGasCharges(String gasCharges) {
		GasCharges = gasCharges;
	}
	
	@Column(name = "WATER_USED",nullable = true)
	public String getWaterUsed() {
		return WaterUsed;
	}
	public void setWaterUsed(String waterUsed) {
		WaterUsed = waterUsed;
	}
	
	@Column(name = "WATER_CHARGED",nullable = true)
	public String getWaterCharges() {
		return WaterCharges;
	}
	public void setWaterCharges(String waterCharges) {
		WaterCharges = waterCharges;
	}
	
	@Column(name = "SEWAGE_CHARGES",nullable = true)
	public String getSewerageCharges() {
		return SewerageCharges;
	}
	public void setSewerageCharges(String sewerageCharges) {
		SewerageCharges = sewerageCharges;
	}
	
	@Column(name = "REFUSE_CHARGES",nullable = true)
	public String getRefuseCharges() {
		return RefuseCharges;
	}
	public void setRefuseCharges(String refuseCharges) {
		RefuseCharges = refuseCharges;
	}
}
