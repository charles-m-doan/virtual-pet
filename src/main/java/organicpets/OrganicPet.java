package organicpets;

import models.VirtualPet;

public abstract class OrganicPet extends VirtualPet {

	protected boolean soiled;
	protected int ticksUntilSoiled;

	protected int hunger;
	protected int thirst;
	protected int boredom;

	protected int hungerRate;
	protected int thirstRate;
	protected int boredomRate;

	protected int minHungerCapacity;
	protected int maxHungerCapacity;

	protected int minThirstCapacity;
	protected int maxThirstCapacity;

	protected int minBoredomCapacity;
	protected int maxBoredomCapacity;

	public OrganicPet() {
		this.ticksUntilSoiled = getValueBetweenRange(3, 5);
	}

	public OrganicPet(String name, int hunger, int thirst) {
		super(name);
		this.hunger = hunger;
		this.thirst = thirst;
		this.soiled = false;
		this.ticksUntilSoiled = 5;

		this.boredom = 8;
		this.boredomRate = 1;
		this.minBoredomCapacity = 0;
		this.maxBoredomCapacity = 100;
	}

	public int getBoredom() {
		return boredom;
	}

	public void play() {
		boredom += 50;
		if (boredom >= 100) {
			boredom = 100;
		}
	}

	public int getHunger() {
		return hunger;
	}

	public int getThirst() {
		return thirst;
	}

	public abstract void tick();

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

	protected void decreaseBoredom(int amountToDecrease) {
		this.boredom -= amountToDecrease;
		if (boredom < 0) {
			boredom = 0;
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
		resetTicksUntilSoiled();
	}

	public void cleanCage() {
		soiled = false;
	}

	public void resetTicksUntilSoiled() {
		ticksUntilSoiled = getValueBetweenRange(3, 5);
	}

	public int getTicksUntilSoiled() {
		return ticksUntilSoiled;
	}

	public boolean isSoiled() {
		return soiled;
	}

	public void decreaseTicksUntilSoiled() {

		ticksUntilSoiled--;
		if (ticksUntilSoiled <= 0) {
			soiled = true;
			resetTicksUntilSoiled();
		}
	}

}
