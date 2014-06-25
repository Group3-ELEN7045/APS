package test.za.ac.wits.elen7045.group3.scrape;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import za.ac.wits.elen7045.group3.aps.domain.BillingAccountDataAccess;
import za.ac.wits.elen7045.group3.aps.domain.ScrapeLogResultDataAccess;
import za.ac.wits.elen7045.group3.aps.domain.entities.BillingAccount;
import za.ac.wits.elen7045.group3.aps.domain.repository.accounts.BillingAccountRepositoryImpl;
import za.ac.wits.elen7045.group3.aps.domain.repository.notification.ScrapeLogResultImpl;
import za.ac.wits.elen7045.group3.aps.domain.vo.CredentialsVO;
import za.ac.wits.elen7045.group3.aps.services.exception.DatabaseException;
import za.ac.wits.elen7045.group3.aps.services.scrape.CreditCardScrapeStrategy;
import za.ac.wits.elen7045.group3.aps.services.scrape.MunicipalScrapeStrategy;
import za.ac.wits.elen7045.group3.aps.services.scrape.TelcoScrapeStrategy;
import za.ac.wits.elen7045.group3.aps.services.scrape.interfaces.ScraperStrategy;

public class ScraperStrategyTest {
	
	
	private ApplicationContext context;
	
	private BillingAccount billingAccount;
	private ScraperStrategy scraper;

	private ScrapeLogResultDataAccess scrapeLogDataAccess;
	private ScrapeLogResultImpl scrapeLogRepository;
	
	private BillingAccountDataAccess billingAccountDataAccess;
	private BillingAccountRepositoryImpl billingAccountRepositoryImpl;
	

	@Before
	public void initilize(){
		context = new ClassPathXmlApplicationContext("res/spring/application-context-test.xml");
			
		scrapeLogDataAccess = context.getBean(ScrapeLogResultDataAccess.class);
		billingAccountRepositoryImpl = context.getBean(BillingAccountRepositoryImpl.class);
		scrapeLogRepository = new ScrapeLogResultImpl(scrapeLogDataAccess);
	}		
	
	
	@Test
	public void testMunicipalStrategy() throws DatabaseException {
		
		billingAccount = new BillingAccount(2L,98654L,"9098666546");
		billingAccount.setCredentials(new CredentialsVO());
		billingAccount.setCompanyUrl("municipal.xml");
		
		billingAccountRepositoryImpl.saveBillingAccount(billingAccount);
		
		scraper = new MunicipalScrapeStrategy(billingAccount, scrapeLogRepository, billingAccountRepositoryImpl);
		
		scraper.scrapeAccount();
		System.out.println("Scraped account for company : "+billingAccountRepositoryImpl.getBillingAccount(billingAccount.getAccountNumber()).getCompanyUrl());
	}
	
	
//	@Test
	public void testCreditStrategy() throws DatabaseException {
		billingAccount = new BillingAccount(2L,67854L,"6678666546");
		billingAccount.setCredentials(new CredentialsVO());
		billingAccount.setCompanyUrl("creditcard.xml");
		scraper = new CreditCardScrapeStrategy(billingAccount, scrapeLogRepository, billingAccountRepositoryImpl);
		
		scraper.scrapeAccount();
		System.out.println("Scraped account for company : "+billingAccountRepositoryImpl.getBillingAccount(billingAccount.getAccountNumber()).getCompanyUrl());
	}

	
//	@Test
	public void testTelcoStrategy() throws DatabaseException {
		billingAccount = new BillingAccount(2L,679987L,"77658666546");
		billingAccount.setCredentials(new CredentialsVO());
		billingAccount.setCompanyUrl("telco.xml");
		billingAccountRepositoryImpl.saveBillingAccount(billingAccount);
		scraper = new TelcoScrapeStrategy(billingAccount, scrapeLogRepository, billingAccountRepositoryImpl);

		scraper.scrapeAccount();
		System.out.println("Scraped account for company : "+billingAccountRepositoryImpl.getBillingAccount(billingAccount.getAccountNumber()).getCompanyUrl());
	}
}
