package za.ac.wits.elen7045.group3.aps.services.scrape;

import za.ac.wits.elen7045.group3.aps.domain.accounts.statement.CreditCardStatement;
import za.ac.wits.elen7045.group3.aps.domain.accounts.statement.MunicipalStatement;
import za.ac.wits.elen7045.group3.aps.domain.accounts.statement.TelcoStatement;
import za.ac.wits.elen7045.group3.aps.services.specification.scrape.DuplicateStatementDataSpecification;
import za.ac.wits.elen7045.group3.aps.services.specification.scrape.VATCalculationSpecification;
import za.ac.wits.elen7045.group3.aps.services.util.DuplicateDataException;
import za.ac.wits.elen7045.group3.aps.services.util.ScrapeErrorException;
import za.ac.wits.elen7045.group3.aps.services.util.StatementScrapedData;
import za.ac.wits.elen7045.group3.aps.services.util.VatCalculationException;

//review


public class ScrapedStatementAdaptor {
	
	private StatementScrapedData scrapedAccount;
	DuplicateStatementDataSpecification duplicateSpec;
	VATCalculationSpecification vatSpec;
	
	public ScrapedStatementAdaptor(StatementScrapedData scrapedAccount) 
			throws DuplicateDataException, ScrapeErrorException{
		
		this.scrapedAccount = scrapedAccount;
		duplicateSpec = new DuplicateStatementDataSpecification();
		vatSpec = new VATCalculationSpecification(14);
		
		if(!duplicateSpec.isSatisfiedBy(scrapedAccount))
			throw new DuplicateDataException();
		
		if(scrapedAccount.getDataPairList().size() == 1)
			throw new ScrapeErrorException(scrapedAccount.getDataPairList().get(0).getValue());
	}
	
	public CreditCardStatement getCreditCardAccount() throws VatCalculationException{
		
		CreditCardStatement creditAcc = ScrapedStatementAdaptorMap.getCreditCardStatement(scrapedAccount);
		
		if (!vatSpec.isSatisfiedBy(creditAcc))
			throw new VatCalculationException();
		
		return creditAcc;
	}
	
	public MunicipalStatement getMunicipalAccount() throws VatCalculationException{
		
		MunicipalStatement municipalAcc = ScrapedStatementAdaptorMap.getMunicipalStatement(scrapedAccount);
		
		if (!vatSpec.isSatisfiedBy(municipalAcc))
			throw new VatCalculationException();
		
		return municipalAcc;
	}

	public TelcoStatement getTelcoAccount() throws VatCalculationException{
		
		TelcoStatement telcoAcc = ScrapedStatementAdaptorMap.getTelcoStatement(scrapedAccount);
		
		if (!vatSpec.isSatisfiedBy(telcoAcc))
			throw new VatCalculationException();
		
		return telcoAcc;
	}
	
}
