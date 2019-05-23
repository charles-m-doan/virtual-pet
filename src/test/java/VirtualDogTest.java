import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class VirtualDogTest {

	public VirtualDogTest() {
	}
	
	@Test
	public void shouldHaveTypeDog() {
		VirtualDog testDog = new VirtualDog("Pooch");
		assertEquals("Dog", testDog.getType());
	}
	
	@Test
	public void shouldHaveHungerOf4Less() {
		VirtualDog testDog = new VirtualDog("Pooch");
		int expectedHunger = testDog.getHunger() - 4;
		testDog.tick();
		testDog.tick();
		int actualHunger = testDog.getHunger();
		assertEquals(expectedHunger, actualHunger);
	}
	
	@Test
	public void hungerShouldBetween15And45() {
		VirtualDog testDog = new VirtualDog("Pooch");
		System.out.println(testDog);
		assertTrue((testDog.getHunger() >= 15 && testDog.getHunger() <= 45));
	}
	

}
