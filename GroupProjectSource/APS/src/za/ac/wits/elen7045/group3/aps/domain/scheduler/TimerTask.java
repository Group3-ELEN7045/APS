package za.ac.wits.elen7045.group3.aps.domain.scheduler;


import java.io.Serializable;
import java.util.Collection;
import java.util.List;

import org.springframework.context.ApplicationContext;

import za.ac.wits.elen7045.group3.aps.domain.accounts.repository.AddBillingAccountRepository;
import za.ac.wits.elen7045.group3.aps.domain.entities.BillingAccount;
import za.ac.wits.elen7045.group3.aps.domain.entities.BillingCompany;
import za.ac.wits.elen7045.group3.aps.services.enumtypes.AccountStatusType;
import za.ac.wits.elen7045.group3.aps.services.exception.DatabaseException;


/**
 * 
 * @author Ronald Menya
 *
 */
public class TimerTask implements Serializable {
    
	private ApplicationContext applicationContext;
	private WorkManager workManager;
	
    public TimerTask(WorkManager workManager, ApplicationContext applicationContext) {
		this.workManager = workManager;
		this.applicationContext = applicationContext;
	}

	public void execute() {
    	System.out.println("Timer running");		
    	
		IBillingCompanyRepository billingCompanyRepository = (IBillingCompanyRepository) this.applicationContext.getBean("billingCompanyRepository");
		
		
		Collection<BillingCompany> companies = billingCompanyRepository.getAllCompanies();
		SchedulingSpecification schedulingSpecification = (SchedulingSpecification)this.applicationContext.getBean("schedulingSpecification");
		AddBillingAccountRepository accountRepository = (AddBillingAccountRepository) this.applicationContext.getBean("billingAccountRepository");
		
		for (BillingCompany billingCompany : companies) {
			//if (schedulingSpecification.isCompanyInSchedule(billingCompany)) {
					
					//try {
						//List<BillingAccount> accounts = accountRepository.getBillingAccountsByCompanyName(billingCompany.getCompanyName());
						
//						for (BillingAccount billingAccount : accounts) {
//							Runnable runnable = new ScrapeTask(billingAccount);
//							this.workManager.add(runnable);	
//						}
//					} catch (DatabaseException e) {
//						// TODO Auto-generated catch block
//						e.printStackTrace();
//					}
			//}	
			
			
			BillingAccount billingAccount = new BillingAccount();
			
			
			for (int i = 0; i < 2; i++) {
				billingAccount.setAccountNumber(new Double(Math.random()).toString());
				//billingAccount.setCompanyUrl("telco.xml");
				billingAccount.setCompanyUrl("Municipal.xml");
				billingAccount.setAccountStatus(AccountStatusType.ACTIVE.getStatusType());
				
				if (i % 2 == 0) {
					billingAccount.setCompanyUrl("Municipal.xml");
						
				}
				
				Runnable runnable = new ScrapeTask(billingAccount);
				this.workManager.add(runnable);	
			}
		}		
	}
}
