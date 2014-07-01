package za.ac.wits.elen7045.group3.aps.services.scrape;
/**
 * @author bakwanyana
 */
import za.ac.wits.elen7045.group3.aps.domain.accounts.statement.TelcoStatement;
import za.ac.wits.elen7045.group3.aps.domain.scrape.vo.ScrapedResult;

public class TelcoStatementConverter {
	private ScrapedResult scrapedStatement;
	public TelcoStatementConverter(ScrapedResult scrapedStatement){
		this.scrapedStatement = scrapedStatement;
	}
	
	public TelcoStatement getTelcoStatement(){
	TelcoStatement telcoAcc = new TelcoStatement(getIndexDataPair("001"));
	telcoAcc.setAccountHolderName(getIndexDataPair("002"));
	telcoAcc.setAccountStatementDate(getIndexDataPair("003"));
	telcoAcc.setAccountStatementNumber(getIndexDataPair("004"));
	telcoAcc.setAccountStatementMonth(getIndexDataPair("005"));
	telcoAcc.setAccountTotalDue(getIndexDataPair("006"));
	telcoAcc.setAccountDueDate(getIndexDataPair("007"));
	telcoAcc.setAccountOpeningBalance(getIndexDataPair("008"));
	telcoAcc.setAccountClosingBalance(getIndexDataPair("009"));
	telcoAcc.setAccountPaymentReceived(getIndexDataPair("010"));
	telcoAcc.setAccountNewCharges(getIndexDataPair("011"));
	telcoAcc.setAccountDeductions(getIndexDataPair("012"));
	telcoAcc.setAccountDiscount(getIndexDataPair("013"));
	telcoAcc.setAccountVATAmount(getIndexDataPair("014"));
	
	telcoAcc.setTelephonenumber(getIndexDataPair("015"));
	telcoAcc.setServiceCharges(getIndexDataPair("016"));
	telcoAcc.setCallCharges(getIndexDataPair("017"));
	telcoAcc.setTotalCustomerCalls(getIndexDataPair("018"));
	telcoAcc.setTotalCallDuration(getIndexDataPair("019"));
	
	return telcoAcc;		
		
	}
	
	private String getIndexDataPair(String id){
		for (int i = 0; i < scrapedStatement.getDataPairList().size(); i++){
			if(scrapedStatement.getDataPairList().get(i).getId().equals(id))
				return scrapedStatement.getDataPairList().get(i).getValue();
		}
		return null;
	}
}
