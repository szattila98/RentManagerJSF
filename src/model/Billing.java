package model;

public class Billing {

	private int flatnum;
	private int floorSpace;
	private double cost;
	private String desc;
	private String name;

	public Billing(int tenant, int floorSpace, String desc, String name) {
		this.flatnum = tenant;
		this.floorSpace = floorSpace;
		this.desc = desc;
		this.name = name;
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

}
