package application;

public class AdvisingPaymentInitializer {
	private String criteria,amount;
	public AdvisingPaymentInitializer(String criteria, String amount) {
		this.criteria=criteria;
		this.amount=amount;
	}
	public void setAmount(String amount) {
		this.amount = amount;
	}
	public void setCriteria(String criteria) {
		this.criteria = criteria;
	}
	public String getAmount() {
		return amount;
	}
	public String getCriteria() {
		return criteria;
	}
		
	
}
