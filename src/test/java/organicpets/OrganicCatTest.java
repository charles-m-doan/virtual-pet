package organicpets;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import organicpets.OrganicCat;

public class OrganicCatTest {

	public OrganicCatTest() {
	}
	
	@Test
	public void favoriteFoodShouldAdd30orMaxHunger() {
		OrganicCat testCat = new OrganicCat("Ninja");
		System.out.println("Pre-Tick Hunger " + testCat.getHunger());

		// Tick cat to 0 hunger
		for (int i = 0; i < 100; i++) {
			testCat.tick();
		}
		
		System.out.println("Post-Tick/Pre-Feed Hunger " + testCat.getHunger());
		
		// Feed cat favorite food
		testCat.feed(testCat.getFavoriteFood());
		
		System.out.println("Post-Feed Hunger " + testCat.getHunger());

		int expectedHunger = Math.min(30, testCat.getMaxHungerCapacity());
		int actualHunger = testCat.getHunger();

		assertEquals(expectedHunger, actualHunger);
	}
	
	

	@Test
	public void shouldHaveFavoriteFood() {
		OrganicCat testCat = new OrganicCat("Pooch");
		System.out.println(testCat.getFavoriteFood());
	}
}
