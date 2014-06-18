package za.ac.wits.elen7045.group3.aps.services.scrape;

import java.util.List;

import za.ac.wits.elen7045.group3.aps.domain.entities.BillingAccount;
import za.ac.wits.elen7045.group3.aps.domain.scrape.entities.ScrapeRequest;

public class ScrapeManager {
	ScrapeRequest scrapeRequest;
	public ScrapeManager(ScrapeRequest scrapeRequest){
		this.scrapeRequest = scrapeRequest;
	}
	
	public void scrapeWebsite(){
		List <BillingAccount> accounts = scrapeRequest.getBillingCompany().getBillingAccounts();
		String url = scrapeRequest.getBillingCompany().getUrl();
		for(int i = 0; i < accounts.size(); i++){
			/*doSomething( url,
			 * 			accounts.get(i).getAccountNumber(),
			 * 			accounts.get(i).getCredentials().getUserName(),
			 * 			accounts.get(i).getCredentials().getPassword(),
			 * 			)
			*/
		}
	}

}
