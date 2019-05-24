package organicpets;

	import static org.junit.Assert.assertEquals;
	import static org.junit.Assert.assertTrue;

	import org.junit.Test;

import organicpets.OrganicHorse;

	public class OrganicHorseTest {

		public OrganicHorseTest() {
		}
		
		@Test
		public void shouldHaveTypeHorse() {
			OrganicHorse testHorse = new OrganicHorse("Eddard");
			assertEquals("Horse", testHorse.getType());
		}
		
		@Test
		public void shouldHaveHungerOf7Less() {
			OrganicHorse testHorse = new OrganicHorse("Eddard");
			int expectedHunger = testHorse.getHunger() - 14;
			testHorse.tick();
			testHorse.tick();
			int actualHunger = testHorse.getHunger();
			assertEquals(expectedHunger, actualHunger);
		}
		
		@Test
		public void hungerShouldBetween25And100() {
			OrganicHorse testHorse = new OrganicHorse("Eddard");
			System.out.println(testHorse);
			assertTrue((testHorse.getHunger() >= 25 && testHorse.getHunger() <= 100));

}
}