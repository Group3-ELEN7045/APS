package za.ac.wits.elen7045.group3.aps.vo.specification.scrape;
/**
 * @author bakwanyana
 */
import za.ac.wits.elen7045.group3.aps.services.specification.ApplicationSpecification;
import za.ac.wits.elen7045.group3.aps.vo.scrape.ScrapedResult;


public class ErrorinScrapedResultSpecification
	extends ApplicationSpecification<ScrapedResult>{
	
	@Override
	public boolean isSatisfiedBy(ScrapedResult scrapedData) {
		
		return scrapedData.getDataPairList().size() == 1;
		
	}
}
