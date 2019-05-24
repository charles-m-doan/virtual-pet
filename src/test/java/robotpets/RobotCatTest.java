package robotpets;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import robotpets.RobotCat;

public class RobotCatTest {

	public RobotCatTest() {
	}
	
	@Test
	public void shouldHaveTypeRobotCat() {
		RobotCat testRobotCat = new RobotCat("George");
		assertEquals("RobotCat", testRobotCat.getType());
	}
	
	@Test
	public void shouldHaveHungerOf4Less() {
		RobotCat testRobotCat = new RobotCat("George");
		int expectedHunger = testRobotCat.getHunger() - 8;
		testRobotCat.tick();
		testRobotCat.tick();
		int actualHunger = testRobotCat.getHunger();
		assertEquals(expectedHunger, actualHunger);
	}
	
	@Test
	public void hungerShouldBetween15And45() {
		RobotCat testRobotCat = new RobotCat("George");
		System.out.println(testRobotCat);
		assertTrue((testRobotCat.getHunger() >= 45 && testRobotCat.getHunger() <= 45));
	}
	

}
