package model;

public class Deposit {

	private int amount;
	private String tenant;
	private String date;

	public Deposit(int amount, String tenant) {
		this.amount = amount;
		this.tenant = tenant;
	}

	public Deposit(String date, int amount) {
		this.amount = amount;
		this.date = date;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public int getAmount() {
		return amount;
	}

	public void setAmount(int amount) {
		this.amount = amount;
	}

	public String getTenant() {
		return tenant;
	}

	public void setTenant(String tenant) {
		this.tenant = tenant;
	}

}
