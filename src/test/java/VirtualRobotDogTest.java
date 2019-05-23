import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class VirtualRobotDogTest {

	public VirtualRobotDogTest() {
	}
	
	@Test
	public void shouldHaveTypeRobotDog() {
		VirtualRobotDog testRobotDog = new VirtualRobotDog("Buzz");
		assertEquals("Robot Dog", testRobotDog.getType());
	}
	
	@Test
	public void shouldHaveHungerOf4Less() {
		VirtualRobotDog testRobotDog = new VirtualRobotDog("Buzz");
		int expectedHunger = testRobotDog.getHunger() - 4;
		testRobotDog.tick();
		testRobotDog.tick();
		int actualHunger = testRobotDog.getHunger();
		assertEquals(expectedHunger, actualHunger);
	}
	
	@Test
	public void hungerShouldBetween15And45() {
		VirtualRobotDog testRobotDog = new VirtualRobotDog("Buzz");
		System.out.println(testRobotDog);
		assertTrue((testRobotDog.getHunger() >= 15 && testRobotDog.getHunger() <= 45));
	}
	

}
