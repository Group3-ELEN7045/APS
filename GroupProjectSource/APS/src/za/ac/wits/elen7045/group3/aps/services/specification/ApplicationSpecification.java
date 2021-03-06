/**
 * 
 */
package za.ac.wits.elen7045.group3.aps.services.specification;

/**
 * @author SilasMahlangu
 *
 */
public abstract class ApplicationSpecification<T> implements Specification<T>{
     public abstract boolean isSatisfiedBy(T tParam);
     
     public Specification<T> and(Specification<T> specification) {
    	    return new AndEqualsSpecification<T>(this, specification);
    	  }

    	  public Specification<T> or(Specification<T> specification) {
    	    return new OrEqualsSpecification<T>(this, specification);
    	  }

    	  public Specification<T> not(Specification<T> specification) {
    	    return new NotEqualsSpecification<T>(specification);
    	  }

}
