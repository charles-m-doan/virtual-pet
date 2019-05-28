package models;

import java.util.Random;

public abstract class VirtualPet {

	protected String name;

	protected int health;
	protected int healthRate;

	public VirtualPet() {
	}

	public VirtualPet(String name) {
		this.name = name;
		this.health = 100;
		this.healthRate = 1;
	}

	public String getType() {
		return "GenericPet";
	}

	public String getName() {
		return name;
	}

	public int getHealth() {
		return health;
	}
	
	protected void decreaseHealth(int amountToDecrease) {
		this.health -= amountToDecrease;
		if (health < 0) {
			health = 0;
		}
	}
	
	public void vetVisit() {
		health = 100;
	}
	
	public abstract void tick();

	public abstract void play();

	public abstract void walk();


	protected static int getValueBetweenRange(int min, int max) {
		Random random = new Random(System.nanoTime());
		int randomValue = min + random.nextInt((max - min) + 1);
		return randomValue;
	}

	// public String toString() {
	// return name + " | " + this.getType() + " | " + this.health + " | " +
	// this.hunger + " | " + this.thirst + " | "
	// + this.boredom;
// }
}
