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
	protected String favoriteFood;
	protected int hungerCapacity;
	protected int currentHunger;

	public abstract void tick();

	public OrganicPet() {
		this.ticksUntilSoiled = getValueBetweenRange(3, 5);
	}

	public OrganicPet(String name) {
		super(name);
		this.soiled = false;
		this.ticksUntilSoiled = 5;
		this.boredom = 8;
		this.boredomRate = 1;
		this.minBoredomCapacity = 0;
		this.maxBoredomCapacity = 100;
		this.favoriteFood = "dog food";
		this.currentHunger = 100;
	}

	public abstract void feed(String selectedFood);

	public void play() {
		boredom += 50;
		if (boredom >= 100) {
			boredom = 100;
		}
	}

	public int getBoredom() {
		return boredom;
	}

	public int getHunger() {
		return hunger;
	}

	public int getThirst() {
		return thirst;
	}

	public int getTicksUntilSoiled() {
		return ticksUntilSoiled;
	}

	public boolean isSoiled() {
		return soiled;
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

	protected void decreaseBoredom(int amountToDecrease) {
		this.boredom -= amountToDecrease;
		if (boredom < 0) {
			boredom = 0;
		}
	}

	public void decreaseTicksUntilSoiled() {
		ticksUntilSoiled--;
		if (ticksUntilSoiled <= 0) {
			soiled = true;
			resetTicksUntilSoiled();
		}
	}

	public void water() {
		if (thirst >= maxThirstCapacity) {
			thirst += 0;
		} else {
			thirst++;
		}
	}

	public void walk() {
		if (boredom >= maxBoredomCapacity) {
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

	@Override
	public String[] getStats() {
		String cageStatus = "clean";
		if (soiled) {
			cageStatus = "dirty";
		}
		String[] petStats = { name, getType(), "" + health, "" + hunger, "" + thirst, "" + boredom, "Spaghetti",
				cageStatus };
		return petStats;
	}

	public static String[] getFieldLabels() {
		String[] fieldLabels = { "Name", "Type", "Health", "Hunger", "Thirst", "Boredom", "Fav Food", "Cage Status" };
		return fieldLabels;
	}

	public String getFavoriteFood() {
		return favoriteFood;
	}

	public int getCurrentHunger() {
		return currentHunger;
	}

}
