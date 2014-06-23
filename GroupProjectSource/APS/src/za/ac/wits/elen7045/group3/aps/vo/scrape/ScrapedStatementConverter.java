package za.ac.wits.elen7045.group3.aps.vo.scrape;
/**
 * @author bakwanyana
 */
import za.ac.wits.elen7045.group3.aps.domain.accounts.abtracts.ScrapedData;
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
import za.ac.wits.elen7045.group3.aps.vo.specification.scrape.ErrorinScrapedResultSpecification;
import za.ac.wits.elen7045.group3.aps.vo.specification.scrape.StatementVATCalculationSpecification;
import za.ac.wits.elen7045.group3.aps.vo.specification.scrape.TelcoStatementDataAdditionSpecification;

public class ScrapedStatementConverter {
	
	private ScrapedResult scrapedData;
	private DuplicateStatementDataSpecification duplicateSpec;
	private StatementVATCalculationSpecification vatSpec;
	private CompanyStatementType companyStatementType;
	private NumericDataFormatter numericDataConverter;
	private MunicipalStatementDataAdditionSpecification municipalAddSpec;
	private TelcoStatementDataAdditionSpecification telcoAddSpec;
	private GenericStatementDataAdditionSpecification genericAddSpec;
	private Specification<ScrapedData> stateMentAddSpec;
	private ErrorinScrapedResultSpecification hasScrapeErrors;
	
	public ScrapedStatementConverter(ScrapedResult scrapedAccount, CompanyStatementType companyStatementType,
			INumericDataFormatStrategy numericConvertStrategy) 
			throws DuplicateDataException, ScrapeErrorException{
		
		this.scrapedData = scrapedAccount;
		this.companyStatementType = companyStatementType;
		this.numericDataConverter = new NumericDataFormatter(numericConvertStrategy);
		duplicateSpec = new DuplicateStatementDataSpecification();
		municipalAddSpec = new MunicipalStatementDataAdditionSpecification();
		telcoAddSpec = new TelcoStatementDataAdditionSpecification();
		genericAddSpec = new GenericStatementDataAdditionSpecification();
		hasScrapeErrors = new ErrorinScrapedResultSpecification();
		
		vatSpec = new StatementVATCalculationSpecification(14, numericDataConverter);
		
		if(!duplicateSpec.isSatisfiedBy(scrapedAccount))
			throw new DuplicateDataException();
		
		if (hasScrapeErrors.isSatisfiedBy(scrapedAccount))
			throw new ScrapeErrorException(scrapedAccount.getDataPairList().get(0).getValue());
	}
	
	public ScrapedData getStatement() 
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
		
		CreditCardStatement creditAcc = new ScrapedStatementConverterMap().getCreditCardStatement(scrapedData,numericDataConverter);
		
		stateMentAddSpec = new GenericStatementDataAdditionSpecification();
		
		if(!stateMentAddSpec.isSatisfiedBy(creditAcc))
			throw new DataIntegrityException(creditAcc.getAccountNumber());
		
		if (!vatSpec.isSatisfiedBy(creditAcc))
			throw new VatCalculationException();
		
		return creditAcc;
	}
	
	private MunicipalStatement getMunicipalStatement() 
			throws VatCalculationException, DataIntegrityException{
		
		MunicipalStatement municipalAcc = new ScrapedStatementConverterMap().getMunicipalStatement(scrapedData,numericDataConverter);
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
		
		TelcoStatement telcoAcc = new ScrapedStatementConverterMap().getTelcoStatement(scrapedData,numericDataConverter);
		stateMentAddSpec = genericAddSpec.and(telcoAddSpec);
		
		if (!stateMentAddSpec.isSatisfiedBy(telcoAcc))
			throw new DataIntegrityException(telcoAcc.getAccountNumber());
		
		if (!vatSpec.isSatisfiedBy(telcoAcc))
			throw new VatCalculationException();
		
		return telcoAcc;
	}
	
}
