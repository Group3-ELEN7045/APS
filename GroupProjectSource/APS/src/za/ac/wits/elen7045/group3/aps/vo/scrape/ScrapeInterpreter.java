package za.ac.wits.elen7045.group3.aps.vo.scrape;

import za.ac.wits.elen7045.group3.aps.domain.accounts.abtracts.AbstractBillingAccountStatement;
import za.ac.wits.elen7045.group3.aps.services.specification.Specification;
import za.ac.wits.elen7045.group3.aps.vo.specification.scrape.ScrapeErrorInStatementSpecification;

public class ScrapeInterpreter {
	private ScrapedResult scrapedStatement;
	private Specification<AbstractBillingAccountStatement> spec_ALL;
	private NumericDataFormatter numericDataFormatter;
	
	public ScrapeInterpreter(ScrapedResult scrapedStatement,Specification<AbstractBillingAccountStatement> spec_ALL,NumericDataFormatter numericDataFormatter){
		this.numericDataFormatter = numericDataFormatter;
		this.spec_ALL = spec_ALL;
		this.scrapedStatement = scrapedStatement;
	}
	
	public String evaluate(){
		if (new ScrapeErrorInStatementSpecification().isSatisfiedBy(scrapedStatement))
			return scrapedStatement.getDataPairList().get(0).getValue();
		
		if (spec_ALL.isSatisfiedBy(scrapedStatement))
			
		
		return null;
	}
	
}
