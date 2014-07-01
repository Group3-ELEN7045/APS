package za.ac.wits.elen7045.group3.aps.services.scrape;
/**
 * @author bakwanyana
 */
import za.ac.wits.elen7045.group3.aps.domain.accounts.statement.TelcoStatement;
import za.ac.wits.elen7045.group3.aps.domain.entities.BillingAccountStatement;
import za.ac.wits.elen7045.group3.aps.domain.scrape.vo.ScrapedResult;

public class TelcoStatementConverter extends StatementConverter{
	
	public TelcoStatementConverter(ScrapedResult scrapedStatement) {
		super(scrapedStatement);
	}

	@Override
	public BillingAccountStatement getStatement() {
		TelcoStatement telcoAcc = new TelcoStatement(getIndexDataPairValue("001"));
		telcoAcc.setAccountHolderName(getIndexDataPairValue("002"));
		telcoAcc.setAccountStatementDate(getIndexDataPairValue("003"));
		telcoAcc.setAccountStatementNumber(getIndexDataPairValue("004"));
		telcoAcc.setAccountStatementMonth(getIndexDataPairValue("005"));
		telcoAcc.setAccountTotalDue(getIndexDataPairValue("006"));
		telcoAcc.setAccountDueDate(getIndexDataPairValue("007"));
		telcoAcc.setAccountOpeningBalance(getIndexDataPairValue("008"));
		telcoAcc.setAccountClosingBalance(getIndexDataPairValue("009"));
		telcoAcc.setAccountPaymentReceived(getIndexDataPairValue("010"));
		telcoAcc.setAccountNewCharges(getIndexDataPairValue("011"));
		telcoAcc.setAccountDeductions(getIndexDataPairValue("012"));
		telcoAcc.setAccountDiscount(getIndexDataPairValue("013"));
		telcoAcc.setAccountVATAmount(getIndexDataPairValue("014"));
		
		telcoAcc.setTelephonenumber(getIndexDataPairValue("015"));
		telcoAcc.setServiceCharges(getIndexDataPairValue("016"));
		telcoAcc.setCallCharges(getIndexDataPairValue("017"));
		telcoAcc.setTotalCustomerCalls(getIndexDataPairValue("018"));
		telcoAcc.setTotalCallDuration(getIndexDataPairValue("019"));
		
		return telcoAcc;	
	}
}
