/**
 * 
 */
package za.ac.wits.elen7045.group3.aps.domain.repository.notification;

import java.util.List;

import za.ac.wits.elen7045.group3.aps.domain.entities.ScrapeLogResult;
import za.ac.wits.elen7045.group3.aps.services.exception.DatabaseException;

/**
 * @author SilasMahlangu
 *
 */
public interface ScrapeLogResultRepository {
    public boolean updateScrapeLogResult(ScrapeLogResult notification)throws DatabaseException;
    public List<ScrapeLogResult> getScrapeLogResult(Long id,String status) throws DatabaseException;
}
