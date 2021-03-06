/**
 * 
 */
package za.ac.wits.elen7045.group3.aps.services.specification;

/**
 * @author SilasMahlangu
 *
 */
public class NotEqualsSpecification<T> extends ApplicationSpecification<T>{
	private Specification<T> compare1;
		   
	public NotEqualsSpecification(Specification<T> compare1){
	    this.compare1 = compare1;
	}

	@Override
	public boolean isSatisfiedBy(T tpatam) {
	   return !compare1.isSatisfiedBy(tpatam);
	}
}
