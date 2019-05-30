package robotpets;

import models.VirtualPet;

public abstract class RobotPet extends VirtualPet {

	protected int oil;
	protected boolean outOfOil;

	public RobotPet() {
		this.health = 100;
		this.oil = 100;
		this.outOfOil = false;
	}

	public abstract void tick();

	public abstract void walk();

	public void performMaitenance() {
		this.health = 100;
	}

	public int getOil() {
		return oil;
	}

	public boolean isOutOfOil() {
		return outOfOil;
	}

	public void decreaseOil(int amountToDecrease) {
		oil -= amountToDecrease;
	}

	public void fillOil() {
		this.oil = 100;
	}
	
	@Override
	public String[] getStats() {
		String[] petStats = {name, "" + health};		
		return petStats;
	}
}
