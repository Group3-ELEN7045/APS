package za.ac.wits.elen7045.group3.aps.vo.scrape;
/**
 * @author bakwanyana
 */
import za.ac.wits.elen7045.group3.aps.domain.accounts.abtracts.AbstractBillingAccountStatement;
import za.ac.wits.elen7045.group3.aps.domain.accounts.statement.CreditCardStatement;
import za.ac.wits.elen7045.group3.aps.domain.accounts.statement.MunicipalStatement;
import za.ac.wits.elen7045.group3.aps.domain.accounts.statement.TelcoStatement;
import za.ac.wits.elen7045.group3.aps.services.enumtypes.CompanyStatementType;
import za.ac.wits.elen7045.group3.aps.services.specification.Specification;
import za.ac.wits.elen7045.group3.aps.vo.exception.scrape.DataIntegrityException;
import za.ac.wits.elen7045.group3.aps.vo.exception.scrape.DuplicateDataException;
import za.ac.wits.elen7045.group3.aps.vo.exception.scrape.ScrapeErrorException;
import za.ac.wits.elen7045.group3.aps.vo.exception.scrape.VatCalculationException;
import za.ac.wits.elen7045.group3.aps.vo.specification.scrape.DuplicateStatementDataSpecification;
import za.ac.wits.elen7045.group3.aps.vo.specification.scrape.GenericStatementDataAdditionSpecification;
import za.ac.wits.elen7045.group3.aps.vo.specification.scrape.MunicipalStatementDataAdditionSpecification;
import za.ac.wits.elen7045.group3.aps.vo.specification.scrape.StatementVATCalculationSpecification;
import za.ac.wits.elen7045.group3.aps.vo.specification.scrape.TelcoStatementDataAdditionSpecification;

public class ScrapedStatementConverter {
	
	private StatementScrapedData scrapedAccount;
	private DuplicateStatementDataSpecification duplicateSpec;
	private StatementVATCalculationSpecification vatSpec;
	private CompanyStatementType companyStatementType;
	private NumericDataFormatter numericDataConverter;
	private MunicipalStatementDataAdditionSpecification municipalAddSpec;
	private TelcoStatementDataAdditionSpecification telcoAddSpec;
	private GenericStatementDataAdditionSpecification genericAddSpec;
	private Specification<AbstractBillingAccountStatement> stateMentAddSpec;
	
	public ScrapedStatementConverter(StatementScrapedData scrapedAccount, CompanyStatementType companyStatementType,
			INumericDataFormatStrategy numericConvertStrategy) 
			throws DuplicateDataException, ScrapeErrorException{
		
		this.scrapedAccount = scrapedAccount;
		this.companyStatementType = companyStatementType;
		this.numericDataConverter = new NumericDataFormatter(numericConvertStrategy);
		duplicateSpec = new DuplicateStatementDataSpecification();
		municipalAddSpec = new MunicipalStatementDataAdditionSpecification();
		telcoAddSpec = new TelcoStatementDataAdditionSpecification();
		genericAddSpec = new GenericStatementDataAdditionSpecification();
		
		vatSpec = new StatementVATCalculationSpecification(14, numericDataConverter);
		
		if(!duplicateSpec.isSatisfiedBy(scrapedAccount))
			throw new DuplicateDataException();
		
		if(scrapedAccount.getDataPairList().size() == 1)
			throw new ScrapeErrorException(scrapedAccount.getDataPairList().get(0).getValue());
	}
	
	public AbstractBillingAccountStatement getStatement() 
			throws VatCalculationException, DataIntegrityException{
		if (companyStatementType.equals(CompanyStatementType.CREDITCARD))
			return getCreditCardStatement();
		else if (companyStatementType.equals(CompanyStatementType.MUNICIPALITY))
			return getMunicipalStatement();
		else
			return getTelcoStatement();
	}
	
	private CreditCardStatement getCreditCardStatement() 
			throws DataIntegrityException,VatCalculationException{
		
		CreditCardStatement creditAcc = new ScrapedStatementConverterMap().getCreditCardStatement(scrapedAccount,numericDataConverter);
		
		stateMentAddSpec = new GenericStatementDataAdditionSpecification();
		
		if(!stateMentAddSpec.isSatisfiedBy(creditAcc))
			throw new DataIntegrityException(creditAcc.getAccountNumber());
		
		if (!vatSpec.isSatisfiedBy(creditAcc))
			throw new VatCalculationException();
		
		return creditAcc;
	}
	
	private MunicipalStatement getMunicipalStatement() 
			throws VatCalculationException, DataIntegrityException{
		
		MunicipalStatement municipalAcc = new ScrapedStatementConverterMap().getMunicipalStatement(scrapedAccount,numericDataConverter);
		stateMentAddSpec = genericAddSpec.and(municipalAddSpec);
		stateMentAddSpec = new GenericStatementDataAdditionSpecification();//stateMentAddSpec = genericAddSpec.and(municipalAddSpec);
		
		if (!stateMentAddSpec.isSatisfiedBy(municipalAcc))
			throw new DataIntegrityException(municipalAcc.getAccountNumber());
		
		if (!vatSpec.isSatisfiedBy(municipalAcc))
			throw new VatCalculationException();
		
		return municipalAcc;
	}

	private TelcoStatement getTelcoStatement()
			throws VatCalculationException, DataIntegrityException{
		
		TelcoStatement telcoAcc = new ScrapedStatementConverterMap().getTelcoStatement(scrapedAccount,numericDataConverter);
		stateMentAddSpec = genericAddSpec.and(telcoAddSpec);
		
		if (!stateMentAddSpec.isSatisfiedBy(telcoAcc))
			throw new DataIntegrityException(telcoAcc.getAccountNumber());
		
		if (!vatSpec.isSatisfiedBy(telcoAcc))
			throw new VatCalculationException();
		
		return telcoAcc;
	}
	
}