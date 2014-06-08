/**
 * 
 */
package za.ac.wits.elen7045.group3.aps.services.specification;

/**
 * @author SilasMahlangu
 *
 */
public interface Specification {
   boolean isFulfiledBy(Object object);
   Specification and(Specification specification);
   Specification or(Specification specification);
   Specification not(Specification specification);
}
