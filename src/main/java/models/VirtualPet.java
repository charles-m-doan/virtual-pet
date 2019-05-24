package models;
import java.util.Random;

public class VirtualPet {

	protected String name;


	protected int boredom;
	protected int health;

	
	protected int boredomRate;
	protected int healthRate;


	protected int minBoredomCapacity;
	protected int maxBoredomCapacity;
	
	public VirtualPet() {
	}
	
	public VirtualPet(String name) {
		this.name = name;
		this.boredom = 8;
		this.health = 100;

		this.boredomRate = 1;
		this.healthRate = 1;
		this.minBoredomCapacity = 0;
		this.maxBoredomCapacity = 100;
	}

	public String getType() {
		return "GenericPet";
	}

	public String getName() {
		return name;
	}

	public int getBoredom() {
		return boredom;
	}

	public int getHealth() {
		return health;
	}

	public void tick() {
		decreaseBoredom(boredomRate);
		decreaseHealth(healthRate);

	}

	protected void decreaseBoredom(int amountToDecrease) {
		this.boredom -= amountToDecrease;
		if (boredom < 0) {
			boredom = 0;
		}
	}

	protected void decreaseHealth(int amountToDecrease) {
		this.health -= amountToDecrease;
		if (health < 0) {
			health = 0;
		}
	}

	public void play() {
		if (boredom >= 10) {
			boredom += 0;
		} else {
			boredom++;
		}
	}
	
	public void walk() {
		if (boredom >= 10) {
			boredom += 0;
		} else {
			boredom++;
		}
	}

	public void vetVisit() {
		health = 100;
	}

	protected static int getValueBetweenRange(int min, int max) {
		Random random = new Random(System.nanoTime());
		int randomValue = min + random.nextInt((max - min) + 1);
		return randomValue;
	}

	// public String toString() {
		// return name + " | " + this.getType() + " | " + this.health + " | " + this.hunger + " | " + this.thirst + " | "
			//	+ this.boredom;
// }
}
