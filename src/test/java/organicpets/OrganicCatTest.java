package organicpets;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import organicpets.OrganicCat;

public class OrganicCatTest {

	public OrganicCatTest() {
	}
	
	@Test
	public void shouldHaveTypeCat() {
		OrganicCat testCat = new OrganicCat("Ninja");
		assertEquals("Cat", testCat.getType());
	}
	
	@Test
	public void shouldHaveHungerOf6Less() {
		OrganicCat testCat = new OrganicCat("Ninja");
		int expectedHunger = testCat.getHunger() - 6;
		testCat.tick();
		testCat.tick();
		int actualHunger = testCat.getHunger();
		assertEquals(expectedHunger, actualHunger);
	}
	
	@Test
	public void hungerShouldBetween15And45() {
		OrganicCat testCat = new OrganicCat("Ninja");
		System.out.println(testCat);
		assertTrue((testCat.getHunger() >= 15 && testCat.getHunger() <= 45));
	}
	

}
