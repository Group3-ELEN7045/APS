package za.ac.wits.elen7045.group3.aps.vo.scrape;

import za.ac.wits.elen7045.group3.aps.vo.specification.scrape.ErrorinScrapedResultSpecification;
public class ScrapeInterpreter {
	private ScrapedResult scrapedStatement;
	
	public ScrapeInterpreter(ScrapedResult scrapedStatement){
		this.scrapedStatement = scrapedStatement;
	}
	
	public String evaluate(){
		if (new ErrorinScrapedResultSpecification().isSatisfiedBy(scrapedStatement))
			return scrapedStatement.getDataPairList().get(0).getValue();
		return "000";
	}
	
}
