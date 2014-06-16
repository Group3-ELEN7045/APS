
<<<<<<< HEAD
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
=======
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
>>>>>>> 334e171862bacecf51ba61bafe29223ce078425e
