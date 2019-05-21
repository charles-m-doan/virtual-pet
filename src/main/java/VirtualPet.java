
public class VirtualPet {

	private String type;
	private String name;

	private int hunger;
	private int thirst;
	private int boredom;

	public VirtualPet() {
		this.type = "Dog";
		this.name = "Rex";
		this.hunger = 8;
		this.thirst = 8;
		this.boredom = 8;
	}

	public VirtualPet(String type, String name) {
		this.type = type;
		this.name = name;
		this.hunger = 8;
		this.thirst = 8;
		this.boredom = 8;
	}

	public VirtualPet(String type, String name, int hunger, int thirst, int boredom) {
		this.type = type;
		this.name = name;
		this.hunger = hunger;
		this.thirst = thirst;
		this.boredom = boredom;
	}

	public String getTypeName() {
		if (type.equals("1")) {
			return "Dog";
		} else if (type.equals("2")) {
			return "Cat";
		}
		return "Unknown";
	}

	public String getType() {
		return type;
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

	public void setName(String name) {
		this.name = name;
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

}
