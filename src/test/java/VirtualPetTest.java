import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class VirtualPetTest {
	VirtualPet underTest1 = new VirtualPet("1", "Jeff");
	VirtualPet underTest2 = new VirtualPet("2", "Bill");

	@Test
	public void petShouldHaveTypeDog() {
		VirtualPet underTest1 = new VirtualPet("Dog", "");
		String expected = underTest1.getType();
		assertEquals(expected, "Dog");
	}

	@Test
	public void petShouldHaveName() {
		String expected = underTest1.getName();
		assertEquals(expected, "Jeff");
	}

	@Test
	public void petShouldHaveHungerValue8() {
		int expected = underTest1.getHunger();
		assertEquals(expected, 8);
	}

	@Test
	public void petShouldHaveThirstValue8() {
		int expected = underTest1.getThirst();
		assertEquals(expected, 8);

	}

	@Test
	public void petShouldHaveBoredomValue8() {
		int expected = underTest1.getBoredom();
		assertEquals(expected, 8);
	}

	@Test
	public void shouldTick() {
		int initialHunger = underTest1.getHunger();
		underTest1.tick();
		int hungerAfterTick = underTest1.getHunger();

		assertEquals(initialHunger - 1, hungerAfterTick);

	}

	@Test
	public void hungerShouldBeHigherAfterFeedingUnless10() {
		int initialHunger = underTest1.getHunger();
		underTest1.feed();
		int hungerAfterFeed = underTest1.getHunger();

		assertTrue(initialHunger <= hungerAfterFeed);
	}

	@Test
	public void hungerLevelCantGoAbove10() {
		underTest1.feed();
		int currentHunger = underTest1.getHunger();
		assertTrue(currentHunger >= 0);
	}

	@Test
	public void thirstShouldBeLowerHigherWateringUnless10() {
		int initialThirst = underTest1.getThirst();
		underTest1.water();
		int thirstAfterWater = underTest1.getThirst();

		assertTrue(initialThirst <= thirstAfterWater);
	}

	@Test
	public void thirstLevelCantGoBelow0() {
		underTest1.water();
		int currentThirst = underTest1.getThirst();
		assertTrue(currentThirst >= 0);
	}

	@Test
	public void boredomShouldBeHigherAfterPlayingUnless10() {
		int initialBoredom = underTest1.getBoredom();
		underTest1.play();
		int boredomAfterPlay = underTest1.getBoredom();

		assertTrue(initialBoredom <= boredomAfterPlay);
	}

	@Test
	public void boredomLevelCantGoBelow0() {
		underTest1.play();
		int currentBoredom = underTest1.getBoredom();
		assertTrue(currentBoredom >= 0);
	}

	@Test
	public void typeNameShouldBeCatAfterTypeSetTo2() {
		assertTrue(underTest2.getTypeName().equals("Cat"));
	}
	
	

}