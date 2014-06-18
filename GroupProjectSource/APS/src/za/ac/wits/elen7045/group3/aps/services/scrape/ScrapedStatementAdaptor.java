package za.ac.wits.elen7045.group3.aps.services.scrape;

import za.ac.wits.elen7045.group3.aps.domain.accounts.abtracts.AbstractBillingAccountStatement;
import za.ac.wits.elen7045.group3.aps.domain.accounts.statement.CreditCardStatement;
import za.ac.wits.elen7045.group3.aps.domain.accounts.statement.MunicipalStatement;
import za.ac.wits.elen7045.group3.aps.domain.accounts.statement.TelcoStatement;
import za.ac.wits.elen7045.group3.aps.services.enumtypes.CompanyStatementType;
import za.ac.wits.elen7045.group3.aps.services.specification.scrape.DuplicateStatementDataSpecification;
import za.ac.wits.elen7045.group3.aps.services.specification.scrape.VATCalculationSpecification;
import za.ac.wits.elen7045.group3.aps.services.util.DuplicateDataException;
import za.ac.wits.elen7045.group3.aps.services.util.ScrapeErrorException;
import za.ac.wits.elen7045.group3.aps.services.util.StatementScrapedData;
import za.ac.wits.elen7045.group3.aps.services.util.VatCalculationException;

//review


public class ScrapedStatementAdaptor {
	
	private StatementScrapedData scrapedAccount;
	private DuplicateStatementDataSpecification duplicateSpec;
	private VATCalculationSpecification vatSpec;
	private CompanyStatementType companyStatementType;
	
	public ScrapedStatementAdaptor(StatementScrapedData scrapedAccount, CompanyStatementType companyStatementType) 
			throws DuplicateDataException, ScrapeErrorException{
		
		this.scrapedAccount = scrapedAccount;
		this.companyStatementType = companyStatementType;
		
		duplicateSpec = new DuplicateStatementDataSpecification();
		
		vatSpec = new VATCalculationSpecification(14);
		
		if(!duplicateSpec.isSatisfiedBy(scrapedAccount))
			throw new DuplicateDataException();
		
		if(scrapedAccount.getDataPairList().size() == 1)
			throw new ScrapeErrorException(scrapedAccount.getDataPairList().get(0).getValue());
	}
	
	public AbstractBillingAccountStatement getStatement()
				throws VatCalculationException{
		if (companyStatementType.equals(CompanyStatementType.CREDITCARD))
			return getCreditCardStatement();
		else if (companyStatementType.equals(CompanyStatementType.MUNICIPALITY))
			return getMunicipalStatement();
		else
			return getTelcoStatement();
	}
	
	private CreditCardStatement getCreditCardStatement() throws VatCalculationException{
		
		CreditCardStatement creditAcc = ScrapedStatementAdaptorMap.getCreditCardStatement(scrapedAccount);
		
		if (!vatSpec.isSatisfiedBy(creditAcc))
			throw new VatCalculationException();
		
		return creditAcc;
	}
	
	private MunicipalStatement getMunicipalStatement() throws VatCalculationException{
		
		MunicipalStatement municipalAcc = ScrapedStatementAdaptorMap.getMunicipalStatement(scrapedAccount);
		
		if (!vatSpec.isSatisfiedBy(municipalAcc))
			throw new VatCalculationException();
		
		return municipalAcc;
	}

	private TelcoStatement getTelcoStatement() throws VatCalculationException{
		
		TelcoStatement telcoAcc = ScrapedStatementAdaptorMap.getTelcoStatement(scrapedAccount);
		
		if (!vatSpec.isSatisfiedBy(telcoAcc))
			throw new VatCalculationException();
		
		return telcoAcc;
	}
	
}
