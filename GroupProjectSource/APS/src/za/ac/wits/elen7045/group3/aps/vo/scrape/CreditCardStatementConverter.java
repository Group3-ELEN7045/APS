package za.ac.wits.elen7045.group3.aps.vo.scrape;

import za.ac.wits.elen7045.group3.aps.domain.accounts.statement.CreditCardStatement;

public class CreditCardStatementConverter {
	private ScrapedResult scrapedStatement;
	
	public CreditCardStatementConverter(ScrapedResult scrapedStatement){
		this.scrapedStatement = scrapedStatement;
	}

	public CreditCardStatement getCreditCardStatement(){
		CreditCardStatement creditAcc = new CreditCardStatement(getIndexDataPair("001").getValue());
		creditAcc.setAccountHolderName(getIndexDataPair("002").getValue());
		creditAcc.setAccountStatementDate(getIndexDataPair("003").getValue());
		creditAcc.setAccountStatementNumber(getIndexDataPair("004").getValue());
		creditAcc.setAccountStatementMonth(getIndexDataPair("005").getValue());
		creditAcc.setAccountTotalDue(getIndexDataPair("006").getValue());
		creditAcc.setAccountDueDate(getIndexDataPair("007").getValue());
		creditAcc.setAccountOpeningBalance(getIndexDataPair("008").getValue());
		creditAcc.setAccountClosingBalance(getIndexDataPair("009").getValue());
		creditAcc.setAccountPaymentReceived(getIndexDataPair("010").getValue());
		creditAcc.setAccountNewCharges(getIndexDataPair("011").getValue());
		creditAcc.setAccountDeductions(getIndexDataPair("012").getValue());
		creditAcc.setAccountDiscount(getIndexDataPair("013").getValue());
		creditAcc.setAccountVATAmount(getIndexDataPair("014").getValue());
		creditAcc.setCardType(getIndexDataPair("015").getValue());
		creditAcc.setInterestRate(getIndexDataPair("016").getValue());
		creditAcc.setCreditLimit(getIndexDataPair("017").getValue());
		creditAcc.setCreditAvailable(getIndexDataPair("018").getValue());
		creditAcc.setMinimumAmountDue(getIndexDataPair("019").getValue());
		
		return creditAcc;
	}


	private DataPair getIndexDataPair(String id){
		for (int i = 0; i < scrapedStatement.getDataPairList().size(); i++){
			if(scrapedStatement.getDataPairList().get(i).getId().equals(id))
				return scrapedStatement.getDataPairList().get(i);
		}
		return null;
	}
}