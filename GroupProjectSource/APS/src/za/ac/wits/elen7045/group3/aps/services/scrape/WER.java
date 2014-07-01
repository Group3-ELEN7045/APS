package za.ac.wits.elen7045.group3.aps.services.scrape;

import za.ac.wits.elen7045.group3.aps.domain.entities.BillingAccountStatement;
import za.ac.wits.elen7045.group3.aps.domain.scrape.vo.ScrapedResult;

public class WER extends CreditCardStatementConverter {

	public WER(ScrapedResult scrapedStatement) {
		super(scrapedStatement);
		// TODO Auto-generated constructor stub
	}
	@Override
	public BillingAccountStatement getStatement(){
		BillingAccountStatement ss = super.getStatement();
		ss.setAccountClosingBalance("");
		return ss;
	}

}
