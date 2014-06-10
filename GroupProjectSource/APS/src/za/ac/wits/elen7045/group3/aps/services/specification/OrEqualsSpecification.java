<<<<<<< HEAD
/**
 * 
 */
package za.ac.wits.elen7045.group3.aps.services.specification;

/**
 * @author SilasMahlangu
 *
 */
public class OrEqualsSpecification<T> extends ApplicationSpecification<T>{
	private Specification<T> compare1;
	private Specification<T> compare2;
	   
	public OrEqualsSpecification(Specification<T> compare1, Specification<T> compare2){
	   this.compare1 = compare1;
	   this.compare2 = compare2;
	}

	@Override
	public boolean isSatisfiedBy(T t) {
	   return compare1.isSatisfiedBy(t) || compare2.isSatisfiedBy(t);
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
public class OrEqualsSpecification extends ApplicationSpecification<Object>{
	private Specification compare1;
	private Specification compare2;
	   
	public OrEqualsSpecification(final Specification compare1, final Specification compare2){
	   this.compare1 = compare1;
	   this.compare2 = compare2;
	}

	@Override
	public boolean isFulfiledBy(Object object) {
	   return compare1.isFulfiledBy(object) || compare2.isFulfiledBy(object);
	}
}
>>>>>>> 9d06a685c42dd92350d06842e6709b616c713041
