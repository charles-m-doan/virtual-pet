import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class VirtualRobotCatTest {

	public VirtualRobotCatTest() {
	}
	
	@Test
	public void shouldHaveTypeRobotCat() {
		VirtualRobotCat testRobotCat = new VirtualRobotCat("George");
		assertEquals("RobotCat", testRobotCat.getType());
	}
	
	@Test
	public void shouldHaveHungerOf4Less() {
		VirtualRobotCat testRobotCat = new VirtualRobotCat("George");
		int expectedHunger = testRobotCat.getHunger() - 8;
		testRobotCat.tick();
		testRobotCat.tick();
		int actualHunger = testRobotCat.getHunger();
		assertEquals(expectedHunger, actualHunger);
	}
	
	@Test
	public void hungerShouldBetween15And45() {
		VirtualRobotCat testRobotCat = new VirtualRobotCat("George");
		System.out.println(testRobotCat);
		assertTrue((testRobotCat.getHunger() >= 45 && testRobotCat.getHunger() <= 45));
	}
	

}
