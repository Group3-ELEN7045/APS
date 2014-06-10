
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
