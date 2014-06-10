<<<<<<< HEAD
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
=======

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
>>>>>>> 9d06a685c42dd92350d06842e6709b616c713041
