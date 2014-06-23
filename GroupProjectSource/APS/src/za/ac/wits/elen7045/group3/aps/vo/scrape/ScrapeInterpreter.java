package za.ac.wits.elen7045.group3.aps.vo.scrape;

import za.ac.wits.elen7045.group3.aps.domain.accounts.abtracts.ScrapedData;
import za.ac.wits.elen7045.group3.aps.services.specification.Specification;
import za.ac.wits.elen7045.group3.aps.vo.specification.scrape.ErrorinScrapedResultSpecification;
import za.ac.wits.elen7045.group3.aps.vo.specification.scrape.ScrapedResultHasVATErrorSpecification;

public class ScrapeInterpreter {
	private ScrapedResult scrapedStatement;
	private Specification<ScrapedData> spec_ALL;
	private NumericDataFormatter numericDataFormatter;
	
	public ScrapeInterpreter(ScrapedResult scrapedStatement,Specification<ScrapedData> spec_ALL,NumericDataFormatter numericDataFormatter){
		this.numericDataFormatter = numericDataFormatter;
		this.spec_ALL = spec_ALL;
		this.scrapedStatement = scrapedStatement;
	}
	
	public String evaluate(){
		if (new ErrorinScrapedResultSpecification().isSatisfiedBy(scrapedStatement))
			return scrapedStatement.getDataPairList().get(0).getValue();
		
		if (new ScrapedResultHasVATErrorSpecification().isSatisfiedBy(scrapedStatement))
			return "BrokenScript";
		//if (spec_ALL.isSatisfiedBy(scrapedStatement))
			
		
		return "000";
	}
	
}
