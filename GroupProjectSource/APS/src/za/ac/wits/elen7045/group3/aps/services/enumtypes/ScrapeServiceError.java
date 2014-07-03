package za.ac.wits.elen7045.group3.aps.services.enumtypes;

/**
 * 
 * @author boitumelo
 *
 *  Scrape Error conditions
 * 
 * IncorrectAccount 		(error 100)
 * InvalidUserCredentials 	(error 110)
 * NotSignedUpForeBilling 	(error 120)
 * ActionRequired 			(error 130)
 * BillingSiteDown 			(error 140)
 * ErrorPageEncountered 	(error 150)
 * BrokenScript 			(error 160)
 * DataIntegrityFailure 	(error 170)
 * 
 */

public enum ScrapeServiceError {
	INVALIDACCOUNT(100,"Invalid account"), INVALIDUSERCREDENTIAL(110,"Invalid user credentials"), 
	NOTSIGNEFOREBILLING(120,"User not signed for eBilling"), ACTIONREQUIRED(130,"Actions required by Billing Company"), 
	BILLINGSITEDOWN(140,"Billing site down"), ERRORPAGEENCOUNTERED(150,"Error page encountered"),
	BROKENSCRIPT(160,"Broken scrape script error"), DATAINTEGRITYFAILURE(170,"Data integrity failure");
	
	private int scrapeServiceError;
	private String scrapeServiceErrorDesc;

	private ScrapeServiceError(int scrapeServiceError, String errorDesc) {
		this.scrapeServiceError = scrapeServiceError;
		this.scrapeServiceErrorDesc = errorDesc;
	}

	public int getScrapeServiceError() {
		return scrapeServiceError;
	}

	public String getScrapeServiceErrorDesc() {
		return scrapeServiceErrorDesc;
	}
}
