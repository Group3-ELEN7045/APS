/**
 * 
 */
package za.ac.wits.elen7045.group3.aps.services.specification;

/**
 * @author SilasMahlangu
 *
 */
public abstract class ApplicationSpecification<T> implements Specification{
     public abstract boolean isFulfiledBy(Object object);
     
     public Specification and(final Specification specification) {
    	    return new AndEqualsSpecification(this, specification);
    	  }

    	  public Specification or(final Specification specification) {
    	    return new OrEqualsSpecification(this, specification);
    	  }

    	  public Specification not(final Specification specification) {
    	    return new NotEqualsSpecification(specification);
    	  }

}
