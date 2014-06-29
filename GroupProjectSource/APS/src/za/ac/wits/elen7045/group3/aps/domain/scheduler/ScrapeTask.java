package za.ac.wits.elen7045.group3.aps.domain.scheduler;
import java.util.Map;

import org.quartz.JobDetail;

import za.ac.wits.elen7045.group3.aps.domain.entities.BillingAccount;
import za.ac.wits.elen7045.group3.aps.services.scrape.ScrapeManagerImpl;
import za.ac.wits.elen7045.group3.aps.services.scrape.exceptions.ScrapeRetryException;
import za.ac.wits.elen7045.group3.aps.services.scrape.interfaces.ScrapeManager;


/**
 * 
 * @author Ronald Menya
 *
 */
public class ScrapeTask implements Runnable {
    
	/**
	 * 
	 */
	private ScrapeManager scrapeManager = new ScrapeManagerImpl();
	
	/**
	 * 
	 */
	private int retryCount = 4;
	private BillingAccount billingAccount;
	/**
	 * @param billingAccount 
	 * 
	 */
	public ScrapeTask(BillingAccount billingAccount) {
		this.billingAccount = billingAccount;
	}
	
	/**
	 * 
	 * @return
	 */
	public int getRetryCount() {
		return retryCount;
	}
	
	/**
	 * 
	 */
	public void decrementRetryCount() {
		this.retryCount --;
	}

	/**
	 * 
	 */
	@Override
	public void run() {
		System.out.println("Scrape Command Executing");
		
		try {
			this.scrapeManager.scrapeAccount(this.billingAccount);
		} catch (ScrapeRetryException e) {
			//throw e;
		}
		
		System.out.println("Scrape Command Executed");
	}
	
	public static void main(String[] args) {
		new ScrapeTask(new BillingAccount());
	}
}
