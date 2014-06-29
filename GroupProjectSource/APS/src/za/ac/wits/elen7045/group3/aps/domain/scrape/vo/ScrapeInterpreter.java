package za.ac.wits.elen7045.group3.aps.domain.scrape.vo;
/**
 * @author bakwanyana
 */
import za.ac.wits.elen7045.group3.aps.vo.specification.scrape.ErrorinScrapedResultSpecification;
public class ScrapeInterpreter {
	private ScrapedResult scrapedStatement;
	
	public ScrapeInterpreter(ScrapedResult scrapedStatement){
		this.scrapedStatement = scrapedStatement;
	}
	
	// TODO Throw exception here for error - notifyuserexception, dataintegritycheckexception
	
	public String evaluate(){
		if (new ErrorinScrapedResultSpecification().isSatisfiedBy(scrapedStatement))
			return scrapedStatement.getDataPairList().get(0).getValue();
		return "000";
	}
	
}
