package za.ac.wits.elen7045.group3.aps.domain.scheduler;


import java.util.Map;
import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;


/**
 * 
 * @author Ronald Menya
 *
 */
public class TimerJob implements Job {
    
	/**
	 * 
	 */
	public void execute(JobExecutionContext context) throws JobExecutionException {
		Map<String, TimerTask> dataMap = context.getJobDetail().getJobDataMap();
		
		for (String key : dataMap.keySet()) {
			TimerTask task = (TimerTask) dataMap.get(key);
			task.execute();	
		}
	}
}