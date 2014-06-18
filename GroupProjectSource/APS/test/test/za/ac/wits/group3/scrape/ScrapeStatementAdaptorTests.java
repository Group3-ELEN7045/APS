package test.za.ac.wits.group3.scrape;

import static org.junit.Assert.*;    

import java.util.ArrayList;
import java.util.List;

import org.junit.After;  
import org.junit.Before;  
import org.junit.Test;  

import za.ac.wits.elen7045.group3.aps.domain.accounts.statement.*;
import za.ac.wits.elen7045.group3.aps.domain.vo.DataPair;
import za.ac.wits.elen7045.group3.aps.services.enumtypes.CompanyStatementType;
import za.ac.wits.elen7045.group3.aps.services.scrape.ScrapedStatementAdaptor;
import za.ac.wits.elen7045.group3.aps.services.util.DuplicateDataException;
import za.ac.wits.elen7045.group3.aps.services.util.ScrapeErrorException;
import za.ac.wits.elen7045.group3.aps.services.util.StatementScrapedData;
import za.ac.wits.elen7045.group3.aps.services.util.VatCalculationException;

public class ScrapeStatementAdaptorTests {
	
	ScrapedStatementAdaptor statementAdaptor;
	TelcoStatement telcoObject;
	CreditCardStatement creditCardObject;
	MunicipalStatement municipalObject;
	StatementScrapedData scrapedStatement;
	List<DataPair> dataPairs;
	
	@Before
	public void init(){
		scrapedStatement = new StatementScrapedData();
		
		dataPairs = new ArrayList<DataPair>();
		
		dataPairs.add(new DataPair("001","qaz","123456789"));
		dataPairs.add(new DataPair("002","qaz","Jack Parcell"));
		dataPairs.add(new DataPair("003","qaz","12/12/2014"));
		dataPairs.add(new DataPair("004","qaz","1122"));
		dataPairs.add(new DataPair("005","qaz","2"));
		dataPairs.add(new DataPair("006","qaz","R340"));
		dataPairs.add(new DataPair("007","qaz","01/01/2015"));
		dataPairs.add(new DataPair("008","qaz","R120"));
		dataPairs.add(new DataPair("009","qaz","R123"));
		dataPairs.add(new DataPair("010","qaz","R40"));
		dataPairs.add(new DataPair("011","qaz","R100"));
		dataPairs.add(new DataPair("012","qaz","R123"));
		dataPairs.add(new DataPair("013","qaz","R456"));
		dataPairs.add(new DataPair("014","qaz","R14.0"));
	}
	@After
	public void tearDown(){
		telcoObject = null;
		dataPairs = null;
		creditCardObject = null;
		municipalObject = null;
	}
	@Test
	public void telcoAccountScrape() throws Exception{
		
		dataPairs.add(new DataPair("015","qaz","0721231232"));
		dataPairs.add(new DataPair("016","qaz","R90"));
		dataPairs.add(new DataPair("017","qaz","R100"));
		dataPairs.add(new DataPair("018","qaz","23"));
		dataPairs.add(new DataPair("019","qaz","120mins"));
		
		scrapedStatement.setDataPairList(dataPairs);
		
		statementAdaptor = new ScrapedStatementAdaptor(scrapedStatement, CompanyStatementType.TELCO);
		telcoObject = (TelcoStatement)statementAdaptor.getStatement();

		assertTrue(telcoObject.getClass().equals(TelcoStatement.class));
		assertTrue("Account number error",telcoObject.getAccountNumber().equals(scrapedStatement.getDataPairList().get(0).getValue()));	
		assertTrue("Account holder name",telcoObject.getAccountHolderName().equals(scrapedStatement.getDataPairList().get(1).getValue()));
		assertTrue("Statement date error",telcoObject.getAccountStatementDate().equals(scrapedStatement.getDataPairList().get(2).getValue()));
		assertTrue("Statement number error",telcoObject.getAccountStatementNumber().equals(scrapedStatement.getDataPairList().get(3).getValue()));
		assertTrue("Statement month error",telcoObject.getAccountStatementMonth().equals(scrapedStatement.getDataPairList().get(4).getValue()));
		assertTrue("Total due error",telcoObject.getAccountTotalDue().equals(scrapedStatement.getDataPairList().get(5).getValue()));
		assertTrue("Due date error",telcoObject.getAccountDueDate().equals(scrapedStatement.getDataPairList().get(6).getValue()));
		assertTrue("Opening balance error",telcoObject.getAccountOpeningBalance().equals(scrapedStatement.getDataPairList().get(7).getValue()));
		assertTrue("Closing balance error",telcoObject.getAccountClosingBalance().equals(scrapedStatement.getDataPairList().get(8).getValue()));
		assertTrue("Payment received error",telcoObject.getAccountPaymentReceived().equals(scrapedStatement.getDataPairList().get(9).getValue()));
		assertTrue("New charges error",telcoObject.getAccountNewCharges().equals(scrapedStatement.getDataPairList().get(10).getValue()));
		assertTrue("Deductions error",telcoObject.getAccountDeductions().equals(scrapedStatement.getDataPairList().get(11).getValue()));
		assertTrue("Discount error",telcoObject.getAccountDiscount().equals(scrapedStatement.getDataPairList().get(12).getValue()));
		assertTrue("VAT amount error",telcoObject.getAccountVATAmount().equals(scrapedStatement.getDataPairList().get(13).getValue()));
		
		assertTrue("Telephone number error",telcoObject.getTelephonenumber().equals(scrapedStatement.getDataPairList().get(14).getValue()));
		assertTrue("Service charges error",telcoObject.getServiceCharges().equals(scrapedStatement.getDataPairList().get(15).getValue()));
		assertTrue("Call charges error",telcoObject.getCallCharges().equals(scrapedStatement.getDataPairList().get(16).getValue()));
		assertTrue("Total number of calls error",telcoObject.getTotalCustomerCalls().equals(scrapedStatement.getDataPairList().get(17).getValue()));
		assertTrue("Total call duration error",telcoObject.getTotalCallDuration().equals(scrapedStatement.getDataPairList().get(18).getValue()));
	}
	
	@Test 
	public void municipalAccountScrape() throws Exception{
		dataPairs.add(new DataPair("015","qaz","10"));
		dataPairs.add(new DataPair("016","qaz","200kW"));
		dataPairs.add(new DataPair("017","qaz","R100"));
		dataPairs.add(new DataPair("018","qaz","400Btu"));
		dataPairs.add(new DataPair("019","qaz","R100"));
		dataPairs.add(new DataPair("020","qaz","300Kl"));
		dataPairs.add(new DataPair("021","qaz","R456"));
		dataPairs.add(new DataPair("022","qaz","R345"));
		dataPairs.add(new DataPair("023","qaz","R123"));
		
		scrapedStatement.setDataPairList(dataPairs);
		
		statementAdaptor = new ScrapedStatementAdaptor(scrapedStatement, CompanyStatementType.MUNICIPALITY);
		municipalObject = (MunicipalStatement)statementAdaptor.getStatement();
		
		assertTrue(municipalObject.getClass().equals(MunicipalStatement.class));
		assertTrue("Account number error",municipalObject.getAccountNumber().equals(scrapedStatement.getDataPairList().get(0).getValue()));	
		assertTrue("Account holder name",municipalObject.getAccountHolderName().equals(scrapedStatement.getDataPairList().get(1).getValue()));
		assertTrue("Statement date error",municipalObject.getAccountStatementDate().equals(scrapedStatement.getDataPairList().get(2).getValue()));
		assertTrue("Statement number error",municipalObject.getAccountStatementNumber().equals(scrapedStatement.getDataPairList().get(3).getValue()));
		assertTrue("Statement month error",municipalObject.getAccountStatementMonth().equals(scrapedStatement.getDataPairList().get(4).getValue()));
		assertTrue("Total due error",municipalObject.getAccountTotalDue().equals(scrapedStatement.getDataPairList().get(5).getValue()));
		assertTrue("Due date error",municipalObject.getAccountDueDate().equals(scrapedStatement.getDataPairList().get(6).getValue()));
		assertTrue("Opening balance error",municipalObject.getAccountOpeningBalance().equals(scrapedStatement.getDataPairList().get(7).getValue()));
		assertTrue("Closing balance error",municipalObject.getAccountClosingBalance().equals(scrapedStatement.getDataPairList().get(8).getValue()));
		assertTrue("Payment received error",municipalObject.getAccountPaymentReceived().equals(scrapedStatement.getDataPairList().get(9).getValue()));
		assertTrue("New charges error",municipalObject.getAccountNewCharges().equals(scrapedStatement.getDataPairList().get(10).getValue()));
		assertTrue("Deductions error",municipalObject.getAccountDeductions().equals(scrapedStatement.getDataPairList().get(11).getValue()));
		assertTrue("Discount error",municipalObject.getAccountDiscount().equals(scrapedStatement.getDataPairList().get(12).getValue()));
		assertTrue("VAT amount error",municipalObject.getAccountVATAmount().equals(scrapedStatement.getDataPairList().get(13).getValue()));
		
		assertTrue("Instalment notice error",municipalObject.getInstalmentNotice().equals(scrapedStatement.getDataPairList().get(14).getValue()));
		assertTrue("Electricity used error",municipalObject.getElectricityUsed().equals(scrapedStatement.getDataPairList().get(15).getValue()));
		assertTrue("Electricity charges error",municipalObject.getElectricityCharges().equals(scrapedStatement.getDataPairList().get(16).getValue()));
		assertTrue("Gas used error",municipalObject.getGasUsed().equals(scrapedStatement.getDataPairList().get(17).getValue()));
		assertTrue("Gas charges due",municipalObject.getGasCharges().equals(scrapedStatement.getDataPairList().get(18).getValue()));
		assertTrue("Water used error",municipalObject.getWaterUsed().equals(scrapedStatement.getDataPairList().get(19).getValue()));
		assertTrue("Water charges error",municipalObject.getWaterCharges().equals(scrapedStatement.getDataPairList().get(20).getValue()));
		assertTrue("Sewerage charges error",municipalObject.getSewerageCharges().equals(scrapedStatement.getDataPairList().get(21).getValue()));
		assertTrue("Refuse charges error",municipalObject.getRefuseCharges().equals(scrapedStatement.getDataPairList().get(22).getValue()));
		
	}
	
	@Test
	public void creditCardAccountScrape() throws Exception{
		
		dataPairs.add(new DataPair("015","qaz","Visa"));
		dataPairs.add(new DataPair("016","qaz","12%"));
		dataPairs.add(new DataPair("017","qaz","R20000"));
		dataPairs.add(new DataPair("018","qaz","R4500"));
		dataPairs.add(new DataPair("019","qaz","R90"));
		
		scrapedStatement.setDataPairList(dataPairs);
		
		statementAdaptor = new ScrapedStatementAdaptor(scrapedStatement, CompanyStatementType.CREDITCARD);
		creditCardObject = (CreditCardStatement)statementAdaptor.getStatement();
		
		assertTrue(creditCardObject.getClass().equals(CreditCardStatement.class));
		assertTrue("Account number error",creditCardObject.getAccountNumber().equals(scrapedStatement.getDataPairList().get(0).getValue()));	
		assertTrue("Account holder name",creditCardObject.getAccountHolderName().equals(scrapedStatement.getDataPairList().get(1).getValue()));
		assertTrue("Statement date error",creditCardObject.getAccountStatementDate().equals(scrapedStatement.getDataPairList().get(2).getValue()));
		assertTrue("Statement number error",creditCardObject.getAccountStatementNumber().equals(scrapedStatement.getDataPairList().get(3).getValue()));
		assertTrue("Statement month error",creditCardObject.getAccountStatementMonth().equals(scrapedStatement.getDataPairList().get(4).getValue()));
		assertTrue("Total due error",creditCardObject.getAccountTotalDue().equals(scrapedStatement.getDataPairList().get(5).getValue()));
		assertTrue("Due date error",creditCardObject.getAccountDueDate().equals(scrapedStatement.getDataPairList().get(6).getValue()));
		assertTrue("Opening balance error",creditCardObject.getAccountOpeningBalance().equals(scrapedStatement.getDataPairList().get(7).getValue()));
		assertTrue("Closing balance error",creditCardObject.getAccountClosingBalance().equals(scrapedStatement.getDataPairList().get(8).getValue()));
		assertTrue("Payment received error",creditCardObject.getAccountPaymentReceived().equals(scrapedStatement.getDataPairList().get(9).getValue()));
		assertTrue("New charges error",creditCardObject.getAccountNewCharges().equals(scrapedStatement.getDataPairList().get(10).getValue()));
		assertTrue("Deductions error",creditCardObject.getAccountDeductions().equals(scrapedStatement.getDataPairList().get(11).getValue()));
		assertTrue("Discount error",creditCardObject.getAccountDiscount().equals(scrapedStatement.getDataPairList().get(12).getValue()));
		assertTrue("VAT amount error",creditCardObject.getAccountVATAmount().equals(scrapedStatement.getDataPairList().get(13).getValue()));
		
		assertTrue("Card type error",creditCardObject.getCardType().equals(scrapedStatement.getDataPairList().get(14).getValue()));
		assertTrue("Interest rate error",creditCardObject.getInterestRate().equals(scrapedStatement.getDataPairList().get(15).getValue()));
		assertTrue("Credit limit error",creditCardObject.getCreditLimit().equals(scrapedStatement.getDataPairList().get(16).getValue()));
		assertTrue("Credit available error",creditCardObject.getCreditAvailable().equals(scrapedStatement.getDataPairList().get(17).getValue()));
		assertTrue("Minimum amount due",creditCardObject.getMinimumAmountDue().equals(scrapedStatement.getDataPairList().get(18).getValue()));
	}
	
	@Test(expected=DuplicateDataException.class)
	public void duplicateDataException() throws Exception{
		StatementScrapedData cc = new StatementScrapedData();
		ArrayList<DataPair> dataPairsFalse = new ArrayList<DataPair>();
			
		dataPairsFalse.add(new DataPair("001","qaz","123456789"));
		dataPairsFalse.add(new DataPair("002","qaz","Jack Parcell"));
		dataPairsFalse.add(new DataPair("001","qaz","12/12/2014"));
		dataPairsFalse.add(new DataPair("004","qaz","1122"));
		dataPairsFalse.add(new DataPair("005","qaz","2"));
		cc.setDataPairList(dataPairsFalse);
		
		statementAdaptor = new ScrapedStatementAdaptor(cc, CompanyStatementType.CREDITCARD);
		
	}
	
	@Test(expected=VatCalculationException.class)
	public void vatCalculationException() throws Exception{
		dataPairs = new ArrayList<DataPair>();
		
		dataPairs.add(new DataPair("001","qaz","123456789"));
		dataPairs.add(new DataPair("002","qaz","Jack Parcell"));
		dataPairs.add(new DataPair("003","qaz","12/12/2014"));
		dataPairs.add(new DataPair("004","qaz","1122"));
		dataPairs.add(new DataPair("005","qaz","2"));
		dataPairs.add(new DataPair("006","qaz","R340"));
		dataPairs.add(new DataPair("007","qaz","01/01/2015"));
		dataPairs.add(new DataPair("008","qaz","R120"));
		dataPairs.add(new DataPair("009","qaz","R123"));
		dataPairs.add(new DataPair("010","qaz","R40"));
		dataPairs.add(new DataPair("011","qaz","R450000"));
		dataPairs.add(new DataPair("012","qaz","R123"));
		dataPairs.add(new DataPair("013","qaz","R456"));
		dataPairs.add(new DataPair("014","qaz","R123"));
		
		dataPairs.add(new DataPair("015","qaz","Visa"));
		dataPairs.add(new DataPair("016","qaz","12%"));
		dataPairs.add(new DataPair("017","qaz","R20000"));
		dataPairs.add(new DataPair("018","qaz","R4500"));
		dataPairs.add(new DataPair("019","qaz","R90"));
		
		scrapedStatement.setDataPairList(dataPairs);
		
		statementAdaptor = new ScrapedStatementAdaptor(scrapedStatement, CompanyStatementType.CREDITCARD);
		creditCardObject = (CreditCardStatement)statementAdaptor.getStatement();
	}
	
	@Test(expected=ScrapeErrorException.class)
	public void scrapeErrorException() throws Exception{
		dataPairs = new ArrayList<DataPair>();
		dataPairs.add(new DataPair("001","Scrape Error","InvalidCredentials"));
		
		scrapedStatement.setDataPairList(dataPairs);
		
		statementAdaptor = new ScrapedStatementAdaptor(scrapedStatement, CompanyStatementType.CREDITCARD);
	}
}
