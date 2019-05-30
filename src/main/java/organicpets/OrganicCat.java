package organicpets;

public class OrganicCat extends OrganicPet {

	public OrganicCat(String name) {
		super(name);
		this.hungerRate = 3;
		this.thirstRate = 1;
		this.boredomRate = 1;
		this.minHungerCapacity = 0;
		this.maxHungerCapacity = getValueBetweenRange(15, 45);
		this.minThirstCapacity = 0;
		this.maxThirstCapacity = getValueBetweenRange(10, 30);
		this.minBoredomCapacity = 0;
		this.maxBoredomCapacity = getValueBetweenRange(30, 100);
		this.favoriteFood = determineFavoriteFood();
		this.hunger = maxHungerCapacity;
		this.thirst = maxThirstCapacity;
		this.boredom = maxBoredomCapacity;
	}

	public String getType() {
		return "Cat";
	}

	public void tick() {
		decreaseHunger(hungerRate);
		decreaseThirst(thirstRate);
		decreaseBoredom(boredomRate);
		decreaseTicksUntilSoiled();
		decreaseHealth(healthRate);
		if (soiled == true) {
			decreaseHealth(7);
		}

	}

	public void feed(String selectedFood) {
		if (selectedFood.equals(favoriteFood)) {
			hunger += 30;
		} else
			hunger += 20;
		if (hunger >= maxHungerCapacity) {
			hunger = maxHungerCapacity;
		}
	}

	private static String determineFavoriteFood() {
		String[] foods = { "dry cat food", "canned cat food", "chicken", "tuna", "treat" };
		return foods[getValueBetweenRange(0, 4)];
	}
}
