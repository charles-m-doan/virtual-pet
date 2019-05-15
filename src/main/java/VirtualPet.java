
public class VirtualPet {

	private String name;
	private int hunger = 0;
	private int thirst = 0;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public VirtualPet() {
		this.name = "Jeff";
	}

	public VirtualPet(String name) {
		super();
		this.name = name;
	}

	public int getHunger() {
		return hunger;
	}

	public int getThirst() {
		return thirst;
	}

}
