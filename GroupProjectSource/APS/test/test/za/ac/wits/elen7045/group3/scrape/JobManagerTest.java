package test.za.ac.wits.elen7045.group3.scrape;

/**
 * @author boitumelo
 * 
 */

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import test.za.ac.wits.elen7045.group3.mock.proxy.APSMockObjectGenerator;
import za.ac.wits.elen7045.group3.aps.domain.ScrapeLogResultDataAccess;
import za.ac.wits.elen7045.group3.aps.domain.entities.BillingAccount;
import za.ac.wits.elen7045.group3.aps.domain.entities.ScrapeLogResult;
import za.ac.wits.elen7045.group3.aps.domain.repository.notification.ScrapeLogResultImpl;
import za.ac.wits.elen7045.group3.aps.domain.repository.notification.ScrapeLogResultRepository;
import za.ac.wits.elen7045.group3.aps.domain.vo.CredentialsVO;

public class JobManagerTest {
	
	private JobManagerMock jmo;
	private BillingAccount billingAccount;
	private ScrapeLogResult notification;
	private List<ScrapeLogResult> notifications;
	private ScrapeLogResultDataAccess notificationDataAccess;
	private ScrapeLogResultRepository notificationRepository;
	private ScrapeLogResultImpl notificationRepositoryImpl;
	private ApplicationContext context;

	@Before
	public void initilize(){
		context = new ClassPathXmlApplicationContext("res/spring/application-context-test.xml");
		notification = context.getBean(ScrapeLogResult.class);
		notificationDataAccess = context.getBean(ScrapeLogResultDataAccess.class);
		notifications = new ArrayList<ScrapeLogResult>();
		notificationRepositoryImpl = new ScrapeLogResultImpl(notificationDataAccess);
		notificationRepository = new APSMockObjectGenerator<ScrapeLogResultImpl>().mock(notificationRepositoryImpl);
		
		billingAccount = new BillingAccount(2L,98654L,"9098666546");
		billingAccount.setCredentials(new CredentialsVO());
		billingAccount.setCompanyUrl("creditcard.xml");

		
	}	
	
	@Before
	public void setUp() throws Exception {
		jmo = new JobManagerMock();
	}

	@Test
	public void test() {
//		assert(jmo.getSm().scrapeAccount(billingAccount));
	}

}
