package test.za.ac.wits.elen7045.group3.statement;

import org.junit.Before;
import org.junit.Test;

import za.ac.wits.elen7045.group3.aps.domain.accounts.abtracts.AbstractBillingAccountStatement;
import za.ac.wits.elen7045.group3.aps.domain.accounts.statement.CreditCardStatement;
import za.ac.wits.elen7045.group3.aps.domain.accounts.statement.MunicipalStatement;
import za.ac.wits.elen7045.group3.aps.domain.accounts.statement.TelcoStatement;
import za.ac.wits.elen7045.group3.aps.domain.accounts.statement.gnerator.StatementRenderer;
import za.ac.wits.elen7045.group3.aps.services.util.ApplicationContants;

public class StatementGenerationTest {

	private AbstractBillingAccountStatement billingStatement;
	private MunicipalStatement  municipalStatement;
	private CreditCardStatement creditcardStatement;
	private TelcoStatement telecomStateMent;

	@Before
	public void init(){
		municipalStatement  = new MunicipalStatement("123456789");
		creditcardStatement = new CreditCardStatement("123456789");
		telecomStateMent    = new TelcoStatement("123456789");

	} 

	@Test
	public void generateMuniCipalStatement(){
		municipalStatement.setAccountNumber("123456789");
		municipalStatement.setInstalmentNotice("01002003004");
		municipalStatement.setAccountHolderName("Silas Mahlangu");
		municipalStatement.setElectricityUsed("0 Megawatts");
		municipalStatement.setAccountStatementDate("01/01/2000");
		municipalStatement.setElectricityCharges("3000.00");
		municipalStatement.setGasUsed("2lt");
		municipalStatement.setAccountStatementNumber("332");
		municipalStatement.setGasCharges("R5000");
		municipalStatement.setAccountStatementMonth("01/2000");
		municipalStatement.setWaterUsed("One drop");
		municipalStatement.setWaterCharges("3000.00");
		municipalStatement.setAccountTotalDue("will Calculte");
		municipalStatement.setSewerageCharges("2300.00");
		municipalStatement.setAccountDueDate("05/01/2000");
		municipalStatement.setRefuseCharges("300.00");
		municipalStatement.setAccountPaymentReceived("1000");
		municipalStatement.setAccountNewCharges("Will calculate");
		
		StatementRenderer statement = StatementRenderer.newInstnce();
		statement.createHTHMLStateMent(municipalStatement, 
				                       ApplicationContants.USER_STATEMENT_PATH+"\\"+municipalStatement.getAccountNumber()+"\\"+municipalStatement.getAccountNumber()+".xml");
	} 
}
