package model;

public class Debt {

	private String name;
	private int balance;
	private String date;

	public Debt(String name, int balance, String date) {
		this.name = name;
		this.balance = balance;
		this.date = date;
	}

	public Debt(int balance, String date) {
		this.balance = balance;
		this.date = date;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
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

}
