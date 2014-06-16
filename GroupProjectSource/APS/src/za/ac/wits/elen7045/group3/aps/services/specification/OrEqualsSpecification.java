/**
 * 
 */
package za.ac.wits.elen7045.group3.aps.services.specification;

/**
 * @author SilasMahlangu
 *
 */
public class OrEqualsSpecification<T> extends ApplicationSpecification<T>{
	private Specification compare1;
	private Specification compare2;
	   
	public OrEqualsSpecification(Specification<T> compare1, Specification<T> compare2){
	   this.compare1 = compare1;
	   this.compare2 = compare2;
	}

	@Override
	public boolean isSatisfiedBy(Object object) {
	   return compare1.isSatisfiedBy(object) || compare2.isSatisfiedBy(object);
	}
}
