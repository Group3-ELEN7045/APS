package za.ac.wits.elen7045.group3.aps.services.specification.scrape;
/**
 * @author bakwanyana
 */
import za.ac.wits.elen7045.group3.aps.services.scrape.StatementScrapedData;
import za.ac.wits.elen7045.group3.aps.services.specification.ApplicationSpecification;


public class DuplicateStatementDataSpecification
	extends ApplicationSpecification<StatementScrapedData>{
	@Override
	public boolean isSatisfiedBy(StatementScrapedData scrapedData) {
		
		return !correlationErrorsExist(scrapedData);
	}
	
	private boolean correlationErrorsExist(StatementScrapedData scrapedData){
		boolean flag = false;
		for (int i = 0; i < scrapedData.getDataPairList().size(); i++){
			for (int j = 0; j < scrapedData.getDataPairList().size(); j++){
				if(scrapedData.getDataPairList().get(i).getId().equals(scrapedData.getDataPairList().get(j).getId())){
					if (!scrapedData.getDataPairList().get(i).getValue().equalsIgnoreCase(scrapedData.getDataPairList().get(j).getValue())){
						flag = true;
					}
				}
			}
		}
		return flag;
	}

}
