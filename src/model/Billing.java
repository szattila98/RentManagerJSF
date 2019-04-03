package model;

public class Billing {

	private int flatnum;
	private int floorSpace;
	private double cost;

	public Billing(int tenant, int floorSpace) {
		this.flatnum = tenant;
		this.floorSpace = floorSpace;
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

}
