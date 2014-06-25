package za.ac.wits.elen7045.group3.aps.domain.scheduler;


import java.io.Serializable;
import java.util.Collection;
import java.util.List;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;
import za.ac.wits.elen7045.group3.aps.domain.accounts.repository.BillingAccountRepository;
import za.ac.wits.elen7045.group3.aps.domain.entities.BillingAccount;
import za.ac.wits.elen7045.group3.aps.domain.entities.BillingCompany;
import za.ac.wits.elen7045.group3.aps.services.exception.DatabaseException;


public class TimerTask implements Serializable {
    
	private ApplicationContext applicationContext = new FileSystemXmlApplicationContext("res/spring/application-context-test.xml");
	
    public void execute() {
		int numOfWorkers = 5;
		WorkManager workManager = WorkManager.getInstance(numOfWorkers);
		IBillingCompanyRepository billingCompanyRepository = new BillingCompanyRepository();
		Collection<BillingCompany> companies = billingCompanyRepository.getAllCompanies();
		SchedulingSpecification schedulingSpecification = new SchedulingSpecification();
		BillingAccountRepository accountRepository = (BillingAccountRepository) this.applicationContext.getBean("billingAccountRepository");
		
		for (BillingCompany billingCompany : companies) {
			if (schedulingSpecification.isCompanyInSchedule(billingCompany)) {
				try {
					List<BillingAccount> accounts = accountRepository.getBillingAccountsByCompanyName(billingCompany.getUrl());
					
					for (BillingAccount billingAccount : accounts) {
						Runnable runnable = new ScrapeTask(billingAccount);
					    workManager.add(runnable);	
					}
				} catch (DatabaseException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}	
		}		
	}
}
