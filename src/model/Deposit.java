package model;

import java.util.Date;

public class Deposit {

	private int id;
	private Date date;
	private int amount;
	private int tenant;

	public Deposit(int amount, int tenant) {
		this.amount = amount;
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

	public int getTenant() {
		return tenant;
	}

	public void setTenant(int tenant) {
		this.tenant = tenant;
	}

}
