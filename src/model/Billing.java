package model;

public class Billing {

	private int flatnum;
	private int floorSpace;
	private double cost;
	private String desc;
	private String name;
	private int balance_after;

	public Billing(int tenant, int floorSpace, String desc, String name, int balance_after) {
		this.flatnum = tenant;
		this.floorSpace = floorSpace;
		this.desc = desc;
		this.name = name;
		this.balance_after = balance_after;
	}

	public int getFloorSpace() {
		return floorSpace;
	}

	public void setFloorSpace(int floorSpace) {
		this.floorSpace = floorSpace;
	}

	public int getFlatnum() {
		return flatnum;
	}

	public void setFlatnum(int flatnum) {
		this.flatnum = flatnum;
	}

	public double getCost() {
		return cost;
	}

	public void setCost(double cost) {
		this.cost = cost;
	}

	public String getDesc() {
		return desc;
	}

	public void setDesc(String desc) {
		this.desc = desc;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getBalance_after() {
		return balance_after;
	}

	public void setBalance_after(int balance_after) {
		this.balance_after = balance_after;
	}

}
