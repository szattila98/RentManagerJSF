package model;

import java.util.ArrayList;

public class Tabulation {

	private ArrayList<Deposit> deposits;
	private ArrayList<Charge> charges;
	private ArrayList<Debt> debts;

	public Tabulation(ArrayList<Deposit> deposits, ArrayList<Charge> charge, ArrayList<Debt> debts) {
		this.deposits = deposits;
		this.charges = charge;
		this.debts = debts;
	}

	public Tabulation() {
	}

	public ArrayList<Deposit> getDeposits() {
		return deposits;
	}

	public void setDeposits(ArrayList<Deposit> deposits) {
		this.deposits = deposits;
	}

	public ArrayList<Charge> getCharges() {
		return charges;
	}

	public void setCharges(ArrayList<Charge> charges) {
		this.charges = charges;
	}

	public ArrayList<Debt> getDebts() {
		return debts;
	}

	public void setDebts(ArrayList<Debt> debts) {
		this.debts = debts;
	}

}
