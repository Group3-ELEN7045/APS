package za.ac.wits.elen7045.group3.aps.domain.scheduler;


/**
 * 
 * @author Ronald Menya
 *
 */
public class MaintenanceWindow {
    
	/**
	 * 
	 */
	private long startTime;
	
	/**
	 * 
	 */
	private long endTime;
	
	/**
	 * 
	 * @param startTime
	 */
	public void setStartTime(long startTime) {
		if (startTime <= 0) {
		    throw new RuntimeException("Start time must be the date in milliseconds");	
		}
		
		this.startTime = startTime;
	}

	/**
	 * 
	 * @return
	 */
	public long getStartTime() {
		return startTime;
	}

	/**
	 * 
	 * @param endTime
	 */
	public void setEndTime(long endTime) {
		if (endTime <= 0) {
		    throw new RuntimeException("end time must be the date in milliseconds");	
		}
		
		if (endTime <= this.startTime) {
			throw new RuntimeException("end time must be greater than start time");
		}
		
		this.endTime = endTime;
		
	}

	/**
	 * 
	 * @return
	 */
	public long getEndTime() {
		return endTime;
	}

	/**
	 * 
	 * @return
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (int) (endTime ^ (endTime >>> 32));
		result = prime * result + (int) (startTime ^ (startTime >>> 32));
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
		MaintenanceWindow other = (MaintenanceWindow) object;
		if (endTime != other.endTime)
			return false;
		if (startTime != other.startTime)
			return false;
		return true;
	}
}