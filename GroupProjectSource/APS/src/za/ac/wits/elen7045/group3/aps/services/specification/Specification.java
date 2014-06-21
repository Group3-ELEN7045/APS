/**
 * 
 */
package za.ac.wits.elen7045.group3.aps.services.specification;

/**
 * @author SilasMahlangu
 *
 */
public interface Specification<T> {
   boolean isSatisfiedBy(T tPram);
   Specification<T> and(Specification<T> specification);
   Specification<T> or(Specification<T> specification);
   Specification<T> not(Specification<T> specification);
}
