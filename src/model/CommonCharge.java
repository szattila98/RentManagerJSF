package model;

public class CommonCharge {

	private int flatnum;
	private int floorSpace;

	public CommonCharge(int tenant, int floorSpace) {
		this.flatnum = tenant;
		this.floorSpace = floorSpace;
	}

	public int getTenant() {
		return flatnum;
	}

	public void setTenant(int tenant) {
		this.flatnum = tenant;
	}

	public int getFloorSpace() {
		return floorSpace;
	}

	public void setFloorSpace(int floorSpace) {
		this.floorSpace = floorSpace;
	}

}
