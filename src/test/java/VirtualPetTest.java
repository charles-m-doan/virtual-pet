import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

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
	
	@Test
	public void hungerShouldBeLowerAfterFeedingUnless0() {
		VirtualPet pet = new VirtualPet("");
		int initialHunger = pet.getHunger();
        pet.feed();
        int hungerAfterFeed = pet.getHunger();

        assertTrue(initialHunger >= hungerAfterFeed);
	}
	
	@Test
	public void hungerLevelCantGoBelow0() {
		VirtualPet pet = new VirtualPet("");
		pet.feed();
		int currentHunger = pet.getHunger();
		assertTrue(currentHunger >= 0);
	}
	@Test
	public void thirstShouldBeLowerAfterWateringUnless0() {
		VirtualPet pet = new VirtualPet("");
		int initialThirst = pet.getThirst();
        pet.water();
        int thirstAfterWater = pet.getThirst();

        assertTrue(initialThirst >= thirstAfterWater);
	}
	@Test
	public void thirstLevelCantGoBelow0() {
		VirtualPet pet = new VirtualPet("");
		pet.water();
		int currentThirst = pet.getThirst();
		assertTrue(currentThirst >= 0);
	}
	@Test
	public void boredomShouldBeLowerAfterPlayingUnless0() {
		VirtualPet pet = new VirtualPet("");
		int initialBoredom = pet.getBoredom();
        pet.play();
        int boredomAfterPlay = pet.getBoredom();

        assertTrue(initialBoredom >= boredomAfterPlay);
	}
	@Test
	public void boredomLevelCantGoBelow0() {
		VirtualPet pet = new VirtualPet("");
		pet.play();
		int currentBoredom = pet.getBoredom();
		assertTrue(currentBoredom >= 0);
	}
}