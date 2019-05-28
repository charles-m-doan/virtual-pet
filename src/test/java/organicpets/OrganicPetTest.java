package organicpets;

import static org.junit.Assert.*;

import org.junit.Test;

import organicpets.OrganicDog;
import organicpets.OrganicPet;

public class OrganicPetTest {
	OrganicPet underTest = new OrganicDog("Jeff");

	@Test
	public void petWillSoilBetween3And5Ticks() {
		underTest.tick();
		underTest.tick();
		underTest.tick();
		underTest.tick();
		underTest.tick();
		assertTrue(underTest.isSoiled());
	}

	@Test
	public void shouldResetSoilCounterAfterWalking() {
		underTest.tick();
		underTest.tick();
		underTest.tick();
		underTest.tick();
		underTest.tick();
		underTest.walk();
		assertTrue(underTest.getTicksUntilSoiled() >= 3);
	}

	@Test
	public void shouldTestCageIsClean() {
		underTest.tick();
		underTest.tick();
		underTest.tick();
		underTest.tick();
		underTest.tick();
		underTest.cleanCage();
		assertFalse(underTest.isSoiled());
	}

}
