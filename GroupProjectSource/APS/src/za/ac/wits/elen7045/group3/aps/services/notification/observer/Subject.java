/**
 * 
 */
package za.ac.wits.elen7045.group3.aps.services.notification.observer;

/**
 * @author SilasMahlangu
 *
 */
public interface Subject{
    public void register(Observer observer);
    public void unRegister(Observer observer);
    
    public void notifyObsrvers();
    
    public Object getResponse(Observer observer);
    public void setResponse(Object object);
}
