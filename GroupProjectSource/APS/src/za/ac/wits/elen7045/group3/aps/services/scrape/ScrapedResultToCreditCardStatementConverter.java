package za.ac.wits.elen7045.group3.aps.services.scrape;

import za.ac.wits.elen7045.group3.aps.domain.accounts.statement.CreditCardStatement;
import za.ac.wits.elen7045.group3.aps.domain.entities.BillingAccountStatement;
import za.ac.wits.elen7045.group3.aps.domain.scrape.vo.ScrapedResult;

public class ScrapedResultToCreditCardStatementConverter extends ScrapedResultToStatementConverter{
	
	public ScrapedResultToCreditCardStatementConverter(ScrapedResult scrapedStatement) {
		super(scrapedStatement);
	}
	
	@Override
	public BillingAccountStatement getStatement() {
		
		CreditCardStatement creditAcc = new CreditCardStatement(getIndexDataPairValue("001"));
		creditAcc.setAccountHolderName(getIndexDataPairValue("002"));
		creditAcc.setAccountStatementDate(getIndexDataPairValue("003"));
		creditAcc.setAccountStatementNumber(getIndexDataPairValue("004"));
		creditAcc.setAccountStatementMonth(getIndexDataPairValue("005"));
		creditAcc.setAccountTotalDue(getIndexDataPairValue("006"));
		creditAcc.setAccountDueDate(getIndexDataPairValue("007"));
		creditAcc.setAccountOpeningBalance(getIndexDataPairValue("008"));
		creditAcc.setAccountClosingBalance(getIndexDataPairValue("009"));
		creditAcc.setAccountPaymentReceived(getIndexDataPairValue("010"));
		creditAcc.setAccountNewCharges(getIndexDataPairValue("011"));
		creditAcc.setAccountDeductions(getIndexDataPairValue("012"));
		creditAcc.setAccountDiscount(getIndexDataPairValue("013"));
		creditAcc.setAccountVATAmount(getIndexDataPairValue("014"));
		creditAcc.setCardType(getIndexDataPairValue("015"));
		creditAcc.setInterestRate(getIndexDataPairValue("016"));
		creditAcc.setCreditLimit(getIndexDataPairValue("017"));
		creditAcc.setCreditAvailable(getIndexDataPairValue("018"));
		creditAcc.setMinimumAmountDue(getIndexDataPairValue("019"));
		
		return creditAcc;
	}
}