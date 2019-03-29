package model;

public class Flat {

	private int id;
	private int floor;
	private int door;
	private int floorSpace;
	private int airSpace;

	public Flat(int id, int floor, int door, int floorSpace, int airSpace) {
		this.id = id;
		this.floor = floor;
		this.door = door;
		this.floorSpace = floorSpace;
		this.airSpace = airSpace;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getFloor() {
		return floor;
	}

	public void setFloor(int floor) {
		this.floor = floor;
	}

	public int getDoor() {
		return door;
	}

	public void setDoor(int door) {
		this.door = door;
	}

	public int getFloorSpace() {
		return floorSpace;
	}

	public void setFloorSpace(int floorSpace) {
		this.floorSpace = floorSpace;
	}

	public int getAirSpace() {
		return airSpace;
	}

	public void setAirSpace(int airSpace) {
		this.airSpace = airSpace;
	}

}
