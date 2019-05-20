
public class VirtualPet {
	
	private String type;
	private String name;

	private int hunger = 10;
	private int thirst = 10;
	private int boredom = 10;
	private int age = 1;

	public VirtualPet(String type, String name) {
		super();
		this.type = type;
		this.name = name;
	}
	public String getType() {
		return type;
	}

	public String getName() {
		return name;
	}

	public int getAge() {
		return age;

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

	public void setName(String name) {
		this.name = name;

	}

	public void tick() {
		age++;
		hunger--;
		thirst--;
		boredom--;
		
		if(thirst < 0) {
			thirst = 0;
			
		}
		
		if(boredom < 0) {
			boredom = 0;
			
		}
		
		if(hunger < 0) {
			hunger = 0;
			
		}

	}

	public void feed(int foodValue) {
		hunger =  hunger + foodValue;
	 if (hunger >= 10) {
			hunger = 10;
		}
	}
	
     public void feedMeal() {
			
			feed(10);
	
	}
		
	public void feedSnack() {
			
			feed(2);
			
		}

	public void water() {
		thirst--;
		if(thirst < 0) {
			thirst = 0;
		}

	}
	public void play() {
		boredom--;
		if(boredom < 0) {
			boredom = 0;
		}
	}


}
