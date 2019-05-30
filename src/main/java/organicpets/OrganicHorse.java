package organicpets;

public class OrganicHorse extends OrganicPet {
	

		public OrganicHorse (String name) {
			this.name = name;
			this.hungerRate = 7;
			this.thirstRate = 5;
			this.boredomRate = 5;
			this.minHungerCapacity = 0;
			this.maxHungerCapacity = getValueBetweenRange(50,100); 
			this.minThirstCapacity = 0;
			this.maxThirstCapacity = getValueBetweenRange(45, 80);
			this.minBoredomCapacity = 0;
			this.maxBoredomCapacity = getValueBetweenRange(50, 75);
			this.favoriteFood = getFavoriteFood();

			this.hunger = maxHungerCapacity;
			this.thirst = maxThirstCapacity;
			this.boredom = maxBoredomCapacity;
		
		}

		public String getType() {
			return "Horse";
		}

		public void tick() {
			decreaseHunger(hungerRate);
			decreaseThirst(thirstRate);
			decreaseBoredom(boredomRate);
			decreaseHealth(healthRate);
		}

		 public String getFavoriteFood() {
				String[] foods;
				foods = new String[] { "Horse feed", "Hay", "Apple", "carrot", "treat" };
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

