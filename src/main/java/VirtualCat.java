import java.util.Random;

public class VirtualCat extends OrganicPet {

	public VirtualCat(String name) {
		super(name);
		this.hungerRate = 2;
		this.thirstRate = 1;
		this.boredomRate = 1;
		this.minHungerCapacity = 0;
		this.maxHungerCapacity = 45;
		this.minThirstCapacity = 0;
		this.maxThirstCapacity = 30;
		this.minBoredomCapacity = 0;
		this.maxBoredomCapacity = 100;

		this.hunger = getValueBetweenRange(15, maxHungerCapacity);
		this.thirst = getValueBetweenRange(10, maxThirstCapacity);
		this.boredom = getValueBetweenRange(50, maxBoredomCapacity);
	}

	public String getType() {
		return "Cat";
	}

	public void tick() {
		decreaseHunger(hungerRate);
		decreaseThirst(thirstRate);
		decreaseBoredom(boredomRate);
	}

}
