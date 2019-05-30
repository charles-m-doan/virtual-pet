package robotpets;

public class RobotDog extends RobotPet {

	public RobotDog(String name) {
		this.name = name;
	}

	public String getType() {
		return "RobotDog";
	}

	@Override
	public void tick() {
		decreaseOil(1);
		decreaseHealth(1);
	}
	
	@Override
	public void walk() {
		decreaseOil(7);
		decreaseHealth(6);
	}

	@Override
	public void play() {
		decreaseOil(10);
		decreaseHealth(11);
	}
}