package za.ac.wits.elen7045.group3.aps.services.pattern.user.factory;

/**
 * @author SilasMahlangu
 *
 */
public abstract class AbstractUserFactory {
   public abstract Object marshallRequest(Object tParam);
   public abstract Object marshallResponse(Object tParam);
}
