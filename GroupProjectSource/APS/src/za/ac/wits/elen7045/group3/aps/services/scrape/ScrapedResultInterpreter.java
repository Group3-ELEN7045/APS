package za.ac.wits.elen7045.group3.aps.services.scrape;
import za.ac.wits.elen7045.group3.aps.domain.scrape.vo.ScrapedResult;
/**
 * @author bakwanyana
 */
import za.ac.wits.elen7045.group3.aps.domain.scrape.vo.specification.HasErrorInScrapedResultSpecification;
public class ScrapedResultInterpreter {
	private ScrapedResult scrapedStatement;
	
	public ScrapedResultInterpreter(ScrapedResult scrapedStatement){
		this.scrapedStatement = scrapedStatement;
	}
	
	// TODO Throw exception here for error - notifyuserexception, dataintegritycheckexception
	
	public String evaluate(){
		if (new HasErrorInScrapedResultSpecification().isSatisfiedBy(scrapedStatement))
			return scrapedStatement.getDataPairListItemValue(0);
		return "000";
	}
	
}
