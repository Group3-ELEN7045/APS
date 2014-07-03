package za.ac.wits.elen7045.group3.aps.services.scrape;

import za.ac.wits.elen7045.group3.aps.domain.entities.BillingAccountStatement;
import za.ac.wits.elen7045.group3.aps.domain.scrape.vo.ScrapedResult;

public abstract class ScrapedResultToStatementConverter {
	private ScrapedResult scrapedStatement;
	public ScrapedResultToStatementConverter(ScrapedResult scrapedStatement){
		this.scrapedStatement = scrapedStatement;
	}
	
	public abstract BillingAccountStatement getBillingStatement();
	
	protected String getIndexDataPairValue(String id){
		for (int i = 0; i < scrapedStatement.getDataPairList().size(); i++){
			if(scrapedStatement.getDataPairList().get(i).getId().equals(id))
				return scrapedStatement.getDataPairList().get(i).getValue();
		}
		return null;
	}
}
