package za.ac.wits.elen7045.group3.aps.domain.entities;


import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import za.ac.wits.elen7045.group3.aps.domain.scheduler.BillingCycle;
import za.ac.wits.elen7045.group3.aps.domain.scheduler.CronExpressionWrapper;


/**
 * @author Livious Ndebele
 * @author Sibusiso Zwane
 * @author Ronald Menya
 *
 */
public class BillingCompany implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String companyName;
	private String url;
	private BillingCycle billingcylce;
	private List<CronExpressionWrapper> maintenanceWindows = new ArrayList<CronExpressionWrapper>();
	private List<CronExpressionWrapper> peakPeriods = new ArrayList<CronExpressionWrapper>();
	
	public BillingCompany(String companyName){
		if (companyName == null || companyName.equals("")) {
			throw new RuntimeException("Company name can not be null or empty String");
		}
		this.companyName = companyName;
	}

	public String getCompanyName() {
		return companyName;
	}
	
	public void setCompanyName(String companyName) {
		if (companyName == null || companyName.equals("")) {
			throw new RuntimeException("Company name can not be null or empty String");
		}
		this.companyName = companyName;
	}
	
	public String getUrl() {
		return url;
	}
	
	public BillingCycle getBillingcylce() {
		return billingcylce;
	}

	public void setBillingcylce(BillingCycle billingcylce) {
		this.billingcylce = billingcylce;
	}

	public List<CronExpressionWrapper> getMaintenancewindows() {
		return Collections.unmodifiableList(maintenanceWindows);
	}

	public void setMaintenancewindow(CronExpressionWrapper time) {
		this.maintenanceWindows.add(time);
	}

	public List<CronExpressionWrapper> getPeakperiod() {
		return Collections.unmodifiableList(peakPeriods);
	}

	public void setPeakperiod(CronExpressionWrapper time) {
		this.peakPeriods.add(time);
	}

	public void setURL(String url) {
		if (url == null || url.equals("")) {
			throw new RuntimeException("URL can not be null or empty string");
		}
		
		//Pattern pattern = Pattern.compile("\\b(https?|ftp|file)://[-a-zA-Z0-9+&@#/%?=~_|!:,.;]*[-a-zA-Z0-9+&@#/%=~_|]");
		//Matcher matcher = pattern.matcher(url);
		
		///if (!matcher.matches()) {
		//	throw new RuntimeException("Wrong URL pattern");
		//}
	    this.url = url;	
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((companyName == null) ? 0 : companyName.hashCode());
		result = prime * result + ((url == null) ? 0 : url.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		BillingCompany other = (BillingCompany) obj;
		if (companyName == null) {
			if (other.companyName != null)
				return false;
		} else if (!companyName.equals(other.companyName))
			return false;
		if (url == null) {
			if (other.url != null)
				return false;
		} else if (!url.equals(other.url))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "BillingCompany [companyName=" + companyName + ", url=" + url
				+ "]";
	} 	 
}