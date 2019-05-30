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
	protected static final String[] PREFERRED_FOODS = { "Pet Food" };

	public abstract void tick();

	public OrganicPet(String name) {
		super(name);
		this.soiled = false;
		this.ticksUntilSoiled = 5;
		this.favoriteFood = determineFavoriteFood();
	}

	public abstract void feed(String selectedFood);

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

	public int getMaxHungerCapacity() {
		return maxHungerCapacity;
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

	public void play() {
		boredom += 50;
		if (boredom >= 100) {
			boredom = 100;
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

	public String getFavoriteFood() {
		return favoriteFood;
	}

	public static String[] getPreferredFoods() {
		return PREFERRED_FOODS;
	}

	protected static String determineFavoriteFood() {
		return PREFERRED_FOODS[getValueBetweenRange(0, PREFERRED_FOODS.length - 1)];
	}

	protected boolean foodIsAmongPreferredFoods(String selectedFood) {
		for (int i = 0; i < PREFERRED_FOODS.length; i++) {
			if (selectedFood.equals(PREFERRED_FOODS[i])) {
				return true;
			}
		}
		return false;
	}

	@Override
	public String[] getStats() {
		String cageStatus = "clean";
		if (soiled) {
			cageStatus = "dirty";
		}
		String[] petStats = { name, getType(), "" + health + "/100", "", "" + hunger + "/" + maxHungerCapacity,
				"" + thirst + "/" + maxThirstCapacity, "" + boredom + "/" + maxBoredomCapacity, getFavoriteFood(),
				cageStatus };
		return petStats;
	}
}
