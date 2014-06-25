package za.ac.wits.elen7045.group3.aps.vo.specification.scrape;
/**
 * @author bakwanyana
 */
import za.ac.wits.elen7045.group3.aps.domain.scrape.vo.ScrapedResult;
import za.ac.wits.elen7045.group3.aps.services.specification.ApplicationSpecification;


public class ErrorinScrapedResultSpecification
	extends ApplicationSpecification<ScrapedResult>{
	
	@Override
	public boolean isSatisfiedBy(ScrapedResult scrapedData) {
		
		return scrapedData.getDataPairList().size() == 1;
		
	}
}
