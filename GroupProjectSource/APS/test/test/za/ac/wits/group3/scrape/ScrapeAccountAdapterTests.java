package test.za.ac.wits.group3.scrape;

import static org.junit.Assert.*;    

import java.util.ArrayList;
import java.util.List;

import org.junit.After;  
import org.junit.Before;  
import org.junit.Test;  
import org.junit.runner.RunWith;  
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;  

import static org.mockito.Mockito.*;
import za.ac.wits.elen7045.group3.aps.domain.accounts.accounttypes.Accounts;
import za.ac.wits.elen7045.group3.aps.domain.accounts.accounttypes.CreditCardAccount;
import za.ac.wits.elen7045.group3.aps.domain.accounts.accounttypes.TelcoAccount;
import za.ac.wits.elen7045.group3.aps.domain.vo.DataPair;
import za.ac.wits.elen7045.group3.aps.services.util.ScrapedAccountAdapter;

@RunWith(MockitoJUnitRunner.class)
public class ScrapeAccountAdapterTests {
	
	TelcoAccount telcoObject;
	CreditCardAccount creditCardObject;
	@Mock Accounts scrapedAccount;
	List<DataPair> dataPairs;
	
	@Before
	public void init(){
		dataPairs = mock(ArrayList.class);
		when(scrapedAccount.getDataPairList()).thenReturn(dataPairs);
		when(dataPairs.get(0)).thenReturn(new DataPair("001","qaz","123456789"));
		when(dataPairs.get(1)).thenReturn(new DataPair("002","qaz","Jack Parcell"));
		when(dataPairs.get(2)).thenReturn(new DataPair("003","qaz","12/12/2014"));
		when(dataPairs.get(3)).thenReturn(new DataPair("004","qaz","1122"));
		when(dataPairs.get(4)).thenReturn(new DataPair("005","qaz","2"));
		when(dataPairs.get(5)).thenReturn(new DataPair("006","qaz","R340"));
		when(dataPairs.get(6)).thenReturn(new DataPair("007","qaz","01/01/2015"));
		when(dataPairs.get(7)).thenReturn(new DataPair("008","qaz","R120"));
		when(dataPairs.get(8)).thenReturn(new DataPair("009","qaz","R123"));
		when(dataPairs.get(9)).thenReturn(new DataPair("000","qaz","R40"));
		when(dataPairs.get(10)).thenReturn(new DataPair("011","qaz","R45"));
		when(dataPairs.get(11)).thenReturn(new DataPair("012","qaz","R123"));
		when(dataPairs.get(12)).thenReturn(new DataPair("013","qaz","R456"));
		when(dataPairs.get(13)).thenReturn(new DataPair("014","qaz","R123"));
	}
	@After
	public void tearDown(){
		telcoObject = null;
		dataPairs = null;
		creditCardObject = null;
	}
	@Test
	public void telcoAccountScrape(){
		
		when(dataPairs.get(14)).thenReturn(new DataPair("015","qaz","0721231232"));
		when(dataPairs.get(15)).thenReturn(new DataPair("016","qaz","R90"));
		when(dataPairs.get(16)).thenReturn(new DataPair("017","qaz","R100"));
		when(dataPairs.get(17)).thenReturn(new DataPair("018","qaz","23"));
		when(dataPairs.get(18)).thenReturn(new DataPair("019","qaz","120mins"));
		
		telcoObject = ScrapedAccountAdapter.getTelcoAccount(scrapedAccount);
		
		assertTrue(telcoObject.getClass().equals(TelcoAccount.class));
		assertTrue("Account number error",telcoObject.getAccountNumber().equals(scrapedAccount.getDataPairList().get(0).getValue()));	
		assertTrue("Account holder name",telcoObject.getAccountHolderName().equals(scrapedAccount.getDataPairList().get(1).getValue()));
		assertTrue("Statement date error",telcoObject.getAccountStatementDate().equals(scrapedAccount.getDataPairList().get(2).getValue()));
		assertTrue("Statement number error",telcoObject.getAccountStatementNumber().equals(scrapedAccount.getDataPairList().get(3).getValue()));
		assertTrue("Statement month error",telcoObject.getAccountStatementMonth().equals(scrapedAccount.getDataPairList().get(4).getValue()));
		assertTrue("Total due error",telcoObject.getAccountTotalDue().equals(scrapedAccount.getDataPairList().get(5).getValue()));
		assertTrue("Due date error",telcoObject.getAccountDueDate().equals(scrapedAccount.getDataPairList().get(6).getValue()));
		assertTrue("Opening balance error",telcoObject.getAccountOpeningBalance().equals(scrapedAccount.getDataPairList().get(7).getValue()));
		assertTrue("Closing balance error",telcoObject.getAccountClosingBalance().equals(scrapedAccount.getDataPairList().get(8).getValue()));
		assertTrue("Payment received error",telcoObject.getAccountPaymentReceived().equals(scrapedAccount.getDataPairList().get(9).getValue()));
		assertTrue("New charges error",telcoObject.getAccountNewCharges().equals(scrapedAccount.getDataPairList().get(10).getValue()));
		assertTrue("Deductions error",telcoObject.getAccountDeductions().equals(scrapedAccount.getDataPairList().get(11).getValue()));
		assertTrue("Discount error",telcoObject.getAccountDiscount().equals(scrapedAccount.getDataPairList().get(12).getValue()));
		assertTrue("VAT amount error",telcoObject.getAccountVATAmount().equals(scrapedAccount.getDataPairList().get(13).getValue()));
		
		assertTrue("Telephone number error",telcoObject.getTelephonenumber().equals(scrapedAccount.getDataPairList().get(14).getValue()));
		assertTrue("Service charges error",telcoObject.getServiceCharges().equals(scrapedAccount.getDataPairList().get(15).getValue()));
		assertTrue("Call charges error",telcoObject.getCallCharges().equals(scrapedAccount.getDataPairList().get(16).getValue()));
		assertTrue("Total number of calls error",telcoObject.getTotalCustomerCalls().equals(scrapedAccount.getDataPairList().get(17).getValue()));
		assertTrue("Total call duration error",telcoObject.getTotalCallDuration().equals(scrapedAccount.getDataPairList().get(18).getValue()));
	}
	/*
	@Test 
	public void municipalAccountScrape(){
		
	}
	*/
	@Test
	public void creditCardAccountScrape(){
		
		when(dataPairs.get(14)).thenReturn(new DataPair("015","qaz","Visa"));
		when(dataPairs.get(15)).thenReturn(new DataPair("016","qaz","12%"));
		when(dataPairs.get(16)).thenReturn(new DataPair("017","qaz","R20000"));
		when(dataPairs.get(17)).thenReturn(new DataPair("018","qaz","R4500"));
		when(dataPairs.get(18)).thenReturn(new DataPair("019","qaz","R90"));
		
		creditCardObject = ScrapedAccountAdapter.getCreditCardAccount(scrapedAccount);
		
		assertTrue(creditCardObject.getClass().equals(CreditCardAccount.class));
		assertTrue("Account number error",creditCardObject.getAccountNumber().equals(scrapedAccount.getDataPairList().get(0).getValue()));	
		assertTrue("Account holder name",creditCardObject.getAccountHolderName().equals(scrapedAccount.getDataPairList().get(1).getValue()));
		assertTrue("Statement date error",creditCardObject.getAccountStatementDate().equals(scrapedAccount.getDataPairList().get(2).getValue()));
		assertTrue("Statement number error",creditCardObject.getAccountStatementNumber().equals(scrapedAccount.getDataPairList().get(3).getValue()));
		assertTrue("Statement month error",creditCardObject.getAccountStatementMonth().equals(scrapedAccount.getDataPairList().get(4).getValue()));
		assertTrue("Total due error",creditCardObject.getAccountTotalDue().equals(scrapedAccount.getDataPairList().get(5).getValue()));
		assertTrue("Due date error",creditCardObject.getAccountDueDate().equals(scrapedAccount.getDataPairList().get(6).getValue()));
		assertTrue("Opening balance error",creditCardObject.getAccountOpeningBalance().equals(scrapedAccount.getDataPairList().get(7).getValue()));
		assertTrue("Closing balance error",creditCardObject.getAccountClosingBalance().equals(scrapedAccount.getDataPairList().get(8).getValue()));
		assertTrue("Payment received error",creditCardObject.getAccountPaymentReceived().equals(scrapedAccount.getDataPairList().get(9).getValue()));
		assertTrue("New charges error",creditCardObject.getAccountNewCharges().equals(scrapedAccount.getDataPairList().get(10).getValue()));
		assertTrue("Deductions error",creditCardObject.getAccountDeductions().equals(scrapedAccount.getDataPairList().get(11).getValue()));
		assertTrue("Discount error",creditCardObject.getAccountDiscount().equals(scrapedAccount.getDataPairList().get(12).getValue()));
		assertTrue("VAT amount error",creditCardObject.getAccountVATAmount().equals(scrapedAccount.getDataPairList().get(13).getValue()));
		
		assertTrue("Card type error",creditCardObject.getCardType().equals(scrapedAccount.getDataPairList().get(14).getValue()));
		assertTrue("Interest rate error",creditCardObject.getInterestRate().equals(scrapedAccount.getDataPairList().get(15).getValue()));
		assertTrue("Credit limit error",creditCardObject.getCreditLimit().equals(scrapedAccount.getDataPairList().get(16).getValue()));
		assertTrue("Credit available error",creditCardObject.getCreditAvailable().equals(scrapedAccount.getDataPairList().get(17).getValue()));
		assertTrue("Minimum amount due",creditCardObject.getMinimumAmountDue().equals(scrapedAccount.getDataPairList().get(18).getValue()));
	}
}
