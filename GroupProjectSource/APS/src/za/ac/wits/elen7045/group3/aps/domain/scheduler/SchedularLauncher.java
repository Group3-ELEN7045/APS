package za.ac.wits.elen7045.group3.aps.domain.scheduler;


import java.io.IOException;
import java.util.Map;
import java.util.Properties;

import org.quartz.JobDetail;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;


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
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	
	/**
	 * 
	 * @param args
	 */
	//public static void main(String[] args) {
	public void launch(){ 
		ApplicationContext applicationContext = new ClassPathXmlApplicationContext("res/spring/application-context-test.xml");
		Timer timer = (Timer) applicationContext.getBean("timer");
		int numOfWorkers = 5;
		WorkManager workManager = WorkManager.getInstance(numOfWorkers);
		TimerTask task = new TimerTask(workManager, applicationContext);
    	JobDetail jobdetail = new JobDetail();
    	jobdetail.setName("APS Timer JOB");
    	jobdetail.setJobClass(TimerJob.class);
    	Map<String, TimerTask> dataMap = jobdetail.getJobDataMap();
    	dataMap.put(jobdetail.getName(), task);
		
		timer.setJob(jobdetail);
		timer.schedule();
	}
}
