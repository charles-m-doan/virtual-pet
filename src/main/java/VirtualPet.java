import java.util.Random;

public class VirtualPet {

	private String name;

	protected int hunger;
	protected int thirst;
	protected int boredom;

	protected int hungerRate = 1;
	protected int thirstRate = 1;
	protected int boredomRate = 1;

	protected int minHungerCapacity;
	protected int maxHungerCapacity;

	protected int minThirstCapacity;
	protected int maxThirstCapacity;

	protected int minBoredomCapacity;
	protected int maxBoredomCapacity;

	public VirtualPet() {
		this.name = "Rex";
		this.hunger = 8;
		this.thirst = 8;
		this.boredom = 8;

		this.hungerRate = 1;
		this.thirstRate = 1;
		this.boredomRate = 1;
		this.minHungerCapacity = 0;
		this.maxHungerCapacity = 100;
		this.minThirstCapacity = 0;
		this.maxThirstCapacity = 100;
		this.minBoredomCapacity = 0;
		this.maxBoredomCapacity = 100;
	}

	public VirtualPet(String name) {
		this.name = name;
		this.hunger = 8;
		this.thirst = 8;
		this.boredom = 8;
	}

	public String getType() {
		return "GenericPet";
	}

	public String getName() {
		return name;
	}

	public int getHunger() {
		return hunger;
	}

	public int getThirst() {
		return thirst;
	}

	public int getBoredom() {
		return boredom;
	}

	public void tick() {
		hunger--;
		thirst--;
		boredom--;
		if (thirst < 0) {
			thirst = 0;
		}
		if (boredom < 0) {
			boredom = 0;
		}
		if (hunger < 0) {
			hunger = 0;
		}
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

	public void play() {
		if (boredom >= 10) {
			boredom += 0;
		} else {
			boredom++;
		}
	}

	protected static int getValueBetweenRange(int min, int max) {
		int randomValue = 0;
		Random random = new Random(System.nanoTime());
		randomValue = min + random.nextInt((max - min) + 1);
		return randomValue;
	}

	public String toString() {
		return name + " | " + this.getType() + " | " + this.hunger + " | " + this.thirst + " | " + this.boredom;
	}

}
