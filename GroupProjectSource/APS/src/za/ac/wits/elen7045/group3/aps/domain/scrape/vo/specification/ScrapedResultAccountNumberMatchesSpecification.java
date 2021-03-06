package za.ac.wits.elen7045.group3.aps.domain.scrape.vo.specification;

import za.ac.wits.elen7045.group3.aps.domain.scrape.vo.ScrapedResult;
import za.ac.wits.elen7045.group3.aps.services.specification.ApplicationSpecification;

// this specification is case sensitive
public class ScrapedResultAccountNumberMatchesSpecification
	extends ApplicationSpecification<ScrapedResult>{
	private String accountNumber;

	public ScrapedResultAccountNumberMatchesSpecification(String accountNumber){
		this.accountNumber = accountNumber;
	}

	@Override
	public boolean isSatisfiedBy(ScrapedResult scrapedData) {
		return scrapedData.getDataPairListItemValue(0).equals(accountNumber);
	}
	
	
}
