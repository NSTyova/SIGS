package org.fao.model;

public class PaymentTransaction {

	private String reference;
    private double amount;
    private String description;
    private String callbackUrl;
    
    
    
	public PaymentTransaction(String reference, double amount, String description, String callbackUrl) {
		super();
		this.reference = reference;
		this.amount = amount;
		this.description = description;
		this.callbackUrl = callbackUrl;
	}
	
	
	
	public PaymentTransaction() {
		super();
	}



	public String getReference() {
		return reference;
	}
	public void setReference(String reference) {
		this.reference = reference;
	}
	public double getAmount() {
		return amount;
	}
	public void setAmount(double amount) {
		this.amount = amount;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getCallbackUrl() {
		return callbackUrl;
	}
	public void setCallbackUrl(String callbackUrl) {
		this.callbackUrl = callbackUrl;
	}
    
    
}
