
public class VirtualDog extends VirtualPet {

	public VirtualDog(String name) {
		super(name);
		this.hungerRate = 25;
		this.thirstRate = 25;
		this.boredomRate = 25;
		this.minHungerCapacity = 0;
		this.maxHungerCapacity = 50;
		this.minThirstCapacity = 0;
		this.maxThirstCapacity = 50;
		this.minBoredomCapacity = 0;
		this.maxBoredomCapacity = 50;

		this.hunger = getValueBetweenRange(50, maxHungerCapacity);
		this.thirst = getValueBetweenRange(50, maxThirstCapacity);
		this.boredom = getValueBetweenRange(50, maxBoredomCapacity);
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
