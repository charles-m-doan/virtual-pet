import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class VirtualPetTest {
	VirtualPet underTest = new VirtualPet("Dog", "Jeff");

	@Test
	public void petShouldHaveTypeDog() {
		VirtualPet underTest = new VirtualPet("Dog", "");
		String expected = underTest.getType();
		assertEquals(expected, "Dog");
	}

	@Test
	public void petShouldHaveName() {
		String expected = underTest.getName();
		assertEquals(expected, "Jeff");
	}

	@Test
	public void petShouldHaveHungerValue5() {
		int expected = underTest.getHunger();
		assertEquals(expected, 5);
	}

	@Test
	public void petShouldHaveThirstValue5() {
		int expected = underTest.getThirst();
		assertEquals(expected, 5);

	}

	@Test
	public void petShouldHaveBoredomValue5() {
		int expected = underTest.getBoredom();
		assertEquals(expected, 5);
	}

	@Test
	public void shouldTick() {
		VirtualPet pet = new VirtualPet("Dog", "");

		int initialHunger = pet.getHunger();
		pet.tick();
		int hungerAfterTick = pet.getHunger();

		assertEquals(initialHunger - 1, hungerAfterTick);

	}

	@Test
	public void hungerShouldBeHigherAfterFeedingUnless10() {
		VirtualPet pet = new VirtualPet("Dog", "");
		int initialHunger = pet.getHunger();
		pet.feed();
		int hungerAfterFeed = pet.getHunger();

		assertTrue(initialHunger <= hungerAfterFeed);
	}

	@Test
	public void hungerLevelCantGoAbove10() {
		VirtualPet pet = new VirtualPet("Dog", "");
		pet.feed();
		int currentHunger = pet.getHunger();
		assertTrue(currentHunger >= 0);
	}

	@Test
	public void thirstShouldBeLowerHigherWateringUnless10() {
		VirtualPet pet = new VirtualPet("Dog", "");
		int initialThirst = pet.getThirst();
		pet.water();
		int thirstAfterWater = pet.getThirst();

		assertTrue(initialThirst <= thirstAfterWater);
	}

	@Test
	public void thirstLevelCantGoBelow0() {
		VirtualPet pet = new VirtualPet("Dog", "");
		pet.water();
		int currentThirst = pet.getThirst();
		assertTrue(currentThirst >= 0);
	}

	@Test
	public void boredomShouldBeHigherAfterPlayingUnless10() {
		VirtualPet pet = new VirtualPet("Dog", "");
		int initialBoredom = pet.getBoredom();
		pet.play();
		int boredomAfterPlay = pet.getBoredom();

		assertTrue(initialBoredom <= boredomAfterPlay);
	}

	@Test
	public void boredomLevelCantGoBelow0() {
		VirtualPet pet = new VirtualPet("Dog", "");
		pet.play();
		int currentBoredom = pet.getBoredom();
		assertTrue(currentBoredom >= 0);
	}
}