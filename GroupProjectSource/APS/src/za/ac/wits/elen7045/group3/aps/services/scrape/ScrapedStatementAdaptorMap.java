package za.ac.wits.elen7045.group3.aps.services.scrape;
/**
 * @author bakwanyana
 */
import za.ac.wits.elen7045.group3.aps.domain.accounts.statement.CreditCardStatement;
import za.ac.wits.elen7045.group3.aps.domain.accounts.statement.MunicipalStatement;
import za.ac.wits.elen7045.group3.aps.domain.accounts.statement.TelcoStatement;
import za.ac.wits.elen7045.group3.aps.domain.vo.DataPair;

public class ScrapedStatementAdaptorMap {
	private StatementScrapedData statement;
	
	public TelcoStatement getTelcoStatement(StatementScrapedData statement, NumericDataFormatter numericData){
		this.statement = statement;
		TelcoStatement telcoAcc = new TelcoStatement(getIndexDataPair("001").getValue());
		telcoAcc.setAccountHolderName(getIndexDataPair("002").getValue());
		telcoAcc.setAccountStatementDate(getIndexDataPair("003").getValue());
		telcoAcc.setAccountStatementNumber(getIndexDataPair("004").getValue());
		telcoAcc.setAccountStatementMonth(getIndexDataPair("005").getValue());
		telcoAcc.setAccountTotalDue(getIndexDataPair("006").getValue());
		telcoAcc.setAccountDueDate(getIndexDataPair("007").getValue());
		telcoAcc.setAccountOpeningBalance(getIndexDataPair("008").getValue());
		telcoAcc.setAccountClosingBalance(getIndexDataPair("009").getValue());
		telcoAcc.setAccountPaymentReceived(getIndexDataPair("010").getValue());
		telcoAcc.setAccountNewCharges(getIndexDataPair("011").getValue());
		telcoAcc.setAccountDeductions(getIndexDataPair("012").getValue());
		telcoAcc.setAccountDiscount(getIndexDataPair("013").getValue());
		telcoAcc.setAccountVATAmount(getIndexDataPair("014").getValue());
		
		telcoAcc.setTelephonenumber(getIndexDataPair("015").getValue());
		telcoAcc.setServiceCharges(getIndexDataPair("016").getValue());
		telcoAcc.setCallCharges(getIndexDataPair("017").getValue());
		telcoAcc.setTotalCustomerCalls(getIndexDataPair("018").getValue());
		telcoAcc.setTotalCallDuration(getIndexDataPair("019").getValue());
		
		return telcoAcc;
	}
	
	public MunicipalStatement getMunicipalStatement(StatementScrapedData statement, NumericDataFormatter numericData){
		this.statement = statement;
		MunicipalStatement municipalAcc = new MunicipalStatement(getIndexDataPair("001").getValue());
		municipalAcc.setAccountHolderName(getIndexDataPair("002").getValue());
		municipalAcc.setAccountStatementDate(getIndexDataPair("003").getValue());
		municipalAcc.setAccountStatementNumber(getIndexDataPair("004").getValue());
		municipalAcc.setAccountStatementMonth(getIndexDataPair("005").getValue());
		municipalAcc.setAccountTotalDue(getIndexDataPair("006").getValue());
		municipalAcc.setAccountDueDate(getIndexDataPair("007").getValue());
		municipalAcc.setAccountOpeningBalance(getIndexDataPair("008").getValue());
		municipalAcc.setAccountClosingBalance(getIndexDataPair("009").getValue());
		municipalAcc.setAccountPaymentReceived(getIndexDataPair("010").getValue());
		municipalAcc.setAccountNewCharges(getIndexDataPair("011").getValue());
		municipalAcc.setAccountDeductions(getIndexDataPair("012").getValue());
		municipalAcc.setAccountDiscount(getIndexDataPair("013").getValue());
		municipalAcc.setAccountVATAmount(getIndexDataPair("014").getValue());
		
		municipalAcc.setInstalmentNotice(getIndexDataPair("015").getValue());
		municipalAcc.setElectricityUsed(getIndexDataPair("016").getValue());
		municipalAcc.setElectricityCharges(getIndexDataPair("017").getValue());
		municipalAcc.setGasUsed(getIndexDataPair("018").getValue());
		municipalAcc.setGasCharges(getIndexDataPair("019").getValue());
		municipalAcc.setWaterUsed(getIndexDataPair("020").getValue());
		municipalAcc.setWaterCharges(getIndexDataPair("021").getValue());
		municipalAcc.setSewerageCharges(getIndexDataPair("022").getValue());
		municipalAcc.setRefuseCharges(getIndexDataPair("023").getValue());
		
		return municipalAcc;
	}
	
	public CreditCardStatement getCreditCardStatement(StatementScrapedData statement, NumericDataFormatter numericDataStrategy){
		this.statement = statement;
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
		for (int i = 0; i < statement.getDataPairList().size(); i++){
			if(statement.getDataPairList().get(i).getId().equals(id))
				return statement.getDataPairList().get(i);
		}
		return null;
	}
}
