
public class VirtualDog extends OrganicPet {

	public VirtualDog(String name) {
		super(name);
		this.hungerRate = 5;
		this.thirstRate = 5;
		this.boredomRate = 5;
		this.minHungerCapacity = 0;
		this.maxHungerCapacity = 60;
		this.minThirstCapacity = 0;
		this.maxThirstCapacity = 70;
		this.minBoredomCapacity = 0;
		this.maxBoredomCapacity = 100;

		this.hunger = getValueBetweenRange(30, maxHungerCapacity);
		this.thirst = getValueBetweenRange(20, maxThirstCapacity);
		this.boredom = getValueBetweenRange(30, maxBoredomCapacity);
	}

	public String getType() {
		return "Dog";
	}

	public void tick() {
		decreaseHunger(hungerRate);
		decreaseThirst(thirstRate);
		decreaseBoredom(boredomRate);
	}

}
