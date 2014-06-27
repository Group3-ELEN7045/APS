package za.ac.wits.elen7045.group3.aps.services.scrape.factory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import za.ac.wits.elen7045.group3.aps.domain.entities.BillingAccount;
import za.ac.wits.elen7045.group3.aps.domain.repository.accounts.BillingAccountRepository;
import za.ac.wits.elen7045.group3.aps.domain.repository.notification.ScrapeLogResultRepository;
import za.ac.wits.elen7045.group3.aps.domain.repository.statement.StatementRepository;
import za.ac.wits.elen7045.group3.aps.services.scrape.CreditCardScrapeStrategy;
import za.ac.wits.elen7045.group3.aps.services.scrape.MunicipalScrapeStrategy;
import za.ac.wits.elen7045.group3.aps.services.scrape.TelcoScrapeStrategy;
import za.ac.wits.elen7045.group3.aps.services.scrape.interfaces.ScraperStrategy;
import za.ac.wits.elen7045.group3.aps.services.scrape.interfaces.ScraperStrategyFactory;
/**
 * 
 * @author boitumelo
 *
 */
@Service
public class ScraperStrategyFactoryImpl implements ScraperStrategyFactory {
	
	BillingAccountRepository 	billingAccountRepository;
	ScrapeLogResultRepository 	scrapeLogRepository;
	StatementRepository			statementRepository;
	
	@Autowired
	public ScraperStrategyFactoryImpl(
			BillingAccountRepository billingAccountRepository,
			ScrapeLogResultRepository scrapeLogRepository) {
		super();
		this.billingAccountRepository = billingAccountRepository;
		this.scrapeLogRepository = scrapeLogRepository;
	}

	@Override
	public ScraperStrategy getScraperStrategy(BillingAccount billingAccount) {
		
		if("municipal.xml".equalsIgnoreCase(billingAccount.getCompanyUrl())){
			return new MunicipalScrapeStrategy(billingAccount, scrapeLogRepository, billingAccountRepository, statementRepository);
		}else if("creditcard.xml".equalsIgnoreCase(billingAccount.getCompanyUrl())){
			return new CreditCardScrapeStrategy(billingAccount, scrapeLogRepository, billingAccountRepository, statementRepository);
		}else if("telco.xml".equalsIgnoreCase(billingAccount.getCompanyUrl())){
			return new TelcoScrapeStrategy(billingAccount, scrapeLogRepository, billingAccountRepository, statementRepository);
		}else{
			return null;
		}
	}
}
