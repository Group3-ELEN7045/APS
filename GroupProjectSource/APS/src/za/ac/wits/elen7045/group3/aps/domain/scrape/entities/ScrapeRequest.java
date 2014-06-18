package za.ac.wits.elen7045.group3.aps.domain.scrape.entities;

import za.ac.wits.elen7045.group3.aps.domain.entities.BillingCompany;

public class ScrapeRequest {
	private String id;
	private BillingCompany billingCompany;
	public ScrapeRequest(String id){
		this.id = id;
	}
	
	public ScrapeRequest(String id, BillingCompany billingCompany){
		this.id = id;
		this.billingCompany = new BillingCompany(billingCompany);
	}

	public String getId() {
		return id;
	}

	public BillingCompany getBillingCompany() {
		return billingCompany;
	}
	
}
