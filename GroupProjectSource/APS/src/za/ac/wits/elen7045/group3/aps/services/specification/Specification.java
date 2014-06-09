<<<<<<< HEAD
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
>>>>>>> f1d7158b44392326220fefc0c7a7c00174b5ec58
