package models;

import java.util.Random;


public abstract class VirtualPet {

	protected String name;
	protected int health;
	protected int healthRate;

	public abstract void tick();

	public abstract void play();

	public abstract void walk();

	public VirtualPet() {
		this.name = "Unnamed";
		this.health = 100;
		this.healthRate = 1;
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

	public String toString() {
		return name + " | " + this.getType() + " | " + this.health;
	}

	protected static int getValueBetweenRange(int min, int max) {
		Random random = new Random(System.nanoTime());
		int randomValue = min + random.nextInt((max - min) + 1);
		return randomValue;
	}

	public String[] getStats() {
		String[] petStats = { name, getType(), "" + health };
		return petStats;
	}

	public static String[] getFieldLabels() {
		String[] fieldLabels = { "Name", "Type", "Health" };
		return fieldLabels;
	}
}
