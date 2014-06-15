package za.ac.wits.elen7045.group3.aps.services.scrape;

import za.ac.wits.elen7045.group3.aps.domain.accounts.abtracts.AbstractAccount;
import za.ac.wits.elen7045.group3.aps.domain.accounts.accounttypes.Accounts;
import za.ac.wits.elen7045.group3.aps.domain.accounts.accounttypes.CreditCardAccount;
import za.ac.wits.elen7045.group3.aps.domain.accounts.accounttypes.MunicipalAccount;
import za.ac.wits.elen7045.group3.aps.domain.accounts.accounttypes.TelcoAccount;

public class ScrapedAccountAdapter {
	//AbstractAccount creditAcc;
	public static CreditCardAccount getCreditCardAccount(Accounts scrapedAccount){
		CreditCardAccount creditAcc = new CreditCardAccount(scrapedAccount.getDataPairList().get(0).getValue());
		creditAcc.setAccountHolderName(scrapedAccount.getDataPairList().get(1).getValue());
		creditAcc.setAccountStatementDate(scrapedAccount.getDataPairList().get(2).getValue());
		creditAcc.setAccountStatementNumber(scrapedAccount.getDataPairList().get(3).getValue());
		creditAcc.setAccountStatementMonth(scrapedAccount.getDataPairList().get(4).getValue());
		creditAcc.setAccountTotalDue(scrapedAccount.getDataPairList().get(5).getValue());
		creditAcc.setAccountDueDate(scrapedAccount.getDataPairList().get(6).getValue());
		creditAcc.setAccountOpeningBalance(scrapedAccount.getDataPairList().get(7).getValue());
		creditAcc.setAccountClosingBalance(scrapedAccount.getDataPairList().get(8).getValue());
		creditAcc.setAccountPaymentReceived(scrapedAccount.getDataPairList().get(9).getValue());
		creditAcc.setAccountNewCharges(scrapedAccount.getDataPairList().get(10).getValue());
		creditAcc.setAccountDeductions(scrapedAccount.getDataPairList().get(11).getValue());
		creditAcc.setAccountDiscount(scrapedAccount.getDataPairList().get(12).getValue());
		creditAcc.setAccountVATAmount(scrapedAccount.getDataPairList().get(13).getValue());
		creditAcc.setCardType(scrapedAccount.getDataPairList().get(14).getValue());
		creditAcc.setInterestRate(scrapedAccount.getDataPairList().get(15).getValue());
		creditAcc.setCreditLimit(scrapedAccount.getDataPairList().get(16).getValue());
		creditAcc.setCreditAvailable(scrapedAccount.getDataPairList().get(17).getValue());
		creditAcc.setMinimumAmountDue(scrapedAccount.getDataPairList().get(18).getValue());
		return creditAcc;
	}
/*	
	public static MunicipalAccount getMunicipalAccount(Accounts scrapedAccount){
		MunicipalAccount creditAcc = new MunicipalAccount(scrapedAccount.getDataPairList().get(0).getValue());
		creditAcc.setAccountHolderName(scrapedAccount.getDataPairList().get(1).getValue());
		creditAcc.setAccountStatementDate(scrapedAccount.getDataPairList().get(2).getValue());
		creditAcc.setAccountStatementNumber(scrapedAccount.getDataPairList().get(3).getValue());
		creditAcc.setAccountStatementMonth(scrapedAccount.getDataPairList().get(4).getValue());
		creditAcc.setAccountTotalDue(scrapedAccount.getDataPairList().get(5).getValue());
		creditAcc.setAccountDueDate(scrapedAccount.getDataPairList().get(6).getValue());
		creditAcc.setAccountOpeningBalance(scrapedAccount.getDataPairList().get(7).getValue());
		creditAcc.setAccountClosingBalance(scrapedAccount.getDataPairList().get(8).getValue());
		creditAcc.setAccountPaymentReceived(scrapedAccount.getDataPairList().get(9).getValue());
		creditAcc.setAccountNewCharges(scrapedAccount.getDataPairList().get(10).getValue());
		creditAcc.setAccountDeductions(scrapedAccount.getDataPairList().get(11).getValue());
		creditAcc.setAccountDiscount(scrapedAccount.getDataPairList().get(12).getValue());
		creditAcc.setAccountVATAmount(scrapedAccount.getDataPairList().get(13).getValue());
		return creditAcc;
	}
*/
	public static TelcoAccount getTelcoAccount(Accounts scrapedAccount){
		TelcoAccount telcoAcc = new TelcoAccount(scrapedAccount.getDataPairList().get(0).getValue());
		telcoAcc.setAccountHolderName(scrapedAccount.getDataPairList().get(1).getValue());
		telcoAcc.setAccountStatementDate(scrapedAccount.getDataPairList().get(2).getValue());
		telcoAcc.setAccountStatementNumber(scrapedAccount.getDataPairList().get(3).getValue());
		telcoAcc.setAccountStatementMonth(scrapedAccount.getDataPairList().get(4).getValue());
		telcoAcc.setAccountTotalDue(scrapedAccount.getDataPairList().get(5).getValue());
		telcoAcc.setAccountDueDate(scrapedAccount.getDataPairList().get(6).getValue());
		telcoAcc.setAccountOpeningBalance(scrapedAccount.getDataPairList().get(7).getValue());
		telcoAcc.setAccountClosingBalance(scrapedAccount.getDataPairList().get(8).getValue());
		telcoAcc.setAccountPaymentReceived(scrapedAccount.getDataPairList().get(9).getValue());
		telcoAcc.setAccountNewCharges(scrapedAccount.getDataPairList().get(10).getValue());
		telcoAcc.setAccountDeductions(scrapedAccount.getDataPairList().get(11).getValue());
		telcoAcc.setAccountDiscount(scrapedAccount.getDataPairList().get(12).getValue());
		telcoAcc.setAccountVATAmount(scrapedAccount.getDataPairList().get(13).getValue());
		telcoAcc.setTelephonenumber(scrapedAccount.getDataPairList().get(14).getValue());
		telcoAcc.setServiceCharges(scrapedAccount.getDataPairList().get(15).getValue());
		telcoAcc.setCallCharges(scrapedAccount.getDataPairList().get(16).getValue());
		telcoAcc.setTotalCustomerCalls(scrapedAccount.getDataPairList().get(17).getValue());
		telcoAcc.setTotalCallDuration(scrapedAccount.getDataPairList().get(18).getValue());
		return telcoAcc;
	}
}
