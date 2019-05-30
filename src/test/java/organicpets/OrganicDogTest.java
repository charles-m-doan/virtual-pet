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
	public void shouldHaveHungerOf5Less() {
		OrganicDog testDog = new OrganicDog("Pooch");
		int expectedHunger = testDog.getHunger() - 10;
		testDog.tick();
		testDog.tick();
		int actualHunger = testDog.getHunger();
		assertEquals(expectedHunger, actualHunger);
	}

	@Test
	public void hungerShouldBetween30And60() {
		OrganicDog testDog = new OrganicDog("Pooch");
		System.out.println(testDog);
		assertTrue((testDog.getHunger() >= 30 && testDog.getHunger() <= 60));
	}

}
