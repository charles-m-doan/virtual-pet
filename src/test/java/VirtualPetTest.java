import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class VirtualPetTest {
	VirtualPet underTest = new VirtualPet("Jeff");

	@Test
	public void petShouldHaveName() {
		VirtualPet underTest = new VirtualPet("Jeff");

		String expected = underTest.getName();

		assertEquals(expected, "Jeff");
	}

	@Test
	public void petShouldHaveHungerValue0() {
		int expected = underTest.getHunger();
		assertEquals(expected, 0);
	}

	@Test
	public void petShouldHaveThirstValue0() {
		int expected = underTest.getThirst();
		assertEquals(expected, 0);

	}

	@Test
	public void petShouldHaveBoredomValue0() {
		int expected = underTest.getBoredom();
		assertEquals(expected, 0);

	}

	@Test
	public void petShouldHaveAgeOf1() {
		int expected = underTest.getAge();
		assertEquals(expected, 1);

	}

	@Test
	public void shouldTick() {
	      VirtualPet pet = new VirtualPet("");

	        int initialHunger = pet.getHunger();
	        pet.tick();
	        int hungerAfterTick = pet.getHunger();

	        assertEquals(initialHunger + 1, hungerAfterTick);

}
}