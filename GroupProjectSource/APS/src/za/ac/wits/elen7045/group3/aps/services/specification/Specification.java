<<<<<<< HEAD
/**
 * 
 */
package za.ac.wits.elen7045.group3.aps.services.specification;

/**
 * @author SilasMahlangu
 *
 */
public interface Specification <T> {
   boolean isSatisfiedBy(T paramT);
   Specification<T> and(Specification<T> specification);
   Specification<T> or(Specification<T> specification);
   Specification<T> not(Specification<T> specification);
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
public interface Specification {
   boolean isFulfiledBy(Object object);
   Specification and(Specification specification);
   Specification or(Specification specification);
   Specification not(Specification specification);
}
>>>>>>> 9d06a685c42dd92350d06842e6709b616c713041
