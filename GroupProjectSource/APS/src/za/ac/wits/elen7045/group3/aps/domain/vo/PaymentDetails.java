/**
 * 
 */
package za.ac.wits.elen7045.group3.aps.domain.vo;

import java.io.Serializable;

/**
 * @author SilasMahlangu
 *
 */
public class PaymentDetails implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String paymentType;
	private String value;
	public String getPaymentType() {
		return paymentType;
	}
	public void setPaymentType(String paymentType) {
		this.paymentType = paymentType;
	}
	public String getValue() {
		return value;
	}
	public void setValue(String value) {
		this.value = value;
	}
}
