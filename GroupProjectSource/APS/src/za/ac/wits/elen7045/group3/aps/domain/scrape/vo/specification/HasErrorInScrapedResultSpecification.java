package za.ac.wits.elen7045.group3.aps.domain.scrape.vo.specification;
/**
 * @author bakwanyana
 */
import za.ac.wits.elen7045.group3.aps.domain.scrape.vo.ScrapedResult;
import za.ac.wits.elen7045.group3.aps.services.specification.ApplicationSpecification;


public class HasErrorInScrapedResultSpecification
	extends ApplicationSpecification<ScrapedResult>{
	
	@Override
	public boolean isSatisfiedBy(ScrapedResult scrapedData) {
		
		return scrapedData.getDataPairList().size() == 1;
		
	}
}
