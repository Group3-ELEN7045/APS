package za.ac.wits.elen7045.group3.aps.domain.scheduler;


import java.text.ParseException;
import java.util.Map;
import java.util.Properties;

import org.quartz.CronExpression;
import org.quartz.CronTrigger;
import org.quartz.JobDetail;
import org.quartz.Scheduler;
import org.quartz.SchedulerException;
import org.quartz.impl.StdSchedulerFactory;


/**
 * 
 * @author Ronald Menya
 *
 */
public class Timer {

	/**
	 * 
	 */
	private String cronExpression;
	
	/**
	 * 
	 */
	private JobDetail jobDetail;
	
	/**
	 * 
	 * @param cronExpression
	 */
	public Timer(String cronExpression) {
		this.cronExpression = cronExpression;
	}

	/**
	 * 
	 * @param jobDetail
	 */
	public void setJob(JobDetail jobDetail) {
		this.jobDetail = jobDetail;
	} 
	
	/**
	 * 
	 */
	public void schedule() { 
    	CronTrigger trigger = new CronTrigger();
    	trigger.setName(jobDetail.getName());
    	
    	try {
			trigger.setCronExpression(this.cronExpression);
	    	Scheduler scheduler = new StdSchedulerFactory().getScheduler();
	    	scheduler.start();
	    	scheduler.scheduleJob(jobDetail, trigger);
		} catch (ParseException e) {
			e.printStackTrace();
		} catch (SchedulerException e) {
			e.printStackTrace();
		}
	}
}
