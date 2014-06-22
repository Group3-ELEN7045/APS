package test.za.ac.wits.group3.scrape;

import za.ac.wits.elen7045.group3.aps.domain.entities.BillingAccount;
import za.ac.wits.elen7045.group3.aps.domain.entities.BillingCompany;
import za.ac.wits.elen7045.group3.aps.domain.vo.CredentialsVO;
import za.ac.wits.elen7045.group3.aps.services.scraper.MunicipalScrapeStrategy;
import za.ac.wits.elen7045.group3.aps.services.scraper.ScrapeManager;
import za.ac.wits.elen7045.group3.aps.services.scraper.interfaces.Scraper;

public class JobManagerMock {
	ScrapeManager sm;
	boolean jobComplete = false;
	
	public JobManagerMock() {
		BillingAccount billingAccount;
		BillingCompany billingCo = new BillingCompany("JoburgMunicipality");
		//home/boitumelo/git/APS/GroupProjectSource/APS
		billingCo.setURL("file:///municipal.xml");
		
		billingAccount = new BillingAccount(1L,98986L,"9098777546");
		billingAccount.setCredentials(new CredentialsVO());
		billingAccount.setCompanyUrl(billingCo.getUrl());
		billingCo.addBillingAccounts(billingAccount);
		
		billingAccount = new BillingAccount(2L,98654L,"9098666546");
		billingAccount.setCredentials(new CredentialsVO());
		billingAccount.setCompanyUrl(billingCo.getUrl());
		billingCo.addBillingAccounts(billingAccount);
		
		Scraper scraper = new MunicipalScrapeStrategy(billingAccount);
		//scrapeRequest = new ScrapeRequest("1", billingCo, scraper);
		
		sm = new ScrapeManager(scraper);
	}

	public void runScrapeJob() {
		jobComplete = sm.scrapeAccount();
	}

	protected boolean isJobComplete() {
		return jobComplete;
	}

	protected ScrapeManager getSm() {
		return sm;
	}

	protected void setSm(ScrapeManager sm) {
		this.sm = sm;
	}	
}
