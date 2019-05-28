package robotpets;

public class RobotCat extends RobotPet {

	public RobotCat(String name) {
		this.name = name;
	}

	public String getType() {
		return "RobotCat";
	}
	
	@Override
	public void tick() {
		decreaseOil(1);
		decreaseHealth(1);
	}
	
	@Override
	public void walk() {
		decreaseOil(2);
		decreaseHealth(3);
	}

	@Override
	public void play() {
		decreaseOil(3);
		decreaseHealth(2);
	}

}
