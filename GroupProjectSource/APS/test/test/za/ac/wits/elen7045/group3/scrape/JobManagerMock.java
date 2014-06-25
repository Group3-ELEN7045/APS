package test.za.ac.wits.elen7045.group3.scrape;

/**
 * @author boitumelo
 * 
 */

import za.ac.wits.elen7045.group3.aps.domain.entities.BillingAccount;
import za.ac.wits.elen7045.group3.aps.domain.entities.BillingCompany;
import za.ac.wits.elen7045.group3.aps.domain.vo.CredentialsVO;
import za.ac.wits.elen7045.group3.aps.services.scrape.ScrapeManagerImpl;
import za.ac.wits.elen7045.group3.aps.services.scrape.exceptions.ScrapeRetryException;

public class JobManagerMock {
	ScrapeManagerImpl sm;
	BillingAccount billingAccount;
	boolean jobComplete = false;
	
	public JobManagerMock() {
		
		BillingCompany billingCo = new BillingCompany("JoburgMunicipality");
		billingCo.setURL("file:///municipal.xml");
		
		billingAccount = new BillingAccount(1L,98986L,"9098777546");
		billingAccount.setCredentials(new CredentialsVO());
		billingAccount.setCompanyUrl("municipal.xml");
		//billingCo.addBillingAccounts(billingAccount);
		
		billingAccount = new BillingAccount(2L,98654L,"9098666546");
		billingAccount.setCredentials(new CredentialsVO());
		billingAccount.setCompanyUrl("creditcard.xml");
		//billingCo.addBillingAccounts(billingAccount);
		
		//ScraperStrategy scraper = new MunicipalScrapeStrategy(billingAccount);	
		//sm = new ScrapeManager(scraper);
	}

	public void runScrapeJob() {
		billingAccount = new BillingAccount(2L,98654L,"9098666546");
		billingAccount.setCredentials(new CredentialsVO());
		billingAccount.setCompanyUrl("municipal.xml");
		
		try {
			sm.scrapeAccount(billingAccount);
		} catch (ScrapeRetryException e) {
			// TODO Process the scrape retry error
			e.printStackTrace();
		}
	}

	protected boolean isJobComplete() {
		return jobComplete;
	}

	protected ScrapeManagerImpl getSm() {
		return sm;
	}

	protected void setSm(ScrapeManagerImpl sm) {
		this.sm = sm;
	}	
}
