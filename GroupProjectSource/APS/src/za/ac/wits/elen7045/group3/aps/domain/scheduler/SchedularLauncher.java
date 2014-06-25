package za.ac.wits.elen7045.group3.aps.domain.scheduler;


import java.io.IOException;
import java.util.Map;
import java.util.Properties;
import org.quartz.JobDetail;


/**
 * 
 * @author Ronald Menya
 *
 */
public class SchedularLauncher {

	private Properties properties = new Properties();
	
	public SchedularLauncher() {
		
		try {
			properties.load(getClass().getClassLoader().getResourceAsStream("Timer-Config.properties"));
			String cronExpression = properties.getProperty("timer-cron");
			System.out.println(cronExpression);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	/**
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		new SchedularLauncher();
		TimerTask task = new TimerTask();
    	JobDetail jobdetail = new JobDetail();
    	jobdetail.setName("APS Timer JOB");
    	jobdetail.setJobClass(TimerJob.class);
    	Map<String, TimerTask> dataMap = jobdetail.getJobDataMap();
    	dataMap.put(jobdetail.getName(), task);
		String cronExpression = "0/1 * * * * ?";
		Timer apsSchedular = new Timer(cronExpression);
		apsSchedular.setJob(jobdetail);
		apsSchedular.schedule();
	}
}
