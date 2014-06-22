package test.za.ac.wits.group3.scrape;

public class ScrapeExceptionErrorsTest {
	/*
	@Test(expected=DuplicateDataException.class)
	public void duplicateDataException() throws Exception{
		ArrayList<DataPair> dataPairsFalse = new ArrayList<DataPair>();
			
		dataPairsFalse.add(new DataPair("001","qaz","123456789"));
		dataPairsFalse.add(new DataPair("002","qaz","Jack Parcell"));
		dataPairsFalse.add(new DataPair("001","qaz","12/12/2014"));
		dataPairsFalse.add(new DataPair("004","qaz","1122"));
		dataPairsFalse.add(new DataPair("005","qaz","2"));
		
		ScrapedResult cc = new ScrapedResult("","","",dataPairsFalse);
		
		statementAdaptor = new ScrapedStatementConverter(cc, CompanyStatementType.CREDITCARD, new DefaultNumericDataFormatStrategy());
		
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
		
		scrapedStatement = new ScrapedResult("","","",dataPairs);
		
		statementAdaptor = new ScrapedStatementConverter(scrapedStatement, CompanyStatementType.CREDITCARD, new DefaultNumericDataFormatStrategy());
		creditCardObject = (CreditCardStatement)statementAdaptor.getStatement();
	}
	/*
	@Test(expected=ScrapeErrorException.class)
	public void scrapeErrorException() throws Exception{
		dataPairs = new ArrayList<DataPair>();
		dataPairs.add(new DataPair("001","Scrape Error","InvalidCredentials"));
		
		scrapedStatement = new ScrapedResult("","","",dataPairs);
		
		statementAdaptor = new ScrapedStatementConverter(scrapedStatement, CompanyStatementType.CREDITCARD, new DefaultNumericDataFormatStrategy());
	}*/
}
