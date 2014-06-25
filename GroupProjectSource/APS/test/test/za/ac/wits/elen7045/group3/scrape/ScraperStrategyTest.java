
package test.za.ac.wits.elen7045.group3.scrape;
/**
 * @author boitumelo
 * 
 */
import java.util.List;

import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import za.ac.wits.elen7045.group3.aps.domain.entities.BillingAccount;
import za.ac.wits.elen7045.group3.aps.domain.entities.BillingAccountStatement;
import za.ac.wits.elen7045.group3.aps.domain.entities.ScrapeLogResult;
import za.ac.wits.elen7045.group3.aps.domain.repository.accounts.BillingAccountRepositoryImpl;
import za.ac.wits.elen7045.group3.aps.domain.repository.notification.ScrapeLogResultImpl;
import za.ac.wits.elen7045.group3.aps.domain.repository.statement.StatementRepository;
import za.ac.wits.elen7045.group3.aps.domain.repository.statement.StatementRepositoryImpl;
import za.ac.wits.elen7045.group3.aps.domain.vo.CredentialsVO;
import za.ac.wits.elen7045.group3.aps.services.exception.DatabaseException;
import za.ac.wits.elen7045.group3.aps.services.scrape.MunicipalScrapeStrategy;
import za.ac.wits.elen7045.group3.aps.services.scrape.interfaces.ScraperStrategy;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class ScraperStrategyTest {
	
	private ApplicationContext context;
	private BillingAccount billingAccount;
	private ScraperStrategy scraper;
	private ScrapeLogResult scrapeLog;
	
//	private ScrapeLogResultDataAccess scrapeLogDataAccess;
	private ScrapeLogResultImpl scrapeLogRepository;
	private BillingAccountRepositoryImpl billingAccountRepository;	
	private StatementRepository statementRepository;
	

	@Before
	public void initilize(){
		context = new ClassPathXmlApplicationContext("res/spring/application-context-test.xml");
		
		billingAccountRepository 		= context.getBean(BillingAccountRepositoryImpl.class);
		statementRepository				= context.getBean(StatementRepositoryImpl.class);
		scrapeLogRepository				= context.getBean(ScrapeLogResultImpl.class);

		//account
		billingAccount = new BillingAccount(2L,98654L,"123456789");
		billingAccount.setCredentials(new CredentialsVO());
		
		//scrapelog
		scrapeLog = new ScrapeLogResult();
		scrapeLog.setAccountNumber(billingAccount.getAccountNumber());
		scrapeLog.setNotificationType("");
		scrapeLog.setStatsus("");
		
	}		
	
	
	@Test
	public void testMunicipalStrategy() throws DatabaseException {
		System.out.println("\n ScrapedAccountTest:START");

		billingAccount.setCompanyUrl("municipal.xml");		
		billingAccountRepository.saveBillingAccount(billingAccount);
		
		scraper = new MunicipalScrapeStrategy(billingAccount, scrapeLogRepository, billingAccountRepository, statementRepository);
		scraper.scrapeAccount();
		System.out.println("\n ScrapedAccountTest:END");//+billingAccountRepository.getBillingAccount(billingAccount.getAccountNumber()).getCompanyUrl());
	}

//	@Test
	public void testCreditStrategy() throws DatabaseException {
		billingAccount = new BillingAccount(2L,67854L,"6678666546");
		billingAccount.setCredentials(new CredentialsVO());
		billingAccount.setCompanyUrl("creditcard.xml");
//		scraper = new CreditCardScrapeStrategy(billingAccount, scrapeLogRepository, billingAccountRepository);
		
		scraper.scrapeAccount();
		System.out.println("Scraped account for company : ");//+billingAccountRepository.getBillingAccount(billingAccount.getAccountNumber()).getCompanyUrl());
	}

	
//	@Test
	public void testTelcoStrategy() throws DatabaseException {
		billingAccount = new BillingAccount(2L,679987L,"77658666546");
		billingAccount.setCredentials(new CredentialsVO());
		billingAccount.setCompanyUrl("telco.xml");
		billingAccountRepository.saveBillingAccount(billingAccount);
//		scraper = new TelcoScrapeStrategy(billingAccount, scrapeLogRepository, billingAccountRepository);

		scraper.scrapeAccount();
		System.out.println("Scraped account for company : ");//+billingAccountRepository.getBillingAccount(billingAccount.getAccountNumber()).getCompanyUrl());
	}
	
	@Test
	public void testScrapeLog(){
		System.out.println("\n ScrapeLogTest:START");
		try {
			List<ScrapeLogResult> logs = scrapeLogRepository.getScrapeLogResult(scrapeLog);
			for(ScrapeLogResult scrapeLog : logs){
				System.out.println("\n ------- scrape log ------ \n ".concat(scrapeLog.toString()));
			}			
		} catch (DatabaseException e) {
			e.printStackTrace();
		}
		System.out.println("\n ScrapeLogTest:END");
	}
	
	@Test
	public void testStatementRepository(){
		System.out.println("\n StatementRepository:START");
		List<BillingAccountStatement> stmatements = statementRepository.getAccountStatement(billingAccount.getAccountNumber());
		for(BillingAccountStatement statement : stmatements){
			System.out.println("\n ------- statement ------ \n ".concat(statement.toString()));
		}
		System.out.println("\n StatementRepository:END");
	}
}
