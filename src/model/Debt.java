package model;

public class Debt {

	private String name;
	private int balanceAtStartOfMonth;
	private int balanceAtEndOfMonth;
	private int balance;
	private String date;

	public Debt(String name, int balanceAtStartOfMonth, int balanceAtEndOfMonth, String date) {
		this.name = name;
		this.balanceAtStartOfMonth = balanceAtStartOfMonth;
		this.balanceAtEndOfMonth = balanceAtEndOfMonth;
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

	public int getBalanceAtStartOfMonth() {
		return balanceAtStartOfMonth;
	}

	public void setBalanceAtStartOfMonth(int balanceAtStartOfMonth) {
		this.balanceAtStartOfMonth = balanceAtStartOfMonth;
	}

	public int getBalanceAtEndOfMonth() {
		return balanceAtEndOfMonth;
	}

	public void setBalanceAtEndOfMonth(int balanceAtEndOfMonth) {
		this.balanceAtEndOfMonth = balanceAtEndOfMonth;
	}

}
