package robotpets;

public class RobotCat extends RobotPet {

	public RobotCat(String name) {
		this.name = name;
	}

	public String getType() {
		return "Robo Cat";
	}
	
	@Override
	public void tick() {
		decreaseOil(1);
		decreaseHealth(1);
	}
	
	@Override
	public void walk() {
		decreaseOil(5);
		decreaseHealth(4);
	}

	@Override
	public void play() {
		decreaseOil(7);
		decreaseHealth(6);
	}

}
