import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class VirtualPetTest {
	VirtualPet underTest = new VirtualPet();

	@Test
	public void shouldBeAbleToCreatePet() {
		VirtualPet pet = new VirtualPet();
	}

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
	public void petShouldHaveThirsValue0() {
		int expected = underTest.getThirst();
		assertEquals(expected, 0);
	}
	
}
