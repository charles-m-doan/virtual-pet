package robotpets;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import robotpets.RobotDog;

public class RobotDogTest {

	public RobotDogTest() {
	}
	
	@Test
	public void shouldHaveTypeRobotDog() {
		RobotDog testRobotDog = new RobotDog("Buzz");
		assertEquals("Robot Dog", testRobotDog.getType());
	}
	
	@Test
	public void shouldHaveHungerOf4Less() {
		RobotDog testRobotDog = new RobotDog("Buzz");
		int expectedHunger = testRobotDog.getHunger() - 4;
		testRobotDog.tick();
		testRobotDog.tick();
		int actualHunger = testRobotDog.getHunger();
		assertEquals(expectedHunger, actualHunger);
	}
	
	@Test
	public void hungerShouldBetween15And45() {
		RobotDog testRobotDog = new RobotDog("Buzz");
		System.out.println(testRobotDog);
		assertTrue((testRobotDog.getHunger() >= 15 && testRobotDog.getHunger() <= 45));
	}
	

}
