
	import static org.junit.Assert.assertEquals;
	import static org.junit.Assert.assertTrue;

	import org.junit.Test;

	public class VirtualHorseTest {

		public VirtualHorseTest() {
		}
		
		@Test
		public void shouldHaveTypeHorse() {
			VirtualHorse testHorse = new VirtualHorse("Eddard");
			assertEquals("Horse", testHorse.getType());
		}
		
		@Test
		public void shouldHaveHungerOf7Less() {
			VirtualHorse testHorse = new VirtualHorse("Eddard");
			int expectedHunger = testHorse.getHunger() - 14;
			testHorse.tick();
			testHorse.tick();
			int actualHunger = testHorse.getHunger();
			assertEquals(expectedHunger, actualHunger);
		}
		
		@Test
		public void hungerShouldBetween25And100() {
			VirtualHorse testHorse = new VirtualHorse("Eddard");
			System.out.println(testHorse);
			assertTrue((testHorse.getHunger() >= 25 && testHorse.getHunger() <= 100));

}
}