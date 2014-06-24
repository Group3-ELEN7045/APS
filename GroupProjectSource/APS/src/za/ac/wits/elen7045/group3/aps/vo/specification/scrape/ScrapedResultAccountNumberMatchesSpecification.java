package za.ac.wits.elen7045.group3.aps.vo.specification.scrape;

import za.ac.wits.elen7045.group3.aps.services.specification.ApplicationSpecification;
import za.ac.wits.elen7045.group3.aps.vo.scrape.ScrapedResult;

// this specification is case sensitive
public class ScrapedResultAccountNumberMatchesSpecification
	extends ApplicationSpecification<ScrapedResult>{
	private String accountNumber;

	public ScrapedResultAccountNumberMatchesSpecification(String accountNumber){
		this.accountNumber = accountNumber;
	}

	@Override
	public boolean isSatisfiedBy(ScrapedResult scrapedData) {
		return scrapedData.getDataPairList().get(0).getValue().equals(accountNumber);
	}
	
	
}
