package model;

public class Tenant {

	private int id;
	private String name;
	private int balance;
	private int flatnum;

	public Tenant(String name, int balance, int flatnum) {
		this.name = name;
		this.balance = balance;
		this.flatnum = flatnum;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getBalance() {
		return balance;
	}

	public void setBalance(int balance) {
		this.balance = balance;
	}

	public int getFlatnum() {
		return flatnum;
	}

	public void setFlatnum(int flatnum) {
		this.flatnum = flatnum;
	}

}
