package za.ac.wits.elen7045.group3.aps.vo.scrape;

import za.ac.wits.elen7045.group3.aps.vo.specification.scrape.ErrorinScrapedResultSpecification;
public class ScrapeInterpreter {
	private ScrapedResult scrapedStatement;
	
	public ScrapeInterpreter(ScrapedResult scrapedStatement){
		this.scrapedStatement = scrapedStatement;
	}
	
	public String evaluate(){
		// duplicate errors have to be run first
		/*if (new HasDuplicateScrapedResultErrorSpecification().isSatisfiedBy(scrapedStatement))
			return "BrokenScript";*/
		
		if (new ErrorinScrapedResultSpecification().isSatisfiedBy(scrapedStatement))
			return scrapedStatement.getDataPairList().get(0).getValue();
		/*if (new ScrapedResultHasVATErrorSpecification().isSatisfiedBy(scrapedStatement))
			return "BrokenScript";*/
		//if (spec_ALL.isSatisfiedBy(scrapedStatement))
		return "000";
	}
	
}
