package robotpets;

import models.VirtualPet;

public abstract class RobotPet extends VirtualPet {

	protected int oil;
	protected boolean outOfOil;

	public abstract void tick();
	public abstract void walk();
	
	public RobotPet(String name) {
		super(name);
	}
	
	public RobotPet() {
		this.health = 100;
		this.oil = 100;
		this.outOfOil = false;
	}

	public boolean isOutOfOil() {
		return outOfOil;
	}

	public void decreaseOil(int amountToDecrease) {
		oil -= amountToDecrease;
	}

	public int getOil() {
		return oil;
	}

	public void fillOil() {
		this.oil = 100;
	}

	public void performMaitenance() {
		this.health = 100;
	}

}
