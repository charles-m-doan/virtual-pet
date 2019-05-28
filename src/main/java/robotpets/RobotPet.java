package robotpets;

import models.VirtualPet;

public abstract class RobotPet extends VirtualPet {

	protected int hunger;
	protected int thirst;

	protected int hungerRate;
	protected int thirstRate;

	protected int minHungerCapacity;
	protected int maxHungerCapacity;

	protected int minThirstCapacity;
	protected int maxThirstCapacity;

	public RobotPet() {

	}

	public RobotPet(String name, int hunger, int thirst) {
		super(name);
		this.hunger = hunger;
		this.thirst = thirst;
	}

	public int getHunger() {
		return hunger;
	}

	public int getThirst() {
		return thirst;
	}

	public void tick() {
		System.out.println("Test 2");
		decreaseHunger(hungerRate);
		decreaseThirst(thirstRate);
		System.out.println("Test 3");

	}

	protected void decreaseHunger(int amountToDecrease) {
		this.hunger -= amountToDecrease;
		if (hunger < 0) {
			hunger = 0;
		}
	}

	protected void decreaseThirst(int amountToDecrease) {
		this.thirst -= amountToDecrease;
		if (thirst < 0) {
			thirst = 0;
		}
	}

	public void feed() {
		if (hunger >= 10) {
			hunger += 0;
		} else {
			hunger++;
		}
	}

	public void water() {
		if (thirst >= 10) {
			thirst += 0;
		} else {
			thirst++;
		}
	}

	public void walk() {
		if (boredom >= 10) {
			boredom += 0;
		} else {
			boredom++;
		}
	}
}
