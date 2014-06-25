
/**
 * 
 */
package za.ac.wits.elen7045.group3.aps.domain.vo;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 * @author SilasMahlangu
 *
 */
@Embeddable
public class PaymentDetailsVO implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String paymentType;
	private String paymentValue;
	
	public String getPaymentType() {
		return paymentType;
	}
	public void setPaymentType(String paymentType) {
		this.paymentType = paymentType;
	}
	
	public String getPaymentValue() {
		return paymentValue;
	}
	public void setPaymentValue(String paymentValue) {
		this.paymentValue = paymentValue;
	}
}
