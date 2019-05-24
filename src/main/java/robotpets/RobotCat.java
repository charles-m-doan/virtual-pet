package robotpets;
public class RobotCat extends RoboticPet {

	public RobotCat(String name) {
		super(name);
		this.hungerRate = 4;
		this.thirstRate = 2;
		this.boredomRate = 2;
		this.minHungerCapacity = 0;
		this.maxHungerCapacity = 45;
		this.minThirstCapacity = 0;
		this.maxThirstCapacity = 30;
		this.minBoredomCapacity = 0;
		this.maxBoredomCapacity = 100;

		this.hunger = getValueBetweenRange(45, maxHungerCapacity);
		this.thirst = getValueBetweenRange(30, maxThirstCapacity);
		this.boredom = getValueBetweenRange(100, maxBoredomCapacity);
	}

	public String getType() {
		return "RobotCat";
	}

	public void tick() {
		decreaseHunger(hungerRate);
		decreaseThirst(thirstRate);
		decreaseBoredom(boredomRate);
	}

}
