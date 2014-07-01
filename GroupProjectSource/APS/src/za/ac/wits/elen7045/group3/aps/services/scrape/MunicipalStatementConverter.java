
package za.ac.wits.elen7045.group3.aps.services.scrape;

import za.ac.wits.elen7045.group3.aps.domain.accounts.statement.MunicipalStatement;
import za.ac.wits.elen7045.group3.aps.domain.entities.BillingAccountStatement;
import za.ac.wits.elen7045.group3.aps.domain.scrape.vo.ScrapedResult;

public class MunicipalStatementConverter extends StatementConverter{
	
	
	public MunicipalStatementConverter(ScrapedResult scrapedStatement) {
		super(scrapedStatement);
	}

	@Override
	public BillingAccountStatement getStatement() {
		MunicipalStatement municipalAcc = new MunicipalStatement(getIndexDataPairValue("001"));
		municipalAcc.setAccountHolderName(getIndexDataPairValue("002"));
		municipalAcc.setAccountStatementDate(getIndexDataPairValue("003"));
		municipalAcc.setAccountStatementNumber(getIndexDataPairValue("004"));
		municipalAcc.setAccountStatementMonth(getIndexDataPairValue("005"));
		municipalAcc.setAccountTotalDue(getIndexDataPairValue("006"));
		municipalAcc.setAccountDueDate(getIndexDataPairValue("007"));
		municipalAcc.setAccountOpeningBalance(getIndexDataPairValue("008"));
		municipalAcc.setAccountClosingBalance(getIndexDataPairValue("009"));
		municipalAcc.setAccountPaymentReceived(getIndexDataPairValue("010"));
		municipalAcc.setAccountNewCharges(getIndexDataPairValue("011"));
		municipalAcc.setAccountDeductions(getIndexDataPairValue("012"));
		municipalAcc.setAccountDiscount(getIndexDataPairValue("013"));
		municipalAcc.setAccountVATAmount(getIndexDataPairValue("014"));
		
		municipalAcc.setInstalmentNotice(getIndexDataPairValue("015"));
		municipalAcc.setElectricityUsed(getIndexDataPairValue("016"));
		municipalAcc.setElectricityCharges(getIndexDataPairValue("017"));
		municipalAcc.setGasUsed(getIndexDataPairValue("018"));
		municipalAcc.setGasCharges(getIndexDataPairValue("019"));
		municipalAcc.setWaterUsed(getIndexDataPairValue("020"));
		municipalAcc.setWaterCharges(getIndexDataPairValue("021"));
		municipalAcc.setSewerageCharges(getIndexDataPairValue("022"));
		municipalAcc.setRefuseCharges(getIndexDataPairValue("023"));
		
		return municipalAcc;
	}
}
