package model;

import java.util.Date;

public class Charge {

	private int id;
	private Date date;
	private int amount;
	private String description;
	private int tenant;

	public Charge(int amount, String description, int tenant) {
		this.amount = amount;
		this.description = description;
		this.tenant = tenant;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
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

}
