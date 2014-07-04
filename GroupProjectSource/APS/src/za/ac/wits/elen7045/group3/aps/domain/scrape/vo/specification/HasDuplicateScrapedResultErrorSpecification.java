package za.ac.wits.elen7045.group3.aps.domain.scrape.vo.specification;
/**
 * @author bakwanyana
 */
import za.ac.wits.elen7045.group3.aps.domain.scrape.vo.ScrapedResult;
import za.ac.wits.elen7045.group3.aps.services.specification.ApplicationSpecification;


public class HasDuplicateScrapedResultErrorSpecification
	extends ApplicationSpecification<ScrapedResult>{
	
	@Override
	public boolean isSatisfiedBy(ScrapedResult scrapedData) {
		
		return correlationErrorsExist(scrapedData);
	}
	
	// method locates data pairs with identical ID, correlates only their value
	private boolean correlationErrorsExist(ScrapedResult scrapedData){
		boolean flag = false;
		for (int i = 0; i < scrapedData.getDataPairSize(); i++){
			for (int j = 0; j < scrapedData.getDataPairSize(); j++){
				if(scrapedData.getDataPairListItemId(i).equals(scrapedData.getDataPairListItemId(j))){
					if (!scrapedData.getDataPairListItemValue(i).equalsIgnoreCase(scrapedData.getDataPairListItemValue(j))){
						flag = true;
					}
				}
			}
		}
		return flag;
	}

}
