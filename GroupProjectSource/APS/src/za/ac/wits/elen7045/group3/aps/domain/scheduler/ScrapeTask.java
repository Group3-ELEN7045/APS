package za.ac.wits.elen7045.group3.aps.domain.scheduler;
import za.ac.wits.elen7045.group3.aps.domain.entities.BillingAccount;


/**
 * 
 * @author Ronald Menya
 *
 */
public class ScrapeTask implements Runnable {
    
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
		System.out.println("Scrape Command Executed");
	}
}
