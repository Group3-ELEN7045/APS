package za.ac.wits.elen7045.group3.aps.vo.scrape;

import za.ac.wits.elen7045.group3.aps.domain.accounts.statement.MunicipalStatement;

public class MunicipalStatementConverter {
	private ScrapedResult scrapedStatement;
	
	public MunicipalStatementConverter(ScrapedResult scrapeResult){
		this.scrapedStatement = scrapeResult;
	}
	
	public MunicipalStatement getMunicipalStatement(){
		MunicipalStatement municipalAcc = new MunicipalStatement(getIndexDataPair("001"));
		municipalAcc.setAccountHolderName(getIndexDataPair("002"));
		municipalAcc.setAccountStatementDate(getIndexDataPair("003"));
		municipalAcc.setAccountStatementNumber(getIndexDataPair("004"));
		municipalAcc.setAccountStatementMonth(getIndexDataPair("005"));
		municipalAcc.setAccountTotalDue(getIndexDataPair("006"));
		municipalAcc.setAccountDueDate(getIndexDataPair("007"));
		municipalAcc.setAccountOpeningBalance(getIndexDataPair("008"));
		municipalAcc.setAccountClosingBalance(getIndexDataPair("009"));
		municipalAcc.setAccountPaymentReceived(getIndexDataPair("010"));
		municipalAcc.setAccountNewCharges(getIndexDataPair("011"));
		municipalAcc.setAccountDeductions(getIndexDataPair("012"));
		municipalAcc.setAccountDiscount(getIndexDataPair("013"));
		municipalAcc.setAccountVATAmount(getIndexDataPair("014"));
		
		municipalAcc.setInstalmentNotice(getIndexDataPair("015"));
		municipalAcc.setElectricityUsed(getIndexDataPair("016"));
		municipalAcc.setElectricityCharges(getIndexDataPair("017"));
		municipalAcc.setGasUsed(getIndexDataPair("018"));
		municipalAcc.setGasCharges(getIndexDataPair("019"));
		municipalAcc.setWaterUsed(getIndexDataPair("020"));
		municipalAcc.setWaterCharges(getIndexDataPair("021"));
		municipalAcc.setSewerageCharges(getIndexDataPair("022"));
		municipalAcc.setRefuseCharges(getIndexDataPair("023"));
		
		return municipalAcc;
	}
	
	private String getIndexDataPair(String id){
		for (int i = 0; i < scrapedStatement.getDataPairList().size(); i++){
			if(scrapedStatement.getDataPairList().get(i).getId().equals(id))
				return scrapedStatement.getDataPairList().get(i).getValue();
		}
		return null;
	}
}
