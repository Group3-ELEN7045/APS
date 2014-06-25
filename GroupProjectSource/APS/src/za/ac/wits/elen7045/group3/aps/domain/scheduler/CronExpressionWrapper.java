package za.ac.wits.elen7045.group3.aps.domain.scheduler;


/**
 * 
 * @author Ronald Menya
 *
 */
public class CronExpressionWrapper {

	/**
	 * 
	 */
	private String seconds;
	
	/**
	 * 
	 */
	private String minutes;
	
	/**
	 * 
	 */
	private String  hours;
	
	/**
	 * 
	 */
	private String  dayOfMonth;
	
	/**
	 * 
	 */
	private String month;
	
	/**
	 * 
	 */
	private String dayOfWeek;
	
	/**
	 * 
	 */
	private String year;
	
	/**
	 * @return the seconds
	 */
	public String getSeconds() {
		return seconds;
	}
	
	/**
	 * @param seconds the seconds to set
	 */
	public void setSeconds(String seconds) {
		this.seconds = seconds;
	}
	
	/**
	 * @return the minutes
	 */
	public String getMinutes() {
		return minutes;
	}
	
	/**
	 * @param minutes the minutes to set
	 */
	public void setMinutes(String minutes) {
		this.minutes = minutes;
	}
	
	/**
	 * @return the hours
	 */
	public String getHours() {
		return hours;
	}
	
	/**
	 * @param hours the hours to set
	 */
	public void setHours(String hours) {
		this.hours = hours;
	}
	
	/**
	 * @return the dayOfMonth
	 */
	public String getDayOfMonth() {
		return dayOfMonth;
	}
	
	/**
	 * @param dayOfMonth the dayOfMonth to set
	 */
	public void setDayOfMonth(String dayOfMonth) {
		this.dayOfMonth = dayOfMonth;
	}
	
	/**
	 * @return the month
	 */
	public String getMonth() {
		return month;
	}
	
	/**
	 * @param month the month to set
	 */
	public void setMonth(String month) {
		this.month = month;
	}
	
	/**
	 * @return the dayOfWeek
	 */
	public String getDayOfWeek() {
		return dayOfWeek;
	}
	
	/**
	 * @param dayOfWeek the dayOfWeek to set
	 */
	public void setDayOfWeek(String dayOfWeek) {
		this.dayOfWeek = dayOfWeek;
	}
	
	/**
	 * @return the year
	 */
	public String getYear() {
		return year;
	}
	
	/**
	 * @param year the year to set
	 */
	public void setYear(String year) {
		this.year = year;
	}
	
	public String getCronExpression() {
		return seconds + minutes + hours + dayOfMonth + month + dayOfWeek + year;
	}	
}
