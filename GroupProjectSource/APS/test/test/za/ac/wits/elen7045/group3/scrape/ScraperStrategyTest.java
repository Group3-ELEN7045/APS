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
import za.ac.wits.elen7045.group3.aps.domain.repository.accounts.AddBillingAccountRepositoryImpl;
import za.ac.wits.elen7045.group3.aps.domain.repository.notification.ScrapeLogResultImpl;
import za.ac.wits.elen7045.group3.aps.domain.repository.statement.SaveStatementRepository;
import za.ac.wits.elen7045.group3.aps.domain.repository.statement.SaveStatementRepositoryImpl;
import za.ac.wits.elen7045.group3.aps.domain.vo.CredentialsVO;
import za.ac.wits.elen7045.group3.aps.services.exception.DatabaseException;
import za.ac.wits.elen7045.group3.aps.services.scrape.CreditCardScrapeStrategy;
import za.ac.wits.elen7045.group3.aps.services.scrape.MunicipalScrapeStrategy;
import za.ac.wits.elen7045.group3.aps.services.scrape.TelcoScrapeStrategy;
import za.ac.wits.elen7045.group3.aps.services.scrape.interfaces.ScraperStrategy;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class ScraperStrategyTest {
	
	private ApplicationContext context;
	private BillingAccount billingAccount;
	private ScraperStrategy scraper;
	private ScrapeLogResult scrapeLog;
	
//	private ScrapeLogResultDataAccess scrapeLogDataAccess;
	private ScrapeLogResultImpl scrapeLogRepository;
	private AddBillingAccountRepositoryImpl billingAccountRepository;	
	private SaveStatementRepository statementRepository;
	

	@Before
	public void initilize(){
		context = new ClassPathXmlApplicationContext("res/spring/application-context-test.xml");
		
		billingAccountRepository 		= context.getBean(AddBillingAccountRepositoryImpl.class);
		statementRepository				= context.getBean(SaveStatementRepositoryImpl.class);
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

		billingAccount.setAccountNumber("123456789");
		billingAccount.setCompanyUrl("municipal.xml");
		
		scraper = new MunicipalScrapeStrategy(billingAccount, scrapeLogRepository, billingAccountRepository, statementRepository);
		scraper.scrapeAccount();
		
		System.out.println("\n ScrapedAccountTest:END");
	}

	@Test
	public void testCreditStrategy() throws DatabaseException {
		System.out.println("\n ScrapedAccountTest:START");
		
		billingAccount.setAccountNumber("6678666546");
		billingAccount.setCompanyUrl("creditcard.xml");
		
		scraper = new CreditCardScrapeStrategy(billingAccount, scrapeLogRepository, billingAccountRepository, statementRepository);		
		scraper.scrapeAccount();
		
		System.out.println("\n ScrapedAccountTest:END");
	}

	
	@Test
	public void testTelcoStrategy() throws DatabaseException {
		System.out.println("\n ScrapedAccountTest:START");
		
		billingAccount.setAccountNumber("77658666546");
		billingAccount.setCompanyUrl("telco.xml");
		
		scraper = new TelcoScrapeStrategy(billingAccount, scrapeLogRepository, billingAccountRepository, statementRepository);
		scraper.scrapeAccount();

		System.out.println("\n ScrapedAccountTest:END");
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
