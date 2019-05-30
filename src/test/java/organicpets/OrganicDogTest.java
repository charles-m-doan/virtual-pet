package organicpets;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import organicpets.OrganicDog;

public class OrganicDogTest {

	public OrganicDogTest() {
	}

	/* @Test public void shouldHaveTypeDog() { OrganicDog testDog = new
	 * OrganicDog("Pooch"); assertEquals("Dog", testDog.getType()); }
	 * 
	 * @Test public void shouldHaveHungerOf4Less() { OrganicDog testDog = new
	 * OrganicDog("Pooch"); int expectedHunger = testDog.getHunger() - 4;
	 * testDog.tick(); testDog.tick(); int actualHunger = testDog.getHunger();
	 * assertEquals(expectedHunger, actualHunger); }
	 * 
	 * @Test public void hungerShouldBetween15And45() { OrganicDog testDog = new
	 * OrganicDog("Pooch"); System.out.println(testDog);
	 * assertTrue((testDog.getHunger() >= 15 && testDog.getHunger() <= 45)); }
	 */

	@Test
	public void shouldHaveFavoriteFood() {
		OrganicDog testDog = new OrganicDog("Pooch");
		System.out.println(testDog.getFavoriteFood());
	}

	@Test
	public void favoriteFoodShouldAdd40Hunger() {
		OrganicDog testDog = new OrganicDog("Pooch");
		int expectedHunger = testDog.getHunger();
		System.out.println(testDog.getHunger());
		testDog.tick();
		testDog.tick();
		System.out.println(testDog.getHunger());
		testDog.tick();
		testDog.tick();
		testDog.tick();
		testDog.tick();
		testDog.tick();
		testDog.tick();
		System.out.println(testDog.getHunger());
		testDog.feed(testDog.getFavoriteFood());
		System.out.println(testDog.getHunger());
		assertEquals(testDog.getHunger(), expectedHunger);
	}
}
