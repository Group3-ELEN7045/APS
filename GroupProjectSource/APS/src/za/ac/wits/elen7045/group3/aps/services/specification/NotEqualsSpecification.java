<<<<<<< HEAD
/**
 * 
 */
package za.ac.wits.elen7045.group3.aps.services.specification;

/**
 * @author SilasMahlangu
 *
 */
public class NotEqualsSpecification<T> extends ApplicationSpecification<T>{
	private Specification compare1;
		   
	public NotEqualsSpecification(Specification<T> compare1){
	    this.compare1 = compare1;
	}

	@Override
	public boolean isSatisfiedBy(T t) {
	   return !compare1.isSatisfiedBy(t);
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
public class NotEqualsSpecification extends ApplicationSpecification<Object>{
	private Specification compare1;
		   
	public NotEqualsSpecification(final Specification compare1){
	    this.compare1 = compare1;
	}

	@Override
	public boolean isFulfiledBy(Object object) {
	   return !compare1.isFulfiledBy(object);
	}
}
>>>>>>> 9d06a685c42dd92350d06842e6709b616c713041
