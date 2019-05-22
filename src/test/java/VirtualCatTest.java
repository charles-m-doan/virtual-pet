import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class VirtualCatTest {

	public VirtualCatTest() {
	}
	
	@Test
	public void shouldHaveTypeCat() {
		VirtualCat testCat = new VirtualCat("Ninja");
		assertEquals("Cat", testCat.getType());
	}
	
	@Test
	public void shouldHaveHungerOf4Less() {
		VirtualCat testCat = new VirtualCat("Ninja");
		int expectedHunger = testCat.getHunger() - 4;
		testCat.tick();
		testCat.tick();
		int actualHunger = testCat.getHunger();
		assertEquals(expectedHunger, actualHunger);
	}
	
	@Test
	public void hungerShouldBetween15And45() {
		VirtualCat testCat = new VirtualCat("Ninja");
		System.out.println(testCat);
		assertTrue((testCat.getHunger() >= 15 && testCat.getHunger() <= 45));
	}
	

}
