
import java.util.Random;

public class VirtualHorse extends VirtualPet {
	

		public VirtualHorse (String name) {
			super(name);
			this.hungerRate = 7;
			this.thirstRate = 5;
			this.boredomRate = 5;
			this.minHungerCapacity = 0;
			this.maxHungerCapacity = 100;
			this.minThirstCapacity = 0;
			this.maxThirstCapacity = 80;
			this.minBoredomCapacity = 0;
			this.maxBoredomCapacity = 75;

			this.hunger = getValueBetweenRange(35, maxHungerCapacity);
			this.thirst = getValueBetweenRange(20, maxThirstCapacity);
			this.boredom = getValueBetweenRange(50, maxBoredomCapacity);
		
		}

		public String getType() {
			return "Horse";
		}

		public void tick() {
			decreaseHunger(hungerRate);
			decreaseThirst(thirstRate);
			decreaseBoredom(boredomRate);
		}

	}

