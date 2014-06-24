/**
 * 
 */
package za.ac.wits.elen7045.group3.aps.services.pattern.notification.observer;

import java.util.ArrayList;
import java.util.List;

import za.ac.wits.elen7045.group3.aps.domain.entities.ScrapeLogResult;
import za.ac.wits.elen7045.group3.aps.domain.vo.NotificationCheck;

/**
 * @author SilasMahlangu
 *
 */
public class NotificationPublisher implements Subject{

	private List<Observer> observerList = new ArrayList<Observer>();
	private ScrapeLogResult notifictionCheck;
	private boolean status;
	private long    id;
	private  Object responseObject;
	private final Object blocker = new Object();
	
	public NotificationPublisher(){
		
	}
	
	@Override
	public void register(Observer observer) {
		if(observer == null) 
			throw new RuntimeException("null Observer");
		synchronized (blocker) {
		    if(!observerList.contains(observer)){
		    	observerList.add(observer);
		    }	
		}
	}

	

	@Override
	public void unRegister(Observer observer) {
		synchronized (blocker) {
		    if(!observerList.contains(observer)){
		    	observerList.remove(observer);
		    }	
		}		
	}

	@Override
	public void notifyObsrvers() {
		List<Observer> listInternalObserver;
		synchronized (blocker) {
		    if(!status){
		    	return;
		    }
		    listInternalObserver = new ArrayList<Observer>();
		    this.status = false;
		}
		for(Observer observer : listInternalObserver){
			observer.update(this.notifictionCheck);
		}
	}
		

	@Override
	public Object getResponse(Observer observer) {
		return this.responseObject;
	}
	
	//public void pleaseNotify(String message){
	//	System.out.println("Senting Message " + message);
	//	this.message = message;
	//	this.status = true;
	//	notifyObsrvers();
	//}
	
	public void checkNotifications(ScrapeLogResult notifictionCheck){
		this.notifictionCheck = notifictionCheck;
		this.status = true;
		notifyObsrvers();
	}
	
	@Override
	public void setResponse(Object object) {
		this.responseObject = object;
	}
	
	  
}
