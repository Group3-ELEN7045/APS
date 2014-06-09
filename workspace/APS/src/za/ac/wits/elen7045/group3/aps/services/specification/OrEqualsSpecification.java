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
