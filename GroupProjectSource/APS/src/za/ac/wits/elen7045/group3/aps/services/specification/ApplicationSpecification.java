
/**
 * 
 */
package za.ac.wits.elen7045.group3.aps.services.specification;

/**
 * @author SilasMahlangu
 *
 */
public abstract class ApplicationSpecification<T> implements Specification<T>{
     public abstract boolean isSatisfiedBy(T paramT);
     
     public Specification<T> and(Specification<T> specification) {
    	    return new AndEqualsSpecification(this, specification);
    	  }

    	  public Specification<T> or(Specification<T> specification) {
    	    return new OrEqualsSpecification(this, specification);
    	  }

    	  public Specification<T> not(Specification<T> specification) {
    	    return new NotEqualsSpecification(specification);
    	  }

}
