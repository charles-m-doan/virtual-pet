package organicpets;

public class OrganicDog extends OrganicPet {

	public OrganicDog(String name) {
		this.name = name;
		this.hungerRate = 5;
		this.thirstRate = 5;
		this.boredomRate = 5;
		this.minHungerCapacity = 0;
		this.maxHungerCapacity = getValueBetweenRange(30, 60);
		this.minThirstCapacity = 0;
		this.maxThirstCapacity = getValueBetweenRange(20, 70);
		this.minBoredomCapacity = 0;
		this.maxBoredomCapacity = getValueBetweenRange(30, 100);
		this.favoriteFood = getFavoriteFood();

		this.hunger = maxHungerCapacity;
		this.thirst = maxThirstCapacity;
		this.boredom = maxBoredomCapacity;
	}

	public String getType() {
		return "Dog";
	}

	public void tick() {
		decreaseHunger(hungerRate);
		decreaseThirst(thirstRate);
		decreaseBoredom(boredomRate);
		decreaseTicksUntilSoiled();
		decreaseHealth(healthRate);
		if (soiled == true) {
			decreaseHealth(5);

		}
	}

	 public String getFavoriteFood() {
		String[] foods;
		foods = new String[] { "dry dog food", "wet dog food", "chicken", "beef", "treat" };
		favoriteFood = foods[getValueBetweenRange(0, 4)];
		return favoriteFood;
	}
	

	public void feed(String selectedFood) {
		if (selectedFood == favoriteFood) {
			hunger += 40;
		} else hunger += 30;
		if (hunger >= maxHungerCapacity) {
			hunger = maxHungerCapacity;
			}
	}
}
