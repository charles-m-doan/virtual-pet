
public class VirtualPet {

	private String name; 

	private int hunger = 0;
	private int thirst = 0;
	private int boredom = 0;
	private int age = 1;
	
	public VirtualPet(String name) {
		super();
		this.name = name;
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
		age ++;
		hunger ++;
		thirst ++;
		boredom ++;
	


	}

}
