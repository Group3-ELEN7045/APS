/**
 * 
 */
package za.ac.wits.elen7045.group3.aps.services.notification;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import javax.persistence.Query;

import za.ac.wits.elen7045.group3.aps.domain.entities.Customer;
import za.ac.wits.elen7045.group3.aps.domain.entities.ScrapeLogResult;

/**
 * @author SilasMahlangu
 *
 */
public class DatabaseNotification extends ConfirmationNotification{
    private ScrapeLogResult notification;
    
    public DatabaseNotification(ScrapeLogResult notification){
    	this.notification = notification;
    }
	
	@Override
	public boolean sendNotification() {
	    //DI Inject This
		EntityManager entityManager = Persistence.createEntityManagerFactory("apsBackend").createEntityManager();
		entityManager.getTransaction().begin();
		entityManager.merge(notification);
		entityManager.getTransaction().commit();
		entityManager.close();
	       
		return true;
	}
    
	//1. get Logon Notifications and the ones in a waiting state	
	@Override
	public Object getNotification() {
		//DI Inject This
	    EntityManager entityManager = Persistence.createEntityManagerFactory("apsBackend").createEntityManager();
		Query query = entityManager.createQuery ("SELECT notify FROM ScrapeLogResult notify WHERE notify.accountNumber = ?1 and notify.notificationType=?2 and notify.statsus=?3");
		query.setParameter (1, notification.getAccountNumber()).setParameter(2, notification.getNotificationType()).setParameter(3, notification.getStatsus());
		List  scrapeResults =(List) query.getResultList();
        return scrapeResults;
	}
	
	public ScrapeLogResult updateNotification(){
	    //DI Inject This
		EntityManager entityManager = Persistence.createEntityManagerFactory("apsBackend").createEntityManager();
		ScrapeLogResult upDateResults = entityManager.find(ScrapeLogResult.class, notification.getId());
		entityManager.getTransaction().begin();
		upDateResults.setStatsus(notification.getStatsus());
		entityManager.getTransaction().commit();
		entityManager.close();
		return upDateResults;
	}

}
