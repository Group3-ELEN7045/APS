package za.ac.wits.elen7045.group3.aps.services.scrape.factory;

import za.ac.wits.elen7045.group3.aps.services.scrape.CreditCardScrapeStrategy;
import za.ac.wits.elen7045.group3.aps.services.scrape.MunicipalScrapeStrategy;
import za.ac.wits.elen7045.group3.aps.services.scrape.interfaces.ScraperStrategy;

public class ScraperStrategyFactory {
	
	public static ScraperStrategy getScraperStrategy(String companyUrl) {
		
	
		
		if("municipal.xml".equalsIgnoreCase(companyUrl)){
			return null;
//			return new MunicipalScrapeStrategy(acc, scrapeLogRepository, billingAccountRepository);
		}else if("creditcard.xml".equalsIgnoreCase(companyUrl)){
			return null;
//			return new CreditCardScrapeStrategy(acc, scrapeLogRepository, billingAccountRepository);
		}else if("telco.xml".equalsIgnoreCase(companyUrl)){
			return null;
//			return new TelcoScrapeStrategy(acc, scrapeLogRepository, billingAccountRepository);
		}else{
			return null;
		}
	}

}
