package model;

public class Charge {

	private int amount;
	private String description;
	private int tenant;
	private String tenantName;
	private String date;

	public Charge(int amount, String description, int tenant) {
		this.amount = amount;
		this.description = description;
		this.tenant = tenant;
	}

	public Charge(String date, int amount, String description) {
		this.amount = amount;
		this.description = description;
		this.date = date;
	}

	public Charge(int amount, String description, String tenantName, String date) {
		this.amount = amount;
		this.description = description;
		this.tenantName = tenantName;
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

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public int getTenant() {
		return tenant;
	}

	public void setTenant(int tenant) {
		this.tenant = tenant;
	}

	public String getTenantName() {
		return tenantName;
	}

	public void setTenantName(String tenantName) {
		this.tenantName = tenantName;
	}

}
