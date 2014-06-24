package za.ac.wits.elen7045.group3.aps.domain.scheduler;


import java.text.ParseException;
import java.util.Date;
import java.util.List;

import org.quartz.CronTrigger;

import za.ac.wits.elen7045.group3.aps.domain.entities.BillingCompany;


/**
 * 
 * @author Ronald Menya
 *
 */
public class SchedulingSpecification {
    
	/**
	 * 
	 * @param billingCompany
	 * @return
	 */
	public boolean isCompanyInSchedule(BillingCompany billingCompany) {
		BillingCycle billingCycle = billingCompany.getBillingcylce();
		Date startDate = billingCycle.getStartDate();
		Date endDate = billingCycle.getEndDate();
		Date now = new Date();
		
		if (!(now.after(endDate) && now.before(startDate))) {
			return false;
		}
		
		List<CronExpressionWrapper> maintenanceWindows = billingCompany.getMaintenancewindows();
		
		for (CronExpressionWrapper cronExpressionWrapper : maintenanceWindows) {
			if (!isCompanyInScheduleHelper(now, cronExpressionWrapper)) {
				return false;
			}
		}
		
		List<CronExpressionWrapper> peakPeriods = billingCompany.getPeakperiod();
		
		for (CronExpressionWrapper cronExpressionWrapper : peakPeriods) {
            if (!isCompanyInScheduleHelper(now, cronExpressionWrapper)) {
				return false;
			}
		}
		
		return true;
	}
	
	/**
	 * 
	 * @param now
	 * @param cronExpressionWrapper
	 * @return
	 */
	private boolean isCompanyInScheduleHelper(Date now, CronExpressionWrapper cronExpressionWrapper) {
		CronTrigger trigger = new CronTrigger();
		
		try {
			trigger.setCronExpression(cronExpressionWrapper.getCronExpression());
		} catch (ParseException e) {
			e.printStackTrace();
		}
		
		if (now.after(trigger.getStartTime()) && now.before(trigger.getEndTime())) {
		      return false;	
		}
		
		return true;
	}
}
