package za.ac.wits.elen7045.group3.aps.domain.scheduler;

import java.util.Date;


public class Period {
    
	/**
	 * 
	 */
	protected Date startDate;
	
	/**
	 * 
	 */
	private Date endDate;
	
	/**
	 * 
	 * @param startDate
	 */
	public void setStartDate(Date startDate) {
		if (startDate == null) {
			throw new RuntimeException("Maintenance Window start date can not be null");
		}
		
	    this.startDate = startDate;	
	}

	/**
	 * 
	 * @return
	 */
	public Date getStartDate() {
		return this.startDate;
	}

	/**
	 * 
	 * @param endDate
	 */
	public void setEndDate(Date endDate) {
		if (endDate == null) {
			throw new RuntimeException("Maintenance Window end date can not be null");
		}
		
		if (endDate.before(startDate) || endDate.equals(startDate)) {
			throw new RuntimeException("Maintenance Window end date has to be after start date");
		}
		
		this.endDate = endDate;
	}

	/**
	 * 
	 * @return
	 */
	public Date getEndDate() {
		return this.endDate;
	}

	/**
	 * 
	 * @return
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((endDate == null) ? 0 : endDate.hashCode());
		result = prime * result
				+ ((startDate == null) ? 0 : startDate.hashCode());
		return result;
	}
    
	/**
	 * 
	 * @return
	 * @param object
	 */
	@Override
	public boolean equals(Object object) {
		if (this == object)
			return true;
		if (object == null)
			return false;
		if (getClass() != object.getClass())
			return false;
		Period other = (Period) object;
		if (endDate == null) {
			if (other.endDate != null)
				return false;
		} else if (!endDate.equals(other.endDate))
			return false;
		if (startDate == null) {
			if (other.startDate != null)
				return false;
		} else if (!startDate.equals(other.startDate))
			return false;
		return true;
	}
    
	/**
	 * 
	 * @return
	 */
	@Override
	public String toString() {
		return "BillingCycle [startDate=" + startDate + ", endDate=" + endDate
				+ "]";
	}
}
