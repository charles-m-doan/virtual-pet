package organicpets;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import organicpets.OrganicDog;

public class OrganicDogTest {
	
	OrganicDog testDog = new OrganicDog("Pooch");

	public OrganicDogTest() {
	}
	
	@Test
	public void shouldHaveTypeDog() {
		assertEquals("Dog", testDog.getType());
	}
	
	@Test
	public void shouldHaveHungerOf10Less() {
		int expectedHunger = testDog.getHunger() - 10;
		testDog.tick();
		testDog.tick();
		int actualHunger = testDog.getHunger();
		assertEquals(expectedHunger, actualHunger);
	}
	
	@Test
	public void hungerShouldBetween30And60() {
		assertTrue((testDog.getHunger() >= 30 && testDog.getHunger() <= 60));
	}
	

}
